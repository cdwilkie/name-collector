import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import java.text.*;
import javax.swing.border.*;


/**
 * Serves as the GUI for the Name Collector Program. Utilizes
 * a main() method to drive the GUI interface.
 */
public class NameGUI {

    /**
     * Driver for GUI window. Makes a call to the Swing EDT
     * and calls the buildFrameUI() method
     * to build and show the GUI for NameCollector.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                buildFrameUI();
            }//end run()
        });//end invokeLater()
    }//end main()

    /**
     * Creates the necessary <code>JComponents</code> to
     * collect text input for a "name" prompt. Utilizes a
     * <code>GridBagLayout</code> to organize the elements.
     * @param targetPanel <code>JPanel</code> to hold the
     * arranged <code>JComponents</code>
     */
    private static void addNameComponents(JPanel targetPanel) {
        //create label
        JLabel nameLabel = new JLabel("Name: ");
        //create field
        JTextField nameField = new JTextField("Enter Name");
        nameField.setColumns(15);
        nameField.setEditable(true);

        //create constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        //format label constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        //add label to target jpanel with constrints
        targetPanel.add(nameLabel, layoutConstraints);

        //format field constraints
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        //add field to target jpanel with constraints
        targetPanel.add(nameField, layoutConstraints);
    }//end addNameComponents()

    /**
     * Adds the target <code>JPanel</code> to the target <code>
     * JFrame</code>. Utilizes <code>GridBagLayout</code> as layout
     * manager to place the Name Panel within the main UI frame.
     * @param targetPanel <code>JPanel</code> to be added 
     * to <code>JFrame</code>
     * @param targetFrame <code>JFrame</code> that will hold panel
     */
    private static void addNamePanel(JPanel targetPanel, JFrame targetFrame) {
        // Create constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        // format panel constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // add panel to frame with constraints
        targetFrame.add(targetPanel, layoutConstraints);
    }//end addNamePanel()

    private static void addAgeComponents(JPanel targetPanel) {
        //TODO
    }

    /**
     * Adds the target <code>JPanel</code> to the target <code>
     * JFrame</code>. Utilizes <code>GridBagLayout</code> as layout
     * manager to place the age panel within the main UI frame.
     * @param targetPanel <code>JPanel</code> to be added
     * to <code>JFrame</code>
     * @param targetFrame <code>JFrame</code> that will hold panel
     */
    private static void addAgePanel(JPanel targetPanel, JFrame targetFrame) {
        // Create constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        // format panel constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // add panel to frame with constraints
        targetFrame.add(targetPanel, layoutConstraints);
    }//end addAgePanel()

    private static void addInchesComponents(JPanel targetPanel) {
        //TODO
    }

    /**
     * Adds the target <code>JPanel</code> to the target <code>
     * JFrame</code>. Utilizes <code>GridBagLayout</code> as layout
     * manager to place the inches panel within the main UI frame.
     * @param targetPanel <code>JPanel</code> to be added
     * to <code>JFrame</code>
     * @param targetFrame <code>JFrame</code> that will hold panel
     */
    private static void addInchesPanel(
            JPanel targetPanel, JFrame targetFrame) {
        // Create constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        // format panel constraints
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 2;
        layoutConstraints.fill = GridBagConstraints.BOTH;
        layoutConstraints.anchor = GridBagConstraints.BASELINE;
        layoutConstraints.weightx = 1.0;
        layoutConstraints.weighty = 1.0;
        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // add panel to frame with constraints
        targetFrame.add(targetPanel, layoutConstraints);
    }//end addInchesPanel()

    private static void addAcceptComponents(JPanel targetPanel) {
        //TODO
    }

    /**
     * Adds the target <code>JPanel</code> to the target <code>
     * JFrame</code>. Utilizes <code>GridBagLayout</code> as layout
     * manager to place the accept panel within the main UI frame.
     * @param targetPanel <code>JPanel</code> to be added
     * to <code>JFrame</code>
     * @param targetFrame <code>JFrame</code> that will hold panel
     */
    private static void addAcceptPanel(
        JPanel targetPanel, JFrame targetFrame) {
        // Create constraints
        GridBagConstraints layoutConstraints = new GridBagConstraints();

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

        // add panel to frame with constraints
        targetFrame.add(targetPanel, layoutConstraints);
    }//end addAcceptPanel()

    /**
     * Initializes the necessary components to build the GUI
     * for the NameCollector program. Utilizes a <code>JFrame
     * </code> to hold the <code>JPanels</code> containing the
     * various <code>JComponents</code> that will allow the
     * collection of data from the user, and then output results.
     */
    private static void buildFrameUI() {
        // Make Frame
        JFrame mainFrame = new JFrame("The Frame");
        // Set Layout Manager
        mainFrame.setLayout(new GridBagLayout());
        // Make jpanel
        JPanel namePanel = new JPanel();
        // Customize Panel
        customizePanel(namePanel);
        // addNameComponents(JPanel)
        addNameComponents(namePanel);
        // addNamePanel(JPanel, JFrame)
        addNamePanel(namePanel, mainFrame);
        // Make jpanel
        JPanel agePanel = new JPanel();
        // Customize Panel
        customizePanel(agePanel);
        // addAgeComponents(jPanel)
        addAgeComponents(agePanel);
        // addAgePanel(JPanel, JFrame)
        addAgePanel(agePanel, mainFrame);
        // Make Jpanel
        JPanel inchesPanel = new JPanel();
        // Customize Panel
        customizePanel(inchesPanel);
        // addInchesComponents(JPanel)
        addInchesComponents(inchesPanel);
        // addInchesPanel(JPanel, JFrame)
        addInchesPanel(inchesPanel, mainFrame);
        // Make JPanel
        JPanel acceptPanel = new JPanel();
        // Customize Panel
        customizePanel(acceptPanel);
        // addAcceptComponents(JPanel)
        addAcceptComponents(acceptPanel);
        // addAcceptPanel(JPanel, JFrame)
        addAcceptPanel(acceptPanel, mainFrame);
        // Customize JFrame
        customizeFrame(mainFrame);
    }//end buildFrameUI()

    /**
     * Modifies the attributes of the target <code>JFame</code>
     * to change:<ul><li> the layout manager</li><li> the background color
     * </li><li>border utilized</li></ul>
     * @param targetFrame <code>JFrame</code> that is to be customized
     */
    private static void customizeFrame(JFrame targetFrame) {
        
        // Set Background Color
        targetFrame.getContentPane().setBackground(Color.DARK_GRAY);
        // Display Frame
        targetFrame.setVisible(true);
        // Close Operation
        targetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // pack()
        targetFrame.pack();
        // minimum size
        targetFrame.setMinimumSize(new Dimension(450, 300));
    }//end customizeFrame()

    /**
     * Modifies the attributes of the target <code>JPanel</code>
     * to change the layout manager, the background color,
     * and the border utilized.
     * @param targetPanel <code>JPanel</code> that is to be customized
     */
    private static void customizePanel(JPanel targetPanel) {
        // set layout manager
        targetPanel.setLayout(new GridBagLayout());
        // Set panel background color to white
        targetPanel.setBackground(Color.WHITE);
        // apply border (compound black soft bevel)
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border softBevelBorder = BorderFactory.createRaisedSoftBevelBorder();
        targetPanel.setBorder(
            BorderFactory.createCompoundBorder(softBevelBorder, blackBorder));
    }//end customizePanel()
}//end NameGUI