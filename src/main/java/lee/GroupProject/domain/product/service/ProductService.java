package lee.GroupProject.domain.product.service;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.productType.service.ProductTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

	public void update (Product product);
	public List<Product> findAll();
	
	public Product findByProductNum(String ProductNum);



	//Paging처리
	public Page<Product> findProducts(String searchValue, Pageable pageable);

	Page<Product> findAllByTypeNumBetween(Integer searchAllFrom,Integer searchAllTo, Pageable pageable);
}
