package javatests.util.discounts;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private final List<Double> priceList = new ArrayList<>();
    private double discount = 0;

    public double getTotal() {
        DecimalFormat df = new DecimalFormat("#.##");

        double result = 0;
        for (Double price : priceList) {
            result += price;
        }

        double response = result * ((100 - discount) / 100);
        return Double.parseDouble(df.format(response));
    }

    public void addPrice(double price) {
        priceList.add(price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
