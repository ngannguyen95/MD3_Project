package ra.model;

import ra.model.Category;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String productName;
    private float  price;
    private Category category;
    private boolean status;

    public Product() {
    }

    public Product(int id, String productName, float price, Category category, boolean status) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "------------------" +
                "\nId:   " + id +
                "\nTên sản phẩm:   " + productName +
                "\nGiá:   " + price +
                "\nTên danh mục:   " + category.getCategoryName()
                ;
    }
}
