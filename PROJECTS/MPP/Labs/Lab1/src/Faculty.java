import java.util.ArrayList;
import java.util.Objects;

public class Faculty extends Person {

    private double Salary;
    private final ArrayList<Course> courses;
    public Faculty( String Name, String Phone, int Age, double Salary){

        super(Name,Phone,Age);
        this.Salary = Salary;
        this.courses = new ArrayList<Course>();
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public double getTotalSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public int getTotalUnits(){
        int totalUnits = 0;
        for (Course c: courses){
            totalUnits+= c.getUnits();
        }
        return totalUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty faculty)) return false;
        return Double.compare(getTotalSalary(), faculty.getTotalSalary()) == 0 && Objects.equals(getCourses(), faculty.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTotalSalary(), getCourses());
    }
}

