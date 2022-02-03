package bg.codexio.brainstars.products.service.product;

import bg.codexio.brainstars.products.entity.Product;
import bg.codexio.brainstars.products.payload.CategoryProductsAvailabilityDto;
import bg.codexio.brainstars.products.payload.ProductDto;
import bg.codexio.brainstars.products.payload.ProductCreateDto;
import bg.codexio.brainstars.products.respository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDto createProduct(ProductCreateDto request) {
        Product product = this.productRepository.save(Product.builder()
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .createdDate(LocalDateTime.now().toLocalDate())
                .build());

        return ProductDto.fromProduct(product);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductCreateDto request) {
        Product product = this.productRepository
                .findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        product = this.productRepository.save(Product.builder()
                .id(product.getId())
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(LocalDateTime.now().toLocalDate()).build());

        return ProductDto.fromProduct(product);
    }

    @Override
    public ProductDto deleteProduct(Long productId) {
        Product deletedProduct = this.productRepository
                .findById(productId)
                .orElseThrow(IllegalArgumentException::new);

        this.productRepository.deleteById(productId);

        return  ProductDto.fromProduct(deletedProduct);
    }

    @Override
    public ProductDto orderProduct(Long productId, int quantity) {
        Product product = this.productRepository.findById(productId).orElseThrow(IllegalArgumentException::new);

        if (product.getQuantity() - quantity < 0) {
            throw new IllegalArgumentException();
        }

        product.setQuantity(product.getQuantity() - quantity);

        //todo: call back the order service

        return ProductDto.fromProduct(this.productRepository.save(product));
    }

    @Override
    public List<CategoryProductsAvailabilityDto> getAllCategoriesAndProductAvailability() {
        return this.productRepository.findAllCategoriesAndProductAvailability();
    }

    @Override
    public List<ProductDto> getAllProducts(int page, int pageSize, String orderBy, String direction, Specification<Product> productSpecification) {


    }


}
