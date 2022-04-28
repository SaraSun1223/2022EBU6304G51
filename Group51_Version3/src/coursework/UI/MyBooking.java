package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Passenger;

import javax.swing.*;
/*import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;  */

import java.awt.*;
import java.awt.event.*;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;
import static coursework.UI.MyButtonListener.surnameStored;

public class MyBooking extends MouseAdapter {
    /**
     * top container
     */
    JFrame jfra;
    /**
     * main panel
     */
    JPanel pane;
    /**
     * first line which can displays "Please complete the information below:"
     */
    JLabel label1;
    JLabel label2;
    JList menu;
    DefaultListModel menu1;
    String[] menuList = {"Booked Flight Information","Choose the Seat","Choose the type of meal","Extra Option: Meal","Extra Option: Seat","Payment","Check-in Confirmation"};
    JPanel p1;
    JPanel p2;
    JPanel p3;
    CardLayout pp;
    JPanel pp1;
    JPanel pp2;
    BasicMenuList pp3;
    ExtraMenuList pp4;
    JPanel pp5;
    Payment pp6;
    JPanel pp7;
    JPanel jp1;
    JPanel jp2;

    JLabel heading3;
    JList list1,list2;
	
	JPanel t1;
    JPanel t2;
	JPanel t3;
	JPanel t4;
    JPanel t5;
	JPanel t6;
	JLabel lab1;
	JLabel lab2;
	JLabel lab3;
	JLabel lab4;
	JButton B1;	
	JButton B2;	
	


