import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Student extends Person{

    private double GPA;
    private ArrayList<Course> courses;
    Student(String Name, String Phone, int Age, double GPA){
        super(Name,Phone,Age);

        this.GPA = GPA;
        this.courses = new ArrayList<>();
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public void addCourses(Course course){
        courses.add(course);
    }



    public int getTotalUnits(){
        int total = 0;
        for (Course course: courses){
            total+= course.getUnits();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(getGPA(), student.getGPA()) == 0 && Objects.equals(getCourses(), student.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getGPA(), getCourses());
    }
}
