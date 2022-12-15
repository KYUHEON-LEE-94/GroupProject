package lee.GroupProject.domain.productType.repository;

import lee.GroupProject.domain.product.entity.Product;
import lee.GroupProject.domain.productType.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author LEE KYUHEON
 */
@Repository
public interface JpaProductTypeRepository extends JpaRepository<ProductType, Integer>{


}
