import java.util.*;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {


    public static boolean function(User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //1
        if (user==null) { //2
            throw new RuntimeException("The user is not instantiated"); //3
        }
        if (user.getUsername()==null || user.getPassword()==null) //4
            throw new RuntimeException("The user is missing some mandatory information"); //5
        String password = user.getPassword();//6
        String passwordLower = password.toLowerCase();//6
        if (passwordLower.contains(user.getUsername().toLowerCase())) { //6
            return false; //7
        }
        else if (passwordLower.length()<8) //8
            return false; //9
        else { //10
            boolean digit = false, upper = false, special = false; //11

            for (int i=0;i<password.length();i++) { //12
                if (Character.isDigit(password.charAt(i))) //13
                    digit = true; //14
                if (Character.isUpperCase(password.charAt(i))) //15
                    upper = true; //16
                if (specialCharacters.contains(String.valueOf(password.charAt(i)))) //17
                    special = true; //18
            }//19
            if (!digit || !upper || !special) //20
                return false; //21
        }//22
        return true; //23

    } //24
}
