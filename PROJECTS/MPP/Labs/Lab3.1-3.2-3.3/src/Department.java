import java.util.ArrayList;

public class Department {

    private String name;
    private String Location;
    private Company company;
    private ArrayList<Position> positions;

    Department(String name, String Location, Company company){
        this.name = name;
        this.Location = Location;
        this.company = company;
        positions = new ArrayList<>();
        company.addDepartments(this);
    }

    public void addPosition(Position position){
        positions.add(position);
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany() {
        return company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }


    public void setLocation(String location) {
        Location = location;
    }


    public void print(){
        System.out.println("   The name of the department is " + name + ", Located at " + Location);


        for(Position position: positions){
            position.print();
        }
    }

    public double getSalary(){
        double total = 0.0;
        for (Position position:positions){
            total += position.getSalary();
        }

        return total;
    }

    public Position getDepartmentHead(Position position){

        if (position.getSuperior() == null) return position;

        getDepartmentHead(position.getSuperior());
        return null;
    }

    public void printReportingHierarchy(Position position){

        position.printDownLine();
        if (!position.getInferiors().isEmpty()){
            for (Position pos : position.getInferiors()){
                System.out.printf("                      "); printReportingHierarchy(pos);
            }
        }

    }
}
