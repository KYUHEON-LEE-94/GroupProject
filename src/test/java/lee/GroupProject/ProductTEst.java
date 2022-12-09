package lee.GroupProject;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.repository.JpaProductRepository;
import lee.GroupProject.domain.product.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductTEst {

	@Autowired
	private ProductServiceImpl service;

	@Test
	void contextLoads() {
		Product product = service.findByProductNum("BlackMM-UF");

	System.out.println(product);
	}

}
