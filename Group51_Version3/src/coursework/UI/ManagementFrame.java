package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Passenger;
import coursework.Entity.Reservations;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

import java.awt.*;
import java.awt.event.*;

import org.apache.commons.lang3.StringUtils;


/**
 * ManagementFrame is the base class for airline staff to get management information about flight, 
 * including meal, seat, passenger check-in statues and baggage management.
 * 
 * @version:1.0
 * 
 */
public class ManagementFrame extends MouseAdapter implements ActionListener{
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
	JButton button;
    JButton button2;//baggage
    JButton button3;//meal
    JButton button4;//seat
    JList menu;
    JTextField SearchPsg;
    JTextField SearchBag;
    JTextField SearchMeal;
    JTextField SearchSeat;
    DefaultListModel menu1;
    String[] menuList = {"Check-in Status","Baggage Management","Meal Management","Seat Management"};
    JPanel p1;
    JPanel p2;
    JPanel p3;
    CardLayout pp;
    JPanel pp1;
    JPanel pp2;
    JPanel pp3;
    JPanel pp4;
    JTable PsgInftable;
    JTable MealInftable;
    JTable BaggageInftable;
    JTable SeatInftable;

	JPanel jp1;
    JPanel jp2;
    String[] Names = {"Flight number","Passenger name","ID number","Check-in status","Phone number"};
    ArrayList<Passenger> passengers = new ArrayList<>();
    String[][] Info;
    //ArrayList<ArrayList<String>> Info=new ArrayList<ArrayList<String>>();
    //Info.ArrayList.toArray(new String[0][]);
    //Info.toArray(new String[Info.size()][]);

    JPanel j2p1;
    JPanel j2p2;
    String[] Names2 = {"Flight number","Passenger name","ID number","Baggage number","Baggage weight"};
    String[][] Info2;

    JPanel j3p1;
    JPanel j3p2;
    String[] Names3 = {"Flight number","Passenger name","Seat number","Standard meal","Extra meal"};
    String[][] Info3;

    JPanel j4p1;
    JPanel j4p2;
    String[] Names4 = {"Flight number and destination","Passenger name","ID number","Seat number","Phone number"};
    String[][] Info4 ={
            {"3933 Beijing","Lily","110100","G10","1923884848"}
    };


