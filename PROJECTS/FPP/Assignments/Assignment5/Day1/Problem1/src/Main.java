//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void printTotal(Shape[] shapes)
    {

        double totalArea = 0.0;
        double totalPerimeter = 0.0;

        for (Shape shape: shapes){

            totalArea += shape.calculateArea();
            totalPerimeter += shape.calculatePerimeter();

        }

        System.out.println("The total area of all the shapes is : "+ totalArea);
        System.out.println("The total perimeter of all the shapes is :"+ totalPerimeter);


    }
    public static void main(String[] args) {

        Shape[] shapes = new Shape[5];
        shapes[0] = new Rectangle("green",20,12);
        shapes[1] = new Circle("blue",7.3);
        shapes[2] = new Square("orange",21);
        shapes[3] = new Rectangle("purple",160,29);
        shapes[4] = new Circle("red",16);

        printTotal(shapes);

    }
}