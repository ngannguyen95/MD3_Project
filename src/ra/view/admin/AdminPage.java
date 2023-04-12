package ra.view.admin;

import ra.config.InputMethod;
import ra.controller.user.UserController;
import ra.model.User;
import ra.view.Main;
import ra.view.user.UserView;

import java.util.List;

public class AdminPage {
    UserController userController = new UserController();

    public void AdminPage() {
        while (true) {
            System.out.println("-------------------- ADMIN ----------------------");
            System.out.print("1. Quản lí người dùng      ");
            System.out.print("2. Quản lí danh mục     ");
            System.out.print("3.Quản lí sản phẩm     ");
            System.out.println("4. Đăng xuất     ");
            System.out.println(" Nhập vào lựa chọn : ");
            int choice = InputMethod.getInteger();

            switch (choice) {
                case 1:
                    informationUser();
                    break;
                case 2:
                    new CategoryView();
                    break;
                case 3:
                    new ProductView().productView();
                    break;
                case 4:
                    userController.logOut();
                    Main.generalShop();
                    break;
                default:
                    break;
            }
        }

    }

    public void informationUser() {
        while (true) {
            System.out.println("----------  Quản lí người dùng --------------");
            System.out.print("1.Hiển thị thông tin người dùng     ");
            System.out.print("2.Thay đổi trạng thái người dùng     ");
            System.out.println("3.Quay lại trang ADMIN     ");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = InputMethod.getInteger();
            switch (choice) {
                case 1:
                    new UserView().showUser();
                    break;
                case 2:
                    new UserView().changeStatusUser();
                    break;
                case 3:
                    new AdminPage().AdminPage();
                    break;
            }

        }
    }

}
