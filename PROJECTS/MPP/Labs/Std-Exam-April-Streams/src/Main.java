
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Main {

    @SuppressWarnings("serial")
    public static void main(String[] args) {
        List<String> ssns = Arrays.asList("234121244",
                "113145657",
                "342892138",
                "999234124",
                "523421589",
                "234112355",
                "553667742",
                "212341557",
                "115513151");

        HashMap<String, Employee> h = new HashMap<String, Employee>() {
            {
                put("523421589", new Employee("Tom", 88000, "523421589"));
                put("234121244", new Employee("Bob", 78000, "234121244"));
                put("212341557", new Employee("Hank", 110000, "212341557"));
                put("999234124",new Employee("Ephraim", 66000, "999234124"));
                put("432346624",new Employee("Dogface", 54000, "432346624"));
                put("115513151",new Employee("Jonas", 76000, "115513151"));
                put("113145657",new Employee("Rick", 92000, "113145657"));
                put("678316579",new Employee("Yonas", 82000, "678316579"));
                put("342892138",new Employee("Ibu", 100000, "342892138"));

            }
        };

        List<Employee> report = EmployeeAdmin.prepareEmpReport(h,  ssns);
        //Expected output: [(212341557: Hank, 110000), (342892138: Ibu, 100000), (113145657: Rick, 92000), (523421589: Tom, 88000)]
        System.out.println(report);

        List<String> report2 = EmployeeAdmin.prepareSsnReport(h,  ssns);
        //Expected output: [432346624, 678316579]
        System.out.println(report2);

    }

}