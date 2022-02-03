package bg.codexio.brainstars.products.service.product;

import bg.codexio.brainstars.products.entity.Product;
import bg.codexio.brainstars.products.payload.CategoryProductsAvailabilityDto;
import bg.codexio.brainstars.products.payload.ProductDto;
import bg.codexio.brainstars.products.payload.ProductCreateDto;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductCreateDto request);

    ProductDto updateProduct(Long productId, ProductCreateDto request);

    ProductDto deleteProduct(Long productId);

    ProductDto orderProduct(Long productId, int quantity);

    List<CategoryProductsAvailabilityDto> getAllCategoriesAndProductAvailability();

    List<ProductDto> getAllProducts(int page, int pageSize, String orderBy, String direction, Specification<Product> productSpecification);
}
