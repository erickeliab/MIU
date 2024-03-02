import java.time.LocalDate;

public class Professor extends DeptEmployee{

    private int numberOfPublications;

    Professor( String name, LocalDate hiredate, double salary, int numberOfPublications){

        super(name,hiredate,salary);
        this.numberOfPublications = numberOfPublications;

    }

    public int getNumberOfPublications() {
        return numberOfPublications;
    }

    public void setNumberOfPublications(int numberOfPublications) {
        this.numberOfPublications = numberOfPublications;
    }

}
