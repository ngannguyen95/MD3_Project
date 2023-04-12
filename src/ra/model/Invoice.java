package ra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Invoice implements Serializable {

    private int idInvoice;
    private int userId;
    private String email;
    private String receiveName;
    private List<Cart> list = new ArrayList<>() ;
    private String address;
    private String phoneNumber;
    private  String createdDate;
    private float total;
    public Invoice() {
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public List<Cart> getList() {
        return list;
    }

    public void setList(List<Cart> list) {
        this.list = list;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String showListProduct(){
        String str = "\n";
        for (Cart cart: list
             ) {
            str+= "Sản phẩm:" + "\nid: " + cart.getProduct().getId() + "\nTên: " + cart.getProduct().getProductName() +
                    "\nGiá: " + cart.getProduct().getPrice() + "\nSố lượng: " + cart.getQuantity() +
                    "\nThành tiền: " + cart.getProduct().getPrice() * cart.getQuantity() + "\n";
        }
        return str;
    }
}
