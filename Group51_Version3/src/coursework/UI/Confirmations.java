package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Passenger;
import coursework.Entity.Reservations;
import coursework.backend.dblayer.ReservationsManager;

import javax.lang.model.type.NullType;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.Iterator;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;
import static coursework.UI.MyButtonListener.surnameStored;

public class Confirmations extends JPanel{
    JLabel heading3;
    JList list1;
    JList list2;
    JList list3;
    JLabel heading4;



    public Confirmations(){
//        String[] reservationsInfo = new String[12];
        PersonalController control = PersonalController.getController();
//
//        try {
//            reservationsInfo = control.getReservationsInfbyBookingnum(bookingNumberStored).confirmationPrint();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        heading3 = new JLabel("Confirm to print----Details of Scheduled Flight:  ");
        heading3.setForeground(Color.white);
        heading3.setFont(new Font("", Font.BOLD, 15));

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

        //---------list3--------
        list3 = new JList<>();
        if(bookingNumberStored!=null){
            list3.setModel(new AbstractListModel<String>() {
            String[] value = control.getReservationsInfbyBookingnum(bookingNumberStored).confirmationPrint();

            @Override
            public int getSize() {
                return value.length;
            };

            @Override
            public String getElementAt(int i) {
                return value[i];
            }
        });}else if (IDnumStored!=null){
            list3.setModel(new AbstractListModel<String>() {
                String[] value = control.getReservationsInformByID(IDnumStored).confirmationPrint();

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


        JPanel p1 = new JPanel();
        p1.setBackground(new Color(60,100,210));
        p1.setLayout(new BorderLayout());
        p1.add(heading3,BorderLayout.NORTH);
        JPanel p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setLayout(new GridLayout(1,2));
        JPanel p22 = new JPanel();
        p22.setLayout(new GridLayout(2,1));
        p22.add(list1);
        p22.add(list2);
        p2.add(list3);
        p2.add(p22);

        p1.add(p2,BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.add(p1,BorderLayout.NORTH);

        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.white);

//        JPanel p3_1 = new JPanel();
//        p3_1.setLayout(new BorderLayout());
//        p3_1.setBackground(new Color(60,100,210));
//        heading4 = new JLabel("Details of meal:");
//        heading4.setForeground(Color.white);
//        heading4.setFont(new Font("", Font.BOLD, 15));
//        p3_1.add(heading4,BorderLayout.NORTH);
//        p3.add(p3_1,BorderLayout.NORTH);
        this.add(p3,BorderLayout.CENTER);

    }
}