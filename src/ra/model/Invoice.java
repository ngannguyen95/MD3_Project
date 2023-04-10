package ra.model;

import java.io.Serializable;
import java.util.List;

public class Invoice implements Serializable {

    private int idInvoice;
    private User invoiceUser;
    private String address;
    private String phoneNumber;

    public Invoice() {
    }

    public Invoice(int idInvoice,User invoiceUser, String address, String phoneNumber) {
        this.idInvoice=idInvoice;
        this.invoiceUser = invoiceUser;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
}
