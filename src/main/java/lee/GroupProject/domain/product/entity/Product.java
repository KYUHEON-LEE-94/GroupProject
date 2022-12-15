package lee.GroupProject.domain.product.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 제품 Bean
 * @author LEE KYUHEON
 */
@Entity
@DynamicInsert
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
	@Id
	@Column(name="product_num")
	private String productNum;
	private Integer typeNum;
	private String productPhoto;
	private Integer productPrice;
	private String productName;
	private Integer productQuantity;
	private String sex;
	private String productSize;
	private String	status;
	private String description;

}