      public  MyBooking(){
//
        jfra = new JFrame("London Heathrow Airport");
        pane = new JPanel();
        jfra.add(pane);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        pp1 = new JPanel();
        pp2 = new JPanel();
        pp3 = new BasicMenuList();
        pp4 = new ExtraMenuList();
        pp5 = new JPanel();
        pp6 = new Payment();
        pp7 = new Confirmations();
        label1 = new JLabel("Booked Flight Information",JLabel.CENTER);
        label1.setFont(new Font("Dialog", Font.PLAIN, 13));
        label2 = new JLabel("London Heathrow Airport");
        jp1 = new JPanel();
        jp2 = new JPanel();

        menu1=new MenuModel(1);
        menu= new JList(menu1);
        menu.setBackground(new Color(60,100,210));
        menu.setForeground(Color.white);
        menu.addMouseListener(this);

        heading3 = new JLabel("  *  Details of Scheduled Flight:  ");
        heading3.setForeground(Color.white);
        heading3.setFont(new Font("", Font.BOLD, 15));

          PersonalController control = PersonalController.getController();
          list1 = new JList<>();

          if(bookingNumberStored!=null){
              list1.setModel(new AbstractListModel<String>() {
                  String[] value = control.getPassengerInform(bookingNumberStored).confirmationPrint();

                  @Override
                  public int getSize() {
                      return value.length;
                  };

                  @Override
                  public String getElementAt(int i) {
                      return value[i];
                  }
              });}else if (IDnumStored!=null){

              list1.setModel(new AbstractListModel<String>() {
                  String[] value = control.getPassengerInform(surnameStored,IDnumStored).confirmationPrint();


                  @Override
                  public int getSize() {
                      return value.length;
                  };

                  @Override
                  public String getElementAt(int i) {
                      return value[i];
                  }
              });
          }

          //---------list2--------

          list2 = new JList<>();
          if(bookingNumberStored!=null){
              Passenger passenger = control.getPassengerInform(bookingNumberStored);
              list2.setModel(new AbstractListModel<String>() {
                  String[] value = control.getFlightInform(passenger.getFlightNumber()).confirmationPrint();

                  @Override
                  public int getSize() {
                      return value.length;
                  };

                  @Override
                  public String getElementAt(int i) {
                      return value[i];
                  }
              });}else if (IDnumStored!=null){

              Passenger passenger = control.getPassengerInform(surnameStored,IDnumStored);
              list2.setModel(new AbstractListModel<String>() {
                  String[] value = control.getFlightInform(passenger.getFlightNumber()).confirmationPrint();


                  @Override
                  public int getSize() {
                      return value.length;
                  };

                  @Override
                  public String getElementAt(int i) {
                      return value[i];
                  }
              });
          }

        pp = new CardLayout(5,5);
//
        jp1.setBackground(new Color(60,100,210));
        jp2.setBackground(Color.white);

        pp2.setLayout(new BorderLayout());//Choose the seat
		
        t1 = new JPanel();
        t2 = new JPanel();
		t3 = new JPanel();
		
		lab1 = new JLabel("Select the seat you want and click Save. Once confirmed, it cannot be changed.");
		lab2= new JLabel("*Blue-Optional");
		
		B1 = new JButton("Save");
		Seat obj1=new Seat();
        obj1.Action(B1);
		obj1.Seat1(t2);
		t1.add(lab1);
		t3.add(lab2);
		//t3.add(lab3);
		t3.add(B1);
		pp2.setPreferredSize(new Dimension(50, 0));
		pp2.add(t1,BorderLayout.NORTH);
		pp2.add(t2,BorderLayout.WEST);
		pp2.add(t3,BorderLayout.EAST);
//        if(confirmSeat == 1){
//            moveToPage("pp3");
//        }
        pp5.setLayout(new BorderLayout());//Choose the seat
		
        t4 = new JPanel();
        t5 = new JPanel();
		t6 = new JPanel();
		
		lab3 = new JLabel("Select the extra seat you want and click Save.You will pay extra.");
		lab4= new JLabel("*Pink-Optional");
		
		B2 = new JButton("Save");

		ExtraSeat obj2=new ExtraSeat();
        obj2.Action(B2);

		obj2.Seat2(t5);
		t4.add(lab3);
		t6.add(lab4);
		
		t6.add(B2);
		pp5.setPreferredSize(new Dimension(50, 0));
		pp5.add(t4,BorderLayout.NORTH);
		pp5.add(t5,BorderLayout.WEST);
		pp5.add(t6,BorderLayout.EAST);
		
        pp3.BasicMenuList();
        pp3.setVisible(true); //Choose the meals
        pp4.ExtraMenuList();
        pp4.setVisible(true);
        pp6.setVisible(true);
        pp7.setVisible(true);

        p1.setBackground(new Color(60,100,210));
        p2.setBackground(new Color(60,100,210));
        label1.setForeground(Color.white);
        label2.setForeground(Color.white);
        pane.setLayout(new BorderLayout());
        p2.setLayout(new BorderLayout());
        pp1.setLayout(new BorderLayout());
        jp1.setLayout(new BorderLayout());
        jp1.add(heading3,BorderLayout.NORTH);
        jp2.setLayout(new GridLayout(1,2));
        jp2.add(list1);
        jp2.add(list2);
        jp1.add(jp2);
        p1.add(new JScrollPane(menu));
        p2.add(label2,BorderLayout.WEST);
        p2.add(label1,BorderLayout.CENTER);
        p3.setLayout(pp);
        pp1.add(jp1);

        p3.add(pp1,"pp1");
        p3.add(pp2,"pp2");
        p3.add(pp3,"pp3");
        p3.add(pp4,"pp4");
        p3.add(pp5,"pp5");
        p3.add(pp6,"pp6");
        p3.add(pp7,"pp7");

        pane.add(p1,BorderLayout.WEST);
        pane.add(p2,BorderLayout.NORTH);
        pane.add(p3,BorderLayout.CENTER);


        p2.setPreferredSize(new Dimension(0,30));

        jfra.setLocation(400,10);
        jfra.setSize(760,480);
        jfra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfra.setContentPane(pane);
        jfra.setVisible(true);//set frame visible
    }

    public void tableSearch(){

    }
    public void mouseClicked(MouseEvent e){
        int index;
        if (e.getSource()==menu) {
            if (e.getClickCount() == 2) {
                index = menu.locationToIndex(e.getPoint());
                String a = "pp"+(index+1);
                confirmationUpdate();
                pp.show(p3, a);
            }
        }
    }
    public void confirmationUpdate(){
        pp7 = new JPanel();
        pp7 = new Confirmations();
        p3.add(pp7,"pp7");
    }
    public void moveToPage(String a){
          pp.show(p3,a);
    }

    class MenuModel extends DefaultListModel{
        MenuModel(int judge){
            if(judge==1){
                for(int i=0;i<menuList.length;i++){
                    addElement(menuList[i]);
                }
            }

        }
    }


}

