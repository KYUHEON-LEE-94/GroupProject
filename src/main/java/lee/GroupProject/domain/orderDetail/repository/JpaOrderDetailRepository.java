package lee.GroupProject.domain.orderDetail.repository;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaOrderDetailRepository extends JpaRepository<OrderDetail, String>{

    public OrderDetail findAllByOrderNum(String memberId);

}
