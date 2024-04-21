import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Department {

    private String Name;
    private ArrayList<Person> people;


    Department(String Name){
        this.Name = Name;
        this.people = new ArrayList<Person>();
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public ArrayList<Person> getPeople() {
        return people;
    }

    public double getTotalSalary(){

        return people.stream().mapToDouble(Person::getTotalSalary).sum();
    }

    public void showAllMembers(){

        System.out.println(people.toString());


    }

    public void unitsPerFaculty() {
        System.out.println("Faculty Units:");
        people.stream().filter(p -> p instanceof Faculty).forEach(f -> {
            System.out.println(f.getName() + " => " + ((Faculty) f).getTotalUnits());
        });

    }

    public void addPerson(Person person){
        this.people.add(person);
    }
    public void addFaculty(Person faculty){
        this.people.add(faculty);
    }

    public void addStudent(Person student){
        this.people.add(student);
    }

    public void addStaff(Person staff){
        this.people.add(staff);
    }


    public void pullStudentsOfFaculty(String name) {
        if (name.isEmpty()) {
            System.out.println("You have not entered a valid name.");
            return;
        }

        boolean facultyFound = people.stream()
                .filter(person -> person instanceof Faculty)
                .anyMatch(person -> person.getName().equals(name));

        if (!facultyFound) {
            System.out.println("There is no Faculty member matching the name: " + name);
            return;
        }

        System.out.println("Printing Students of Faculty Member: " + name + " =>");
        people.stream()
                .filter(person -> person instanceof Student)
                .filter(student -> {
                    ArrayList<Course> studentCourses = ((Student) student).getCourses();
                    List<Course> facultyCourses = people.stream()
                            .filter(person -> person instanceof Faculty && person.getName().equals(name))
                            .flatMap(faculty -> ((Faculty) faculty).getCourses().stream())
                            .collect(Collectors.toList());
                    return facultyCourses.stream().anyMatch(studentCourses::contains);
                })
                .forEach(student -> System.out.println(student.getName()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getPeople(), that.getPeople());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPeople());
    }
}
