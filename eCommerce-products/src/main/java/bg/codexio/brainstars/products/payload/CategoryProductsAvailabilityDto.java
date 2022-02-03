package bg.codexio.brainstars.products.payload;

public class CategoryProductsAvailabilityDto {

    private String categoryName;

    private Long productsAvailable;

    public CategoryProductsAvailabilityDto() {
    }

    public CategoryProductsAvailabilityDto(String categoryName, Long productsAvailable) {
        this.categoryName = categoryName;
        this.productsAvailable = productsAvailable;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getProductsAvailable() {
        return productsAvailable;
    }

    public void setProductsAvailable(Long productsAvailable) {
        this.productsAvailable = productsAvailable;
    }
}
