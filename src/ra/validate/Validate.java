package ra.validate;

import ra.config.InputMethod;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public static boolean checkEmail(String email) {
        String pattern = "^(.+)@(\\S+)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
       return m.matches();

   }
   public static boolean checkUserName(String string){
        String pattern= "\\w{4,}";
       Pattern p = Pattern.compile(pattern);
       Matcher m = p.matcher(string);
       return m.matches();
   } public static boolean checkUserFullName(String fullName){
        String pattern="^[a-zA-Z\\s]+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(fullName);
        return m.matches();
    }
    public static boolean checkPhoneNumber(String number){
        String pattern="0\\d{9}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(number);
        return m.matches();
    }
    public static boolean checkPassword(String password){
        String pattern=".[^\\s]{6,}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

}
