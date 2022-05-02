package coursework.UI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.BorderFactory.*;


public class JFrameTest extends JFrame{

	public  JFrameTest() {
		this.setTitle("Check-in");
		this.setSize(760, 500);
		this.setLocation(400, 0);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		JPanel jpnorth = new JPanel();
		JPanel jpsouth = new JPanel();
		JPanel jpeast = new JPanel();
		JPanel jpwest = new JPanel();
		JPanel jpcenter = new JPanel();

		jpcenter.setLayout(new GridLayout(6,1));
		jpcenter.setBackground(Color.white);
		jpcenter.setBorder(BorderFactory.createEtchedBorder());
		
		jpnorth.setBackground(new Color(60, 100, 210));
        jpnorth.setPreferredSize(new Dimension(760, 90));
        jpsouth.setBackground(new Color(60, 100, 210));
        jpsouth.setPreferredSize(new Dimension(760, 90));
        jpwest.setBackground(new Color(60, 100, 210));
        jpwest.setPreferredSize(new Dimension(230, 380));
        jpeast.setBackground(new Color(60, 100, 210));
        jpeast.setPreferredSize(new Dimension(230, 380));

		
		JPanel jplab1 = new JPanel();
		jplab1.setBackground(Color.white);
	    JPanel jplab2 = new JPanel();
	    jplab2.setBackground(Color.white);
		JLabel jlabel1 = new JLabel("Welcome aboard British Airways",JLabel.CENTER);
		jlabel1.setForeground(Color.white);
        jlabel1.setOpaque(true);
        jlabel1.setBorder(BorderFactory.createLineBorder(new Color(60,100,210),5,true));
        jlabel1.setBackground(new Color(60,100,210));
        jlabel1.setFont(new Font(null, Font.PLAIN, 15));
		jplab1.add(jlabel1);
		jplab2.add(new JLabel("Please choose your preferred way for check-in",JLabel.CENTER));

		 JPanel jp1 = new JPanel();
		 jp1.setBackground(Color.white);
	     JPanel jp2 = new JPanel();
	     jp2.setBackground(Color.white);
	     JPanel jp3 = new JPanel();
	     jp3.setBackground(Color.white);
	     JPanel jp4 = new JPanel();
	     jp4.setBackground(Color.white);

		JButton btn1 = new JButton("Use Booking Number");
		JButton btn2 = new JButton("Use Surname and ID number");
		JButton btn3 = new JButton("Scan ID Document");
		JButton btn4 = new JButton("Back");





		btn1.addActionListener(new ButtonListener4(this));
		  btn2.addActionListener(new ButtonListener4(this));
		   btn3.addActionListener(new ButtonListener4(this));
		    btn4.addActionListener(new ButtonListener4(this));
	   //btn1
		btn1.setBackground(new Color(60, 100, 210));
        btn1.setForeground(new Color(60, 100, 210));
        btn1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		btn1.setPreferredSize(new Dimension(185,22));
		//btn2
		btn2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btn2.setBackground(new Color(60,100,210));
        btn2.setForeground(new Color(60, 100, 210));
		btn2.setPreferredSize(new Dimension(185,22));
		//btn3
		btn3.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btn3.setBackground(new Color(60, 100, 210));
        btn3.setForeground(new Color(60, 100, 210));
		btn3.setPreferredSize(new Dimension(185,22));
		//btn4
		btn4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btn4.setBackground(new Color(60, 100, 210));
        btn4.setForeground(new Color(60, 100, 210));
		btn4.setPreferredSize(new Dimension(185,22));
		

		 jp1.add(btn1);
		 jp2.add(btn2);
		 jp3.add(btn3);
		 jp4.add(btn4);
		jpcenter.add(jplab1);
		jpcenter.add(jplab2);
		jpcenter.add(jp1);
		jpcenter.add(jp2);
		jpcenter.add(jp3);
		jpcenter.add(jp4);
      this.add(jpcenter, BorderLayout.CENTER);
        this.add(jpnorth, BorderLayout.NORTH);
       this.add(jpsouth, BorderLayout.SOUTH);
       this.add(jpwest, BorderLayout.WEST);
       this.add(jpeast, BorderLayout.EAST);
	}
	
	
}
class ButtonListener4 implements ActionListener{
    JFrameTest tf;

    public ButtonListener4(JFrameTest frame){
        this.tf = frame;

    }
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Use Booking Number")) {
			tf.setVisible(false);
          new Login2test().setVisible(true);
		}
		else if(e.getActionCommand().equals("Use Surname and ID number")){
           tf.setVisible(false);
            new Login1().setVisible(true);
        }
      else if(e.getActionCommand().equals("Scan ID Document")){
          tf.setVisible(false);
            new Login3().setVisible(true);
        }
		else{
		tf.setVisible(false);
		new JFrameTest3().setVisible(true);
		}
}
}