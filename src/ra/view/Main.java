package ra.view;

import ra.config.Config;
import ra.config.InputMethod;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.service.role.RoleServiceIMPL;
import ra.view.admin.CategoryView;
import ra.view.admin.ProductView;
import ra.view.user.UserView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void generalShop() {
        UserView userView = new UserView();
        while (true) {
            System.out.println("----------------------------  TRANG CHỦ ---------------------------");
            System.out.println("1. Đăng ký      " +
                    "2.Đăng nhập      " +
                    "3.Tìm kiếm sản phẩm     " +
                    "4. Sản phẩm     " );
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
                    break;
                case 4:
                    new ProductView().showFormProduct();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng nhập  lại!!!");
                    break;
            }

        }
    }

    public static void main(String[] args) {
        Main.generalShop();
    }

}
