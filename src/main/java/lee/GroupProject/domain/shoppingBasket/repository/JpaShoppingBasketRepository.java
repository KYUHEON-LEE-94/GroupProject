package lee.GroupProject.domain.shoppingBasket.repository;

import lee.GroupProject.domain.productType.entity.ProductType;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasket;
import lee.GroupProject.domain.shoppingBasket.entity.ShoppingBasketID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LEE KYUHEON
 */
@Repository
public interface JpaShoppingBasketRepository extends JpaRepository<ShoppingBasket, ShoppingBasketID>{

    public List<ShoppingBasket> findAllByMemberIdOrderByShoppingDateAsc(String MemberID);

    public void deleteShoppingBasketByMemberIdAndProductNumOrderByShoppingDateAsc(String memberId, String productNum);

}
