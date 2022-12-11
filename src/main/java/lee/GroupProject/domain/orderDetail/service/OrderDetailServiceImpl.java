package lee.GroupProject.domain.orderDetail.service;

import lee.GroupProject.domain.member.entity.Member;
import lee.GroupProject.domain.member.repository.JpaMemberRepository;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.repository.JpaOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
