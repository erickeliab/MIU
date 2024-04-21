import java.util.Objects;

public class Course {
    private String Number;
    private String Title;
    private int Units;

    Course(String Number , String Title, int Units){
        this.Number = Number;
        this.Title = Title;
        this.Units = Units;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getUnits() {
        return Units;
    }

    public void setUnits(int units) {
        Units = units;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getUnits() == course.getUnits() && Objects.equals(getNumber(), course.getNumber()) && Objects.equals(getTitle(), course.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getTitle(), getUnits());
    }
}
