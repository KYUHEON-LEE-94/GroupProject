package lee.GroupProject.domain.shoppingBasket.entity;

import lombok.*;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShoppingBasketID implements Serializable {

    private String memberId;
    private String productNum;
}
