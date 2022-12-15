package lee.GroupProject.domain.orderDetail.service;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.repository.JpaOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private JpaOrderDetailRepository jpaOrderDetailRepository;

	@Override
	public OrderDetail register(OrderDetail orderDetail) {
		return jpaOrderDetailRepository.save(orderDetail);
	}

	//orderNum으로 해당하는 OrderDetail찾기
	@Override
	public OrderDetail findAllByOrderNum(String orderNum) {
		return jpaOrderDetailRepository.findAllByOrderNum(orderNum);
	}
}
