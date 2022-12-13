package lee.GroupProject.domain.orderList.repository;

import lee.GroupProject.domain.member.entity.Members;
import lee.GroupProject.domain.orderDetail.entity.OrderDetail;
import lee.GroupProject.domain.orderList.entity.OrderList;
import lee.GroupProject.domain.orderList.entity.OrderListID;
import lee.GroupProject.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderListRepository extends JpaRepository<OrderList, OrderListID>{

    public Product findByProductNum(String productNum);

    public OrderDetail findByOrderNum(String orderNum);
}
