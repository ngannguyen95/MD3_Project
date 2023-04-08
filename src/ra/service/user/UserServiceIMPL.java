package ra.service.user;

import ra.config.Config;
import ra.model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService {
    List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        if (findById(user.getUserId())==null){
            userList.add(user);
        }else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserId() == user.getUserId()){
                    userList.set(i,user);
                }
            }
        }
        new Config<User>().writerFile(Config.PATH_USER, userList);
    }

    @Override
    public User findById(int id) {
        for (User u : userList
             ) {
            if (u.getUserId()==id){
                return  u;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existedByUserName(String username) {
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existedByEmail(String email) {
        for (User user : userList) {
            if (user.getUserName().equals(email)) {
                return true;
            }
        }
        return false;
    }

    List<User> userLogin = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);

    @Override
    public boolean checkLogin(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                userLogin.add(user);
                new Config<User>().writerFile(Config.PATH_USER_LOGIN, userLogin);
                return true;
            }
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        if (userLogin.size() != 0) {
            User userCurrent = userLogin.get(0);
            return userCurrent;
        }
        return null;
    }

    @Override
    public void updateUserLogin(User user) {
        userLogin.set(0, user);
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, userLogin);
    }

    @Override
    public void logOut() {
        userLogin.remove(0);
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, userLogin);
    }
}
