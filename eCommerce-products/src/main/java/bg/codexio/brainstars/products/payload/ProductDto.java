package bg.codexio.brainstars.products.payload;

import bg.codexio.brainstars.products.entity.Product;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Date;

@Builder
public class ProductDto {

    private Long id;

    private String name;

    private String category;

    private String description;

    private int quantity;

    private LocalDate createdDate;

    private LocalDate lastModifiedDate;

    public ProductDto() {
    }

    public ProductDto(Long id,
                      String name,
                      String category,
                      String description,
                      int quantity,
                      LocalDate createdDate,
                      LocalDate lastModifiedDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.quantity = quantity;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public static ProductDto fromProduct(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .createdDate(product.getCreatedDate())
                .lastModifiedDate(product.getLastModifiedDate())
                .build();
    }
}
