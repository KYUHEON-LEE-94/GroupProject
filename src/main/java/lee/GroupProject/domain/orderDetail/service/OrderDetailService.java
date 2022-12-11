package lee.GroupProject.domain.orderDetail.service;

import lee.GroupProject.domain.member.entity.Member;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
	
	/** 회원가입 */
	public OrderDetail register(OrderDetail orderDetail);
	

}
