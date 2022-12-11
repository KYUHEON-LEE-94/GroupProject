package lee.GroupProject.web.basic.controller;



import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
public class MainController {
	@Autowired
	ProductServiceImpl productService;
	@GetMapping("/")
	public String main(Model model){

		return "includes/IndexContent";
	}


}
