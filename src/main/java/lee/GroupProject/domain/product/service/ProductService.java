package lee.GroupProject.domain.product.service;

import lee.GroupProject.domain.member.entity.Member;
import lee.GroupProject.domain.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	public List<Product> findAll();
	
	public Product findByProductNum(String ProductNum);

	//Paging처리
	public Page<Product> findProducts(String searchValue, Pageable pageable);
}
