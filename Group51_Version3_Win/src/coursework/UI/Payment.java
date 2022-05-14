package coursework.UI;
import coursework.Controller.MenuController;
import coursework.Controller.PersonalController;
import coursework.Controller.SeatController;
import coursework.Entity.Reservations;
import coursework.backend.dblayer.DataManager;
import coursework.backend.dblayer.MenuManager;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.MaskFormatter;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;

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
    JPanel phead;
    JPanel pmeal;
    JPanel pseat;
    JTable mealTable;
    String[] Names = {"Food Type","Food Select","Price"};
    String[][] Info;

    public  Payment(MyBooking myBooking){
        this.setLayout(new GridLayout(2,1));
        this.setBackground(Color.white);


        PersonalController control = PersonalController.getController();
        Reservations reservations = null;
        SeatController seatcontrol = SeatController.getController();
        MenuController menuController = MenuController.getMenuController();


        if(bookingNumberStored!=null){
            reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
            control.updateReservations(reservations);

        }else if (IDnumStored!=null) {
            reservations = control.getReservationsInformByID(IDnumStored);
            control.updateReservations(reservations);

        }


        pmeal = new JPanel();
        pmeal.setBorder(new TitledBorder("Airline Food Bill"));
        pmeal.setBackground(Color.white);
        pmeal.setSize(150,150);

        assert reservations != null;

        int length = reservations.getExtraMealName().size();
        Info = new String[2+length][3];
        Info[0][0] = "Basic Food";
        Info[0][1] = reservations.getStandardMeal().get(0);
        Info[0][2] = "0";
        Info[1][0] = "Basic Food";
        Info[1][1] = reservations.getStandardMeal().get(1);
        Info[1][2] = "0";
        for(int i = 0;i<length;i++){
            Info[i+2][0] = "Extra Food";
            Info[i+2][1] = reservations.getExtraMealName().get(i);
            if (menuController.getPriceByMenuName(reservations.getExtraMealName().get(i))!=null){
                Double price = menuController.getPriceByMenuName(reservations.getExtraMealName().get(i)).getMenuPrice();
                Info[i+2][2] = price.toString();
            }
        }

        mealTable = new JTable(new MyTable1(Names,Info));
        mealTable.setPreferredScrollableViewportSize(new Dimension(700,34));

        pmeal.add(mealTable.getTableHeader(),BorderLayout.NORTH);
        pmeal.add(mealTable,BorderLayout.CENTER);
        double TotalBill = 0;
        for(int i=0; i<reservations.getExtraMealName().size();i++){
            if (menuController.getPriceByMenuName(reservations.getExtraMealName().get(i))!=null){
                TotalBill += menuController.getPriceByMenuName(reservations.getExtraMealName().get(i)).getMenuPrice();
            }
        }
        JLabel mealPriceLabel = new JLabel("\nAmount Total:    "+TotalBill);
        mealPriceLabel.setFont(new Font(Font.SERIF,Font.BOLD,15));
        pmeal.add(mealPriceLabel,BorderLayout.SOUTH);

        pseat = new JPanel();
        pseat.setLayout(new FlowLayout());
        pseat.setBorder(new TitledBorder("Bill For Upgrades"));
        JLabel seatLabel = new JLabel("               Seat:   "+reservations.getGate());
        seatLabel.setFont(new Font(Font.SERIF,Font.BOLD,15));
        pseat.add(seatLabel);
        JLabel seaPriceLabel = new JLabel("\n               Class Fee:"+seatcontrol.getPriceBySeat(reservations.getGate()).getPrice()+".0");
        seaPriceLabel.setFont(new Font(Font.SERIF,Font.BOLD,15));
        pseat.add(seaPriceLabel);
        pseat.setBackground(Color.white);

        phead = new JPanel();
        phead.setLayout(new GridLayout(1,2));
        phead.setBackground(Color.white);
        phead.add(pmeal);
        phead.add(pseat);
        this.add(phead);

        //heading
        p1 = new JPanel();
        heading = new JLabel("Enter your bank card information to complete the payment:");
        heading.setToolTipText("To pay for your extra option");
        heading.setForeground(Color.white);
        heading.setFont(new Font("", Font.BOLD, 10));
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(heading);
        p1.setBackground(new Color(60, 100, 210));
//        this.add(p1);

        //card information
        p2=new JPanel();
        p2.setLayout(new FlowLayout());
        p2.add(p1);
        JLabel fnlabel = new JLabel("First name:");
        JLabel lnlabel = new JLabel("Last name:");
        fn = new JTextField(10);
        fn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isLetter(c)||127<c)e.consume();
            }
        });
        ln = new JTextField(10);
        ln.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char a = e.getKeyChar();
                if(!Character.isLetter(a)||127<a)e.consume();
            }
        });
        JPanel p2_1 = new JPanel();
        p2_1.setBackground(Color.white);
        p2_1.add(fnlabel);
        p2_1.add(fn);
        p2_1.add(lnlabel);
        p2_1.add(ln);
        p2.add(p2_1);


        cardnum = new JTextField(20);
        cardnum.addFocusListener(new JTextFieldHintListener(cardnum,"Card Number"));
        cardnum.addKeyListener(new NumKeyListener(cardnum));
        cardnum.setBorder(BorderFactory.createEtchedBorder());


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



        cards = new ButtonGroup();
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.white);
        heading2 = new JLabel("Please select your bank card type:");
        heading2.setFont(new Font("", Font.BOLD, 15));
        JPanel p3_1 = new JPanel();
        p3_1.setLayout(new BorderLayout());
        p3_1.add(heading2,BorderLayout.NORTH);

        Icon visaicon = new ImageIcon("./Imgs/Visa5.png");
        visa = new JRadioButton("Visa Card",visaicon);
        Icon mastericon = new ImageIcon("./Imgs/Mastercard7.png");
        master = new JRadioButton("Master Card",mastericon);
        Icon expreico = new ImageIcon("./Imgs/usexpress4.png");
        expre = new JRadioButton("American Express Card",expreico);
        visa.setBackground(Color.white);
        master.setBackground(Color.white);
        expre.setBackground(Color.white);

        cards.add(visa);
        cards.add(master);
        cards.add(expre);
        JPanel p3_2 = new JPanel();
        p3_2.setLayout(new FlowLayout());
        p3_2.add(visa);
        p3_2.add(master);
        p3_2.add(expre);
        p3_1.setBackground(Color.white);
        p3_2.setBackground(Color.white);
        p3.add(p3_1,BorderLayout.CENTER);
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
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cardnum.getText().length()==19 )
                {
                    JOptionPane.showMessageDialog(null,"You have paid successfully");
                    myBooking.moveToPage("pp7");
                }else if(cardnum.getText().length()!=19 )
                {
                    JOptionPane.showMessageDialog(null,"Sorry!"+"\nThe Card Number is wrong!");
                }
            }
        });
        p2.add(confirm);

        p2.setBackground(Color.white);
        this.add(p2);



    }

}
