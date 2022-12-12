package lee.GroupProject.domain.orderList.repository;

import lee.GroupProject.domain.orderList.entity.OrderLlist;
import lee.GroupProject.domain.orderList.entity.OrderLlistID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderListRepository extends JpaRepository<OrderLlist, OrderLlistID>{
}
