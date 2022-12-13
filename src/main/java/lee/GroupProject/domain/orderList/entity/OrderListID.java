package lee.GroupProject.domain.orderList.entity;

import lombok.*;

import java.io.Serializable;

/**
 * JPA사용 전제하에 복합키를 사용할 경우 필요한 Bean
 */

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderListID implements Serializable {

	private String orderNum;
	private String productNum;
	private String memberId;


}

