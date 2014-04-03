import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBook extends JFrame {

    public AddressBook() {
        // Window
        setTitle("Address Book");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);

        // Panels
        JPanel mainPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        JPanel fieldPanel = new JPanel();

        // Labels
        JLabel firstNameLabel = new JLabel("First Name");
        JLabel lastNameLabel = new JLabel("Last Name");
        JLabel streetLabel = new JLabel("Street");
        JLabel cityLabel = new JLabel("City");
        JLabel zipLabel = new JLabel("Zip");
        JLabel phoneLabel = new JLabel("Phone");
        JLabel emailLabel = new JLabel("Email");

        // Text Fields
        final JTextField firstNameField = new JTextField();
        final JTextField lastNameField = new JTextField();
        final JTextField streetField = new JTextField();
        final JTextField cityField = new JTextField();
        final JTextField zipField = new JTextField();
        final JTextField phoneField = new JTextField();
        final JTextField emailField = new JTextField();

        // Buttons
        JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                // TODO save field text to JSON file
            }
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                firstNameField.setText("");
                lastNameField.setText("");
                streetField.setText("");
                cityField.setText("");
                zipField.setText("");
                phoneField.setText("");
                emailField.setText("");
            }
        });

        // Layout
        add(mainPanel);
        add(BorderLayout.SOUTH, buttonPanel);

        Border mainBorder = BorderFactory.createEmptyBorder(0, 10, 10, 10);
        mainPanel.setBorder(mainBorder);
        buttonPanel.setBorder(mainBorder);

        GridLayout buttonPanelLayout = new GridLayout(0, 2);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanel.add(clear);
        buttonPanel.add(save);

        GridLayout mainPanelLayout = new GridLayout(0, 2);
        mainPanel.setLayout(mainPanelLayout);
        mainPanel.add(labelPanel);
        mainPanel.add(fieldPanel);

        GridLayout labelPanelLayout = new GridLayout(0, 1);
        labelPanel.setLayout(labelPanelLayout);
        labelPanel.add(firstNameLabel);
        labelPanel.add(lastNameLabel);
        labelPanel.add(streetLabel);
        labelPanel.add(cityLabel);
        labelPanel.add(zipLabel);
        labelPanel.add(phoneLabel);
        labelPanel.add(emailLabel);

        GridLayout fieldPanelLayout = new GridLayout(0, 1);
        fieldPanel.setLayout(fieldPanelLayout);
        fieldPanel.add(firstNameField);
        fieldPanel.add(lastNameField);
        fieldPanel.add(streetField);
        fieldPanel.add(cityField);
        fieldPanel.add(zipField);
        fieldPanel.add(phoneField);
        fieldPanel.add(emailField);

        setVisible(true);
    }

    public static void main(String[] args) {
        new AddressBook();
    }
}
