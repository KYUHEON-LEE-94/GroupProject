package lee.GroupProject.domain.orderDetail.dto;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;


@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailForm {
	//주문번호는 생성해서 사용할거기 때문에 받아오지 않음

	private String memberId;
	@NotBlank(message = "수령자 이름은 필수입니다.")
	@Pattern(regexp="[a-zA-Z가-핳]", message = "한글 또는 영어로 입력해주세요")
	private String recipientName;
	private String orderName;
	@NotBlank(message = "주소는 필수입니다.")
	@Pattern(regexp="[a-zA-Z가-핳]", message = "한글 또는 영어로 입력해주세요")
	private String orderAddress;
	private String  orderPhone;
	private Integer deliveryCharge;
	private Integer totalAmount;
	private Integer orderQuantity;
	private String paymentMethod;
	private LocalDateTime orderDate;
}

