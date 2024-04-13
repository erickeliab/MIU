import java.util.ArrayList;

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
}
