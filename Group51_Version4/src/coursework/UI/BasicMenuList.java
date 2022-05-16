package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Menu;
import coursework.Entity.Passenger;
import coursework.Entity.Reservations;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;

public class BasicMenuList extends JPanel implements actionPerformed {
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
       JRadioButton Hamburger;
       JButton button6;
       JPanel panel13;
       JRadioButton Rice;
       JButton button7;
       JPanel panel14;
       JRadioButton Pasta;
       JButton button8;
       JPanel panel15;
       JLabel label4;
       JPanel panel16;
       JPanel panel17;
       JRadioButton Juice;
       JButton button9;
       JPanel panel18;
       JRadioButton Milk;
       JButton button10;
       JPanel panel19;
       JRadioButton CoffeeAmerican;
       JButton button11;
       JPanel panel20;
       JButton button12;

       public void BasicMenuList(MyBooking myBooking) {
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
              Hamburger = new JRadioButton();
              button6 = new JButton();
              panel13 = new JPanel();
              Rice = new JRadioButton();
              button7 = new JButton();
              panel14 = new JPanel();
              Pasta = new JRadioButton();
              button8 = new JButton();
              panel15 = new JPanel();
              label4 = new JLabel();
              panel16 = new JPanel();
              panel17 = new JPanel();
              Juice = new JRadioButton();
              button9 = new JButton();
              panel18 = new JPanel();
              Milk = new JRadioButton();
              button10 = new JButton();
              panel19 = new JPanel();
              CoffeeAmerican = new JRadioButton();
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
                     label1.setText("  Choose the Type of Meals:  ");
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
                            label2.setText("   *   Select the meal you like and Click Ok.  Once you've confirmed, it cannot be changed.");
                            label2.setFont(new Font("Dialog", Font.ITALIC , 12));
                            JLabel LB = new JLabel("      ");
                            panel3.add(label2, BorderLayout.CENTER);
                            panel3.add(LB, BorderLayout.SOUTH);
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
                                          panel11.setLayout(new GridLayout(2,3));
                                          panel11.setBackground(Color.white);
                                          {
                                                 //------button6------
                                                 button6.setBackground(Color.white);
                                                 button6.setIcon(new ImageIcon("./Imgs/Hamburger  .jpeg"));
                                                 button6.setOpaque(true);
                                                 button6.setBorderPainted(false);

                                                 //------JRadiobutton----
                                                 Hamburger.setText("Hamburger");
                                                 Hamburger.setHorizontalAlignment(SwingConstants.CENTER);
                                                 Hamburger.setBackground(Color.white);
                                                 Hamburger.setOpaque(true);

                                          }
                                          {
                                                 //------button7------
                                                 button7.setBackground(Color.white);
                                                 button7.setIcon(new ImageIcon("./Imgs/Rice.jpg"));
                                                 button7.setOpaque(true);
                                                 button7.setBorderPainted(false);

                                                 //------JRadioButton----
                                                 Rice.setText("Rice");
                                                 Rice.setHorizontalAlignment(SwingConstants.CENTER);
                                                 Rice.setBackground(Color.white);
                                                 Rice.setOpaque(true);
                                          }

                                          {
                                                 //------button8------
                                                 button8.setBackground(Color.white);
                                                 button8.setIcon(new ImageIcon("./Imgs/Pasta.jpg"));
                                                 button8.setOpaque(true);
                                                 button8.setBorderPainted(false);

                                                 //-----JRadioButton----
                                                 Pasta.setText("Pasta");
                                                 Pasta.setHorizontalAlignment(SwingConstants.CENTER);
                                                 Pasta.setBackground(Color.white);
                                                 Pasta.setOpaque(true);
                                          }
                                          panel11.add(button6, new GridLayout());
                                          panel11.add(button7,new GridLayout());
                                          panel11.add(button8, new GridLayout());
                                          panel11.add(Hamburger, new GridLayout());
                                          panel11.add(Rice, new GridLayout());
                                          panel11.add(Pasta, new GridLayout());

                                          ButtonGroup btngroup1 = new ButtonGroup();
                                          btngroup1.add(Hamburger);
                                          btngroup1.add(Rice);
                                          btngroup1.add(Pasta);

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
                                                 //-----button9-------
                                                 button9.setBackground(Color.white);
                                                 button9.setIcon(new ImageIcon("./Imgs/Juice.jpg"));
                                                 button9.setOpaque(true);
                                                 button9.setBorderPainted(false);
                                                 //-----JRadioButton------
                                                 Juice.setHorizontalAlignment(SwingConstants.CENTER);
                                                 Juice.setText("Juice");
                                                 Juice.setBackground(Color.white);
                                                 Juice.setOpaque(true);
                                          }
                                          {
                                                 //-----JRadioButton------
                                                 Milk.setHorizontalAlignment(SwingConstants.CENTER);
                                                 Milk.setText("Milk");
                                                 Milk.setBackground(Color.white);
                                                 Milk.setOpaque(true);
                                                 //-----button10-------
                                                 button10.setBackground(Color.white);
                                                 button10.setIcon(new ImageIcon("./Imgs/Milk.jpg"));
                                                 button10.setOpaque(true);
                                                 button10.setBorderPainted(false);
                                          }
                                          {
                                                 //----JRadioButton----
                                                 CoffeeAmerican.setText("Coffee");
                                                 CoffeeAmerican.setBackground(Color.white);
                                                 CoffeeAmerican.setHorizontalAlignment(SwingConstants.CENTER);
                                                 CoffeeAmerican.setBackground(Color.white);
                                                 CoffeeAmerican.setOpaque(true);
                                                 //---- button11 ----
                                                 button11.setBackground(Color.white);
                                                 button11.setIcon(new ImageIcon("./Imgs/Coffee American.jpg"));
                                                 button11.setOpaque(true);
                                                 button11.setBorderPainted(false);


                                          }
                                          panel16.add(button9, new GridLayout());
                                          panel16.add(button10, new GridLayout());
                                          panel16.add(button11, new GridLayout());
                                          panel16.add(Juice, new GridLayout());
                                          panel16.add(Milk, new GridLayout());
                                          panel16.add(CoffeeAmerican, new GridLayout());

