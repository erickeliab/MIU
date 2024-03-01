public final class Triangle{

    private final double base;
    private final double height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea(){

        return 0.5 * this.height * this.base;
    }
}
