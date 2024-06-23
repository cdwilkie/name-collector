import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;


public class NameGUI {
    private NamePanel namePanel;
    private AgePanel agePanel;
    private InchesPanel inchesPanel;
    private AcceptPanel acceptPanel;
    private JPanel mainPanel;
    private JFrame mainFrame;
    private NameCollector newUser;

    public NameGUI() {
        newUser = new NameCollector();
        mainFrame = new JFrame("Name Collector");
        mainPanel = new JPanel();
        namePanel = new NamePanel();
        agePanel = new AgePanel();
        inchesPanel = new InchesPanel();
        acceptPanel = new AcceptPanel();
        acceptPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkInput()) {
                    collectData();
                }
            }
        });

        GridBagConstraints layoutConstraints2 = new GridBagConstraints();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        // gridbag layout constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        // setlayout
        mainFrame.setLayout(new GridBagLayout());

        // add name components
        this.addNamePanel(layoutConstraints);
        // add age components
        this.addAgePanel(layoutConstraints);
        // add inches componenets
        this.addInchesPanel(layoutConstraints);
        // add accept components
        this.addAcceptPanel(layoutConstraints);

        this.addMainPanel(layoutConstraints2);

        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(600, 375));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.getContentPane().setBackground(Color.DARK_GRAY);
        mainFrame.pack();

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NameGUI();
            }
        });
    }

    public String getName() {
        return namePanel.getName();
    }

    public int getAge() {
        return agePanel.getAge();
    }

    public double getInches() {
        return inchesPanel.getInches();
    }

    public void setName(String userName) {
        namePanel.setName(userName);
    }

    public void setAge(int userAge) {
        agePanel.setAge(userAge);
    }

    public void setInches(double userInches) {
        inchesPanel.setInches(userInches);
    }

    private void addNamePanel(GridBagConstraints layoutConstraints) {
        
         // format panel constraints
         layoutConstraints.gridx = 0;
         layoutConstraints.gridy = 0;
         layoutConstraints.fill = GridBagConstraints.BOTH;
         layoutConstraints.anchor = GridBagConstraints.BASELINE;
         layoutConstraints.weightx = 1.0;
         layoutConstraints.weighty = 1.0;
         layoutConstraints.insets = new Insets(10, 10, 10, 10);
 
         this.customizePanel(namePanel);
         // add panel to frame with constraints
         mainPanel.add(namePanel, layoutConstraints);

    }

    private void addAgePanel(GridBagConstraints layoutConstraints) {

        // format panel constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.customizePanel(agePanel);
        // add panel to frame with constraints
        mainPanel.add(agePanel, layoutConstraints);
    }

    private void addInchesPanel(GridBagConstraints layoutConstraints) {
        
         // format panel constraints
         layoutConstraints.gridx = 0;
         layoutConstraints.gridy = 2;
         layoutConstraints.fill = GridBagConstraints.BOTH;
         layoutConstraints.anchor = GridBagConstraints.BASELINE;
         layoutConstraints.weightx = 1.0;
         layoutConstraints.weighty = 1.0;
         layoutConstraints.insets = new Insets(10, 10, 10, 10);
 
         this.customizePanel(inchesPanel);
         // add panel to frame with constraints
         mainPanel.add(inchesPanel, layoutConstraints);
    }

    private void addAcceptPanel(GridBagConstraints layoutConstraints) {
        
        // format panel constraints
        layoutConstraints.gridx = 2;
        layoutConstraints.gridy = 3;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);
        layoutConstraints.gridheight = 1;
        layoutConstraints.gridwidth = 1;

        this.customizePanel(acceptPanel);
        // add panel to frame with constraints
        mainPanel.add(acceptPanel, layoutConstraints);
    }

    private void customizePanel(JPanel targetPanel) {
        // Set panel background color to white
        targetPanel.setBackground(Color.WHITE);
        // apply border (compound black soft bevel)
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border softBevelBorder = BorderFactory.createRaisedSoftBevelBorder();
        targetPanel.setBorder(
            BorderFactory.createCompoundBorder(softBevelBorder, blackBorder));
    }//end customizePanel()

    private void addMainPanel(GridBagConstraints layoutConstraints) {
        // format panel constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        //layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        //layoutConstraints.insets = new Insets(10, 10, 10, 10);

        mainFrame.add(mainPanel, layoutConstraints);
    }

    private void collectData() {
        newUser.setName(this.getName());
        newUser.setAge(this.getAge());
        newUser.setInches(this.getInches());
        newUser.setResults();

        JOptionPane.showMessageDialog(
            this.mainPanel, newUser.getResults(), "User Results",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean checkInput() {
        String validNamePattern = "^[a-zA-Z]+\s*[a-zA-Z]*$";
        String validAgePattern = "\\d{1,3}";
        String validInchesPattern = "^\\d{1,3}\\.?\\d*$";

        if ((!this.getName().matches(validNamePattern))) {
            JOptionPane.showMessageDialog(
                this.mainPanel, "Name Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }

        if ((!this.agePanel.getAgeFieldText().matches(validAgePattern))) {
            JOptionPane.showMessageDialog(
                this.mainPanel, "Age Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }

        if ((!this.inchesPanel.getInchesFieldText().matches(validInchesPattern))) {
            JOptionPane.showMessageDialog(
                this.mainPanel, "Inches Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }
        return true;
    }

}

class NamePanel extends JPanel {

    private JLabel nameLabel;
    private JTextField nameField;

    public NamePanel() {
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        nameField.setColumns(15);
        // create gridbag constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        // set layout
        this.setLayout(new GridBagLayout());

        // format label layout
        this.addLabel(layoutConstraints);
        // add label component
        // format field layout
        // add field component
        this.addField(layoutConstraints);
    }

    public String getName() {

        return nameField.getText();
    }

    public void setName(String userName) {
        nameField.setText(userName);
    }

    private void addLabel(GridBagConstraints layoutConstraints) {
        //format label constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(nameLabel, layoutConstraints);
    }
    
    private void addField(GridBagConstraints layoutConstraints) {
        //format field constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(nameField, layoutConstraints);
    }
}

class AgePanel extends JPanel {

    private JLabel ageLabel;
    private JFormattedTextField ageField; 
   
    public AgePanel() {
        ageLabel  = new JLabel("Age: ");
        ageField = new JFormattedTextField(
            NumberFormat.getIntegerInstance());
        ageField.setColumns(14);
        // create gridbag constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        // set layout
        this.setLayout(new GridBagLayout());

        // format label layout
        // add label component
        this.addLabel(layoutConstraints);
        // format field layout
        // add field component
        this.addField(layoutConstraints);
    }

    public String getAgeFieldText() {
        return ageField.getText();
    }

    public int getAge() {

        return Integer.parseInt(ageField.getText());
    }

    public void setAge(int userAge) {
        ageField.setText(String.valueOf(userAge));
    }

    private void addLabel(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(ageLabel, layoutConstraints);
    }

    private void addField(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(ageField, layoutConstraints);
    }
}

class InchesPanel extends JPanel {

    private JLabel inchesLabel;
    private JFormattedTextField inchesField;

    public InchesPanel() {
        inchesLabel = new JLabel("Inches: ");
        inchesField = new JFormattedTextField(
            DecimalFormat.getNumberInstance());
        inchesField.setColumns(15);
        // create gridbag constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        // set layout
        this.setLayout(new GridBagLayout());
        // format label layout
        // add label component
        this.addLabel(layoutConstraints);
        // format field layout
        // add field component
        this.addField(layoutConstraints);

    }

    public String getInchesFieldText() {
        return inchesField.getText();
    }

    public double getInches() {
    
        return Double.parseDouble(inchesField.getText());
    }

    public void setInches(double userInches) {

        inchesField.setText(String.valueOf(userInches));
    }

    private void addLabel(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(inchesLabel, layoutConstraints);
    }

    private void addField(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        this.add(inchesField, layoutConstraints);
    }
}

class AcceptPanel extends JPanel {

    private JButton acceptButton;

    public AcceptPanel() {
        acceptButton = new JButton("Accept");
        GridBagConstraints layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());
        this.addButton(layoutConstraints);
    }

    private void addButton(GridBagConstraints layoutConstraints) {
        // Format Button Layout Constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        //layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10,10,10,10);
        layoutConstraints.gridheight = 2;
        layoutConstraints.gridwidth = 2;
        layoutConstraints.ipady = 40;

        this.add(acceptButton, layoutConstraints);
    }

    public JButton getButton() {

        return this.acceptButton;
    }



}