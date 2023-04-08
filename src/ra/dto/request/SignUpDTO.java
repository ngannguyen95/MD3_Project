package ra.dto.request;

import java.util.HashSet;
import java.util.Set;

public class SignUpDTO {
    private int userId;
    private String userName;
    private String fullName;
    private String password;
    private String email;
    // set huwnsg tuwf phias fronend nên chỉ hứng được dạng chuỗi
    private Set<String> strRole=new HashSet<>();

    public SignUpDTO() {
    }

    public SignUpDTO(int userId, String userName,String fullName, String password, String email, Set<String> strRole) {
        this.userId = userId;
        this.userName = userName;
        this.fullName=fullName;
        this.password = password;
        this.email = email;
        this.strRole = strRole;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String userName) {
        this.fullName = fullName;
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

    public Set<String> getStrRole() {
        return strRole;
    }

    public void setStrRole(Set<String> strRole) {
        this.strRole = strRole;
    }
}
