package lee.GroupProject.web.shop;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.repository.JpaProductRepository;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
 * 메인 컨트롤러
 */
@Slf4j
@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ProductServiceImpl service;


	// 검색 및 페이징 처리 + list 목록 출력
	@GetMapping
	public String ProductPaging(@PageableDefault(page = 0, size = 6, sort = "productQuantity", direction = Sort.Direction.DESC) Pageable pageable, @RequestParam(required = false, defaultValue = "") String search, Model model) {
		//th:object 설정을 위한 Model.
		Product product = new Product();
		model.addAttribute("product", product);

		Page<Product> page = service.findProducts(search, pageable);

		List<Product> productList = page.getContent();


		long totalElements = page.getTotalElements();
		int requestPage = page.getPageable().getPageNumber() + 1;
		int totalPage = page.getTotalPages();
		int startPage = Math.max(1, requestPage - 4);
		int endPage   = Math.min(page.getTotalPages(), requestPage + 4);
		boolean hasPrevious = page.hasPrevious();
		boolean hasNext = page.hasNext();

		model.addAttribute("totalElements", totalElements);
		model.addAttribute("productList", productList);
		model.addAttribute("requestPage", requestPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("hasPrevious", hasPrevious);
		model.addAttribute("hasNext", hasNext);

		return "includes/shop";
	}


}
