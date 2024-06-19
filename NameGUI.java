import javax.swing.*;
import java.text.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;

public class NameGUI extends JFrame implements ActionListener {
    public static void main(String[] args) {
        /* 
        NameGUI newDemo = new NameGUI();
        newDemo.pack();
        newDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newDemo.setVisible(true);
        */

        NameFrame newDemo = new NameFrame();
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
        ageField.setValue(69);

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

class NameFrame extends JFrame {
    private NameComponent nameComponent;
    private AgeComponent ageComponent;
    private InchesComponent inchesComponent;
    private JButton acceptButton;
    private GridBagConstraints layoutConst;


    NameFrame() {
        nameComponent = new NameComponent();
        ageComponent = new AgeComponent();
        inchesComponent = new InchesComponent();
        acceptButton = new JButton("Accept");

        setLayout(new GridBagLayout());
        layoutConst = new GridBagConstraints();

        layoutConst.gridx = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        
        add(nameComponent,layoutConst);

        layoutConst.gridx = 1;
        add(ageComponent, layoutConst);

        layoutConst.gridx = 2;
        add(inchesComponent, layoutConst);

        layoutConst.gridx = 3;
        layoutConst.gridy = 2;
        add(acceptButton, layoutConst);

        //setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}

class NameComponent extends JComponent{
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;

    NameComponent() {
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField(15);
        nameField.setText("Enter Name Here");
        namePanel = new JPanel();
        buildPanel();
    }

    private void buildPanel() {
        GridBagConstraints layoutConst = new GridBagConstraints();
        namePanel.setLayout(new GridBagLayout());

        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        namePanel.add(nameLabel, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        namePanel.add(nameField, layoutConst);

    }
}

class AgeComponent extends JComponent {
    private JLabel ageLabel;
    private JFormattedTextField ageField;
    private JPanel agePanel;

    AgeComponent() {
        ageLabel = new JLabel("Age: ");
        ageField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        agePanel = new JPanel();
        agePanel.add(ageLabel);
        agePanel.add(ageField);
    }

}

class InchesComponent extends JComponent {
    private JLabel inchesLabel;
    private JFormattedTextField inchesField;
    private JPanel inchesPanel;

    InchesComponent() {
        inchesLabel = new JLabel("Inches Tall: ");
        inchesField = new JFormattedTextField(DecimalFormat.getInstance());
        inchesPanel = new JPanel();
        inchesPanel.add(inchesLabel);
        inchesPanel.add(inchesField);
    }
}


