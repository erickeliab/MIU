public class Rectangle extends Shape {

    double height;
    double width;

    Rectangle(String color, double height,double width){
        super(color);
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea(){
        return height * width;
    }

    public double calculatePerimeter(){

        return 2 * (height * width);
    }


}
