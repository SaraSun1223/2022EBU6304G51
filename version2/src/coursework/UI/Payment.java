package coursework.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

public class Payment extends JPanel{
    JPanel p1;
    JLabel heading;
    JPanel p2;
    JLabel heading2;
    JPanel p3;
    JTextField fn;
    JTextField ln;
    JPanel p4;
    JTextField cardnum;
    JPasswordField passwd;
    ButtonGroup cards;
    JRadioButton visa;
    JRadioButton master;
    JRadioButton expre;
    JButton confirm;
    public  Payment(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        //heading
        p1 = new JPanel();
        heading = new JLabel("Enter your bank card information to complete the payment:");
        heading.setToolTipText("To pay for your extra option");
        heading.setForeground(Color.white);
        heading.setFont(new Font("", Font.BOLD, 15));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(heading);
        p1.setBackground(new Color(60, 100, 210));
        this.add(p1,BorderLayout.NORTH);

        //card information
        p2=new JPanel();
        p2.setLayout(new FlowLayout());

        JLabel fnlabel = new JLabel("First name:");
        JLabel lnlabel = new JLabel("Last name:");
        fn = new JTextField(10);
        ln = new JTextField(10);
        JPanel p2_1 = new JPanel();
        p2_1.setBackground(Color.white);
        p2_1.add(fnlabel);
        p2_1.add(fn);
        p2_1.add(lnlabel);
        p2_1.add(ln);
        p2.add(p2_1);

        cardnum = new JTextField(20);
        passwd = new JPasswordField(20);
        JLabel cardnumlabel = new JLabel("Credit Card Numbers:");
        JLabel passwdlabel = new JLabel("                  Password:");

        JPanel p2_2 = new JPanel();
        p2_2.setBackground(Color.white);

        JPanel p2_3 = new JPanel();
        p2_3.setBackground(Color.white);

        p2_2.add(cardnumlabel);
        p2_2.add(cardnum);
        p2_3.add(passwdlabel);
        p2_3.add(passwd);
        p2.add(p2_2);
        p2.add(p2_3);




        //
        cards = new ButtonGroup();
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.white);
        heading2 = new JLabel("Please select your bank card type:");
        heading2.setFont(new Font("", Font.BOLD, 15));
        JPanel p3_1 = new JPanel();

        p3_1.add(heading2);

        Icon visaicon = new ImageIcon("Imgs/Visa5.png");
        visa = new JRadioButton("Visa Card",visaicon);
        Icon mastericon = new ImageIcon("Imgs/Mastercard7.png");
        master = new JRadioButton("Master Card",mastericon);
        Icon expreico = new ImageIcon("Imgs/usexpress4.png");
        expre = new JRadioButton("American Express Card",expreico);
        visa.setBackground(Color.white);
        master.setBackground(Color.white);
        expre.setBackground(Color.white);

        cards.add(visa);
        cards.add(master);
        cards.add(expre);
        JPanel p3_2 = new JPanel();

        p3_2.add(visa);
        p3_2.add(master);
        p3_2.add(expre);
        p3_1.setBackground(Color.white);
        p3_2.setBackground(Color.white);
        p3.add(p3_1,BorderLayout.NORTH);
        p3.add(p3_2,BorderLayout.CENTER);
        visa.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(visa.isSelected()){
                    visa.setBackground(Color.pink);
                }else{
                    visa.setBackground(Color.white);
                }
            }
        });
        master.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(master.isSelected()){
                    master.setBackground(Color.pink);
                }else{
                    master.setBackground(Color.white);
                }
            }
        });
        expre.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(expre.isSelected()){
                    expre.setBackground(Color.pink);
                }else{
                    expre.setBackground(Color.white);
                }
            }
        });
        p2.add(p3);

        confirm = new JButton("Confirm to Pay for the extra Option.");
        p2.add(confirm);

        p2.setBackground(Color.white);
        this.add(p2,BorderLayout.CENTER);



    }
}
