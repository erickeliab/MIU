import java.time.LocalDate;

public class Hourly extends Employee{

    private double hourlyWage;
    private int hoursPerWeek;

    Hourly(int empId, double hourlyWage, int hoursPerWeek){
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }


    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }


    @Override
    public double calcGrossPay(LocalDate dateRange) {

        return (hourlyWage * hoursPerWeek) * 4;

    }

}
