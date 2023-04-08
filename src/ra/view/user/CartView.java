package ra.view.user;

import ra.config.Config;
import ra.config.InputMethod;
import ra.controller.user.CartController;
import ra.model.Cart;
import ra.model.Product;

import java.util.List;

public class CartView {
    CartController cartController = new CartController();
    List<Cart> cartList = cartController.getListCart();
    List<Product> productList=new Config<Product>().readFromFile(Config.PATH_PRODUCT);

    public void showFormCart() {
        System.out.println("Hiển thị giỏ hàng:  ");
        float total = 0;
        for (Cart cart : cartList) {
            total = cart.getProduct().getPrice() * cart.getQuantity();
            System.out.println("Sản phẩm: " + cart.getProduct() + " giá: " + cart.getProduct().getPrice() + " số lượng: " + cart.getQuantity());
        }
        System.out.println("Tổng giá : " + total);
    }

    public void createFormCart() {
        System.out.println("---------- Thông tin sản phẩm:------------");
        for (Product product:productList) {
            System.out.println("Id:  "+product.getId()+"  Tên sản phẩm: "+product.getProductName()+"   Giá: "+product.getPrice());
        }
        System.out.println(" Nhập vào product Id: ");
        Cart cart = cartController.detailCart(InputMethod.getInteger());
        for (Cart ca : cartList) {
            if (cart == null) {
                createFormCart();
            } else {
                System.out.println("nhập vào số lượng: ");
                int quantity = InputMethod.getInteger();
                Cart newCart = new Cart(ca.getProduct(), quantity);
                System.out.println(" Thêm vào giỏ hàng thành công..");
            }
        }
    }
    public void updateFormCart(){

    }


}
