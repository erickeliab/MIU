
public class UPS implements ICarrier {
    private static final double RATE = 0.45;

    public String getCarrierName() {
        return "UPS";
    }

    public double calculateCost(double weight, String zone) {
        return RATE * weight;
    }
}

