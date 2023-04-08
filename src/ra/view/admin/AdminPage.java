package ra.view.admin;

import ra.config.InputMethod;
import ra.controller.user.UserController;
import ra.model.User;

import java.util.List;

public class AdminPage {
    UserController userController=new UserController();
    List<User> userList=userController.getListUser();
    public AdminPage() {
        while (true){
            System.out.println("-------------------- ADMIN ----------------------");
            System.out.print("1. Quản lí người dùng      ");
            System.out.print("2. Quản lí danh mục     ");
            System.out.print("3.Quản lí sản phẩm     ");
            System.out.println("4. Đăng xuất     ");
            System.out.println(" Nhập vào lựa chọn : ");
            int choice= InputMethod.getInteger();

            switch (choice){
                case 1:
                    System.out.println(userList);
                    break;
                case 4:
                    userController.logOut();
                    break;
                default:
                    break;
            }
        }

    }



}
