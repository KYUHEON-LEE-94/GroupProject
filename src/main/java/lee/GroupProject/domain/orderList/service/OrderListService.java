package lee.GroupProject.domain.orderList.service;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.product.entity.Product;

public interface OrderListService {
	
	/** 회원가입 */
	public OrderList register(OrderList orderList);

	public Product findByProductNum(String productNum);

	public OrderDetail findByOrderNum(String orderNum);
}
