package ra.controller.user;

import ra.dto.reponse.Responsemessage;
import ra.dto.request.SignInDTO;
import ra.dto.request.SignUpDTO;
import ra.model.Role;
import ra.model.RoleName;
import ra.model.User;
import ra.service.role.IRoleService;
import ra.service.user.IUserService;
import ra.service.role.RoleServiceIMPL;
import ra.service.user.UserServiceIMPL;

import javax.jws.soap.SOAPBinding;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserController {
    private IUserService userService = new UserServiceIMPL();
    private IRoleService roleService = new RoleServiceIMPL();

    public Responsemessage register(SignUpDTO sign) {
        //từ userService tương tác lên kểm tra xem có trùng tên không, trả ra message cho front end
        if (userService.existedByUserName(sign.getUserName())) {
            return new Responsemessage("user_existed");
        }
        if (userService.existedByUserName(sign.getEmail())) {
            return new Responsemessage("email_existed");
        }
        // kiểu role của front end truyền về
        Set<String> strRole = sign.getStrRole();
        Set<Role> roleSet = new HashSet<>();

        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    roleSet.add(roleService.findByAll(RoleName.ADMIN));
                    break;
                case "pm":
                    roleSet.add(roleService.findByAll(RoleName.PM));
                    break;
                default:
                    roleSet.add(roleService.findByAll(RoleName.USER));

            }
        });

        User user = new User(sign.getUserId(), sign.getUserName(), sign.getFullName(), sign.getEmail(), sign.getPassword(), roleSet, true);
        // thêm vào người đùng
        userService.save(user);
        return new Responsemessage("create_success");
    }

    public List<User> getListUser() {
        return userService.findAll();
    }

    //gửi thông điệp đến frontend
    public Responsemessage login(SignInDTO sign) {

        if (userService.checkLogin(sign.getUserName(), sign.getPassword())) {
            System.out.println(userService.checkLogin(sign.getUserName(), sign.getPassword()));
            return new Responsemessage("login_success");

        } else {
            System.out.println(userService.checkLogin(sign.getUserName(), sign.getPassword()));
            return new Responsemessage("login_failed");
        }

    }

    public User getUserLogin() {
        return userService.getCurrentUser();
    }

    public void updateUserLogin(User user) {
        userService.updateUserLogin(user);
    }

    public void logOut() {
        userService.logOut();
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public void changeStatus(int id) {
        userService.changeStatusUser(id);
    }

    public User findById(int id) {
        return userService.findById(id);
    }

}
