package lee.GroupProject.domain.orderList.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * JPA사용 전제하에 복합키를 사용할 경우 필요한 Bean
 */

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderLlistID implements Serializable {

	private String orderNum;
	private String productNum;
	private String memberId;


}

