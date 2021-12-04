package dto;

import model.Cart;

import javax.validation.constraints.NotNull;

public class CartDto {
    private Integer id;
    private @NotNull Integer userid;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    public CartDto() {

    }
    public CartDto(Cart cart) {
        this.setId(cart.getId());
        this.setUserId(cart.getUserid());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "id=" + id +
                ", userId=" + userid +
                ", quantity=" + quantity +
                ", productName=" + product.getName() +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void  setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userid;
    }

    public void setUserId(Integer userId) {
        this.userid = userId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
