package lee.GroupProject.web.admin.loginform;

import lee.GroupProject.domain.member.dto.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
@RequestMapping("/admin/loginForm")
public class LoginformController {

	@GetMapping
	public String doGet(@ModelAttribute("loginForm") LoginForm loginForm,
						@CookieValue(value = "rememberId", required = false) String rememberId,
						Model model){

		 return "admin/includes/loginForm";
	}


}
