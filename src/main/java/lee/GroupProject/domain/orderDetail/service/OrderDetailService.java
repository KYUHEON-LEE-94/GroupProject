package lee.GroupProject.domain.orderDetail.service;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;

import java.util.Optional;

public interface OrderDetailService {
	
	/** 회원가입 */
	public OrderDetail register(OrderDetail orderDetail);

	public OrderDetail findAllByOrderNum(String orderNum);
	

}
