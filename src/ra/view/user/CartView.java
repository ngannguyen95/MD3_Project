package ra.view.user;

import ra.config.Config;
import ra.config.InputMethod;
import ra.controller.category.ProductController;
import ra.controller.user.CartController;
import ra.model.Cart;
import ra.model.Product;

import java.util.List;

public class CartView {
    CartController cartController = new CartController();
    List<Cart> cartList = cartController.getListCart();
    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_PRODUCT);

    public void showFormCart() {
        System.out.println("----------- Thông tin giỏ hàng ------------ ");
        float total = 0;
        for (Cart cart : cartList) {
            total += cart.getProduct().getPrice() * cart.getQuantity();
            System.out.println("Sản phẩm:" + "\nid: " + cart.getProduct().getId() + "\nTên: " + cart.getProduct().getProductName() +
                    "\nGiá: " + cart.getProduct().getPrice() + "\nSố lượng: " + cart.getQuantity() +
                    "\nThành tiền:" + cart.getProduct().getPrice() * cart.getQuantity() + "\n");
        }
        System.out.println("Tổng : " + total);
    }

    public void createFormCart() {
        System.out.println("---------- Thông tin sản phẩm:------------");
        for (Product product : productList) {
            System.out.println("Id:  " + product.getId() + "  Tên sản phẩm: " + product.getProductName() + "   Giá: " + product.getPrice());
        }
        System.out.println(" Nhập vào product Id: ");
        Product product = new ProductController().detailProduct(InputMethod.getInteger());
        System.out.println("Nhập vào quantity : ");
        int quantity = InputMethod.getInteger();
        Cart cart = new Cart(product, quantity);
        cartController.createCart(cart);
        System.out.println(" Thêm vào giỏ hàng thành công..");
    }


    public void updateFormCart() {

    }


}
