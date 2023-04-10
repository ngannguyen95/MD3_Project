package ra.service.user;

import ra.config.Config;
import ra.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceIMPL implements IUserService {
    private List<User> userList = new Config<User>().readFromFile(Config.PATH_USER);


    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public void save(User user) {
        if (findById(user.getUserId()) == null) {
            userList.add(user);
        } else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserId() == user.getUserId()) {
                    userList.set(i, user);
                }
            }
        }
        new Config<User>().writerFile(Config.PATH_USER, userList);
    }

    @Override
    public User findById(int id) {
        for (User u : userList) {
            if (u.getUserId() == id) {
                return u;
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


    @Override
    public boolean checkLogin(String userName, String password) {
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                users.add(user);
                new Config<User>().writerFile(Config.PATH_USER_LOGIN, users);
                return true;
            }
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        List<User> userLogin = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);
        if (userLogin.size() == 0) {
            return null;
        } else {
            User user = userLogin.get(0);
            return user;
        }
    }

    @Override
    public void updateUserLogin(User user) {
        List<User> userLogin = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);
        userLogin.set(0, user);
        save(user);
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, userLogin);
    }

    @Override
    public void logOut() {
        List<User> userLogin = new Config<User>().readFromFile(Config.PATH_USER_LOGIN);
        userLogin.remove(0);
        new Config<User>().writerFile(Config.PATH_USER_LOGIN, userLogin);
    }
    @Override
    public void changeStatusUser(int id) {
        for (User u:userList) {
           if (u.getUserId()==id){
               u.setUserStatus(!u.isUserStatus());
               new Config<User>().writerFile(Config.PATH_USER,userList);
               break;
           }
        }
    }


}
