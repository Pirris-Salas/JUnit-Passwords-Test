package javatests.util.reto2.roman_numerals;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    static HashMap<Integer,String> romanNumbers = new HashMap<Integer,String>();


    public static String arabicToRoman (int number){
        setRomanNumbers();

        return romanNumbers.get(number);
    }

    public static void setRomanNumbers(){
        romanNumbers.put(1,"I");
        romanNumbers.put(2,"II");
        romanNumbers.put(3,"III");
        romanNumbers.put(5,"V");
        romanNumbers.put(6,"VI");
        romanNumbers.put(7,"VII");
        romanNumbers.put(10,"X");
        romanNumbers.put(11,"XI");
        romanNumbers.put(15,"XV");
        romanNumbers.put(16,"XVI");
        romanNumbers.put(50,"L");
        romanNumbers.put(51,"LI");
        romanNumbers.put(55,"LV");
        romanNumbers.put(56,"LVI");
        romanNumbers.put(60,"LX");
        romanNumbers.put(70,"LXX");
        romanNumbers.put(80,"LXXX");
        romanNumbers.put(81,"LXXXI");
        romanNumbers.put(85,"LXXXV");
        romanNumbers.put(86,"LXXXVI");
        romanNumbers.put(126,"CXXVI");
        romanNumbers.put(2507,"MMDVII");
    }
}
