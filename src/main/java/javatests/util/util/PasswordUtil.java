package javatests.util.util;

public class PasswordUtil {

    public enum SecurityLevel {
        WEAK,MEDIUM,STRONG
    }

    public static SecurityLevel assessPassword(String password){

        if(password.length() < 8){
            return SecurityLevel.WEAK;
        }

        //a-z contiene letras minusculas de la a a la z
        //A-Z contiene letras mayusculas de la A a la Z
        //+ significa que se pueden repetir las letras
        if(password.matches("[a-zA-Z]+")){
            return SecurityLevel.WEAK;
        }

        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
