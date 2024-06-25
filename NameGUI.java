import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.text.JTextComponent;



/**
 * 
 */
public class NameGUI extends JPanel {

    private NamePanel namePanel;
    private AgePanel agePanel;
    private InchesPanel inchesPanel;
    private AcceptPanel acceptPanel;

    private NameCollector newUser;

    public NameGUI() {
        namePanel = new NamePanel();
        addFieldFocusLogic(namePanel);
        agePanel = new AgePanel();
        addFieldFocusLogic(agePanel);
        inchesPanel = new InchesPanel();
        addFieldFocusLogic(inchesPanel);
        acceptPanel = new AcceptPanel();
        addButtonLogic(acceptPanel);

        // NameCollector found in NameCollector.java
        newUser = new NameCollector();

        // Customize Panel
        this.setLayout(new GridBagLayout());
        this.setBackground(Color.DARK_GRAY);
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        // Add Each Custom Sub-Panel
        this.addNamePanel(layoutConstraints);
        this.addAgePanel(layoutConstraints); 
        this.addInchesPanel(layoutConstraints); 
        this.addAcceptPanel(layoutConstraints);
    }//end constructor

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
        this.add(namePanel, layoutConstraints);
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
        this.add(agePanel, layoutConstraints);
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
        this.add(inchesPanel, layoutConstraints);
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
        this.add(acceptPanel, layoutConstraints);
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

