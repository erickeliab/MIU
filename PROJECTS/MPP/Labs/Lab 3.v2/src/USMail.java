
public class USMail implements ICarrier {
    private static final double RATEBELOW = 1.00;
    private static final double RATEABOVE = 0.55;

    public String getCarrierName() {
        return "US Mail";
    }

    public double calculateCost(double weight, String zone) {
        if (weight <= 3) {
            return RATEBELOW;
        } else {
            return RATEABOVE * weight;
        }
    }
}

