package lee.GroupProject.web.signup;

import lee.GroupProject.domain.member.dto.MemberForm;
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
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * 회원가입 컨트롤러
 * @author LEE KYUHEON
 */
@Slf4j
@Controller
@RequestMapping("/members/signup")
public class SignupFormController {


    @Autowired
    private MemberServiceImpl memberService;





    @GetMapping()
    public String doGet(Model model,
                        HttpServletRequest request,
                        @ModelAttribute("members") Members members){



        return "includes/signupForm";
    }
    @PostMapping()
    public String doPost(@Validated @ModelAttribute("members") MemberForm members,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,
                         HttpServletRequest request,Model model){

        if (bindingResult.hasErrors()) {
            return "includes/signupForm";
        }

        Members registerMember = new Members();
        registerMember.setMemberId(members.getMemberId());
        registerMember.setMemberPw(members.getMemberPw());
        registerMember.setMemberName(members.getMemberName());
        registerMember.setMemberEmail(members.getMemberEmail());
        registerMember.setPhoneNum(members.getPhoneNum());
        registerMember.setHomeNum(members.getHomeNum());
        registerMember.setMemberAddress(members.getMemberAddress());

        memberService.register(registerMember);


        return "redirect:/";
    }



}
