package ra.service.admin;

import ra.config.Config;
import ra.model.Cart;
import ra.model.User;
import ra.service.user.IUserService;
import ra.service.user.UserServiceIMPL;

import java.util.List;

public class CartServiceIMPL implements ICartService {
    public static List<User> uses = new UserServiceIMPL().findAll();
    public static User userLogin = new UserServiceIMPL().getCurrentUser();
    public static List<Cart> cartList = userLogin.getCartList();

    @Override
    public List<Cart> findAll() {
        return cartList;
    }

    //thêm và sửa
    @Override
    public void save(Cart cart) {
        boolean check = false;
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProduct().getId() == cart.getProduct().getId()) {
                cartList.get(i).setQuantity((cart.getQuantity() + cartList.get(i).getQuantity()));
                check = true;
            }
        }
        if (!check) {
            cartList.add(cart);
        }
        for (User u : uses) {
            if (u.getUserId() == uses.get(0).getUserId()) {
                u.setCartList(cartList);
            }
        }
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
                new Config<User>().writerFile(Config.PATH_USER_LOGIN, uses);
                new Config<User>().writerFile(Config.PATH_USER, uses);
            }
        }
    }

}
