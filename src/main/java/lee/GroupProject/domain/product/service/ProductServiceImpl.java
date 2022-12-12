package lee.GroupProject.domain.product.service;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private JpaProductRepository jpaProductRepository;

	@Override
	public List<Product> findAll() {
		return jpaProductRepository.findAll();
	}

	@Override
	public Product findByProductNum(String ProductNum) {
		return jpaProductRepository.findByProductNum(ProductNum);
	}


	@Override
	public Page<Product> findProducts(String searchValue, Pageable pageable) {
		Integer searchValueInt;
		try {
			searchValueInt = Integer.parseInt(searchValue);
		}catch (NumberFormatException n){
			return jpaProductRepository.findAllBySexOrStatusOrTypeNum(searchValue, "true",null, pageable);
		}
		return jpaProductRepository.findAllBySexOrStatusOrTypeNum(searchValue, "true",searchValueInt, pageable);
	}

	/**
	 * 받는 파라미터가 숫자가 아닌 경우를 고려한 try~catch
	 * SQL BETWEEN 처리를 위한 파라미터 받기
	 * @param searchAllFrom  : ~부터
	 * @param searchAllTo : ~까지
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Product> findAllByTypeNumBetween(Integer searchAllFrom, Integer searchAllTo,Pageable pageable) {
		try {
			return jpaProductRepository.findAllByTypeNumBetween(searchAllFrom, searchAllTo, pageable);
		}catch (NumberFormatException n){
			return jpaProductRepository.findAllByTypeNumBetween(null, null, pageable);
		}

	}
}
