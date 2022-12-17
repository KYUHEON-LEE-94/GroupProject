package lee.GroupProject.domain.product.repository;

import lee.GroupProject.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, String>{
	// 아이디와 비밀번호에 의한 조회
	public Product findByProductNum(String ProductNum);

	//메인화면에 보여줄 제품, 수량 기준

	Page<Product> findAllBySexOrStatusOrTypeNum(String sex, String status, Integer typeNum, Pageable pageable);

	Page<Product> findAllByTypeNumBetween(Integer From, Integer To, Pageable pageable);

	//재고량이 적은 순으로 정렬
	List<Product> findAllByProductQuantityBetween(Integer from, Integer to);


}
