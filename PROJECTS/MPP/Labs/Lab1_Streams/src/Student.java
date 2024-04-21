import java.util.*;

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
//
        return courses.stream().mapToInt(Course::getUnits).sum();

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
