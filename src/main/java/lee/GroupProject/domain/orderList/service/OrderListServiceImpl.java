package lee.GroupProject.domain.orderList.service;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderDetail.repository.JpaOrderDetailRepository;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.orderList.repository.JpaOrderListRepository;
import lee.GroupProject.domain.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderListServiceImpl implements OrderListService {
	@Autowired
	private JpaOrderListRepository jpaOrderListRepository;

	@Override
	public OrderList register(OrderList orderList) {
		return jpaOrderListRepository.save(orderList);
	}

	@Override
	public Product findByProductNum(String productNum) {
		return jpaOrderListRepository.findByProductNum(productNum);
	}

	@Override
	public OrderDetail findByOrderNum(String orderNum) {
		return jpaOrderListRepository.findByOrderNum(orderNum);
	}
}
