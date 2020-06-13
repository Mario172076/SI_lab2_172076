import java.util.List;

public class SILab2 {

    public boolean function (User user, List<String> allUsers) {
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";//1
        if (user!=null) {//1
            if (user.getUsername()!=null && user.getPassword()!=null) { //2
                String password = user.getPassword();//3
                String passwordLower = password.toLowerCase();//3
                if (!passwordLower.contains(user.getUsername().toLowerCase()) && password.length()>=8) {//3
                    boolean digit = false, upper = false, special = false;//4
                    for (int i=0;i<password.length();i++) {//4
                        if (Character.isDigit(password.charAt(i)))//5
                            digit = true;//6
                        if (Character.isUpperCase(password.charAt(i)))//7
                            upper = true;//8
                        if (specialCharacters.contains(String.valueOf(password.charAt(i))))//9
                            special = true;//10
                    }//11
                    if (digit && upper && special)//12
                        return true;//13
                }
            }
        }
        return false;//14
    }
}
//15
