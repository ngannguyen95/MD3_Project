package ra.controller.user;

import ra.model.Cart;
import ra.model.Category;
import ra.service.admin.CartServiceIMPL;
import ra.service.admin.ICartService;

import java.util.List;

public class CartController {
    private ICartService cartService = new CartServiceIMPL();
    public List<Cart> getListCart(){
        return cartService.findAll();
    }

    public void createCart(Cart cart) {
        cartService.save(cart);
    }
    public void updateCart(Cart cart){
        cartService.save(cart);
    }
    public Cart detailCart(int id){
        return cartService.findById(id);
    }
    public void deleteCart(int id){
        cartService.deleteById(id);
    }
    public void deleteCartAll(){
        cartService.deleteAllCart();
    }

}
