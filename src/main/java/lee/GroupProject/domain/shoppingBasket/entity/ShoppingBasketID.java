package lee.GroupProject.domain.shoppingBasket.entity;

import lombok.*;

import java.io.Serializable;

/**
 * JPA사용 전제하에 복합키를 사용할 경우 필요한 Bean
 * @author LEE KYUHEON
 */

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingBasketID implements Serializable {

    private String memberId;
    private String productNum;
}
