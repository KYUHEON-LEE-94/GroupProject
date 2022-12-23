package lee.GroupProject.web.admin;

import lee.GroupProject.domain.member.dto.LoginForm;
import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Admin Page Controller
 * @author LEE KYUHEON
 */
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private MemberServiceImpl memberService;

    @Autowired
    private ProductServiceImpl productService;


    @GetMapping()
    public String doGet(@RequestParam(value = "quantityFrom", required = false, defaultValue = "0") Integer quantityFrom,
                        @RequestParam(value= "quantityTo", required = false, defaultValue = "50") Integer quantityTo,
            Model model){
        //재고량 현황을 위한 view 전달
        List<Product> products = productService.findAllByProductQuantityBetween(quantityFrom,quantityTo);
        model.addAttribute("products",products);

        return "admin/admin";
    }


    @PostMapping("/login")
    public String DoSignIn(@Validated @ModelAttribute("loginForm") LoginForm loginForm,
                           BindingResult bindingResult,
                           @RequestParam(name = "redirect", defaultValue = "/") String redirect,
                           HttpServletRequest request, HttpServletResponse response,
                           Model model){

        if(bindingResult.hasErrors()) {
            // BindingResult는 모델에 자동 저장된다.
            return "includes/loginForm";
        }

        Members loginMember = memberService.isMember(loginForm.getMemberId(), loginForm.getMemberPw());
        if(loginMember == null) {
            // 글로벌 오류 생성 및 로그인화면으로 포워드
            bindingResult.reject("loginFail", "아이디 또는 비밀번호를 확인하여 주세요.");
            return "includes/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);

        // 로그인 저장 체크시
        Cookie cookie;
        if(loginForm.getRemember()) {
            cookie = new Cookie("rememberId", loginMember.getMemberId());
            cookie.setMaxAge(60*60*24*30);
        }else {
            cookie = new Cookie("rememberId", "");
            cookie.setMaxAge(0);
        }
        cookie.setPath("/");
        response.addCookie(cookie);


        return "redirect:"+redirect;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session  = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }



}
