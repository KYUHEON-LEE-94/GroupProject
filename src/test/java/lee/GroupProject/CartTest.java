package lee.GroupProject;

import lee.GroupProject.domain.shoppingBasket.service.ShoppingBasketService;
import lee.GroupProject.domain.shoppingBasket.service.ShoppingBasketServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartTest {
	@Autowired
	ShoppingBasketServiceImpl service;

	@Test
	void contextLoads() {
		service.deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc("Nonmember","GrayMM-UF");
	}

}
