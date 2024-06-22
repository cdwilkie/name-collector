import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import javax.swing.border.*;


/**
 * Serves as the GUI for the Name Collector Program
 */
public class NameGUI {

    public static void main(String[] args) {
        buildFrameUI();
    }

    private static void addNameComponents(JPanel targetPanel) {
        //create label
        //create field
        //create constraints
        //format label constraints
        //add label to target jpanel with constrints
        //format field constraints
        //add field to target jpanel with constraints

    }

    private static void addNamePanel(JPanel targetPanel, JFrame targetFrame) {
        // Create constraints
        // format panel constraints
        // add panel to frame with constraints
    }

    private static void addAgeComponents(JPanel targetPanel) {

    }

    private static void addAgePanel(JPanel targetPanel, JFrame targetFrame) {

    }

    private static void addInchesComponents(JPanel targetPanel) {

    }

    private static void addInchesPanel(JPanel targetPanel, JFrame targetFrame) {

    }

    private static void addAcceptComponents(JPanel targetPanel) {

    }

    private static void addAcceptPanel(JPanel targetPanel, JFrame targetFrame) {

    }
    
    private static void buildFrameUI() {
        // Make Frame
        JFrame mainFrame = new JFrame("The Frame");
        // Make jpanel
        JPanel namePanel = new JPanel();
        // addNameComponents(JPanel)
        addNameComponents(namePanel);
        // Customize Panel
        customizePanel(namePanel);
        // addNamePanel(JPanel, JFrame)
        addNamePanel(namePanel, mainFrame);
        // Make jpanel
        JPanel agePanel = new JPanel();
        // addAgeComponents(jPanel)
        addAgeComponents(agePanel);
        // Customize Panel
        customizePanel(agePanel);
        // addAgePanel(JPanel, JFrame)
        addAgePanel(agePanel, mainFrame);
        // Make Jpanel
        JPanel inchesPanel = new JPanel();
        // addInchesComponents(JPanel)
        addInchesComponents(inchesPanel);
        // Customize Panel
        customizePanel(inchesPanel);
        // addInchesPanel(JPanel, JFrame)
        addInchesPanel(inchesPanel, mainFrame);
        // Make JPanel
        JPanel acceptPanel = new JPanel();
        // addAcceptComponents(JPanel)
        addAcceptComponents(acceptPanel);
        // Customize Panel
        customizePanel(acceptPanel);
        // addAcceptPanel(JPanel, JFrame)
        addAcceptPanel(acceptPanel, mainFrame);
        // Customize JFrame
        customizeFrame(mainFrame);
       
    }//end buildFrameUI()

    private static void customizeFrame(JFrame targetFrame) {
        // Set Layout Manager
        targetFrame.setLayout(new GridBagLayout());
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
    }

    private static void customizePanel(JPanel targetPanel) {
        // set layout manager
        targetPanel.setLayout(new GridBagLayout());
        // Set panel background color to white
        targetPanel.setBackground(Color.WHITE);
        // apply border (compound black soft bevel)
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        Border softBevelBorder = BorderFactory.createRaisedSoftBevelBorder();
        targetPanel.setBorder(BorderFactory.createCompoundBorder(softBevelBorder, blackBorder));
    }

    

}