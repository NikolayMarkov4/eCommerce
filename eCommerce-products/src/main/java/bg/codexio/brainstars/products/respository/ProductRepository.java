package bg.codexio.brainstars.products.respository;

import bg.codexio.brainstars.products.entity.Product;
import bg.codexio.brainstars.products.payload.CategoryProductsAvailabilityDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select new bg.codexio.brainstars.products.payload." +
            "CategoryProductsAvailabilityDto(p.category, count(p.category))" +
            " from Product as p" +
            " group by p.category")
    List<CategoryProductsAvailabilityDto> findAllCategoriesAndProductAvailability();
}