                                          ButtonGroup btngroup2 = new ButtonGroup();
                                          btngroup2.add(Juice);
                                          btngroup2.add(Milk);
                                          btngroup2.add(CoffeeAmerican);

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
                                          String basicFood = "";
                                          String basicDrink = "";

                                          for (Component c : panel11.getComponents()) {
                                                 if (c instanceof JRadioButton) {
                                                        if (((JRadioButton) c).isSelected()) {
                                                               basicFood += ((JRadioButton) c).getText();
                                                        }
                                                 }
                                          }
                                          for (Component c : panel16.getComponents()) {
                                                 if (c instanceof JRadioButton) {
                                                        if (((JRadioButton) c).isSelected()) {
                                                               basicDrink += ((JRadioButton) c).getText();
                                                        }
                                                 }
                                          }

                                          if(basicFood!="" || basicFood!="")
                                          {
                                                 int getOption= JOptionPane.showConfirmDialog(null, "What you have choosed:  " +
                                                         "\n\n STAPLE FOOD :  " + basicFood +
                                                         "\n DRINK :  " + basicDrink);
                                                 PersonalController control = PersonalController.getController();
                                                 if(getOption == JOptionPane.YES_OPTION){
                                                        if(bookingNumberStored!=null){
                                                               Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
                                                               ArrayList<String> h = new ArrayList<>();
                                                               h.add(basicFood);
                                                               h.add(basicDrink);
                                                               reservations.setStandardMeal(h);
                                                               control.updateReservations(reservations);
                                                               myBooking.confirmationUpdate();
                                                               myBooking.moveToPage("pp4");
                                                        }else if (IDnumStored!=null) {
                                                               Reservations reservations = control.getReservationsInformByID(IDnumStored);
                                                               ArrayList<String> h = new ArrayList<>();
                                                               h.add(basicFood);
                                                               h.add(basicDrink);
                                                               reservations.setStandardMeal(h);
                                                               control.updateReservations(reservations);
                                                               myBooking.confirmationUpdate();
                                                               myBooking.moveToPage("pp4");
                                                        }
                                                 }else{

                                                 }
                                          }else if(basicFood==""&&basicDrink!=""){
                                                 JOptionPane.showMessageDialog(null, "You didn't choose the basic meal!");
                                          }else if(basicFood!=""&&basicDrink==""){
                                                 JOptionPane.showMessageDialog(null, "You didn't choose the basic drink!");
                                          }else{
                                                 JOptionPane.showMessageDialog(null, "You didn't choose the basic meal and drink!");
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


