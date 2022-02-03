package bg.codexio.brainstars.products.payload;

public class ProductQuantityOrderDto {
    private Long productId;

    private String product;

    private Long quantity;

    public ProductQuantityOrderDto() {
    }

    public ProductQuantityOrderDto(Long productId, String product, Long quantity) {
        this.productId = productId;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
