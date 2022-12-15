package lee.GroupProject.domain.productType.service;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.productType.entity.ProductType;
/**
 * @author LEE KYUHEON
 */
public interface ProductTypeService {

	/** 회원가입 */
	public ProductType register(ProductType productType);

}