    public ManagementFrame(){
//    
        jfra = new JFrame("London Heathrow Airport");
        pane = new JPanel();
        jfra.add(pane);
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        pp1 = new JPanel();
        pp2 = new JPanel();
        pp3 = new JPanel();
        pp4 = new JPanel();
        label1 = new JLabel("Airline Mangement Center",JLabel.CENTER);
		label2 = new JLabel("London Heathrow Airport");
//      psg
		button = new JButton("Search");
        button.addActionListener(this);
        button.setActionCommand("SearchFlight");
        SearchPsg = new JTextField();
		SearchPsg.setColumns(40);
		jp1 = new JPanel();
		jp2 = new JPanel();
		CheckinInfo();
        PsgInftable = new JTable(new MyTable1(Names,Info));
        PsgInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
        JScrollPane s = new JScrollPane(PsgInftable);

        //baggage
        button2 = new JButton("Search");
        SearchBag = new JTextField();
        SearchBag.setColumns(40);
        j2p1 = new JPanel();
        j2p2 = new JPanel();
        button2.addActionListener(this);
        button2.setActionCommand("SearchBaggage");
        BaggageInfo();
        BaggageInftable = new JTable(new MyTable1(Names2,Info2));
        BaggageInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
        JScrollPane s2 = new JScrollPane(BaggageInftable);

        //meal
        button3 = new JButton("Search");
        SearchMeal = new JTextField();
        SearchMeal.setColumns(40);
        j3p1 = new JPanel();
        j3p2 = new JPanel();
        button3.addActionListener(this);
        button3.setActionCommand("SearchMeal");
        MealInfo();
        MealInftable = new JTable(new MyTable1(Names3,Info3));
        MealInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
        JScrollPane s3 = new JScrollPane(MealInftable);

        //seat
        button4 = new JButton("Search");
        SearchSeat = new JTextField();
        SearchSeat.setColumns(40);
        j4p1 = new JPanel();
        j4p2 = new JPanel();
        button4.addActionListener(this);
        button4.setActionCommand("SearchSeat");

        SeatInftable = new JTable(new MyTable1(Names4,Info4));
        SeatInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
        JScrollPane s4 = new JScrollPane(SeatInftable);


        menu1=new MenuModel(1);
        menu= new JList<>(menu1);
		menu.setBackground(new Color(60,100,210));
		menu.setForeground(Color.white);
        menu.addMouseListener(this);

        label1.setForeground(Color.white);
        label2.setForeground(Color.white);


        p1.add(new JScrollPane(menu));
        p2.setLayout(new BorderLayout());
        p2.add(label2,BorderLayout.WEST);
        p2.add(label1,BorderLayout.CENTER);
        p1.setBackground(new Color(60,100,210));
        p2.setBackground(new Color(60,100,210));


//        pssg
        pp1.setLayout(new BorderLayout());
        jp1.setBackground(Color.white);
		jp2.setBackground(Color.white);
		jp2.setLayout(new BorderLayout());
		jp1.add(SearchPsg);
	    jp1.add(button);
		jp2.add(PsgInftable.getTableHeader(),BorderLayout.NORTH);
		jp2.add(PsgInftable,BorderLayout.CENTER);
		pp1.add(jp1,BorderLayout.NORTH);
        pp1.add(jp2,BorderLayout.CENTER);

//        bagg
        j2p1.setBackground(Color.white);
        j2p2.setBackground(Color.white);
        pp2.setLayout(new BorderLayout());
        j2p2.setLayout(new BorderLayout());
        j2p1.add(SearchBag);
        j2p1.add(button2);
        j2p2.add(BaggageInftable.getTableHeader(),BorderLayout.NORTH);
        j2p2.add(BaggageInftable,BorderLayout.CENTER);
        pp2.add(j2p1,BorderLayout.NORTH);
        pp2.add(j2p2,BorderLayout.CENTER);

//      meal
        j3p1.setBackground(Color.white);
        j3p2.setBackground(Color.white);
        pp3.setLayout(new BorderLayout());
        j3p2.setLayout(new BorderLayout());
        j3p1.add(SearchMeal);
        j3p1.add(button3);
        j3p2.add(MealInftable.getTableHeader(),BorderLayout.NORTH);
        j3p2.add(MealInftable,BorderLayout.CENTER);
        pp3.add(j3p1,BorderLayout.NORTH);
        pp3.add(j3p2,BorderLayout.CENTER);

        //      seat
        j4p1.setBackground(Color.white);
        j4p2.setBackground(Color.white);
        pp4.setLayout(new BorderLayout());
        j4p2.setLayout(new BorderLayout());
        j4p1.add(SearchSeat);
        j4p1.add(button4);
        j4p2.add(SeatInftable.getTableHeader(),BorderLayout.NORTH);
        j4p2.add(SeatInftable,BorderLayout.CENTER);
        pp4.add(j4p1,BorderLayout.NORTH);
        pp4.add(j4p2,BorderLayout.CENTER);

        pp1.setBackground(Color.white);
        pp2.setBackground(Color.white);
        pp3.setBackground(Color.white);
        pp4.setBackground(Color.white);

        pp = new CardLayout(5,5);
        p3.setLayout(pp);
        p3.add(pp1,"pp1");
        p3.add(pp2,"pp2");
        p3.add(pp3,"pp3");
        p3.add(pp4,"pp4");

        pane.setLayout(new BorderLayout());
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




    public void mouseClicked(MouseEvent e){
        int index;
        if (e.getSource()==menu) {
            if (e.getClickCount() == 2) {
                index = menu.locationToIndex(e.getPoint());
                String a = "pp"+(index+1);
                System.out.println(index+a);
                pp.show(p3, a);

            }
        }
    }

    public String[][] CheckinInfo(){
        ArrayList<Passenger> passengers = new ArrayList<>();
        PersonalController control = PersonalController.getController();
        passengers=control.getAllPassenger();
        Info = new String[passengers.size()][5];
        for(int i = 0; i < passengers.size(); i++){
            Info[i][0]=passengers.get(i).getFlightNumber();
            System.out.println(Info[i][0]);
            Info[i][1]=passengers.get(i).getFirstName()+" "+passengers.get(i).getSurname();
            System.out.println(Info[i][1]);
            Info[i][2]=passengers.get(i).getIdNumber();
            System.out.println(Info[i][2]);
            Info[i][3]=Boolean.toString(passengers.get(i).getStatus());
            System.out.println(Info[i][3]);
            Info[i][4]=passengers.get(i).getPhoneNumber();
            System.out.println(Info[i][4]);
        }
        return Info;
    }

    public String[][] BaggageInfo(){
        ArrayList<Reservations> reservations = new ArrayList<>();
        PersonalController control = PersonalController.getController();
        reservations=control.getAllReservations();
        Info2 = new String[reservations.size()][5];
        for(int i = 0; i < reservations.size(); i++){
            Info2[i][0]=reservations.get(i).getFlightNum();
            Info2[i][2]=reservations.get(i).getIDNum();
            Info2[i][3]=Integer.toString(reservations.get(i).getBaggageNum());
            Info2[i][4]=Integer.toString(reservations.get(i).getBaggageWeight())+"kg";
            Info2[i][1]=control.getPassengerInform(reservations.get(i).getBookingNum()).getFirstName()+" "+
                    control.getPassengerInform(reservations.get(i).getBookingNum()).getSurname();

        }
        return Info2;
    }

    public String[][] MealInfo(){
        ArrayList<Reservations> reservations = new ArrayList<>();
        PersonalController control = PersonalController.getController();
        reservations=control.getAllReservations();
        Info3 = new String[reservations.size()][5];
        for(int i = 0; i < reservations.size(); i++){
            Info3[i][0]=reservations.get(i).getFlightNum();
            Info3[i][2]=reservations.get(i).getGate();
            Info3[i][3]=StringUtils.join(reservations.get(i).getStandardMeal(),",");
            Info3[i][4]=StringUtils.join(reservations.get(i).getExtraMealName(),",");
            Info3[i][1]=control.getPassengerInform(reservations.get(i).getBookingNum()).getFirstName()+" "+
                    control.getPassengerInform(reservations.get(i).getBookingNum()).getSurname();

        }
        return Info3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Reservations> reservations = new ArrayList<>();
        if (e.getActionCommand().equals("SearchFlight")) {
            PersonalController control = PersonalController.getController();
            System.out.println(SearchPsg.getText());
            passengers=control.filterByKeyword(control.getAllPassenger(), SearchPsg.getText());
            System.out.println(passengers);
            System.out.println(passengers.size());
//            System.out.println(Info[0][0]);
//            System.out.println(Info[0][1]);
//            System.out.println(Info[0][2]);
//            System.out.println(Info[0][3]);
//            System.out.println(Info[0][4]);
            Info = new String[passengers.size()][5];

//            System.out.println(passengers.get(0));
            for(int i = 0; i < passengers.size(); i++){
                Info[i][0]=passengers.get(i).getFlightNumber();
                System.out.println(passengers.get(i).getFlightNumber());
                System.out.println(Info[i][0]);
                Info[i][1]=passengers.get(i).getFirstName()+" "+passengers.get(i).getSurname();
                System.out.println(Info[i][1]);
                Info[i][2]=passengers.get(i).getIdNumber();
                System.out.println(Info[i][2]);
                Info[i][3]=Boolean.toString(passengers.get(i).getStatus());
                System.out.println(Info[i][3]);
                Info[i][4]=passengers.get(i).getPhoneNumber();
                System.out.println(Info[i][4]);
            }
            System.out.println(Info);
            System.out.println("hello");

            PsgInftable = new JTable(new MyTable1(Names,Info));
            PsgInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
            JScrollPane s = new JScrollPane(PsgInftable);

            jp2.add(PsgInftable.getTableHeader(),BorderLayout.NORTH);
            jp2.add(PsgInftable,BorderLayout.CENTER);

            jp2.setVisible(true);
            pp1.add(jp2,BorderLayout.CENTER);

            JPanel pp5 = new JPanel();
            pp5.add(new JLabel("hello"));
            p3.add(pp5,"pp5");
            pp1.setVisible(true);
//            pp.show(p3,"pp1");
//            p3.setVisible(true);
//            jfra.setLocation(400,10);
//            jfra.setSize(760,480);
//            jfra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jfra.setContentPane(pane);
//            jfra.setVisible(true);//set frame visible
            System.out.println("Already searched through all passenger information.");
        }
        else if (e.getActionCommand().equals("SearchBaggage")) {
            PersonalController control = PersonalController.getController();
            System.out.println(SearchBag.getText());
            reservations =control.FilterByKeyword(control.getAllReservations(), SearchBag.getText());
            System.out.println(reservations);
            System.out.println(reservations.size());
//            System.out.println(Info[0][0]);
//            System.out.println(Info[0][1]);
//            System.out.println(Info[0][2]);
//            System.out.println(Info[0][3]);
//            System.out.println(Info[0][4]);
            Info2 = new String[reservations.size()][5];

//            System.out.println(passengers.get(0));
            for(int i = 0; i < reservations.size(); i++){
                Info2[i][0]=reservations.get(i).getFlightNum();
                System.out.println(reservations.get(i).getFlightNum());
                System.out.println(Info2[i][0]);
                Info2[i][1]=control.getPassengerInform(reservations.get(i).getBookingNum()).getFirstName()+" "+
                        control.getPassengerInform(reservations.get(i).getBookingNum()).getSurname();
                System.out.println(Info2[i][1]);
                Info2[i][2]=reservations.get(i).getIDNum();
                System.out.println(Info2[i][2]);
                Info2[i][3]=Integer.toString(reservations.get(i).getBaggageNum());
                System.out.println(Info2[i][3]);
                Info2[i][4]=Integer.toString(reservations.get(i).getBaggageWeight())+"kg";
                System.out.println(Info2[i][4]);
            }
            System.out.println(Info2);
            System.out.println("hello");

            BaggageInftable = new JTable(new MyTable1(Names2,Info2));
            BaggageInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
            JScrollPane s2 = new JScrollPane(BaggageInftable);

            j2p2.add(BaggageInftable.getTableHeader(),BorderLayout.NORTH);
            j2p2.add(BaggageInftable,BorderLayout.CENTER);
            j2p2.setVisible(true);
            pp2.add(j2p2,BorderLayout.CENTER);

            JPanel pp5 = new JPanel();
            pp5.add(new JLabel("hello"));
            p3.add(pp5,"pp5");
            pp2.setVisible(true);
//            pp.show(p3,"pp1");
//            p3.setVisible(true);
//            jfra.setLocation(400,10);
//            jfra.setSize(760,480);
//            jfra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jfra.setContentPane(pane);
//            jfra.setVisible(true);//set frame visible
            System.out.println("Already searched through all passenger information.");
        }
        else if (e.getActionCommand().equals("SearchMeal")) {
            PersonalController control = PersonalController.getController();
            System.out.println(SearchMeal.getText());
            reservations =control.FilterByKeyword(control.getAllReservations(), SearchMeal.getText());
            System.out.println(reservations);
            System.out.println(reservations.size());
//            System.out.println(Info[0][0]);
//            System.out.println(Info[0][1]);
//            System.out.println(Info[0][2]);
//            System.out.println(Info[0][3]);
//            System.out.println(Info[0][4]);
            Info3 = new String[reservations.size()][5];

//            System.out.println(passengers.get(0));
            for(int i = 0; i < reservations.size(); i++){
                Info3[i][0]=reservations.get(i).getFlightNum();
                System.out.println(reservations.get(i).getFlightNum());
                System.out.println(Info3[i][0]);
                Info3[i][1]=control.getPassengerInform(reservations.get(i).getBookingNum()).getFirstName()+" "+
                        control.getPassengerInform(reservations.get(i).getBookingNum()).getSurname();
                System.out.println(Info3[i][1]);
                Info3[i][2]=reservations.get(i).getGate();
                System.out.println(Info3[i][2]);
                Info3[i][3]=StringUtils.join(reservations.get(i).getStandardMeal(),",");
                System.out.println(Info3[i][3]);
                Info3[i][4]=StringUtils.join(reservations.get(i).getExtraMealName(),",");
                System.out.println(Info3[i][4]);
            }
            System.out.println(Info3);
            System.out.println("hello");

            MealInftable = new JTable(new MyTable1(Names3,Info3));
            MealInftable.setPreferredScrollableViewportSize(new Dimension(600,34));
            JScrollPane s3 = new JScrollPane(MealInftable);

            j3p2.add(MealInftable.getTableHeader(),BorderLayout.NORTH);
            j3p2.add(MealInftable,BorderLayout.CENTER);
            j3p2.setVisible(true);
            pp3.add(j3p2,BorderLayout.CENTER);

            JPanel pp5 = new JPanel();
            pp5.add(new JLabel("hello"));
            p3.add(pp5,"pp5");
            pp3.setVisible(true);
//            pp.show(p3,"pp1");
//            p3.setVisible(true);
//            jfra.setLocation(400,10);
//            jfra.setSize(760,480);
//            jfra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jfra.setContentPane(pane);
//            jfra.setVisible(true);//set frame visible
            System.out.println("Already searched through all passenger information.");
        }
        else ;


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
class MyTable1 extends AbstractTableModel
{
    String[] Names;
    String[][] Info;

    public MyTable1(){

    }
    public MyTable1(String[] names,String[][]info){
        Names = names;
        Info = info;
    }
    @Override
    public int getRowCount() {
        return Info.length;
    }

    @Override
    public int getColumnCount() {
        return Names.length;
    }

    public String getColumnName(int col){
        return Names[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return Info[rowIndex][columnIndex];
    }


}


