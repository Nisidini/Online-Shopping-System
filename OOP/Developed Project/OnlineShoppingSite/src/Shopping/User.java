package Shopping;

import java.util.HashMap;

public class User {
    private String UserName;
    private String Password;

    HashMap<String, String> Login = new HashMap<String, String>();

   public User(){

    }

    public HashMap<String, String> getLogin() {
        return Login;
    }

    public static void main(String[] args) {
        User user = new  User();
        LoginPage loginPage = new LoginPage();


    }
}

