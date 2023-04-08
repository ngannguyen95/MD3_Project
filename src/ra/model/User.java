package ra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String fullName;
    //    private boolean permission;
    private boolean userStatus;
    private Set<Role> roles = new HashSet<>();
    private List<Cart> cartList = new ArrayList<>();

    public User(int userId, String userName, String password, String email, String fullName, boolean userStatus, Set<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.userStatus = userStatus;
        this.roles = roles;
    }

    public User(int userId, String userName,String fullName, String email, String password, Set<Role> roleSet, boolean b) {
        this.userId = userId;
        this.userName = userName;
        this.fullName=fullName;
        this.email = email;
        this.password = password;
        this.roles = roleSet;

    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return
                "               Thông tin cá nhân                    \n"+
                "    Id     Name            Password        Email         FullName\n"+
                "    "+userId+"    "+userName+"    "+password+"    "+email+"    "+fullName+
                "\n ---------------------------------------------------------------------";

    }

}
