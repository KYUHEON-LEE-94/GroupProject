package lee.GroupProject.domain.orderDetail.repository;

import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderDetailRepository extends JpaRepository<OrderDetail, String>{

}