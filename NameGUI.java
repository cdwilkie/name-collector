import javax.swing.*;
import java.text.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;

public class NameGUI extends JFrame implements ActionListener {
    public static void main(String[] args) {
        NameGUI newDemo = new NameGUI();
        newDemo.pack();
        newDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newDemo.setVisible(true);
    }

    private JLabel nameLabel, ageLabel, inchesLabel;
    private JTextField nameField;
    private JFormattedTextField ageField, inchesField;
    private JButton acceptButton;

    public NameGUI () {
        nameLabel = new JLabel("Name: ");
        ageLabel = new JLabel("Age: ");
        inchesLabel = new JLabel("Height in inches: ");

        nameField = new JTextField(20);
        nameField.setEditable(true);
        nameField.setText("John Doe");

        ageField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        ageField.setColumns(15);
        ageField.setEditable(true);
        ageField.setValue(42);

        inchesField = new JFormattedTextField(NumberFormat.getInstance());
        inchesField.setColumns(15);
        inchesField.setEditable(true);
        inchesField.setValue(42.0);

        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(this);

        setLayout(new GridBagLayout());

        GridBagConstraints layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 0;
        layoutConsts.gridy = 0;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(nameLabel, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 1;
        layoutConsts.gridy = 0;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(nameField, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 0;
        layoutConsts.gridy = 1;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(ageLabel, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 1;
        layoutConsts.gridy = 1;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(ageField, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 0;
        layoutConsts.gridy = 2;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(inchesLabel, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 1;
        layoutConsts.gridy = 2;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(inchesField, layoutConsts);

        layoutConsts = new GridBagConstraints();
        layoutConsts.gridx = 2;
        layoutConsts.gridy = 3;
        layoutConsts.insets = new Insets(10,10,10,10);
        add(acceptButton, layoutConsts);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Yuo have entered data and preesed accept");
    }
    
}


