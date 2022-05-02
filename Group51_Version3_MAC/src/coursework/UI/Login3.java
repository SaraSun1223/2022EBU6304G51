package coursework.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 *
 */

public class Login3 extends JFrame {

    public Login3() {
        this.setTitle("Check-in");
        this.setLocation(400, 0);
        this.setSize(760, 500);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.loadFrame();
        this.buttonAction();
    }

    JPanel p1, p2, p3, p4;

    JPanel content;

    JPanel heading;

    JLabel welcome;

    JTextArea text;

    JPanel scan;

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

        text = new JTextArea(5, 50);
        text.setText("       Please click the 'start scanning' button and\n" +
                "       place your ID document on the machine\n       for automatic scanning");
        text.setFont(new Font(null, Font.BOLD, 11));
        text.setEditable(false);
        content.add(text);

        scan = new JPanel();
        content.add(scan);
        scan.setBackground(Color.white);
        b1 = new JButton("Start Scanning");
        b1.setBackground(new Color(60, 100, 210));
        b1.setForeground(new Color(60, 100, 210));
        b1.setPreferredSize(new Dimension(185,22));
        b1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        scan.add(b1);

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
        back.addActionListener(new ButtonListener3(this));
        back.setActionCommand("Back");
        back.setBackground(new Color(60, 100, 210));
        back.setForeground(new Color(60, 100, 210));
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

    public void optionsStyle() {
        b2 = new JButton("Enter surname and ID number");
        b2.setPreferredSize(new Dimension(185,22));
        b2.setBackground(new Color(60, 100, 210));
        b2.setForeground(new Color(60, 100, 210));
        b2.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        b3 = new JButton("Enter booking number");
        b3.setPreferredSize(new Dimension(185,22));
        b3.setBackground(new Color(60, 100, 210));
        b3.setForeground(new Color(60, 100, 210));
        b3.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        option1.add(b2);
        option2.add(b3);
    }

    public void buttonAction() {
        ButtonListener3 buttonListener;
        buttonListener = new ButtonListener3(this);
        b1.addActionListener(buttonListener);
        b2.addActionListener(buttonListener);
        b3.addActionListener(buttonListener);
    }

}

class ButtonListener3 implements ActionListener {
    Login3 jf;

    public ButtonListener3(Login3 frame) {
        this.jf = frame;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Start Scanning")) {
            jf.setVisible(false);
            new MyBooking().jfra.setVisible(true);
            // to de added
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
            new Login1().setVisible(true);
        }
    }

}
