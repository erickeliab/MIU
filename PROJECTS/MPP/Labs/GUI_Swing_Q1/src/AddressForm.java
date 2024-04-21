import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressForm extends JFrame {
    private JTextField nameField, streetField, cityField, stateField, zipField;

    public AddressForm() {
        setTitle("Address Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        JLabel streetLabel = new JLabel("Street:");
        streetField = new JTextField(20);
        JLabel cityLabel = new JLabel("City:");
        cityField = new JTextField(20);
        JLabel stateLabel = new JLabel("State:");
        stateField = new JTextField(5);
        JLabel zipLabel = new JLabel("ZIP:");
        zipField = new JTextField(5);

        // Create Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        // Create panels to organize components
        JPanel formPanel = new JPanel(new FlowLayout());
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(streetLabel);
        formPanel.add(streetField);
        formPanel.add(cityLabel);
        formPanel.add(cityField);

        JPanel stateZipPanel = new JPanel(new FlowLayout());
        stateZipPanel.add(stateLabel);
        stateZipPanel.add(stateField);
        stateZipPanel.add(zipLabel);
        stateZipPanel.add(zipField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);

        // Add panels to the frame
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(formPanel);
        add(stateZipPanel);
        add(buttonPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String street = streetField.getText();
            String city = cityField.getText();
            String state = stateField.getText();
            String zip = zipField.getText();

            // Output the address to the console
            System.out.println(name);
            System.out.println(street);
            System.out.println(city + ", " + state + " " + zip);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AddressForm addressForm = new AddressForm();
            addressForm.setVisible(true);
        });
    }
}
