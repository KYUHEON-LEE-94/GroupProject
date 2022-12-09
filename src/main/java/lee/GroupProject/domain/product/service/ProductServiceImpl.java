package lee.GroupProject.domain.product.service;

import lee.GroupProject.domain.member.entity.Member;
import lee.GroupProject.domain.member.repository.JpaMemberRepository;
import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.repository.JpaProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
