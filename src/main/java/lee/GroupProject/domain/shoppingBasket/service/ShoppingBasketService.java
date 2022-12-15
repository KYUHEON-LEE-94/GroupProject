package lee.GroupProject.domain.shoppingBasket.service;

import lee.GroupProject.domain.productType.entity.ProductType;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;

import java.util.List;

/**
 * @author LEE KYUHEON
 */
public interface ShoppingBasketService {

    public void register(ShoppingBasket shoppingBasket);

    public List<ShoppingBasket> findAllByMemberIdOrderByShoppingDateAsc(String memberId);

    public void deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc(String memberId, String productNum);

}
