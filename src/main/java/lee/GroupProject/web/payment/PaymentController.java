package lee.GroupProject.web.payment;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.orderDetail.dto.OrderDetailForm;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.service.OrderDetailServiceImpl;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.orderList.service.OrderListServiceImpl;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lee.GroupProject.web.common.filter.NonMemberCount;
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
import java.util.UUID;

import static lee.GroupProject.web.common.filter.NonMemberCount.getCount;

/**
 * 주문 정보를 받아서 처리하는 Controller
 * @author LEE KYUHEON
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



    @GetMapping()
    public String doGet(@RequestParam("productNum") String productNum,
                        @RequestParam("product-quanity") Integer quantity,
                        Model model,
                        HttpServletRequest request){
        OrderDetailForm orderDetailForm = new OrderDetailForm();
        model.addAttribute("orderDetailForm",orderDetailForm);

        Product product = service.findByProductNum(productNum);
        Integer totalPrice = (product.getProductPrice() * quantity) + 2500;
        model.addAttribute("product",product);
        model.addAttribute("quantity",quantity);
        //총금액 계산해서 model에 보내서 사용
        model.addAttribute("totalPrice",totalPrice);

        //Session으로 loginMember를 얻어와서, 있으면 members 객체를 전달 / 없으면 null값으로 전달
        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");
        if(session.getAttribute("loginMember") != null){
            model.addAttribute("members",members);
        }else{
            model.addAttribute("member",null);
            model.addAttribute("count", NonMemberCount.getCount());
        }



        return "includes/payment";
    }

    @PostMapping()
    public String doPost( @ModelAttribute("orderDetailForm") OrderDetailForm orderDetailForm,
            @RequestParam("productNum") String productNum,
            BindingResult bindingResult, RedirectAttributes redirectAttributes){

//        if (bindingResult.hasErrors()) {
//            log.info("bindingResults : {}", bindingResult);
//            return "includes/payment";
//        }

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
        log.info("orderDetail: {}",orderDetail);


        OrderList orderlist = new OrderList();
        orderlist.setMemberId(orderDetailForm.getMemberId());
        orderlist.setProductNum(productNum);
        orderlist.setOrderNum(orderDetail.getOrderNum());
        log.info("오더리스트: {}",orderlist);

        orderDetailService.register(orderDetail);
        orderListService.register(orderlist);

        //주문 정상 완료되면 result화면으로 리다이렉트
        redirectAttributes.addAttribute("orderDetailNum",orderlist.getOrderNum());
        redirectAttributes.addAttribute("orderlistProductNum",orderlist.getProductNum());
        return"redirect:/shop/payment/result.do";
    }
}
