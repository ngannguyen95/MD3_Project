package ra.view.user;

import ra.config.InputMethod;
import ra.controller.user.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.view.Main;
import ra.view.admin.AdminPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Profile {
    UserController userController = new UserController();
    User user = userController.getUserLogin();
    Set<Role> roleSet = user.getRoles();
    List<Role> roleList = new ArrayList<>(roleSet);


    public Profile() {
        if (roleList.get(0).getName() == RoleName.ADMIN) {
            new AdminPage();
        } else {
            while (true) {
                System.out.println("------------------   Xin chào " + user.getFullName() + "---------------");
                System.out.print("1. Thông tin cá nhân     ");
                System.out.print("2.Thêm vào giỏ hàng     ");
                System.out.print("3.Xem giỏ hàng    ");
                System.out.println("4. Đăng xuất       ");
                System.out.println("Nhập vào lựa chọn:    ");
                int choice = InputMethod.getInteger();
                switch (choice) {
                    case 1:
                        System.out.println(user);
                        break;
                    case 2:
                        new CartView().createFormCart();
                        break;
                    case 3:
                        new CartView().showFormCart();
                        break;
                    case 4:
                        userController.logOut();
                        Main.generalShop();
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại");
                        break;
                }
            }
        }

    }
}
