package lee.GroupProject.web.payment;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.orderDetail.dto.OrderDetailForm;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.service.OrderDetailServiceImpl;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.orderList.service.OrderListServiceImpl;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;
import lee.GroupProject.domain.shoppingBasket.service.ShoppingBasketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 주문 정보를 받아서 처리하는 Controller
 * @author LEE KYUHEON
 * 장바구니에 저장된 정보를 memberID로 제일 최신 자료를 찾아옵니다.
 * 그리고 해당 정보를 view에 model.addAttribute해서 화면에 출력해줍니다.
 *
 * 해당하는 memberID로 찾게될 경우에는 다수의 장바구니 목록이 나오게됩니다만,
 * 장바구니에 담긴 일자 기준 제일 최신의 데이터가 필요하기 때문에 list.get(index)로 제일 최신 데이터를 불러와서 view에 출력해줍니다.
 */
@Slf4j
@Controller
@RequestMapping("/shop/payment.do")
public class PaymentController {
    /*비회원 이름 겹치지 않게 하기 위한 구별 숫자*/
    @Autowired
    private ProductServiceImpl service;

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private OrderListServiceImpl orderListService;

    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private ShoppingBasketService shoppingBasketService;



    @GetMapping()
    public String doGet(Model model,
                        HttpServletRequest request,
                        @ModelAttribute("orderDetail") OrderDetail orderDetail){


        //Session으로 loginMember를 얻어와서, 있으면 members 객체를 전달 / 없으면 null값으로 전달
        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");

        //카트에 저장된 제일 최신날짜의 정보 하나를 불러온다.
            //로그인한 경우에는 로그인된 아이디로, 비회원일 경우에는 비회원 공유 아이디로 찾아온다.

        List<ShoppingBasket> cart;
        if(session.getAttribute("loginMember") != null){
            model.addAttribute("members",members);
            cart = shoppingBasketService.findAllByMemberIdOrderByShoppingDateDesc(members.getMemberId());
        }else{
            /**
             *  비회원용 계정을 DB에 따로 Nonmember라는 ID를 생성해놓았습니다.
             *  이렇게 하지않으면 PK를 지키기 위해서 비회원이 구매할때마다 새로운 비회원 계정을 생성해야 하기때문에 관리의 용이성을 위해서
             *  Nonmember라고 하는 하나의 계정을 모든 비회원 계정으로 사용하기로 했습니다.
             */
            Optional<Members> nonMember = memberService.findMember("Nonmember");
            cart = shoppingBasketService.findAllByMemberIdOrderByShoppingDateDesc(nonMember.get().getMemberId());
            model.addAttribute("member",null);
            model.addAttribute("nonMember", nonMember);
        }

        //찾아온 카트에 있는 제품번호로 해당 제품의 정보를 찾아온다.
        Product product = service.findByProductNum(cart.get(0).getProductNum());
        model.addAttribute("product",product);


        //총 금액 = (제품의 가격 * 수량) + 배달비
        Integer totalPrice = (product.getProductPrice() * (cart.get(0).getShoppingQuantity())) + 2500;
        //입력된 정보들을 model에 보내줌
        model.addAttribute("quantity",cart.get(0).getShoppingQuantity());
        model.addAttribute("totalPrice",totalPrice);




        return "includes/payment";
    }
    @PostMapping()
    public String doPost(@Validated @ModelAttribute("orderDetail") OrderDetailForm orderDetail,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            log.info("bindingResults : {}", bindingResult);
            return "redirect:/includes/payment";
        }


        //OrderDeatil을 DB에 저장
         //무작위 주문번호 생성
        String uuid = UUID.randomUUID().toString();

        OrderDetail registerorderDetail = new OrderDetail();
        registerorderDetail.setOrderAddress(orderDetail.getOrderAddress());
        registerorderDetail.setOrderNum(uuid);
        registerorderDetail.setOrderName(orderDetail.getOrderName());
        registerorderDetail.setOrderPhone(orderDetail.getOrderPhone());
        registerorderDetail.setDeliveryCharge(orderDetail.getDeliveryCharge());
        registerorderDetail.setMemberId(orderDetail.getMemberId());
        registerorderDetail.setRecipientName(orderDetail.getRecipientName());
        registerorderDetail.setPaymentMethod(orderDetail.getPaymentMethod());
        registerorderDetail.setOrderQuantity(orderDetail.getOrderQuantity());
        registerorderDetail.setTotalAmount(orderDetail.getTotalAmount());
        registerorderDetail.setOrderPhone(orderDetail.getOrderPhone());

        //OrderList DB에 저장
        OrderList orderlist = new OrderList();
        orderlist.setMemberId(orderDetail.getMemberId());
        orderlist.setProductNum(orderDetail.getProductNum());
        orderlist.setOrderNum(registerorderDetail.getOrderNum());

        orderDetailService.register(registerorderDetail);
        orderListService.register(orderlist);


        //Product의 수량 변경
        Product findProduct = service.findByProductNum(orderDetail.getProductNum());
        findProduct.setProductQuantity(findProduct.getProductQuantity() - orderDetail.getOrderQuantity());
        //DB에 저장
        service.update(findProduct);

        //주문완료된건 장바구니 리스트에서 제거
        shoppingBasketService.deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc(orderDetail.getMemberId(),orderDetail.getProductNum());

        //주문 정상 완료되면 result화면으로 리다이렉트
        redirectAttributes.addAttribute("orderDetailNum",orderlist.getOrderNum());
        redirectAttributes.addAttribute("orderlistProductNum",orderlist.getProductNum());
        return "redirect:/shop/payment/result.do";
    }



}
