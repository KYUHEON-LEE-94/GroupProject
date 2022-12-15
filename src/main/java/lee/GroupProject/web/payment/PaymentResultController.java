package lee.GroupProject.web.payment;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.service.OrderDetailServiceImpl;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/shop/payment/result.do")
public class PaymentResultController {
    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    /**
     * @author LEE KYUHEON
     *
     * PaymentController에서 넘어온 파라미터 2개를 받습니다.
     * orderDetailNum,orderlistProductNum
     * 1. 받아온 파라미터 2개로 해당하는 product 와 orderDetail을 찾아옵니ㅏ.
     * 2. 생성된 객체는 view로 전달해서 사용합니다.
     */
    public String doGet(@RequestParam("orderDetailNum") String orderDetailNum,
                        @RequestParam("orderlistProductNum") String orderlistProductNum,
                        HttpServletRequest request,
                        Model model){

        Product product = productService.findByProductNum(orderlistProductNum);
        OrderDetail orderDetail = orderDetailService.findAllByOrderNum(orderDetailNum);
        model.addAttribute("product",product);
        model.addAttribute("orderDetail",orderDetail);
        return "/includes/paymentResult";

    }
}
