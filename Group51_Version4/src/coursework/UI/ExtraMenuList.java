package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;

public class ExtraMenuList extends JPanel {
    JPanel panel1;
    JLabel label1;
    JPanel panel2;
    JPanel panel3;
    JLabel label2;
    JPanel panel4;
    JPanel panel5;
    JLabel label3;
    JPanel panel11;
    JPanel panel12;
    JRadioButton Tacco;
    JButton button6;
    JPanel panel13;
    JRadioButton Cake;
    JButton button7;
    JPanel panel14;
    JRadioButton Lasagna;
    JButton button8;
    JPanel panel15;
    JLabel label4;
    JPanel panel16;
    JPanel panel17;
    JRadioButton Latte;
    JButton button9;
    JPanel panel18;
    JRadioButton Tea;
    JButton button10;
    JPanel panel19;
    JRadioButton Frappuccino;
    JButton button11;
    JPanel panel20;
    JButton button12;

    public void ExtraMenuList(MyBooking myBooking) {
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        label3 = new JLabel();
        panel11 = new JPanel();
        panel12 = new JPanel();
        Tacco = new JRadioButton();
        button6 = new JButton();
        panel13 = new JPanel();
        Cake = new JRadioButton();
        button7 = new JButton();
        panel14 = new JPanel();
        Lasagna = new JRadioButton();
        button8 = new JButton();
        panel15 = new JPanel();
        label4 = new JLabel();
        panel16 = new JPanel();
        panel17 = new JPanel();
        Latte = new JRadioButton();
        button9 = new JButton();
        panel18 = new JPanel();
        Tea = new JRadioButton();
        button10 = new JButton();
        panel19 = new JPanel();
        Frappuccino = new JRadioButton();
        button11 = new JButton();
        panel20 = new JPanel();
        button12 = new JButton();


        //=========this.panel============
        setBackground(Color.white);
        setLayout(new BorderLayout(5, 5));

        //==========panel1==============
        {
            panel1.setBackground(new Color(60, 100, 210));
            panel1.setLayout(new GridLayout(1, 1));
            //------label1----------
            label1.setText("  Extra Options - Extra Meals  ");
            label1.setForeground(Color.white);
            label1.setFont(new Font("", Font.BOLD, 15));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
        }
        add(panel1, BorderLayout.NORTH);

        //==========panel2==============
        {
            panel2.setLayout(new BorderLayout());
            panel2.setBackground(Color.white);
            //=========panel3=========
            {
                panel3.setBackground(Color.white);
                panel3.setLayout(new BorderLayout());
                //--------label2-----------
                label2.setText("You are given the option to choose special meal with gourmet menu.\n" +
                        "These require an extra price. Select the meal you want and click Ok.");
                label2.setFont(new Font("Dialog", Font.ITALIC, 10));
                JLabel Lb =new JLabel("    ");
                panel3.add(label2, BorderLayout.CENTER);
                panel3.add(Lb, BorderLayout.SOUTH);
            }
            panel2.add(panel3, BorderLayout.NORTH);

            //=========panel4==========
            {
                panel4.setBackground(Color.white);
                panel4.setForeground(Color.white);
                panel4.setLayout(new GridLayout(2, 4));

                //=========panel5=========
                {
                    panel5.setLayout(new BorderLayout());
                    panel5.setBackground(Color.white);
                    //------label3-------
                    label3.setText("  Staple Food  ");
                    label3.setFont(new Font("", Font.BOLD, 15));
                    panel5.add(label3, BorderLayout.NORTH);

                    //=======panel11=========
                    {
                        panel11.setLayout(new GridLayout(2, 3));
                        panel11.setBackground(Color.white);

                        {
                            //------JRadioButton----
                            Tacco.setText("Tacco");
                            Tacco.setHorizontalAlignment(SwingConstants.CENTER);
                            Tacco.setBackground(Color.white);
                            Tacco.setOpaque(true);

                            //------button6------
                            button6.setBackground(Color.white);
                            button6.setIcon(new ImageIcon("./Imgs/Tacco.jpg"));
                            button6.setOpaque(true);
                        }
                        {
                            //------JRadioButton----
                            Cake.setText("Tiramisu");
                            Cake.setHorizontalAlignment(SwingConstants.CENTER);
                            Cake.setBackground(Color.white);
                            Cake.setOpaque(true);
                            //------button7------
                            button7.setBackground(Color.white);
                            button7.setIcon(new ImageIcon("./Imgs/Tiramisu Cake.jpg"));
                            button7.setOpaque(true);
                        }
                        {
                            //------JRadioButton----
                            Lasagna.setText("Lasagna");
                            Lasagna.setHorizontalAlignment(SwingConstants.CENTER);
                            Lasagna.setBackground(Color.white);
                            Lasagna.setOpaque(true);
                            //------button8------
                            button8.setBackground(Color.white);
                            button8.setIcon(new ImageIcon("./Imgs/Cheese Lasagna.jpg"));
                            button8.setOpaque(true);
                        }
                        panel11.add(button6, new GridLayout());
                        panel11.add(button7, new GridLayout());
                        panel11.add(button8, new GridLayout());
                        panel11.add(Tacco, new GridLayout());
                        panel11.add(Cake, new GridLayout());
                        panel11.add(Lasagna, new GridLayout());

                        ButtonGroup btngroup1 = new ButtonGroup();
                        btngroup1.add(Tacco);
                        btngroup1.add(Cake);
                        btngroup1.add(Lasagna);
                    }
                    panel5.add(panel11, BorderLayout.CENTER);
                }
                panel4.add(panel5);

                //=======panel15==========
                {
                    panel15.setBackground(Color.white);
                    panel15.setLayout(new BorderLayout());
                    //------label4------
                    label4.setText("  Drinks       ");
                    label4.setFont(new Font("", Font.BOLD, 15));
                    panel15.add(label4, BorderLayout.NORTH);

                    //========panel16==========
                    panel16.setLayout(new GridLayout(2, 3));
                    {
                        {
                            //-----JRadioButton------
                            Latte.setHorizontalAlignment(SwingConstants.CENTER);
                            Latte.setText("Latte");
                            Latte.setBackground(Color.white);
                            Latte.setOpaque(true);
                            //-----button9-------
                            button9.setBackground(Color.white);
                            button9.setIcon(new ImageIcon("./Imgs/Coffee Latte.jpg"));
                            button9.setOpaque(true);
                        }
                        {
                            //-----JRadioButton------
                            Tea.setHorizontalAlignment(SwingConstants.CENTER);
                            Tea.setText("Lemon Tea");
                            Tea.setBackground(Color.white);
                            Tea.setOpaque(true);
                            //-----button10-------
                            button10.setBackground(Color.white);
                            button10.setIcon(new ImageIcon("./Imgs/Shaken Tea Lemonade.jpg"));
                            button10.setOpaque(true);
                        }
                        {
                            //---- JRadioButton ----
                            Frappuccino.setText("Frappuccino");
                            Frappuccino.setBackground(Color.white);
                            Frappuccino.setHorizontalAlignment(SwingConstants.CENTER);
                            Frappuccino.setBackground(Color.white);
                            Frappuccino.setOpaque(true);
                            //---- button11 ----
                            button11.setBackground(Color.white);
                            button11.setIcon(new ImageIcon("./Imgs/Frappuccino.jpg"));
                            button11.setOpaque(true);
                        }
                        panel16.add(button9, new GridLayout());
                        panel16.add(button10, new GridLayout());
                        panel16.add(button11, new GridLayout());
                        panel16.add(Latte, new GridLayout());
                        panel16.add(Tea, new GridLayout());
                        panel16.add(Frappuccino, new GridLayout());

                        ButtonGroup btngroup2 = new ButtonGroup();
                        btngroup2.add(Latte);
                        btngroup2.add(Tea);
                        btngroup2.add(Frappuccino);
                    }
                    panel15.add(panel16, BorderLayout.CENTER);
                }
                panel4.add(panel15);
            }
            panel2.add(panel4,BorderLayout.CENTER);

            //=======panel20=============
            {
                panel20.setBackground(Color.white);
                panel20.setLayout(new GridLayout(1,1));
                //-----button12--------
                button12.setText("OK");
                button12.setBackground(Color.white);
                button12.setAlignmentX(0.5F);
                button12.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String extraFood ="";
                        String extraDrink = "";

                        for (Component c:panel11.getComponents()){
                            if (c instanceof JRadioButton){
                                if(((JRadioButton) c).isSelected()){
                                    extraFood += ((JRadioButton)c).getText();
                                }
                            }
                        }
                        for (Component c:panel16.getComponents()){
                            if (c instanceof JRadioButton){
                                if(((JRadioButton) c).isSelected()){
                                    extraDrink += ((JRadioButton)c).getText();
                                }
                            }
                        }


                        PersonalController control = PersonalController.getController();
                        if(extraFood!=""||extraDrink!=""){
                            int getOption= JOptionPane.showConfirmDialog(null, "What you have choosed:  "+
                                "\n\n STAPLE FOOD :  "+extraFood +
                                "\n DRINK :  "+extraDrink);
                            if(getOption == JOptionPane.YES_OPTION){
                                if(bookingNumberStored!=null){
                                    Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
                                    ArrayList<String> h = new ArrayList<>();
                                    h.add(extraFood);
                                    h.add(extraDrink);
                                    reservations.setIfExtraMeal(true);
                                    reservations.setExtraMealName(h);
                                    control.updateReservations(reservations);
                                    myBooking.confirmationUpdate();
                                    myBooking.moveToPage("pp5");
                                }else if (IDnumStored!=null) {
                                    Reservations reservations = control.getReservationsInformByID(IDnumStored);
                                    ArrayList<String> h = new ArrayList<>();
                                    h.add(extraFood);
                                    h.add(extraDrink);
                                    reservations.setIfExtraMeal(true);
                                    reservations.setExtraMealName(h);
                                    control.updateReservations(reservations);
                                    myBooking.confirmationUpdate();
                                    myBooking.moveToPage("pp5");
                                }
                            }else{

                            }
                        }else{
                            int getOption= JOptionPane.showConfirmDialog(null, "Do you confirm not to choose extra meal?" );
                            if(getOption == JOptionPane.YES_OPTION){
                                if(bookingNumberStored!=null){
                                    Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
                                    reservations.setIfExtraMeal(false);
                                    control.updateReservations(reservations);
                                    myBooking.confirmationUpdate();
                                    myBooking.moveToPage("pp5");
                                }else if (IDnumStored!=null) {
                                    Reservations reservations = control.getReservationsInformByID(IDnumStored);
                                    reservations.setIfExtraMeal(false);
                                    control.updateReservations(reservations);
                                    myBooking.confirmationUpdate();
                                    myBooking.moveToPage("pp5");
                                }
                            }else{

                            }
                        }

                    }
                });
                panel20.add(button12);
            }
            panel2.add(panel20,BorderLayout.SOUTH);
        }
        add(panel2,BorderLayout.CENTER);

    }

}



