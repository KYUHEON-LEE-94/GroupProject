package lee.GroupProject.web.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
public class ShopSinglesController {
	@GetMapping("/shopSingles.do")
	public String main(){
		return "includes/shop-single";
	}


}
