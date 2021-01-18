package javatests.util.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    private PriceCalculator calculator;

    @Before
    public void setUp(){
        calculator = new PriceCalculator();
    }
    @Test
    public void total_zero_when_there_are_not_prices(){
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){
        calculator.addPrice(50.0);
        calculator.addPrice(50.25);

        assertThat(calculator.getTotal(), is(100.25));
    }

    @Test
    public void apply_discount_to_prices(){

        calculator.addPrice(50.0);
        calculator.addPrice(50.25);
        calculator.setDiscount(10.0);

        assertThat(calculator.getTotal(), is(90.23));
    }
}