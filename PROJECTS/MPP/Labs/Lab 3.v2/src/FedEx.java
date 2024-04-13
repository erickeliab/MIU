
public class FedEx implements ICarrier {
    private static final double IA_MT_OR_CA = 0.35;
    private static final double TX_UT = 0.30;
    private static final double FL_MA_OH = 0.55;
    private static final double OTHERS = 0.43;

    public String getCarrierName() {
        return "FedEx";
    }

    public double calculateCost(double weight, String zone) {
        double zoneRate;
        switch (zone) {
            case "IA":
            case "MT":
            case "OR":
            case "CA":
                zoneRate = IA_MT_OR_CA;
                break;
            case "TX":
            case "UT":
                zoneRate = TX_UT;
                break;
            case "FL":
            case "MA":
            case "OH":
                zoneRate = FL_MA_OH;
                break;
            default:
                zoneRate = OTHERS;
                break;
        }
        return zoneRate * weight;
    }
}
