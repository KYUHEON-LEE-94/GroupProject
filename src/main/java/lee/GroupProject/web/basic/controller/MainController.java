package lee.GroupProject.web.basic.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
public class MainController {
	@GetMapping("/")
	public String main(){
		return "includes/mainContent";
	}


}
