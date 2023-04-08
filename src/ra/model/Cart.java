package ra.model;

import java.io.Serializable;

public class Cart implements Serializable{
    private Product product;
    private float quantity;

    public Cart() {
    }

    public Cart(Product product, float quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

}
