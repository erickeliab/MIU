public final class Circle{

    private final double radius;
    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public double computeArea(){
        return Math.PI * Math.pow(this.radius,2);
    }

}
