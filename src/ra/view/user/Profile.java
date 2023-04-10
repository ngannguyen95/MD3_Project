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


    public void Profile() {
        if (roleList.get(0).getName() == RoleName.ADMIN) {
            new AdminPage().AdminPage();
        } else {
            while (true) {
                System.out.println("------------------   Xin chào " + user.getFullName() + "---------------");
                System.out.print("1. Thông tin cá nhân     ");
                System.out.print("2. Giỏ hàng     ");
                System.out.print("3.Lịch sử    ");
                System.out.println("4. Đăng xuất       ");
                System.out.println("Nhập vào lựa chọn:    ");
                int choice = InputMethod.getInteger();
                switch (choice) {
                    case 1:
                        inforUser();
                        break;
                    case 2:
                        inforCart();
                        break;
                    case 3:
                        //lịch sử
                        break;
                    case 4:
                        new UserView().logOut();
                        break;
                    default:
                        System.out.println("Vui lòng nhập lại");
                        break;
                }
            }
        }

    }

    public void inforUser() {
        while (true) {
            System.out.println("-------- Thông tin người dùng --------");
            System.out.print("1.Thông tin cá nhân     ");
            System.out.print("2.Thay đổi thông tin cá nhân    ");
            System.out.println("3.Quay lại trang cá nhân  ");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    System.out.println("------  Thông tin cá nhân -------");
                    System.out.println(user);
//                    new UserView().showUseLogin();
                    break;
                case 2:
                    new UserView().updateFormUser();
                    user = userController.getUserLogin();
                    break;
                case 3:
                    Profile();
                    break;
                default:
                    System.err.println("Vui lòng nhập lại!!!");
                    break;
            }
        }
    }

    public void inforCart() {
        while (true) {
            System.out.println("-------------- Giỏ hàng --------------");
            System.out.print("1.Thêm vào giỏ hàng    ");
            System.out.print("2.Xem giỏ hàng     ");
            System.out.print("3.Thanh toán   ");
            System.out.println("3.Quay lại trang cá nhân ");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    new CartView().createFormCart();
                    break;
                case 2:
                    new CartView().showFormCart();
                    break;
                case 3:
                    Profile();
                    break;
                default:
                    System.out.println("Vui lòng nhập lại!!");
                    break;
            }
        }
    }

}
