package lee.GroupProject.domain.orderList.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@IdClass(OrderListID.class)
public class OrderList {
	@Id
	@Column(name="order_num")
	private String orderNum;
	@Id
	@Column(name="product_num")
	private String productNum;
	@Id
	@Column(name="member_id")
	private String memberId;


}

