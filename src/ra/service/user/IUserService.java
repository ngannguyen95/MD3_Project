package ra.service.user;

import ra.model.User;
import ra.service.admin.IGenericService;

public interface IUserService extends IGenericService<User> {

    //check tên và emial đã tồn tại hay chưa
    boolean existedByUserName(String username);
    boolean existedByEmail(String email);
    boolean checkLogin(String userName,String password);
    User getCurrentUser();
    void updateUserLogin(User user);
    void logOut();
    void changeStatusUser(int id);

}
