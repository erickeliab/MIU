import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


public class Company {

    private String name;
    private ArrayList<Department> departments;

    Company(String name){
        this.name = name;
        departments = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void addDepartments(Department department) {

        departments.add(department);

    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void print(){
        System.out.println("Company name is: "+ name);

        for (Department department: departments){
            department.print();
        }


    }


    public double getSalary(){
        double total = 0.0;
        for (Department department: departments){
            total+= department.getSalary();
        }

        return total;
    }


    public Position getTopExecutive(){
        Position top = null;
        for (Department department:departments){

            for (Position position: department.getPositions()){
                if (position.getManagerStatus()){
                    top = position;
                }

            }
        }

        return top;

    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(getName(), company.getName()) && Objects.equals(getDepartments(), company.getDepartments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDepartments());
    }

    public void printReportingHierarchy(){
        System.out.println("Reporting hierarchy for " + name + ":");

        Position topExecutive = this.getTopExecutive();
        if (topExecutive != null){
            System.out.printf("  "); topExecutive.print();
        }

        for (Department department: departments){

            Position depHead = department.getDepartmentHead(department.getPositions().get(0));
            if (depHead != topExecutive){
                System.out.printf("                 "); department.printReportingHierarchy(depHead);
            }

        }

    }


}
