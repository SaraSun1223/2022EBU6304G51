package coursework.UI;

import coursework.Controller.PersonalController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is class for The Staff Login.
 * 
 * @author Jinshuo Sun
 * @version 1.0
 * @since 29 Mar 2022
 * 
 * @author Jinshuo Sun
 * @version 1.1
 * @since 30 Mar 2022
 *
 * @author Junyue Li
 * @version 1.2 add button's action listener
 * @since 30 Mar 2022
 */

public class StaffLogin extends JFrame {

    JLabel welcome;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    JButton b2;

    JPanel login;
    JPanel welcomePanel;
    JPanel text1;
    JPanel text2;
    JPanel loginButton;
    JPanel backButton;

    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;

    public StaffLogin() {
        setBak();
        Container c = getContentPane();
        JPanel jp = new JPanel();
        jp.setOpaque(false);
        c.add(jp);
        c.setSize(800, 500);
        c.setVisible(true);

        this.setTitle("Staff Check-in");
        this.setSize(800, 500);
        this.setLocation(320, 120);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setBackground(new Color(60, 100, 210));
        p1.setPreferredSize(new Dimension(760, 90));
        p2.setBackground(new Color(60, 100, 210));
        p2.setPreferredSize(new Dimension(760, 90));
        p3.setBackground(new Color(60, 100, 210));
        p3.setPreferredSize(new Dimension(230, 300));
        p4.setBackground(new Color(60, 100, 210));
        p4.setPreferredSize(new Dimension(230, 300));
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        p4.setOpaque(false);


        login = new JPanel();
        login.setLayout(new GridLayout(5, 1));
        login.setBackground(Color.white);
        login.setBorder(BorderFactory.createEtchedBorder());

        welcomePanel = new JPanel();
        welcomePanel.setBorder(BorderFactory.createEmptyBorder());
        welcomePanel.setBackground(Color.white);
        welcome = new JLabel("Welcome to Heathrow Airport!", JLabel.CENTER);
        welcome.setForeground(Color.white);
        welcome.setOpaque(true);
        welcome.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 210), 5, true));
        welcome.setBackground(new Color(60, 100, 210));
        welcome.setFont(new Font(null, Font.PLAIN, 15));
        welcomePanel.add(welcome);
        login.add(welcomePanel);

        text1 = new JPanel();
        text2 = new JPanel();
        panel1Style();
        text1.setBackground(Color.white);
        text2.setBackground(Color.white);
        login.add(text1);
        login.add(text2);

        loginButton = new JPanel();
        loginButton.setBackground(Color.white);
        b1 = new JButton("Login");
        b1.addActionListener(new StaffButtonListener(this));
        b1.setBackground(new Color(60, 100, 210));
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setPreferredSize(new Dimension(185, 22));
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loginButton.add(b1);
        login.add(loginButton);

        backButton = new JPanel();
        backButton.setBackground(Color.white);
        b2 = new JButton("Back");
        b2.addActionListener(new StaffButtonListener(this));
        b2.setBackground(new Color(60, 100, 210));
        b2.setForeground(Color.white);
        b2.setOpaque(true);
        b2.setPreferredSize(new Dimension(185, 22));
        b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        backButton.add(b2);
        login.add(backButton);

        this.add(login, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);
    }
    public void setBak() {

        ((JPanel) this.getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon(
                "./Imgs/backpic.jpeg");
        JLabel background = new JLabel(img);
        this.getLayeredPane().add(background, Integer.valueOf(Integer.MIN_VALUE));
        background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

    }

    public void panel1Style() {
        t1 = new JTextField(20);
        t1.addFocusListener(new JTextFieldHintListener(t1, "Staff ID"));
        t1.addKeyListener(new NumKeyListener(t1));
        t1.setBorder(BorderFactory.createTitledBorder("Staff ID"));

        t2 = new JPasswordField(20);

        t2.setBorder(BorderFactory.createTitledBorder("Password"));

        text1.add(t1);
        text2.add(t2);

    }

}

class StaffButtonListener implements ActionListener {
    StaffLogin jf;

    public StaffButtonListener(StaffLogin frame) {
        this.jf = frame;

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Login")) {
            if (checkTextField()) {
                Object[] options = { "No", "Yes" };

                int choice = JOptionPane.showOptionDialog(null, "Do you want to login?",
                        "Confirm Login in?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                // create a option dialog to confirm check in and receive the user's choice
                if(choice==JOptionPane.CANCEL_OPTION){//give up, draw back
                    jf.setVisible(true);
                    new StaffLogin().setVisible(true);
                }
                if (choice == 1) {
                    // if the user chose "Yes", confirm to check in
                    // jf.setVisible(false); //exit current frame
                    // new ManagementFrame().jfra.setVisible(true);
                    loginCheck(jf.t1, jf.t2);

                }

            } else { // if there are some incomplete session, the following commands will be
                     // executed.
                JOptionPane.showMessageDialog(jf, "Please fill in the missing information.", "Missing information",
                        JOptionPane.WARNING_MESSAGE);
                // display an error box prompting the user to complete the missing information
            }
        }

        if(e.getActionCommand().equals("Back")){
            jf.setVisible(false);
            new JFrameTest3().setVisible(true);
        }
    }

    public boolean checkTextField() {
        boolean a1 = this.CheckEmpty(jf.t1);
        boolean a2 = this.CheckEmpty(jf.t2);
        return a1 && a2;
    }

    public boolean CheckEmpty(JTextField textField) {
        boolean result = false;

        if (textField.getText().equals("") || textField.getText().equals("Staff ID")
                || textField.getText().equals("Password")) {

        } else {
            result = true;
        }
        return result;
    }

    public static String StaffIDStored;
    public static String PINStored;

    public void loginCheck(JTextField t1, JTextField t2) {
        String staffid = t1.getText();
        String password = t2.getText();
        PersonalController controller = PersonalController.getController();
        int status = controller.checkStaff(staffid, password);
        if (status == 2) {
            JOptionPane.showMessageDialog(jf, "Sorry, the staff ID and password you entered doesn't exist.",
                    "Login failed",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            jf.setVisible(false); // exit current frame
            StaffIDStored = staffid;
            PINStored = password;
            new ManagementFrame().jfra.setVisible(true);
        }
    }
}
