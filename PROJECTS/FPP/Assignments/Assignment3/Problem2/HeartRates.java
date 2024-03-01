import java.time.LocalDate;
import java.util.Scanner;

public class HeartRates {

    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;

    HeartRates(String firstname, String lastname, LocalDate dateOfBirth){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int calculateAge(){
        // Calculate age
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();


        if (LocalDate.now().getMonthValue() < dateOfBirth.getMonthValue() ||
                (LocalDate.now().getMonthValue() == dateOfBirth.getMonthValue()
                        && LocalDate.now().getDayOfMonth() < dateOfBirth.getDayOfMonth())) {
            age--;
        }

        return age;
    }


    public int getMinimumHR(){

        return 76;
    }

    public int getMaximumHR(){

        return 220 - calculateAge();
    }

    public String getTargetHR(){

        double low = 0.5*getMaximumHR();
        double high = 0.85*getMaximumHR();

        return low+" "+"and"+" "+high;
    }


    public void toString(HeartRates hr){
        System.out.println("The target Heart Rate Range is between "+ " " + hr.getTargetHR());
        System.out.println("First Name : " + hr.firstname);
        System.out.println("First Name : " + hr.lastname);
        System.out.println("Age : " + hr.calculateAge());
        System.out.println("Date of Birth : " + hr.dateOfBirth);
        System.out.println("Maximum Heart Rate : " + hr.getMaximumHR());
    }

    public static void main(String[] args) {


       Scanner sc = new Scanner(System.in);

       System.out.println("Please enter your firstname:");
       String firstname = sc.nextLine();
       System.out.println("Please, enter your last name:");
       String lastname = sc.nextLine();
       System.out.println("Please enter your birth date in the format-(yyyy-mm-dd)-Example 1989-4-14");
       LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());
       sc.close();
       HeartRates hr = new HeartRates(firstname,lastname,dateOfBirth);

       hr.toString(hr);


    }


}
