package ra.service.admin;

import ra.config.Config;
import ra.controller.user.CartController;
import ra.controller.user.UserController;
import ra.model.Cart;
import ra.model.User;
import ra.service.user.IUserService;
import ra.service.user.UserServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class CartServiceIMPL implements ICartService {
    IUserService userService = new UserServiceIMPL();
    public static List<User> uses = new UserServiceIMPL().findAll();
    public static User userLogin = new UserServiceIMPL().getCurrentUser();
     List<Cart> cartList = userLogin.getCartList();

    @Override
    public List<Cart> findAll() {
        return cartList;
    }

    //thêm và sửa
    @Override
    public void save(Cart cart) {
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProduct().getId() == cart.getProduct().getId()) {
                cartList.get(i).setQuantity((cart.getQuantity() + cartList.get(i).getQuantity()));
            }
        }
        cartList.add(cart);
        userLogin.setCartList(cartList);
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, uses);
        new Config<User>().writerFile(Config.PATH_USER, uses);
    }

    // tìm theo id product
    @Override
    public Cart findById(int id) {
        for (Cart cart : cartList) {
            if (cart.getProduct().getId() == id) {
                return cart;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (Cart cart : cartList) {
            if (cart.getProduct().getId() == id) {
                cartList.remove(cart);
                userLogin.setCartList(cartList);
                new Config<User>().writerFile(Config.PATH_USER_LOGIN, uses);
                new Config<User>().writerFile(Config.PATH_USER, uses);
            }
        }
    }

    // xóa hết listCart trong phiên đăng nhập
    @Override
    public void deleteAllCart() {
        userLogin.setCartList(new ArrayList<>());
        userService.save(userLogin);
    }


}
