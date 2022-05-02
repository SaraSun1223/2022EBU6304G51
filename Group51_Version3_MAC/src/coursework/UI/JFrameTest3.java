package coursework.UI;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import static javax.swing.BorderFactory.*;

public class JFrameTest3 extends JFrame {
	JButton btn1;
	JButton btn2;

	public JFrameTest3() {

		this.setTitle("Welcome");
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
		
		
		jpcenter.setLayout(new GridLayout(4, 1));

		jpnorth.setBackground(new Color(60, 100, 210));
        jpnorth.setPreferredSize(new Dimension(760, 90));
        jpsouth.setBackground(new Color(60, 100, 210));
        jpsouth.setPreferredSize(new Dimension(760, 90));
        jpwest.setBackground(new Color(60, 100, 210));
        jpwest.setPreferredSize(new Dimension(230, 380));
        jpeast.setBackground(new Color(60, 100, 210));
        jpeast.setPreferredSize(new Dimension(230, 380));
		jpcenter.setBackground(Color.white);
        jpcenter.setBorder(BorderFactory.createEtchedBorder());
		
		
		JPanel jplab1 = new JPanel();
		jplab1.setBackground(Color.white);
		JPanel jplab2 = new JPanel();
		jplab2.setBackground(Color.white);
		JLabel jlabel1 = new JLabel("Welcome to London Heathrow Airport!",JLabel.CENTER);
		jlabel1.setForeground(Color.white);
        jlabel1.setOpaque(true);
        jlabel1.setBorder(BorderFactory.createLineBorder(new Color(60,100,210),5,true));
        jlabel1.setBackground(new Color(60,100,210));
        jlabel1.setFont(new Font(null, Font.PLAIN, 15));
		jplab1.add(jlabel1);

		JLabel jlabel2 = new JLabel("Please select your login identity",JLabel.CENTER);
		jlabel1.setFont(new Font(null, Font.PLAIN, 13));
		jplab2.add(jlabel2);

		JPanel jp1 = new JPanel();
		jp1.setBackground(Color.white);
		JPanel jp2 = new JPanel();
		jp2.setBackground(Color.white);
		
		btn1 = new JButton("I am a passenger");
		btn2 = new JButton("I am an airline staff");
		btn1.addActionListener(new ButtonListener5(this));
		btn2.addActionListener(new ButtonListener5(this));
		btn1.setBackground(new Color(60, 100, 210));
        btn1.setForeground(new Color(60, 100, 210));
        btn1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		btn1.setPreferredSize(new Dimension(185,22));
		btn2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        btn2.setBackground(new Color(60,100,210));
        btn2.setForeground(new Color(60, 100, 210));
		btn2.setPreferredSize(new Dimension(185,22));
		jp1.add(btn1);
		jp2.add(btn2);
		jpcenter.add(jplab1);
		jpcenter.add(jplab2);
		
		jpcenter.add(jp1);
		jpcenter.add(jp2);
	   this.add(jpcenter, BorderLayout.CENTER);
		this.add(jpnorth, BorderLayout.NORTH);
		this.add(jpsouth, BorderLayout.SOUTH);
		this.add(jpwest, BorderLayout.WEST);
		this.add(jpeast, BorderLayout.EAST);

		this.setVisible(true);
	}

}

class ButtonListener5 implements ActionListener{
	JFrameTest3 jf;

	public ButtonListener5(JFrameTest3 frame){
		this.jf=frame;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("I am a passenger")) {
			jf.setVisible(false);
			new JFrameTest().setVisible(true);

		}
		else{
			jf.setVisible(false);
			new StaffLogin().setVisible(true);
		}

	}

}
