package lee.GroupProject.domain.product.repository;

import lee.GroupProject.domain.member.entity.Member;
import lee.GroupProject.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, String>{
	// 아이디와 비밀번호에 의한 조회
	public Product findByProductNum(String ProductNum);

	Page<Product> findAllBySexOrStatus(String sex, String status, Pageable pageable);


}
