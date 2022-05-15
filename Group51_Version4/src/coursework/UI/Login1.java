package coursework.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import static javax.swing.BorderFactory.*;

import coursework.Entity.*;
import coursework.Controller.*;

/**
 *
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

 * @author Junyue Li
 * @version 1.3 continue to beautify GUI design
 * @since 31 Mar 2022
 **/

public class Login1 extends JFrame {

    public Login1() {
        this.setTitle("Check-in");
        this.setSize(800, 500);
        this.setLocation(400, 150);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.loadFrame();
    }

    JPanel p1, p2, p3, p4;
    JPanel content;

    JPanel heading;

    JLabel welcome;

    JPanel text1;

    JPanel text2;

    JTextField t1;

    JTextField t2;

    JPanel login;

    JLabel reminder;

    JPanel option1;

    JPanel option2;
    JPanel backButton;

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
        content.setLayout(new GridLayout(8, 1));
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

        text1 = new JPanel();
        text2 = new JPanel();
        text1.setBackground(Color.white);
        text2.setBackground(Color.white);
        panel1Style();
        content.add(text1);
        content.add(text2);

        login = new JPanel();
        loginStyle();
        login.setBackground(Color.white);
        content.add(login);

        reminder = new JLabel("   Other Options:", JLabel.LEFT);
        content.add(reminder);

        option1 = new JPanel();
        //options.setBackground(Color.white);
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
        back.addActionListener(new MyButtonListener(this));
        back.setActionCommand("Back");
        back.setBackground(new Color(60, 100, 210));
        back.setForeground(Color.white);
        back.setOpaque(true);
        back.setPreferredSize(new Dimension(60, 22));
        back.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        backButton.add(back);
        content.add(backButton);

        this.add(content, BorderLayout.CENTER);
        this.add(p1, BorderLayout.NORTH);
        this.add(p2, BorderLayout.SOUTH);
        this.add(p3, BorderLayout.WEST);
        this.add(p4, BorderLayout.EAST);

    }

    public void panel1Style() {
        t1 = new JTextField(20);
        t1.addKeyListener(new LetterKeyListener(t1));
        t1.addFocusListener(new JTextFieldHintListener(t1, "Surname"));
        t1.setBorder(BorderFactory.createEtchedBorder());

        t2 = new JTextField(20);
        t2.addKeyListener(new NumKeyListener(t1));
        t2.addFocusListener(new JTextFieldHintListener(t2, "ID number"));
        t2.setBorder(BorderFactory.createEtchedBorder());

        text1.add(t1);
        text2.add(t2);
    }

    public void loginStyle() {
        b1 = new JButton("Login");
        b1.addActionListener(new MyButtonListener(this));
        b1.setBackground(new Color(60, 100, 210));
        b1.setForeground(Color.white);
        b1.setOpaque(true);
        b1.setPreferredSize(new Dimension(185,22));
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        login.add(b1);
    }

    public void optionsStyle() {
        //panel.setLayout(new GridLayout(2, 1,5,5));
        b2 = new JButton("Enter booking number");
        b2.addActionListener(new MyButtonListener(this));
        b2.setPreferredSize(new Dimension(185,22));
        b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b2.setBackground(new Color(60,100,210));
        b2.setForeground(Color.white);
        b2.setOpaque(true);

        b3 = new JButton("Scan ID document");
        b3.addActionListener(new MyButtonListener(this));
        b3.setPreferredSize(new Dimension(185,22));
        b3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        b3.setBackground(new Color(60, 100, 210));
        b3.setForeground(Color.white);
        b3.setOpaque(true);

        option1.add(b2);
        option2.add(b3);
    }

}

class JTextFieldHintListener implements FocusListener {
    private String hintText;
    private JTextField textField;

    public JTextFieldHintListener(JTextField jTextField, String hintText) {
        this.textField = jTextField;
        this.hintText = hintText;
        jTextField.setText(hintText);
        jTextField.setForeground(Color.GRAY);
    }

    @Override
    public void focusGained(FocusEvent e) {
        // 获取焦点时，清空提示内容
        String temp = textField.getText();
        if (temp.equals(hintText)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }

    }

    @Override
    public void focusLost(FocusEvent e) {

        String temp = textField.getText();
        if (temp.equals("")) {
            textField.setForeground(Color.GRAY);
            textField.setText(hintText);
        }

    }

}
class NumKeyListener implements KeyListener{
    JTextField text;
    boolean b1;
    boolean b2;

    public NumKeyListener(JTextField text){
        this.text = text;
    }

