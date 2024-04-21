import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashSet;
import java.util.Set;

public class StringManipulationApp extends JFrame {
    private JTextField inputField, outputField;
    private JButton countLettersBtn, reverseLettersBtn, removeDuplicatesBtn;

    public StringManipulationApp() {
        setTitle("String Manipulation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        countLettersBtn = new JButton("Count Letters");
        reverseLettersBtn = new JButton("Reverse Letters");
        removeDuplicatesBtn = new JButton("Remove Duplicates");

        // Create input and output fields
        inputField = new JTextField(20);
        outputField = new JTextField(20);
        outputField.setEditable(false); // make output field read-only

        // Create button listeners
        countLettersBtn.addActionListener(new CountLettersListener());
        reverseLettersBtn.addActionListener(new ReverseLettersListener());
        removeDuplicatesBtn.addActionListener(new RemoveDuplicatesListener());

        // Layout components
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.add(countLettersBtn);
        buttonPanel.add(reverseLettersBtn);
        buttonPanel.add(removeDuplicatesBtn);

        JPanel inputOutputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputOutputPanel.add(new JLabel("Input:"));
        inputOutputPanel.add(inputField);
        inputOutputPanel.add(new JLabel("Output:"));
        inputOutputPanel.add(outputField);

        // Add padding/margin using empty panels
        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(20, 20));
        JPanel emptyPanelEast = new JPanel();
        emptyPanelEast.setPreferredSize(new Dimension(20, 20));
        JPanel emptyPanelNorth = new JPanel();
        emptyPanelNorth.setPreferredSize(new Dimension(20, 20));
        JPanel emptyPanelSouth = new JPanel();
        emptyPanelSouth.setPreferredSize(new Dimension(20, 20));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(emptyPanelWest, BorderLayout.WEST);
        getContentPane().add(emptyPanelEast, BorderLayout.EAST);
        getContentPane().add(emptyPanelNorth, BorderLayout.NORTH);
        getContentPane().add(emptyPanelSouth, BorderLayout.SOUTH);
        getContentPane().add(buttonPanel, BorderLayout.WEST);
        getContentPane().add(inputOutputPanel, BorderLayout.CENTER);

        // Create and add menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu myMenu = new JMenu("myMenu");
        JMenuItem menuItem1 = new JMenuItem("MenuItem1");
        JMenuItem menuItem2 = new JMenuItem("MenuItem2");
        JMenuItem menuItem3 = new JMenuItem("MenuItem3");

        menuItem1.addActionListener(new MenuItemListener());
        menuItem2.addActionListener(new MenuItemListener());
        menuItem3.addActionListener(new MenuItemListener());

        myMenu.add(menuItem1);
        myMenu.add(menuItem2);
        myMenu.add(menuItem3);

        menuBar.add(myMenu);
        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    private class CountLettersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText();
            int count = inputText.length();
            outputField.setText(String.valueOf(count));
        }
    }

    private class ReverseLettersListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText();
            StringBuilder reversedText = new StringBuilder(inputText).reverse();
            outputField.setText(reversedText.toString());
        }
    }

    private class RemoveDuplicatesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String inputText = inputField.getText();
            Set<Character> uniqueChars = new LinkedHashSet<>();
            for (char c : inputText.toCharArray()) {
                if (Character.isLetter(c)) {
                    uniqueChars.add(c);
                }
            }
            StringBuilder result = new StringBuilder();
            for (char c : uniqueChars) {
                result.append(c);
            }
            outputField.setText(result.toString());
        }
    }

    private class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem source = (JMenuItem) e.getSource();
            String menuItemText = source.getText();
            JOptionPane.showMessageDialog(StringManipulationApp.this, menuItemText + " was clicked.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StringManipulationApp app = new StringManipulationApp();
            app.setVisible(true);
        });
    }
}
