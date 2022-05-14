package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Passenger;
import coursework.Entity.Reservations;
import coursework.backend.dblayer.ReservationsManager;

import javax.lang.model.type.NullType;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;
import static coursework.UI.MyButtonListener.surnameStored;

public class Confirmations extends JPanel{
    JLabel heading3;
    JList list1;
    JList list2;
    JList list3;
    JLabel heading4;
    JButton confirm;


    public Confirmations(JFrame jfra){
        PersonalController control = PersonalController.getController();
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
        int[] rows1 = {0,1,2};
        list1.setCellRenderer(new MyRenderer(rows1,Color.white));
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
        int[] rows2 = {0,1,2,3};
        list2.setCellRenderer(new MyRenderer(rows2,Color.white));
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
        int rows3[]={0,1,2,3,4,5,7,8};
        list3.setCellRenderer(new MyRenderer(rows3,Color.white));

        JPanel p1 = new JPanel();
        p1.setBorder(new MyLineBorder(Color.white,8,true));

        p1.setBackground(new Color(60,100,210));
        p1.setLayout(new BorderLayout());
        p1.add(heading3,BorderLayout.NORTH);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1,2));
        JPanel p22 = new JPanel();
        p22.setLayout(new GridLayout(2,1));
        p22.add(list1);
        p22.add(list2);
        p2.add(p22);
        p2.add(list3);

        p1.add(p2,BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.setBackground(Color.white);
        this.add(p1,BorderLayout.NORTH);

        JPanel p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        p3.setBackground(Color.white);

        JPanel p3_1 = new JPanel();
        p3_1.setBackground(Color.white);
        confirm = new JButton("Confirm to print");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int getoption=JOptionPane.showConfirmDialog(null,"Have you confirmed all information are correct?");
                if(getoption == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "You have already finish, go back to the main panel...");
                    JFrameTest3 frame1 = new JFrameTest3();
                    jfra.setVisible(false);
                    frame1.setVisible(true);
                }

            }
        });
        p3_1.add(confirm);
        p3.add(p3_1,BorderLayout.NORTH);
        this.add(p3,BorderLayout.CENTER);

    }
}

class MyLineBorder extends LineBorder{

    public MyLineBorder(Color color, int thickness, boolean roundedCorners) {
        super(color, thickness, roundedCorners);
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color oldColor = g.getColor();
        Graphics2D g2 = (Graphics2D)g;
        int i;
        g2.setRenderingHints(rh);
        g2.setColor(lineColor);
        for(i = 0; i < thickness; i++)  {
            if (roundedCorners) {
                g2.setStroke(new BasicStroke(thickness));
                g2.drawRoundRect(x, y, width, height, 20, 20);
            }
            else
                g2.drawRect(x, y, width, height);//实际中此循环语句需要修改
        }
        g2.setColor(oldColor);
    }
}

class MyRenderer extends DefaultListCellRenderer {

    private Font font1;
    private Font font2;
    private Color rowcolor;
    private int row;
    private int[] rows;

    public MyRenderer() {
        this.font1 = getFont();
        this.font2 = font1.deriveFont((float) (font1.getSize() + 10));
    }

    public MyRenderer(int row, Color color) {
        this.rowcolor = color;
        this.row = row;
    }

    public MyRenderer(int[] rows, Color color) {
        this.rowcolor = color;
        this.rows = rows;
    }

    public Component getListCellRendererComponent(JList list, Object value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (rows==null) {
            if (index == row) {
                setBackground(this.rowcolor);
                setFont(getFont().deriveFont((float) (getFont().getSize() + 2)));
            }
        } else {
            for (int i = 0; i < rows.length; i++) {
                if (index == rows[i]) {
                    setBackground(this.rowcolor);
                    setFont(getFont().deriveFont((float) (getFont().getSize() + 2)));
                }
            }
        }

        return this;
    }
}