    private void addButtonLogic(AcceptPanel targetPanel) {
        targetPanel.getAcceptButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {
                if (checkInput()) {
                    collectData();
                }//end if input valid
            }//end actionPerformed
        });//end actionListener
    }//end addButtonLogic()

    private void addFieldFocusLogic(JPanel targetPanel) {
        targetPanel.getComponent(1).addFocusListener(new FieldListenerLogic(targetPanel));
    }//end addFieldFocusLogic()

    private void collectData() {
        newUser.setName(this.namePanel.getName());
        newUser.setAge((Integer)this.agePanel.getAge());
        newUser.setInches((Double)this.inchesPanel.getInches());
        newUser.setResults();

        JOptionPane.showMessageDialog(
            this, newUser.getResults(), "User Results",
            JOptionPane.INFORMATION_MESSAGE);
    }//end collectData()

    private boolean checkInput() {
        String validNamePattern = "^[a-zA-Z]{1,15}\s*[a-zA-Z]{0,15}$";
        String validAgePattern = "\\d{1,3}";
        String validInchesPattern = "^\\d{1,3}\\.?\\d*$";

        if ((!this.namePanel.getNameField().getText().matches(validNamePattern))) {
            JOptionPane.showMessageDialog(
                this, "Name Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }

        if ((!this.agePanel.getAgeField().getText().matches(validAgePattern))) {
            JOptionPane.showMessageDialog(
                this, "Age Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }

        if ((!this.inchesPanel.getInchesField().getText().matches(validInchesPattern))) {
            JOptionPane.showMessageDialog(
                this, "Inches Error", "Input Error",
                JOptionPane.ERROR_MESSAGE); 
                return false;
        }
        return true;
    }//end checkInput()

    public static void main(String[] args) {

        runDemo();
    }//end main()

    public static void runDemo() {
        JFrame mainFrame = new JFrame("Name Collector");
        mainFrame.setLayout(new GridLayout(1,2));
        mainFrame.add(new NameGUI());

        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(600, 375));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
    }//end runDemo()
}//end NameGUI3 class

/**
 * Subclasse JPanel to create a panel that holds a
 * JLabel and a JTextField to collect data from user.
 */
class NamePanel extends JPanel {
    private JLabel nameLabel;
    private JTextField nameField;

    /**
     * Default constructor adds JLabel "Name" and JTextField
     * to JPanel using GridBagLayout as layout manager.
     */
    NamePanel() {
        nameLabel = new JLabel();
        nameLabel.setText("Name:");

        nameField = new JTextField();
        nameField.setColumns(15);

        GridBagConstraints layoutConstraints =
            new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        // add label
        this.addLabel(layoutConstraints);

        // add textfield
        this.addNameField(layoutConstraints);
    }//end constructor

    /**
     * Returns reference to instance's nameField 
     * JTextField
     * @return JTextField holding Name data
     */
    public JTextField getNameField() {

        return this.nameField;
    }//end getNameField()

    /**
     * Returns the String value stored
     */
    public String getName() {
        return this.nameField.getText();
    }//end getName()

    /**
     * Uses GridBagConstraints to place the JLabel within the JPanel
     * @param layoutConstraints GridBagLayout constraints for JLabel
     */
    private void addLabel(GridBagConstraints layoutConstraints) {
        // format label constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // add label to custom JPanel
        this.add(nameLabel, layoutConstraints);
    }//end addLabel()

    /**
     * Uses GridBagConstraints to place the JTextField within the Jpanel
     * @param layoutConstraints GridBagLayout constraints for JTextField
     */
    private void addNameField(GridBagConstraints layoutConstraints) {
        // format label constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // add label to custom JPanel
        this.add(nameField, layoutConstraints);
    }//end addNameField()
}//end NamePanel class

/**
 * Subclasses JPanel to create a panel that holds an "age" JLabel
 * and a JFormattedTextField that accepts integers for the user's age.
 */
class AgePanel extends JPanel{
    private JLabel ageLabel;
    private JFormattedTextField ageField;

    /**
     * Default constructor sets JLabel to "Age" and creates a
     * JFormattedTextField that accepts integers for the age value.
     * Adds the components to the JPanel
     */
    AgePanel() {
        ageLabel = new JLabel();
        ageLabel.setText("Age:");

        // Only accepts integers as valid input
        ageField = new JFormattedTextField(NumberFormat.getIntegerInstance());
        ageField.setColumns(14);

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        this.addLabel(layoutConstraints);

        this.addTextField(layoutConstraints);
    }//end constructor

    /**
     * Returns reference to the instance's JFormattedTextField
     * ageField
     * @return JFormattedTextField reference to age field
     */
    public JFormattedTextField getAgeField() {
        return this.ageField;
    }//end getAgeField()

    public int getAge() {
        return Integer.parseInt(this.ageField.getText());
    }//end getAge()

    /**
     * Adds the JLabel component to the custom JPanel replacing the
     * provided layoutconstraint reference with own constraints. 
     * @param layoutConstraints reference to a GridBagConstraints that 
     * will be overwritten in method
     */
    private void addLabel(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // Add Label to Panel
        this.add(ageLabel, layoutConstraints);
    }//end addLabel()

    /**
     * Adds the JFormattedTextField ageField to the custom Jpanel
     * AgePanel instance. Overwrites the provided GridBagConstraint
     * reference with own constraints.
     * @param layoutConstraints GridBagConstraints reference to be
     * overwritten
     */
    private void addTextField(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // Add Field to Panel
        this.add(ageField, layoutConstraints);
    }//end addTextField()
}//end AgePanel class

/**
 * Subclasses JPanel to create a panel that holds an "inches" JLabel
 * and a JFormattedTextField that accepts decimal numbers for the
 * user's height in inches.
 */
class InchesPanel extends JPanel{
    private JLabel inchesLabel;
    private JFormattedTextField inchesField;

    /**
     * Default constructor initializes the JLabel with "Inches"
     * and creates a JFormattedTextField to accept decimal numbers.
     * Components are added to panel using GridBagLayout manager.
     */
    InchesPanel() {
        inchesLabel = new JLabel();
        inchesLabel.setText("Inches:");

        inchesField = new JFormattedTextField(DecimalFormat.getInstance());
        inchesField.setColumns(15);

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        this.addLabel(layoutConstraints);

        this.addTextField(layoutConstraints);
    }//end constructor

    /**
     * Returns reference to JFormattedTextField inches field
     * @return JFormattedTextField reference to inches field
     */
    public JFormattedTextField getInchesField() {
        return this.inchesField;
    }//end getInchesField()

    public double getInches() {
        return Double.parseDouble(this.getInchesField().getText());
    }

    /**
     * Adds the JLabel "inches" to the custom JPanel InchesPanel
     * @param layoutConstraints GridBagConstraints reference
     * that wil be overwritten
     */
    private void addLabel(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // Add Label to JPanel AgePanel
        this.add(inchesLabel, layoutConstraints);
    }//end addLabel()

    /**
     * Adds the JFormattedTextField inchesField to the custom
     * JPanel InchesPanel using GridBagConstraints from method.
     * @param layoutConstraints Refernce to GridBagConstraints object
     * that will be overwritten inside method.
     */
    private void addTextField(GridBagConstraints layoutConstraints) {
        // Format Label Constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // Add JFormmatedTextField to JPanel
        this.add(inchesField, layoutConstraints);
    }//end addTextField()
}//end InchesPanel class

/**
 * Subclass of JPanel that holds a JButton that will
 * act as the "Accept" button for the GUI.
 */
class AcceptPanel extends JPanel{
    private JButton acceptButton;

    /**
     * Default constructor creates a JButton named
     * "Accept" and places the button within the JPanel
     * using GridBagConstraints and GridBagLayout.
     */
    AcceptPanel() {
        acceptButton = new JButton();
        acceptButton.setText("Accept");

        GridBagConstraints layoutConstraints = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        this.addButton(layoutConstraints);
    }//end constructor

    /**
     * Returns reference to the JButton component of the
     * instance.
     * @return JButton reference to "Accept" button
     */
    public JButton getAcceptButton() {
        return this.acceptButton;
    }//end getAcceptButton()

    /**
     * Adds the JButton "Accept" to the custom JPanel using
     * the method's GridBagConstraints values to overwite
     * the provided reference.
     * @param layoutConstraints Reference to GridBagConstraints
     * object that will be overwritten with method values.
     */
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
 
         // Add Button to JPanel
         this.add(acceptButton, layoutConstraints);
    }//end addButton()
}//end AcceptPanel class

class FieldListenerLogic implements FocusListener {
    private JPanel targetPanel;

    /**
     * Default Constructor assigns the passed JPanel reference
     * to the instance var targetPanel.
     * @param targetPanel
     */
    FieldListenerLogic(JPanel targetPanel) {
        this.targetPanel = targetPanel;
    }//end constructor

    @Override
    public void focusGained(FocusEvent e) {
        Component componentReference = e.getComponent();
        if (componentReference instanceof JTextComponent) {
            JTextComponent textFieldReference = (JTextComponent)componentReference;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    textFieldReference.selectAll();
                }
            });
        }//end if component is JTextComponent

        this.targetPanel.setBackground(Color.LIGHT_GRAY);
        
    }//end focusGained()

    @Override
    public void focusLost(FocusEvent e) {
        this.targetPanel.setBackground(Color.WHITE);
    }//end focusLost()
}//end FieldListenerLogic class