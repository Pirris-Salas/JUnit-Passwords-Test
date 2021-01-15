package javatests.util;

public class StringUtilTest {

    public static void main(String[] args) {

        assertEquals(StringUtil.repeat("Luis, ", 3), "Luis, Luis, Luis, ");

        assertEquals(StringUtil.repeat("Salas, ", 1), "Salas, ");

        System.out.println(StringUtil.repeat("Luis, ", 3));
        System.out.println(StringUtil.repeat("Salas, ", 1));
    }

    private static void assertEquals(String actual, String expected){
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equal than expected " +expected);
        }
    }

}