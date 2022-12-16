package lee.GroupProject.domain.shoppingBasket.service;

import lee.GroupProject.domain.productType.entity.ProductType;
import lee.GroupProject.domain.productType.repository.JpaProductTypeRepository;
import lee.GroupProject.domain.productType.service.ProductTypeService;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;
import lee.GroupProject.domain.shoppingBasket.repository.JpaShoppingBasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LEE KYUHEON
 */
@Service
@Transactional
public class ShoppingBasketServiceImpl implements ShoppingBasketService {
	@Autowired
	JpaShoppingBasketRepository jpaShoppingBasketRepository;

	@Override
	public void register(ShoppingBasket shoppingBasket) {
		jpaShoppingBasketRepository.save(shoppingBasket);

	}

	@Override
	public List<ShoppingBasket> findAllByMemberIdOrderByShoppingDateDesc(String memberId) {
		return jpaShoppingBasketRepository.findAllByMemberIdOrderByShoppingDateDesc(memberId);
	}

	@Override
	public void deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc(String memberId, String productNum) {
		jpaShoppingBasketRepository. deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc(memberId, productNum);
	}
}
