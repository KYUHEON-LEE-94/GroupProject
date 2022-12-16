package lee.GroupProject.web.shoppingbasket;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.orderDetail.dto.OrderDetailForm;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;
import lee.GroupProject.domain.shoppingBasket.service.ShoppingBasketServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * shop-singles에서 buy 버튼을 누르면 바로 장바구니 DB에 저장해서 고객이 해당 제품을 구매하려다가 다른 제품을 보러가더라도,
 * 장바구니 DB에 남겨놓을 수 있도록 해야함
 * 그렇기 때문에 shopSingles의 form을 post 방식으로 여기에 전달해서 장바구니 DB에 한차례 저장한 후에 paymentController로 보내게 됩니다.
 * paymentcontroller에서는 더욱 상세한 정보를 받아서 DB에 저장하는 절차를 진행합니다.
 * @author LEE KYUHEON
 */
@Controller
@RequestMapping("/shop/cart.do")
public class ShoppingBasketController {
    @Autowired
    private ShoppingBasketServiceImpl shoppingBasketService;

    @Autowired
    private MemberServiceImpl memberService;

    @PostMapping
    public String doPost(@RequestParam(value = "product-quanity", required = false, defaultValue = "1") Integer productQuantity,
                         @RequestParam("productNum") String productNum,
                         HttpServletRequest request){

        //세션을 통해서 로그인 여부를 확인한다.
        HttpSession session = request.getSession();
        Members members = (Members) session.getAttribute("loginMember");

        //장바구니 DB에 저장하는 코드
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.setShoppingQuantity(productQuantity);
        shoppingBasket.setProductNum(productNum);

        //세션에서 찾아온 members가 있다면 해당 id를 사용해서 DB에 저장하고,
        if(members != null){
            shoppingBasket.setMemberId(members.getMemberId());
        }
        //없으면 Nonmember를 사용해서 저장한다.
        if(members == null){
            Optional<Members> nonmember = memberService.findMember("Nonmember");
            shoppingBasket.setMemberId(nonmember.get().getMemberId());
        }

        shoppingBasketService.register(shoppingBasket);

        return "redirect:/shop/payment.do";
    }



    @GetMapping
    public String showCart(@RequestParam("memberId") String memberId, Model model){
        List<ShoppingBasket> list = shoppingBasketService.findAllByMemberIdOrderByShoppingDateDesc(memberId);
        model.addAttribute("list", list);
        return "includes/cart";

    }


}
