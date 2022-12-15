package lee.GroupProject.domain.productType.service;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.product.repository.JpaProductRepository;
import lee.GroupProject.domain.product.service.ProductService;
import lee.GroupProject.domain.productType.entity.ProductType;
import lee.GroupProject.domain.productType.repository.JpaProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LEE KYUHEON
 */
@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private JpaProductTypeRepository jpaProductTypeRepository;

	@Override
	public ProductType register(ProductType productType) {
		return jpaProductTypeRepository.save(productType);
	}

}
