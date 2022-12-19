package lee.GroupProject.web.shop;

import lee.GroupProject.common.error.YzRuntimeException;
import lee.GroupProject.domain.member.entity.Members;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Shop Main 컨트롤러
 * @author LEE KYUHEON
 */

@Slf4j
@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ProductServiceImpl service;


	// 검색 및 페이징 처리 + list 목록 출력
	@GetMapping
	public String ProductPaging(@PageableDefault(page = 0, size = 6, sort = "productQuantity", direction = Sort.Direction.DESC) Pageable pageable,
								@RequestParam(required = false, defaultValue = "") String search,
								@RequestParam(required = false, defaultValue = "") Integer searchAll,
								HttpServletRequest request,
								Model model) {
		//th:object 설정을 위한 Model.
		Product product = new Product();
		model.addAttribute("product", product);

		HttpSession session = request.getSession();
		Members members = (Members) session.getAttribute("loginMember");
		if(members != null){
			model.addAttribute("members",members);
		}else if(members == null){
			model.addAttribute("members",null);
		}

		//paging 처리를 위한 service 처리
		Page<Product> page = service.findProducts(search, pageable);

		//만약 searchALl(모두 검색) 파라미터가 있다면 아래와 같이 처리를 하겠다.
		/**
		 * 8000 = 모든 맨투맨
		 * 8501 = 모든 후드티
		 */
		if(searchAll != null){
			if (8000 == searchAll){
				Integer searAllTo = 8500;
				page = service.findAllByTypeNumBetween(searchAll,searAllTo, pageable);
			}else if(8501 == searchAll ){
				Integer searAllTo = 9000;
				page = service.findAllByTypeNumBetween(searchAll,searAllTo, pageable);
			}

		}

		//paging 처리를 위한 getContent()
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
