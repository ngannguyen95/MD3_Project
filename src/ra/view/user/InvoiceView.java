package ra.view.user;

import ra.config.Config;
import ra.config.InputMethod;
import ra.controller.user.CartController;
import ra.controller.user.InvoiceController;
import ra.controller.user.UserController;
import ra.model.Cart;
import ra.model.Invoice;
import ra.model.User;
import ra.validate.Validate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceView {
    InvoiceController invoiceController = new InvoiceController();
    List<Invoice> listAllInvoices = invoiceController.findAll();
    CartController cartController = new CartController();
    List<Cart> cartList = cartController.getListCart();

    User userLogin = new UserController().getUserLogin();

    // xác nhận
    public void confirm() {
        if (cartList.size() == 0) {
            System.err.println("Chưa có hàng trong giỏ!!");
            new Profile().inforCart();
        }else {
            Invoice invoice = new Invoice();
            if (listAllInvoices.size() == 0) {
                invoice.setIdInvoice(1);
            } else {
                invoice.setIdInvoice(listAllInvoices.get(listAllInvoices.size() - 1).getIdInvoice() + 1);
            }
            invoice.setUserId(userLogin.getUserId());
            invoice.setEmail(userLogin.getEmail());
            invoice.setList(cartList);
            System.out.println("Nhập vào tên người nhận ");
            invoice.setReceiveName(InputMethod.getString());
            System.out.println("Nhập vào địa chỉ: ");
            invoice.setAddress(InputMethod.getString());
            String phone;
            while (true) {
                System.out.println("Số điện thoại : ");
                phone = InputMethod.getString();
                if (Validate.checkPhoneNumber(phone)) {
                    break;
                } else {
                    System.err.println("Số điện thoại không hợp lệ!!");
                }
            }
            invoice.setPhoneNumber(phone);
            // tính tổng tiền
            float total = 0;
            for (Cart cart : cartList) {
                total += cart.getProduct().getPrice() * cart.getQuantity();
            }
            invoice.setTotal(total);
            // thêm ngày
            Date date = new Date();
            String createdDate = date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getYear();
            invoice.setCreatedDate(createdDate);
            invoiceController.create(invoice);
            cartList = new ArrayList<>();
            userLogin.setCartList(cartList);
            new UserController().updateUserLogin(userLogin);
            System.out.println("Thanh toán thành công!!!");
        }
    }

    public void showHistory() {
        System.out.println("--------- Lịch sử mua hàng --------");
        List<Invoice> invoiceList = invoiceController.findAllByUserLogin();
        for (Invoice invoice : invoiceList) {
            System.out.println("\n----------------" +
                    "\nTên: " + invoice.getReceiveName() +
                    "\nĐịa chỉ: " + invoice.getAddress() +
                    "\nSố điện thoại: " + invoice.getPhoneNumber() +
                    "\nThông tin sản phẩm: " + invoice.showListProduct() +
                    "\nNgày tạo: " + invoice.getCreatedDate() +
                    "\n----------------\n"
            );
        }
    }

    // hiển thị tất cả hóa đơn của user
    public void showAllInvoices() {

        for (Invoice invoice : listAllInvoices) {
            List<Cart> cartList = invoice.getList();
            System.out.println("Khách hàng: " +invoice.getReceiveName());
            System.out.println("Địa chỉ:  " + invoice.getAddress());
            System.out.println("Số điện thoại: " + invoice.getPhoneNumber());
            float total = 0;
            for (Cart cart : cartList) {
                System.out.println("---------------" +
                        "\nTên sản phẩm: " + cart.getProduct().getProductName() +
                        "\nGiá:  " + cart.getProduct().getPrice() +
                        "\nSố lượng: " + cart.getQuantity() +
                        "\nThành tiền: " + cart.getProduct().getPrice() * cart.getQuantity() +
                        "\n---------------");
            }
            System.out.println("Tổng tiền: " + invoice.getTotal());
        }
    }

}
