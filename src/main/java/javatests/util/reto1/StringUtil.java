package javatests.util.reto1;

public class StringUtil {

    public static boolean isEmpty(String str){
        String result = str.trim();

        if(result.equals("") || result.equals("null")){
            return true;
        }
        else{
            return false;
        }
    }
}
