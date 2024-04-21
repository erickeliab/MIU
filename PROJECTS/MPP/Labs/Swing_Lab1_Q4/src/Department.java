import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


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

//   using InstanceOf

        double total = 0;
        Iterator<Person> it = people.iterator();
        while (it.hasNext()){
            Person next = it.next();
//            USING instanceOf
//            if (next instanceof Staff staff){
//
//                total+= staff.getTotalSalary();
//
//            }else if (next instanceof Faculty faculty){
//                total+= faculty.getTotalSalary();
//            }
//            USING polymorphism
            total+= next.getTotalSalary();


        }

        return total;
    }

    public void showAllMembers(){

        System.out.println(people.toString());


    }

    public void unitsPerFaculty() {
        System.out.println("Faculty Units:");
        for (Person person : people) {
            if (person instanceof Faculty faculty) {

                System.out.println(faculty.getName() + " => " + faculty.getTotalUnits());
            }
        }
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

        boolean facultyFound = false;
        for (Person person : people) {
            if (person instanceof Faculty && person.getName().equals(name)) {
                facultyFound = true;
                System.out.println("Printing Students of Faculty Member: " + person.getName() + " =>");
                ArrayList<Course> facultyCourses = ((Faculty) person).getCourses();

                boolean studentsFound = false;
                for (Person student : people) {
                    if (student instanceof Student currentstudent) {
                        ArrayList<Course> studentCourses = currentstudent.getCourses();
                        for (Course studentCourse : studentCourses) {
                            if (facultyCourses.contains(studentCourse)) {
                                System.out.println(student.getName());
                                studentsFound = true;
                                break;
                            }
                        }
                    }
                }
                if (!studentsFound) {
                    System.out.println("No student was found for this Faculty Member.");
                }

                break;
            }
        }

        if (!facultyFound) {
            System.out.println("There is no Faculty member matching the name: " + name);
        }
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
