package ra.view.user;

import ra.config.Config;
import ra.config.InputMethod;
import ra.controller.category.ProductController;
import ra.controller.user.CartController;
import ra.controller.user.UserController;
import ra.model.Cart;
import ra.model.Product;
import ra.model.User;
import ra.service.user.UserServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class CartView {
    private static CartController cartController = new CartController();
    private static List<Cart> cartList = new UserController().getUserLogin().getCartList();
    private static ProductController productController = new ProductController();

    User userLogin = new UserController().getUserLogin();
    private static List<Product> productList = productController.getListProduct();


    public void showFormCart() {
        System.out.println("----------- Thông tin giỏ hàng ------------ ");
        float total = 0;
        for (Cart cart : userLogin.getCartList()) {
            total += cart.getProduct().getPrice() * cart.getQuantity();
            System.out.println("Sản phẩm:" + "\nid: " + cart.getProduct().getId() + "\nTên: " + cart.getProduct().getProductName() +
                    "\nGiá: " + cart.getProduct().getPrice() + "\nSố lượng: " + cart.getQuantity() +
                    "\nThành tiền: " + cart.getProduct().getPrice() * cart.getQuantity() + "\n");
        }
        System.out.println("Tổng : " + total);
    }

    public void createFormCart() {
        System.out.println("---------- Thông tin sản phẩm:------------");
        for (Product product : productList) {
            System.out.println("Id:  " + product.getId() + "  Tên sản phẩm: " + product.getProductName() + "   Giá: " + product.getPrice());
        }
        System.out.println(" Nhập vào product Id: ");
        //@todo xử lý ngoại lệ cho dòng tạo product dưới.
        Product product = new ProductController().detailProduct(InputMethod.getInteger());
        if (product == null) {
            System.out.println("Id không tồn tại, vui lòng nhập lại!!!");
            createFormCart();
        } else {
            System.out.println("Nhập vào quantity : ");
            int quantity = InputMethod.getInteger();
            Cart cart = new Cart(product, quantity);
            cartList.add(cart);
            System.out.println(" Thêm vào giỏ hàng thành công.");
        }

    }

    public void deleteCartAll() {
        cartController.deleteCartAll();
    }


}
