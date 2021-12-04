package model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Users")
@SecondaryTable(name = "BookInfo")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @Column(name = "userID")
    private @NotBlank Integer userid;

    @Column(name = "Bookname")
    private @NotBlank long productId;

    @ManyToOne
    @JoinColumn(name = "Bookname", referencedColumnName = "BookInfo", insertable = false, updatable = false)
    private Product product;

    private int quantity;

    public Cart() {

    }

    public Cart(CartDto cartDto, Product product, int userid) {
        this.userid = userid;
        this.productId = cartDto.getProductId();
        this.quantity = quantity;
    }

    public Cart(CartDto cartDto, Product product) {
        this.productId = cartDto.getProductId();
        this.quantity = cartDto.getQuantity();
        this.product = product;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
