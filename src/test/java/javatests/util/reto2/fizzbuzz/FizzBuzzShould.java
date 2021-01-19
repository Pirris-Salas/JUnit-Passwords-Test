package javatests.util.reto2.fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    /*
    Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”
     */

    @Test
    public void return_fizz_if_number_is_divisible_by_3(){

        assertThat(FizzBuzz.fizzBuzz(9), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(12), is("Fizz"));
        assertThat(FizzBuzz.fizzBuzz(33), is("Fizz"));
    }

    @Test
    public void return_buzz_if_number_is_divisible_by_5(){

        assertThat(FizzBuzz.fizzBuzz(10), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(50), is("Buzz"));
        assertThat(FizzBuzz.fizzBuzz(70), is("Buzz"));
    }

    @Test
    public void return_fizzbuzz_if_number_is_divisible_by_3_and_5(){
        assertThat(FizzBuzz.fizzBuzz(3255), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(90), is("FizzBuzz"));
        assertThat(FizzBuzz.fizzBuzz(150), is("FizzBuzz"));
    }

    @Test
    public void return_number_if_number_is_not_divisible_by_3_or_5(){
        assertThat(FizzBuzz.fizzBuzz(4), is(String.valueOf(4)));
        assertThat(FizzBuzz.fizzBuzz(26), is(String.valueOf(26)));
        assertThat(FizzBuzz.fizzBuzz(52), is(String.valueOf(52)));
    }
}