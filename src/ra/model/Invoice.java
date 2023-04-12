package ra.model;

import java.io.Serializable;
import java.util.List;

public class Invoice implements Serializable {

    private int idInvoice;
    private User invoiceUser;
    private String address;
    private String phoneNumber;
    private  String createdDate;
    private float total;
    public Invoice() {
    }

    public Invoice(int idInvoice,User invoiceUser, String address, String phoneNumber,String createdDate) {
        this.idInvoice=idInvoice;
        this.invoiceUser = invoiceUser;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.createdDate=createdDate;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public User getInvoiceUser() {
        return invoiceUser;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setInvoiceUser(User invoiceUser) {
        this.invoiceUser = invoiceUser;
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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    public String showListProduct(){
        String str = "\n";
        for (Cart cart: invoiceUser.getCartList()
             ) {
            str+= "Sản phẩm:" + "\nid: " + cart.getProduct().getId() + "\nTên: " + cart.getProduct().getProductName() +
                    "\nGiá: " + cart.getProduct().getPrice() + "\nSố lượng: " + cart.getQuantity() +
                    "\nThành tiền: " + cart.getProduct().getPrice() * cart.getQuantity() + "\n";
        }
        return str;
    }
}
