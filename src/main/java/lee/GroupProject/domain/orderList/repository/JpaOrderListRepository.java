package lee.GroupProject.domain.orderList.repository;

import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.orderList.entity.OrderListID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderListRepository extends JpaRepository<OrderList, OrderListID>{
}
