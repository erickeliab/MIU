
public class StudentDiscount implements IDiscountCategory {
    private static final double DISCOUNT_PERCENTAGE = 0.10;

    public double applyDiscount(double cost) {
        return cost * (1 - DISCOUNT_PERCENTAGE);
    }
}
