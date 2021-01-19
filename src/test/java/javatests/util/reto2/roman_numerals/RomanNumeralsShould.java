package javatests.util.reto2.roman_numerals;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RomanNumeralsShould {

    @Test
    public void return_roman_number_equivalent_to_arabic_number(){

        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
        assertThat(RomanNumerals.arabicToRoman(5), is("V"));
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
        assertThat(RomanNumerals.arabicToRoman(51), is("LI"));
        assertThat(RomanNumerals.arabicToRoman(56), is("LVI"));
        assertThat(RomanNumerals.arabicToRoman(60), is("LX"));
        assertThat(RomanNumerals.arabicToRoman(70), is("LXX"));
        assertThat(RomanNumerals.arabicToRoman(80), is("LXXX"));
        assertThat(RomanNumerals.arabicToRoman(81), is("LXXXI"));
        assertThat(RomanNumerals.arabicToRoman(85), is("LXXXV"));
        assertThat(RomanNumerals.arabicToRoman(86), is("LXXXVI"));
        assertThat(RomanNumerals.arabicToRoman(126), is("CXXVI"));
        assertThat(RomanNumerals.arabicToRoman(2507), is("MMDVII"));
    }

}