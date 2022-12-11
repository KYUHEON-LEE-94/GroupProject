package lee.GroupProject.domain.orderDetail.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {
	@Id
	@Column(name="order_num")
	private String orderNum;
	private String memberId;
	private String recipientName;
	private String orderName;
	private String orderAddress;
	private String orderPhone;
	private Integer deliveryCharge;
	private Integer totalAmount;
	private Integer orderQuantity;
	private String paymentMethod;
	private LocalDateTime orderDate;
}

