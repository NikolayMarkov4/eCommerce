package bg.codexio.brainstars.products.controller;

import bg.codexio.brainstars.products.entity.Product;
import bg.codexio.brainstars.products.payload.ProductCreateDto;
import bg.codexio.brainstars.products.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateDto requestDto) {
        return new ResponseEntity<>(this.productService.createProduct(requestDto), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> update(@PathVariable Long productId, @RequestBody ProductCreateDto model) {
        return new ResponseEntity<>(this.productService.updateProduct(productId, model), HttpStatus.OK);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return new ResponseEntity<>(this.productService.deleteProduct(productId), HttpStatus.OK);
    }

    @PostMapping("/{productId}/order/{quantity}")
    public ResponseEntity<?> orderProductQuantity(@PathVariable Long productId, @PathVariable int quantity) {
        return new ResponseEntity<>(this.productService.orderProduct(productId, quantity), HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> allCategoriesAndProductsAvailability(){
        return new ResponseEntity<>(this.productService.getAllCategoriesAndProductAvailability(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts( @RequestParam(required = false, defaultValue = "1") int page,
                                             @RequestParam(required = false, defaultValue = "10") int pageSize,
                                             @RequestParam(required = false) String orderBy,
                                             @RequestParam(required = false) String direction,
                                             Specification<Product> productSpecification
    ){
        return new ResponseEntity<>(this.productService.getAllProducts(page,pageSize,orderBy,direction,productSpecification), HttpStatus.OK);
    }



}
