package ra.view.user;

import ra.config.InputMethod;
import ra.controller.user.UserController;
import ra.dto.reponse.Responsemessage;
import ra.dto.request.SignInDTO;
import ra.dto.request.SignUpDTO;
import ra.model.User;
import ra.validate.Validate;
import ra.view.Main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {
    UserController userController = new UserController();
    List<User> userList = userController.getListUser();

    public void fromRegister() {
        int id = 0;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getUserId() + 1;
        }

        String userName;
        while (true) {
            System.out.println("Nhập vào tên người dùng: ");
            userName = InputMethod.getString();
            if (Validate.checkUserName(userName)) {
                break;
            } else {
                System.err.println("Tên người dùng không hợp lệ,phải có 4 kí tự trở lên");

            }
        }
        String fullName;
        while (true) {
            System.out.println("Nhập đầy đủ họ tên: ");
            fullName = InputMethod.getString();
            if (Validate.checkUserFullName(fullName)) {
                break;
            } else {
                System.err.println("Tên không hợp lệ!!");

            }
        }
        String email;
        while (true) {
            System.out.println("Nhập vào email: ");
            email = InputMethod.getString();
            if (Validate.checkEmail(email)) {
                break;
            } else
                System.err.println("Email không hợp lệ, vui lòng nhập lại");
        }

        String password;
        while (true) {
            System.out.println("Mật khẩu: ");
            password = InputMethod.getString();
            if (Validate.checkPassword(password)) {
                break;
            } else
                System.err.println("Mật khẩu không hợp lệ,không được chứa khoảng trắng và chứa 6 kí tự trở lên");
        }
        System.out.println("Tư cách đăng nhập: ");
        String role = InputMethod.getString();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO sign = new SignUpDTO(id, userName, fullName, password, email, strRole);

        while (true) {
            Responsemessage responseMessage = userController.register(sign);
            if (responseMessage.getMessage().equals("user_existed")) {
                System.err.println("Tên người dùng đã tồn tại!! Vui lòng nhập lại");
                userName = InputMethod.getString();
                sign.setUserName(userName);
            } else if (responseMessage.getMessage().equals("email_existed")) {
                System.err.println("Email đã tồn tại!! Vui lòng nhập lại email");
                email = InputMethod.getString();
                sign = new SignUpDTO(id, userName, fullName, password, email, strRole);
            } else if (responseMessage.getMessage().equals("create_success")) {
                formLogin();
                break;
            }
        }

    }

    public void formLogin() {

        System.out.println("-----------------  LOGIN ------------------");
        SignInDTO signInDTO = new SignInDTO();
        String userName;
        while (true) {
            System.out.println("Nhập vào tên người dùng: ");
            userName = InputMethod.getString();
            if (Validate.checkUserName(userName)) {
                break;
            } else {
                System.err.println("Tên người dùng không hợp lệ,phải có 4 kí tự trở lên");
            }
        }

        String password;
        while (true) {
            System.out.println("Nhập vào password: ");
            password = InputMethod.getString();
            if (Validate.checkPassword(password)) {
                break;
            } else {
                System.err.println("Mật khẩu không hợp lệ,không được chứa khoảng trắng");
            }
        }
        signInDTO.setUserName(userName);
        signInDTO.setPassword(password);
        while (true) {
            Responsemessage responsemessage = userController.login(signInDTO);
            if (responsemessage.getMessage().equals("login_failed")) {
                System.err.println("Đăng nhập thất bại! Vui lòng thử lại.");
                System.out.println("Nhập vào tên:");
                signInDTO.setUserName(InputMethod.getString());
                System.out.println("Nhập vào password: ");
                signInDTO.setPassword(InputMethod.getString());
            } else {
                System.out.println(" Đăng nhập thành công.");
                new Profile().Profile();
                break;
            }
        }

    }

    public void logOut() {
        userController.logOut();
        Main.generalShop();
    }

    public void showUser() {
        for (User user : userController.findAll()) {
            System.out.println(user);
        }
    }

    public void updateFormUser() {
        User userLogin = userController.getUserLogin();
        String userName;
        while (true) {
            System.out.println("Tên người dùng: ");
            userName = InputMethod.getString();
            if (Validate.checkUserName(userName)) {
                break;
            } else {
                System.err.println("Tên người dùng không hợp lệ,phải có 4 kí tự trở lên");
            }
        }
        userLogin.setUserName(userName);
        String password;
        while (true) {
            System.out.print("Mật khẩu : ");
            password = InputMethod.getString();
            if (Validate.checkPassword(password)) {
                break;
            } else {
                System.err.println("Mật khẩu không hợp lệ,không được chứa khoảng trắng và 7 kí tự trở lên");
            }
        }
        userLogin.setPassword(password);
        String email;
        while (true) {
            System.out.println("Nhập vào email: ");
            email = InputMethod.getString();
            if (Validate.checkEmail(email)) {
                break;
            } else
                System.err.println("Email không hợp lệ, vui lòng nhập lại");
        }
        userLogin.setEmail(email);
        String fullName;
        while (true) {
            System.out.println("Nhập đầy đủ họ tên: ");
            fullName = InputMethod.getString();
            if (Validate.checkUserFullName(fullName)) {
                break;
            } else {
                System.err.println("Tên không hợp lệ!!");
            }
        }
        userLogin.setFullName(fullName);
        userController.updateUserLogin(userLogin);
    }

    public void changeStatusUser() {
        System.out.println("Nhập vào id người dùng muốn thay đổi: ");
        while (true) {
            int id = InputMethod.getInteger();
            if (userController.findById(id) == null) {
                System.out.println("Id không tồn tại!!Vui lòng nhập lại..");
            } else {
                userController.changeStatus(id);
                break;
            }
        }
    }
    public User getUseLogin(){
        return userController.getUserLogin();
    }
}