    public void check(){
        if(b1&&b2){
        JOptionPane.showMessageDialog(null, "Please enter Arabic numerals.", "Input Format Reminder",
                JOptionPane.WARNING_MESSAGE);}
    }


    @Override
    public void keyTyped(KeyEvent e){
        if(text.getText().length()<20) {
            char c = e.getKeyChar();
            if (!(c >= '0' && c <= '9')) {
                System.out.println("char:"+e.getKeyChar());
                System.out.println("code:"+e.getKeyCode());
                b1=true;
                this.check();
                e.consume();
                System.out.println("b1"+b1);
                System.out.println("b2"+b2);
                System.out.println("result:"+(b1&&b2));
            }
            else{
                b1=false;
            }
        }
        else{
            e.consume();
            JOptionPane.showMessageDialog(null,"Sorry, the maximum input length has been reached.", "Input Format Reminder",
                    JOptionPane.WARNING_MESSAGE);
        }

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            System.out.println("keypressed");
            b2=false;
        }
        else{
            b2=true;
            e.consume();}
    }
    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            System.out.println("keypressed");
            b2=false;
        }
        else {
            b2 = true;
            e.consume();}


    }



}

class LetterKeyListener implements KeyListener{
    JTextField text;
    boolean b1;
    boolean b2;

    public void check(){
        if(b1&&b2){
            JOptionPane.showMessageDialog(null, "Please enter Capital Letters.", "Input Format Reminder",
                    JOptionPane.WARNING_MESSAGE);}
    }

    public LetterKeyListener(JTextField text){
        this.text = text;
    }
    @Override
    public void keyTyped(KeyEvent e){
        if(text.getText().length()<20) {
            if (e.getKeyChar() < 'A' || e.getKeyChar() > 'Z') {
                    System.out.println("char:"+e.getKeyChar());
                    System.out.println("code:"+e.getKeyCode());
                    b1=true;
                    this.check();
                    e.consume();
            }
            else{
                b1=false;
            }
        }
        else{
            e.consume();
            JOptionPane.showMessageDialog(null,"Sorry, the maximum input length has been reached.", "Input Format Reminder",
                        JOptionPane.WARNING_MESSAGE);
        }

    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            System.out.println("keypressed");
            b2=false;
        }
        else{
            b2=true;
            e.consume();}
    }
    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE){
            System.out.println("keypressed");
            b2=false;
        }
        else{
            b2=true;
            e.consume();}
    }



}

class MyButtonListener implements ActionListener {
    Login1 jf;

    public MyButtonListener(Login1 frame) {
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

                if (choice == 1) { // if the user chose "Yes", confirm to check in
                    //jf.setVisible(false); // exit current frame
                    //new MyBooking().jfra.setVisible(true);
                    loginCheck(jf.t1, jf.t2);
                }

            } else { // if there are some incomplete session, the following commands will be
                     // executed.
                JOptionPane.showMessageDialog(jf, "Please fill in the missing information.", "Missing information",
                        JOptionPane.WARNING_MESSAGE);
                // display an error box prompting the user to complete the missing information
            }
        }
        else if (e.getActionCommand().equals("Enter booking number")) {
            jf.setVisible(false);
            new Login2test().setVisible(true);
        }
        else if(e.getActionCommand().equals("Back")){
            jf.setVisible(false);
            new JFrameTest().setVisible(true);
        }
        else {
            jf.setVisible(false);
            new Login3().setVisible(true);
        }
    }

    public boolean checkTextField() {
        boolean a1 = this.CheckEmpty(jf.t1);
        System.out.println(a1);
        boolean a2 = this.CheckEmpty(jf.t2);
        System.out.println(a2);
        return a1 && a2;
    }

    public boolean CheckEmpty(JTextField textField) {
        boolean result = false;
        System.out.println(textField.getText());
        if (textField.getText().equals("") || textField.getText().equals("Surname")
                || textField.getText().equals("ID number")) {
            System.out.println("the textfield is null");
        } else {
            result = true;
            System.out.println(textField.getText());
        }
        return result;
    }

    public static String IDnumStored;
    public static String surnameStored;
    public void loginCheck(JTextField t1, JTextField t2){
        String surname= t1.getText();
        String idNo=t2.getText();
        PersonalController controller = PersonalController.getController();
        int status = controller.checkPassenger(surname,idNo);
        if(status==2){
            JOptionPane.showMessageDialog(jf, "Sorry, the surname and ID number you entered doesn't exist.", "Login failed",
                    JOptionPane.WARNING_MESSAGE);
        }
        else{
            jf.setVisible(false); // exit current frame
            IDnumStored = idNo;
            surnameStored = surname;
            new MyBooking().jfra.setVisible(true);
        }
    }
}
