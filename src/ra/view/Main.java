package ra.view;


import ra.config.InputMethod;
import ra.controller.user.UserController;

import ra.model.User;

import ra.view.admin.ProductView;
import ra.view.user.InvoiceView;
import ra.view.user.Profile;
import ra.view.user.UserView;


public class Main {
    public static void generalShop() {
        UserView userView = new UserView();
        User userLogin = new UserController().getUserLogin();
        if (userLogin != null && userLogin.isUserStatus()) {
            new Profile().Profile();
        } else if (userLogin != null && !userLogin.isUserStatus()) {
            System.err.println("Tài khoản đã bị khóa ");
            home(userView);
        }else {
            home(userView);
        }
    }

    private static void home(UserView userView) {
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

    public static void main(String[] args) {
        Main.generalShop();
    }
}
