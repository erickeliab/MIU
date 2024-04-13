import java.util.ArrayList;

class Package {
    private String description;
    private double weight;
    private String zone;
    private ICarrier carrier;
    private final ArrayList<ICarrier> carriers;

    private IDiscountCategory discount;

    public Package(String description, double weight, String zone, ArrayList<ICarrier> carriers) {
        this.description = description;
        this.weight = weight;
        this.zone = zone;
        this.carriers = carriers;

    }

    public void setDiscount(IDiscountCategory discount) {
        this.discount = discount;
    }

    public IDiscountCategory getDiscount() {
        return discount;
    }

    public ArrayList<ICarrier> getCarriers() {
        return carriers;
    }

    public ICarrier getCarrier() {
        return carrier;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setCarrier(ICarrier carrier) {
        this.carrier = carrier;
    }

    public String getZone() {
        return zone;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDescription() {
        return description;
    }

    public double calculateCost() {



        if(!carriers.isEmpty()){
            carrier = carriers.get(0);
            double smaller = carrier.calculateCost(weight,zone);


            for (ICarrier carrier1: carriers){
                double cost = carrier1.calculateCost(weight, zone);
                if (cost < smaller){
                    carrier = carrier1;
                    smaller = cost;
                }

            }

            return smaller;

        }else {

            return 0;

        }



    }
}
