package coursework.UI;

import coursework.Controller.*;
import coursework.Entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Color;
import java.awt.BorderLayout;
import static javax.swing.BorderFactory.*;

/**
 * This is class for The Staff Login.
 * 
 * @author JunYue Li
 * @version 1.0
 * @since 29 Mar 2022
 * 
 * @author JunYue Li
 * @version 1.1
 * @since 30 Mar 2022
 * 
 * @author Jinshuo Sun
 * @version 1.2
 * @since 30 Mar 2022
 *
 * @author Junyue Li
 * @version 1.3 continue to beautify GUI design
 * @since 31 Mar 2022
 */

public class Login2test extends JFrame {

    public Login2test() {
        this.setTitle("Check-in");
        this.setSize(760, 480);
        this.setLocation(400, 0);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.loadFrame();
    }

    JPanel p1, p2, p3, p4;

    JPanel content;

    JPanel heading;

    JLabel welcome;

    JPanel text;

    JPanel login;

    JLabel reminder;

    JPanel option1;

    JPanel option2;
    JPanel backButton;

    JTextField t1;

    JButton b1;

    JButton b2;

    JButton b3;
    JButton back;

    public void loadFrame() {
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p1.setBackground(new Color(60, 100, 210));
        p1.setPreferredSize(new Dimension(760, 70));
        p2.setBackground(new Color(60, 100, 210));
        p2.setPreferredSize(new Dimension(760, 70));
        p3.setBackground(new Color(60, 100, 210));
        p3.setPreferredSize(new Dimension(230, 380));
        p4.setBackground(new Color(60, 100, 210));
        p4.setPreferredSize(new Dimension(230, 380));

        content = new JPanel();
        content.setSize(300, 400);
        content.setLayout(new GridLayout(7, 1));
        content.setBackground(Color.white);
        content.setBorder(BorderFactory.createEtchedBorder());

        heading = new JPanel();
        heading.setBorder(BorderFactory.createEmptyBorder());
        heading.setBackground(Color.white);
        welcome = new JLabel("Welcome aboard British Airways!", JLabel.CENTER);
        welcome.setForeground(Color.white);
        welcome.setOpaque(true);
        welcome.setBorder(BorderFactory.createLineBorder(new Color(60,100,210),5,true));
        welcome.setBackground(new Color(60,100,210));
        welcome.setFont(new Font(null, Font.PLAIN, 15));
        heading.add(welcome);
        content.add(heading);

        text = new JPanel();
        text.setBackground(Color.white);
        panel1Style();
        content.add(text);

        login = new JPanel();
        login.setBackground(Color.white);
        b1 = new JButton("Login");
        b1.setBackground(new Color(60, 100, 210));
        b1.setForeground(Color.white);
        b1.setPreferredSize(new Dimension(185,22));
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        login.add(b1);
        content.add(login);

        reminder = new JLabel("   Other Options:", JLabel.LEFT);
        content.add(reminder);

        option1 = new JPanel();
        option1.setBorder(BorderFactory.createEmptyBorder());
        option1.setBackground(Color.white);

        option2 = new JPanel();
        //options.setBackground(Color.white);
        option2.setBorder(BorderFactory.createEmptyBorder());
        option2.setBackground(Color.white);
        optionsStyle();
        content.add(option1);
        content.add(option2);

        backButton = new JPanel();
        backButton.setBackground(Color.white);
        back = new JButton("Back");
        back.addActionListener(new ButtonListener2test(this));
        back.setActionCommand("Back");
        back.setBackground(new Color(60, 100, 210));
        back.setForeground(Color.white);
        back.setPreferredSize(new Dimension(60, 22));
        back.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        backButton.add(back);
        content.add(backButton);

        buttonAction();

        this.add(content, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);

    }

    public void panel1Style() {
        t1 = new JTextField(20);
        t1.addFocusListener(new JTextFieldHintListener(t1, "Booking Number"));
        t1.addKeyListener(new NumKeyListener(t1));
        t1.setBorder(BorderFactory.createEtchedBorder());
        text.add(t1);

    }

    public void optionsStyle() {
        b2 = new JButton("Enter surname and ID number");
        b2.setPreferredSize(new Dimension(185,22));
        b2.setBackground(new Color(60, 100, 210));
        b2.setForeground(Color.white);
        b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        b3 = new JButton("Scan ID document");
        b3.setPreferredSize(new Dimension(185,22));
        b3.setBackground(new Color(60, 100, 210));
        b3.setForeground(Color.white);
        b3.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        option1.add(b2);
        option2.add(b3);
    }

    public void buttonAction() {
        ButtonListener2test buttonListener;
        buttonListener = new ButtonListener2test(this);
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
    }

}

class ButtonListener2test implements ActionListener {
    Login2test jf;

    public ButtonListener2test(Login2test frame) {

        this.jf = frame;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Login")) {

            if (CheckEmpty(jf.t1)) {
                Object[] options = { "No", "Yes" };

                int choice = JOptionPane.showOptionDialog(null, "Do you want to login?",
                        "Confirm Login in?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                // create a option dialog to confirm check in and receive the user's choice

                if (choice == 1) { // if the user chose "Yes", confirm to check in
                    //jf.setVisible(false); // exit current frame
                    //new MyBooking().jfra.setVisible(true);
                    loginCheck(jf.t1);
                }

            }
            else { // if there are some incomplete session, the following commands will be
                     // executed.
                JOptionPane.showMessageDialog(jf, "Please fill in the missing information.", "Missing information",
                        JOptionPane.WARNING_MESSAGE);
                // display an error box prompting the user to complete the missing information
            }
        }
        else if (e.getActionCommand().equals("Enter surname and ID number")) {
            jf.setVisible(false);
            new Login1().setVisible(true);
        }
        else if(e.getActionCommand().equals("Back")){
            jf.setVisible(false);
            new JFrameTest().setVisible(true);
        }
        else {
            jf.setVisible(false);
            // to be added!
            new Login3().setVisible(true);
        }
    }

    public boolean CheckEmpty(JTextField textField) {
        boolean result = false;
        System.out.println(textField.getText());
        if (textField.getText().equals("") || textField.getText().equals("Booking Number")) {
            System.out.println("the textfield is null");
        } else {
            result = true;
            System.out.println(textField.getText());
        }
        return result;
    }

    public static String bookingNumberStored;

    public void loginCheck(JTextField t1) {
        String bookingNo = t1.getText();
        PersonalController controller = PersonalController.getController();
        int status = controller.checkPassenger(bookingNo);
        if (status == 2) {
            JOptionPane.showMessageDialog(jf, "Sorry, the booking number you entered doesn't exist.", "Login failed",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            jf.setVisible(false); // exit current frame
            bookingNumberStored = bookingNo;
            new MyBooking().jfra.setVisible(true);
        }

    }
}
