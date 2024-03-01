
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter C for Circle");
        System.out.println("Enter R for Rectangle");
        System.out.println("Enter T for Triangle");
        String shape = sc.nextLine();

        if (shape.equals("C")){

            System.out.println("Enter Radius of a Circle");
            double radius = Double.parseDouble(sc.nextLine());

            Circle c = new Circle(radius);

            System.out.println("The Area of Circle is: " + c.computeArea());

        } else if (shape.equals("R")) {

            System.out.println("Enter width of a Rectangle");
            double width = Double.parseDouble(sc.nextLine());
            System.out.println("Enter height of a Rectangle");
            double height = Double.parseDouble(sc.nextLine());

            Rectangle r = new Rectangle(width,height);

            System.out.println("The Area of Rectangle is: " + r.computeArea());


        } else if (shape.equals("T")) {
            System.out.println("Enter width of a Rectangle");
            double base = Double.parseDouble(sc.nextLine());
            System.out.println("Enter height of a Rectangle");
            double height = Double.parseDouble(sc.nextLine());

            Triangle t = new Triangle(base,height);

            System.out.println("The Area of Triangle is: " + t.computeArea());
        }

        sc.close();
    }
}
