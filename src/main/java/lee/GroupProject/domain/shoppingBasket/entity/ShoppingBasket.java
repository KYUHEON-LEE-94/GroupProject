package lee.GroupProject.domain.shoppingBasket.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@IdClass(ShoppingBasketID.class)
public class ShoppingBasket {
	@Id
	@Column(name="member_id")
	private String memberId;
	@Id
	@Column(name="product_num")
	private String productNum;
	private Integer shoppingQuantity;
	private LocalDateTime shoppingDate;


}

