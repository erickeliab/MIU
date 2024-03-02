import java.time.LocalDate;

public class DeptEmployee {

 private String name;
 private LocalDate hiredate;

 private double salary;

 DeptEmployee(String name, LocalDate hiredate, double salary){

  this.name = name;
  this.hiredate = hiredate;
  this.salary = salary;
 }

 public LocalDate getHiredate() {
  return hiredate;
 }

 public void setHiredate(LocalDate hiredate) {
  this.hiredate = hiredate;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }


 public double computeSalary(){
  return salary;
 }


}
