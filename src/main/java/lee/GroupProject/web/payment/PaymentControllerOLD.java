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
import java.util.Optional;
import java.util.UUID;

/**
 * 주문 정보를 받아서 처리하는 Controller
 * @author LEE KYUHEON
 */
@Slf4j
@Controller
@RequestMapping("none")
public class PaymentControllerOLD {
    /*비회원 이름 겹치지 않게 하기 위한 구별 숫자*/
    @Autowired
    private ProductServiceImpl service;

    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private OrderListServiceImpl orderListService;

    @Autowired
    private MemberServiceImpl memberService;


    /***
     *Shop-singles.html의 form에서 넘어온 데이터를 사용합니다.
     * @param productNum 제품번호
     * @param quantity  수량
     * @param request 로그인 여부 확인을 위한 session 획득
     *
     */
    @GetMapping()
    public String doGet(@RequestParam("productNum") String productNum,
                        @RequestParam("product-quanity") Integer quantity,
                        @ModelAttribute("orderDetail") OrderDetail orderDetail,
                        Model model,
                        HttpServletRequest request){

        //param으로 전달받은 제품번호를 사용해서 해당하는 Product 객체를 찾아옵니다.
        Product product = service.findByProductNum(productNum);
        //총 금액 = (제품의 가격 * 수량) + 배달비
        Integer totalPrice = (product.getProductPrice() * quantity) + 2500;
        //입력된 정보들을 model에 보내줌
        model.addAttribute("product",product);
        model.addAttribute("quantity",quantity);
        model.addAttribute("totalPrice",totalPrice);

        //Session으로 loginMember를 얻어와서, 있으면 members 객체를 전달 / 없으면 null값으로 전달
        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");
        if(session.getAttribute("loginMember") != null){
            model.addAttribute("members",members);
        }else{
            /**
             *  비회원용 계정을 DB에 따로 Nonmember라는 ID를 생성해놓았습니다.
             *  이렇게 하지않으면 PK를 지키기 위해서 비회원이 구매할때마다 새로운 비회원 계정을 생성해야 하기때문에 관리의 용이성을 위해서
             *  Nonmember라고 하는 하나의 계정을 모든 비회원 계정으로 사용하기로 했습니다.
             */
            Optional<Members> nonMember = memberService.findMember("Nonmember");
            model.addAttribute("member",null);
            model.addAttribute("nonMember", nonMember);
        }

        return "includes/payment";
    }
    @PostMapping()
    public String doPost(@Validated @ModelAttribute("orderDetailForm") OrderDetailForm orderDetailForm,
                        @RequestParam("productNum") String productNum,
                        @PathVariable ("productNum") String productNum2,
                        BindingResult bindingResult,
                         RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {

            return "/shop/payment.do{productNum2}";
        }

        //OrderDeatil을 DB에 저장
         //무작위 주문번호 생성
        String uuid = UUID.randomUUID().toString();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAddress(orderDetailForm.getOrderAddress());
        orderDetail.setOrderNum(uuid);
        orderDetail.setOrderName(orderDetailForm.getOrderName());
        orderDetail.setOrderPhone(orderDetailForm.getOrderPhone());
        orderDetail.setDeliveryCharge(orderDetailForm.getDeliveryCharge());
        orderDetail.setMemberId(orderDetailForm.getMemberId());
        orderDetail.setRecipientName(orderDetailForm.getRecipientName());
        orderDetail.setPaymentMethod(orderDetailForm.getPaymentMethod());
        orderDetail.setOrderQuantity(orderDetailForm.getOrderQuantity());
        orderDetail.setTotalAmount(orderDetailForm.getTotalAmount());
        orderDetail.setOrderPhone(orderDetailForm.getOrderPhone());

        //OrderList DB에 저장
        OrderList orderlist = new OrderList();
        orderlist.setMemberId(orderDetailForm.getMemberId());
        orderlist.setProductNum(productNum);
        orderlist.setOrderNum(orderDetail.getOrderNum());

        orderDetailService.register(orderDetail);
        orderListService.register(orderlist);

        //Product의 수량 변경
        Product findProduct = service.findByProductNum(productNum);
        findProduct.setProductQuantity(findProduct.getProductQuantity() - orderDetailForm.getOrderQuantity());
        //DB에 저장
        service.update(findProduct);

        //주문 정상 완료되면 result화면으로 리다이렉트
        redirectAttributes.addAttribute("orderDetailNum",orderlist.getOrderNum());
        redirectAttributes.addAttribute("orderlistProductNum",orderlist.getProductNum());
        return"redirect:/shop/payment/result.do";
    }



}
