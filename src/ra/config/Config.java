package ra.config;

import ra.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Config<T> {

    public static final String PATH_CATEGORY = "src/ra/database/category.txt";
    public static final String PATH_PRODUCT = "src/ra/database/product.txt";
    public static final String PATH_USER = "src/ra/database/user.txt";
    public static final String PATH_USER_LOGIN = "src/ra/database/user_login.txt";
    public static final String PATH_INVOICE="src/ra/database/invoice.txt";
    public static final String PATH_INVOICE_HISTORY="src/ra/database/invoice_history.txt";

    // phương thức đọc file
    public List<T> readFromFile(String pathFile) {

        List<T> tList = new ArrayList<>();
        try {
            File file = new File(pathFile);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList = (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
            System.err.println("File not Found");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IO Exception");
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found Exception ");
        }
        return tList;
    }

    // phương thức ghi file
    public void writerFile(String pathFile, List<T> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Config<User>().readFromFile(PATH_USER).get(1).getCartList());
    }
}
