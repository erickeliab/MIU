import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepartmentApplication extends JFrame {
    private JTextArea outputTextArea;
    private JTextField inputTextField;
    private Department dept;

    public DepartmentApplication(Department dept) {
        this.dept = dept;

        setTitle("Department Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 400); // Set width to 600 pixels and height to 400 pixels

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        add(scrollPane, BorderLayout.CENTER);

        createMenuBar(); // Create menu bar and add menus

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        inputTextField = new JTextField();
        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new EnterButtonListener());
        inputPanel.add(inputTextField, BorderLayout.CENTER);
        inputPanel.add(enterButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the frame

        showMenu();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");

        JMenuItem totalSalaryItem = new JMenuItem("Get Total Salary");
        totalSalaryItem.addActionListener(e -> getTotalSalary());
        optionsMenu.add(totalSalaryItem);

        JMenuItem showMembersItem = new JMenuItem("Show All Members");
        showMembersItem.addActionListener(e -> showAllMembers());
        optionsMenu.add(showMembersItem);

        JMenuItem unitsPerFacultyItem = new JMenuItem("Units Per Faculty");
        unitsPerFacultyItem.addActionListener(e -> unitsPerFaculty());
        optionsMenu.add(unitsPerFacultyItem);

        JMenuItem pullStudentsItem = new JMenuItem("Pull Students of Faculty");
        pullStudentsItem.addActionListener(e -> pullStudentsOfFaculty());
        optionsMenu.add(pullStudentsItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(e -> System.exit(0));
        optionsMenu.add(quitItem);

        menuBar.add(optionsMenu);

        setJMenuBar(menuBar);
    }

    private void showMenu() {
        outputTextArea.append("Welcome to the Department Application!\n");
    }

    private void getTotalSalary() {
        double totSalary = dept.getTotalSalary();
        outputTextArea.append("Total sum of all salaries is: " + totSalary + "\n");
    }

    private void showAllMembers() {
        dept.showAllMembers();
    }

    private void unitsPerFaculty() {
        dept.unitsPerFaculty();
    }

    private void pullStudentsOfFaculty() {
        String facultyName = JOptionPane.showInputDialog("Input name of a Faculty Member:");
        dept.pullStudentsOfFaculty(facultyName);
    }

    private class EnterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button click events if needed
        }
    }

    public static void main(String[] args) {
        Department dept = new Department("ComputerScience");
        // Populate the department with data
        // Add your manual data initialization here

        // Create faculty objects
        Person frankMoore = new Faculty("Frank Moore","472-5921",43,10000);
        Person samHoward = new Faculty("Sam Howard","472-7222",55,9500);
        Person johnDoodle = new Faculty("John Doodle","472-6190",39,8600);
        dept.addPerson (frankMoore);
        dept.addFaculty(samHoward);
        dept.addFaculty(johnDoodle);

        // Create student objects
        Person johnDoe = new Student("John Doe","472-1121",22,4.0);
        Person maryJones = new Student("Mary Jones","472-7322",32,3.80);
        Person leeJohnson = new Student("Lee Johnson","472-6009",19,3.65);
        dept.addPerson (johnDoe);
        dept.addStudent(maryJones);
        dept.addStudent(leeJohnson);

        // Create staff objects
        Person frankGore = new Staff("Frank Gore","472-3321",33,4050);
        Person adamDavis = new Staff("Adam Davis","472-7552",50,5500);
        Person davidHeck = new Staff("David Heck","472-8890",29,3600);
        dept.addPerson (frankGore);
        dept.addStaff(adamDavis);
        dept.addStaff(davidHeck);

        // Create courses and assign them to faculty and students

        // Create courses
        Course cs201 = new Course("cs201","programming",4);
        Course cs360 = new Course("cs360","database",3);
        Course cs404 = new Course("cs404","compiler",4);
        Course cs240 = new Course("cs240","datastructure",2);
        Course cs301 = new Course("cs301","Software engg",3);
        Course cs450 = new Course("cs450","Advanced architecture",5);

        // Assign courses to faculty
        Faculty jdl = (Faculty) johnDoodle;
        jdl.addCourse(cs201);
        jdl.addCourse(cs404);
        jdl.addCourse(cs240);

        Faculty smh = (Faculty) samHoward;
        smh.addCourse(cs360);
        smh.addCourse(cs301);

        Faculty frm = (Faculty) frankMoore;
        frm.addCourse(cs450);

        // Assign courses to students
        Student jd = (Student) johnDoe;
        jd.addCourses(cs201);
        jd.addCourses(cs360);
        jd.addCourses(cs404);
        jd.addCourses(cs301);

        Student mj = (Student) maryJones;
        mj.addCourses(cs201);
        mj.addCourses(cs404);
        mj.addCourses(cs450);

        Student lj = (Student) leeJohnson;
        lj.addCourses(cs201);
        lj.addCourses(cs360);
        lj.addCourses(cs240);
        lj.addCourses(cs450);

        // Launch the GUI with the populated department
        SwingUtilities.invokeLater(() -> {
            DepartmentApplication gui = new DepartmentApplication(dept);
            gui.setVisible(true);
        });
    }
}
