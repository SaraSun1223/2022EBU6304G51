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
 * @version 1.2  add button's action listener
 * @since 30 Mar 2022
 */

public class StaffLogin extends JFrame{

    JLabel welcome;
    JTextField t1;
    JTextField t2;
    JButton b1;

    JPanel login;
    JPanel welcomePanel;
    JPanel text1;
    JPanel text2;
    JPanel loginButton;

    JPanel p1;
    JPanel p2;
    JPanel p3;
    JPanel p4;

    public StaffLogin() {
        this.setTitle("Staff Check-in");
        this.setSize(760, 480);
        this.setLocation(400, 0);
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

        login = new JPanel();
        login.setLayout(new GridLayout(4, 1));
        login.setBackground(Color.white);
        login.setBorder(BorderFactory.createEtchedBorder());

        welcomePanel = new JPanel();
        welcomePanel.setBorder(BorderFactory.createEmptyBorder());
        welcomePanel.setBackground(Color.white);
        welcome = new JLabel("Welcome to Heathrow Airport!", JLabel.CENTER);
        welcome.setForeground(Color.white);
        welcome.setOpaque(true);
        welcome.setBorder(BorderFactory.createLineBorder(new Color(60,100,210),5,true));
        welcome.setBackground(new Color(60,100,210));
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
        b1.setPreferredSize(new Dimension(185,22));
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        loginButton.add(b1);
        login.add(loginButton);

        this.add(login, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);
    }

    public void panel1Style() {
        t1 = new JTextField(20);
        t1.addFocusListener(new JTextFieldHintListener(t1, "Staff ID"));
        t1.addKeyListener(new NumKeyListener(t1));
        t1.setBorder(BorderFactory.createEtchedBorder());

        t2 = new JTextField(20);
        t2.addFocusListener(new JTextFieldHintListener(t2, "Password"));
        t2.setBorder(BorderFactory.createEtchedBorder());

        text1.add(t1);
        text2.add(t2);

    }

}

class StaffButtonListener implements ActionListener {
    StaffLogin jf;

    public StaffButtonListener(StaffLogin frame){
        this.jf = frame;

    }

    public void actionPerformed(ActionEvent e){

        if(e.getActionCommand().equals("Login")){
            if(checkTextField()){
                Object[] options = {"No","Yes"};

                int choice = JOptionPane.showOptionDialog(null,"Do you want to login?",
                        "Confirm Login in?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                //create a option dialog to confirm check in and receive the user's choice

                if(choice != 0){   //if the user chose "Yes", confirm to check in
                    //jf.setVisible(false); //exit current frame
                    //new ManagementFrame().jfra.setVisible(true);
                    loginCheck(jf.t1, jf.t2);
                }

            }
            else {  //if there are some incomplete session, the following commands will be executed.
                JOptionPane.showMessageDialog(jf, "Please fill in the missing information.","Missing information",JOptionPane.WARNING_MESSAGE);
                //display an error box prompting the user to complete the missing information
            }
        }

    }

    public boolean checkTextField(){
        boolean a1=this.CheckEmpty(jf.t1);
        System.out.println(a1);
        boolean a2=this.CheckEmpty(jf.t2);
        System.out.println(a2);
        return a1&&a2;
    }

    public boolean CheckEmpty(JTextField textField){
        boolean result = false;
        System.out.println(textField.getText());
        if(textField.getText().equals("")||textField.getText().equals("Staff ID")||textField.getText().equals("Password")){
            System.out.println("the textfield is null");
        }
        else{
            result = true;
            System.out.println(textField.getText());
        }
        return result;
    }
    public static String StaffIDStored;
    public static String PINStored;

    public void loginCheck(JTextField t1, JTextField t2){
        String staffid = t1.getText();
        String password = t2.getText();
        PersonalController controller = PersonalController.getController();
        int status = controller.checkStaff(staffid,password);
        if(status==2){
            JOptionPane.showMessageDialog(jf, "Sorry, the staff ID and password you entered doesn't exist.", "Login failed",
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            jf.setVisible(false); // exit current frame
            StaffIDStored=staffid;
            PINStored=password;
            new ManagementFrame().jfra.setVisible(true);
        }
    }
}
