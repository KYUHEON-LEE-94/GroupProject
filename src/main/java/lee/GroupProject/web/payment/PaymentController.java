package lee.GroupProject.web.payment;

import lee.GroupProject.domain.orderDetail.dto.OrderDetailForm;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
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

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;

/**
 * 주문 정보를 받아서 처리하는 Controller
 * @author LEE KYUHEON
 */
@Slf4j
@Controller
@RequestMapping("/shop/payment.do")
public class PaymentController {
    @Autowired
    private ProductServiceImpl service;



    @GetMapping()
    public String doGet(@RequestParam("productNum") String productNum,
                        @RequestParam("product-quanity") Integer quanity,
                        Model model){
        OrderDetail orderDetail = new OrderDetail();
        model.addAttribute("orderDetail",orderDetail);

        Product product = service.findByProductNum(productNum);
        Integer totalPrice = (product.getProductPrice() * quanity) + 2500;
        model.addAttribute("product",product);
        model.addAttribute("quanity",quanity);
        //총금액 계산해서 model에 보내서 사용
        model.addAttribute("totalPrice",totalPrice);


        return "includes/payment";
    }

    @PostMapping()
    public String doPost(@Validated @ModelAttribute("orderDetailForm") OrderDetailForm orderDetailForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            log.info("bindingResults : {}", bindingResult);
            // BindingResult는 모델에 자동 저장된다.
            return "includes/payment";
        }

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

        return"redirect:/includes/payment";
    }
}
