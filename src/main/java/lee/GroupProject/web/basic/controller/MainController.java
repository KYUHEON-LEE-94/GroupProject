package lee.GroupProject.web.basic.controller;



import lee.GroupProject.domain.member.dto.LoginForm;
import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.member.service.MemberService;
import lee.GroupProject.domain.member.service.MemberServiceImpl;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lee.GroupProject.domain.shoppingBasket.service.ShoppingBasketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
public class MainController {
	@Autowired
	ProductServiceImpl productService;

	@Autowired
	private MemberServiceImpl memberService;

	@GetMapping("/")
	public String main(Model model){

		return "includes/IndexContent";
	}

	//로그인 페이지로 이동
	@GetMapping("/signup")
	public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm, @CookieValue(value = "rememberId", required = false) String rememberId, Model model) {

		if(rememberId != null) {
			loginForm.setMemberId(rememberId);
			loginForm.setRemember(true);
		}

		return "includes/loginForm";
	}

	//로그인 PostMapping
	@PostMapping("/signin")
	public String login(@Validated @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
						@RequestParam(name = "redirect", defaultValue = "/") String redirect, HttpServletRequest request, HttpServletResponse response, Model model) {

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


		if(loginForm.getMemberId().equalsIgnoreCase("admin1234")){
			session.setAttribute("admin", loginMember);
		}



		// 로그인 저장 체크시
		if(loginForm.getRemember() == true) {
			Cookie cookie = new Cookie("rememberId", loginMember.getMemberId());
			cookie.setMaxAge(60*60*24*30);
			cookie.setPath("/");
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("rememberId", "");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "redirect:"+redirect;
	}

	//로그 아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session  = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}


}
