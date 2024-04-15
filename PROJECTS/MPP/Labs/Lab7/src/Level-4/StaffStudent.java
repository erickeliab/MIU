package Level

import java.time.LocalDate;
import java.util.Objects;

public class StaffStudent extends Staff{

    private final Student student;
    private LocalDate startingCourseDate;
    StaffStudent(String Name, String Phone, int Age, double Salary, double GPA, LocalDate startingCourseDate){
        super(Name, Phone, Age, Salary);
        student = new Student(Name,Phone,Age,GPA);
        this.startingCourseDate = startingCourseDate;

    }

    public LocalDate getStartingCourseDate() {
        return startingCourseDate;
    }

    public void setStartingCourseDate(LocalDate startingCourseDate) {
        this.startingCourseDate = startingCourseDate;
    }

    public double getGPA(){
        return student.getGPA();
    }

    public void setGPA(double GPA){
        student.setGPA(GPA);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffStudent that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(student, that.student) && Objects.equals(getStartingCourseDate(), that.getStartingCourseDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), student, getStartingCourseDate());
    }
}
