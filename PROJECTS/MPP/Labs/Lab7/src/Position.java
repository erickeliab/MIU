import java.util.ArrayList;
import java.util.Objects;

public class Position {

    private String title;
    private String description;

    private Department department;
    private Employee employee;
    private ArrayList<Employee> employees;

    private Position superior;

    private boolean isManager;

    private ArrayList<Position> inferiors;

    Position(String title, String description, Department department){
        this.title = title;
        this.description = description;
        this.department = department;
        department.addPosition(this);
        isManager = false;
        inferiors = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public Position getSuperior() {
        return superior;
    }


    public void setSuperior(Position superior) {

            this.superior = superior;
            superior.addInferior(this);

    }

    public void addInferior(Position position){

            inferiors.add(position);


    }


    public ArrayList<Position> getInferiors() {
        return inferiors;
    }

    public void setInferiors(ArrayList<Position> inferiors) {
        this.inferiors = inferiors;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        if (this.employee == null){
            this.employee = employee;
        } else if(employees.isEmpty()){
            employees.add(this.employee);
            employees.add(employee);
        }else{
            employees.add(employee);

        }


    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void print(){
        System.out.println("      Title: " + title + ", => " + description);
        if (employee != null && employees.isEmpty()) employee.print();
        if (!employees.isEmpty()){

            for (Employee e : employees){
                e.print();
            }

        }
    }




    public double getSalary(){
        if (employee != null) return employee.getSalary();
        return 0.0;
    }


    public void setManager(boolean manager) {
        isManager = manager;
    }

    public boolean getManagerStatus(){
        return isManager;
    }

    public void printDownLine(){

//        System.out.println("Title: " + title + ", => " + description);
        if (employee != null && employees.isEmpty()) employee.print();
        if (!employees.isEmpty()){

            for (Employee e : employees){
                e.print();
            }



        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", department=" + department +
                ", employee=" + employee +
                ", employees=" + employees +
                ", superior=" + superior +
                ", isManager=" + isManager +
                ", inferiors=" + inferiors +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Position copy = (Position) super.clone();
        copy.department = (Department) department.clone();
        copy.inferiors = (ArrayList) inferiors.clone();
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return isManager == position.isManager && Objects.equals(getTitle(), position.getTitle()) && Objects.equals(getDescription(), position.getDescription()) && Objects.equals(getDepartment(), position.getDepartment()) && Objects.equals(getEmployee(), position.getEmployee()) && Objects.equals(employees, position.employees) && Objects.equals(getSuperior(), position.getSuperior()) && Objects.equals(getInferiors(), position.getInferiors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription(), getDepartment(), getEmployee(), employees, getSuperior(), isManager, getInferiors());
    }
}
