package ra.service.admin;

import ra.config.Config;
import ra.model.Cart;
import ra.model.User;
import ra.service.user.IUserService;
import ra.service.user.UserServiceIMPL;

import java.util.List;

public class CartServiceIMPL implements ICartService {
    IUserService userService = new UserServiceIMPL();
    List<User> user = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);

    List<Cart> cartList = user.get(0).getCartList();

    @Override
    public List<Cart> findAll() {
        return cartList;
    }

    //thêm và sửa
    @Override
    public void save(Cart cart) {
        if (cartList.size() == 0) {
            cartList.add(cart);
        } else {
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getProduct().getId() == cart.getProduct().getId()) {
                    cartList.set(i, cart);
                }
            }
        }
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, user);
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
                new Config<User>().writerFile(Config.PATH_USER_LOGIN, user);
            }
        }
    }


}
