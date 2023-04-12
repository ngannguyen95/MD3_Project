package ra.view;

import ra.config.Config;
import ra.config.InputMethod;
import ra.controller.user.UserController;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.service.role.RoleServiceIMPL;
import ra.view.admin.CategoryView;
import ra.view.admin.ProductView;
import ra.view.user.Profile;
import ra.view.user.UserView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void generalShop() {
        UserView userView = new UserView();
        User userLogin = new UserController().getUserLogin();
        if (userLogin != null) {
            new Profile().Profile();
        } else {
            while (true) {
                System.out.println("----------------------------  TRANG CHỦ ---------------------------");
                System.out.println("1. Đăng ký      " +
                        "2.Đăng nhập      " +
                        "3.Xem sản phẩm     " +
                        "4.Tìm kiếm sản phẩm     ");
                System.out.println(" Nhập vào lựa chọn: ");
                int choice = InputMethod.getInteger();
                switch (choice) {
                    case 1:
                        userView.fromRegister();
                        break;
                    case 2:
                        userView.formLogin();
                        break;
                    case 3:
                        new ProductView().showFormProduct();
                        break;
                    case 4:
                        new ProductView().formSearchProduct();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    case 6:
                        new UserView().showUser();
                        break;
                    default:
                        System.out.println("Vui lòng nhập  lại!!!");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main.generalShop();
    }
}
