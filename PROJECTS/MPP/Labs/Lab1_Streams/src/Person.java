import java.util.Objects;

public class Person {

    private String Name;
    private String Phone;
    private int Age;

    Person(String Name, String Phone, int Age){
        this.Name = Name;
        this.Phone = Phone;
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public double getTotalSalary(){
        return 0.0;
    }

    @Override
    public String toString() {
        String type = "";
        if (this instanceof Staff) {
            type = "staff";
        } else if (this instanceof Student) {
            type = "student";
        } else if (this instanceof Faculty){
            type = "faculty";
        }



        return "Name: "+ Name + " with Phone number: "+ Phone + ", age : " + Age + " Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && Objects.equals(getName(), person.getName()) && Objects.equals(getPhone(), person.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone(), getAge());
    }
}
