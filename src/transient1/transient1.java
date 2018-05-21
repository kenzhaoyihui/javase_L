package transient1;

import java.io.*;

/**
 * @description use transient not to serial to disk
 *
 * @author yzhao_sherry
 * @data 2018-05-21
 *
 */


class User implements Serializable{
    private static final long serialVersionUID = 1L;

    public  static String username;
    private transient String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


public class transient1 {

    public static void main(String[] args){

        User user = new User();
        //User.username = "yy";

        user.setUsername("yzhao");
        user.setPassword("123456");

        System.out.println("Before serializable: \n" + "Username: " + user.getUsername() + "\nPassword: " + user.getPassword());

        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("-----------------------------------------------------------");
        user.setUsername("yzhaohah");
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("user.txt"));
            user = (User) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("After serializable: \n" + "Username: " + user.getUsername() + "\nPassword: " + user.getPassword());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
