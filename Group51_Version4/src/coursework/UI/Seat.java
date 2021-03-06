package coursework.UI;

import coursework.Controller.PersonalController;
import coursework.Controller.SeatController;
import coursework.Entity.Reservations;
import coursework.backend.dblayer.SeatManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;


public class Seat extends MouseAdapter{

//	public static int confirmSeat = 0;
JButton btns1[];
	int num1;
	int state1=-1;
	String option="";
	int confirmSeat;
	SeatController seatcontrol = SeatController.getController();
	public void Seat1(JPanel t2){
		num1 =60;
		ImageIcon icon = new ImageIcon("./Imgs/seat.png");

		JPanel pans1[] = new JPanel[num1];
		JPanel p = new JPanel();
		p.setBackground(Color.white);
		p.setPreferredSize(new Dimension(400,800));
		p.setOpaque(true);
		btns1 = new JButton[num1];
		p.setLayout(new GridLayout(10,6));

		for (int i = 0; i <num1; i++) {
			String seat1;
			int number1=i/6+1;
			if((i+1)%6==1){
				seat1= number1+"A";}
			else if((i+1)%6==2){
				seat1= number1+"B";}
			else if((i+1)%6==3){
				seat1= number1+"C";}
			else if((i+1)%6==4){
				seat1= number1+"D";}
			else if((i+1)%6==5){
				seat1= number1+"E";}
			else{
				seat1= number1+"F";}

			btns1[i] = new JButton();
			btns1[i].setSize(38, 34);

			Image temp = icon.getImage().getScaledInstance(btns1[i].getWidth(),
					btns1[i].getHeight(), icon.getImage().SCALE_DEFAULT);
			icon = new ImageIcon(temp);
			btns1[i] = new JButton(seat1,icon);
			btns1[i].setHorizontalTextPosition(SwingConstants.CENTER);
			pans1[i] = new JPanel();
			pans1[i].setBackground(Color.white);
			pans1[i].setOpaque(true);

			btns1[i].setBackground(new Color(91,155,244));
			btns1[i].setForeground(Color.white);
			btns1[i].setFont(new Font("",Font.BOLD,11));
			btns1[i].setOpaque(true);
			btns1[i].setBorderPainted(false);
			btns1[i].setContentAreaFilled(true);
			btns1[i].addMouseListener(this);
			pans1[i].add(btns1[i]);

			p.add(pans1[i]);
		}


		JScrollPane jsp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setViewportView(p);
		jsp.setPreferredSize(new Dimension(450,380));
		jsp.setBackground(Color.white);
		t2.add(jsp);

		for (int i = 0; i <num1; i++) {

			if(seatcontrol.getStatusBySeat(btns1[i].getText()).getStatus()){
				btns1[i].setBackground(new Color(135,135,135));
				btns1[i].setBorderPainted(false);

			}

		}



	}

	public void mouseClicked(MouseEvent e){
        //Botton list1

		for(int i = 0; i <num1; i++){

		    if(e.getSource()==btns1[i]){
				if(state1==-1){
					if(seatcontrol.getStatusBySeat(btns1[i].getText()).getStatus()){

					}
					else{
						btns1[i].setBackground(new Color(27,64,170));
						btns1[i].setBorderPainted(false);

						state1=i;
						option=btns1[i].getText();

					}
				}
				else if(state1==i){
					if(seatcontrol.getStatusBySeat(btns1[i].getText()).getStatus()){

					}
					else {
						btns1[state1].setBackground(new Color(91,155,244));
						btns1[state1].setBorderPainted(false);

						state1 = -1;
						option = "";
					}
				}
				else{
					if(seatcontrol.getStatusBySeat(btns1[i].getText()).getStatus()){

					}
					else {
						btns1[state1].setBackground(new Color(91,155,244));

						btns1[state1].setBorderPainted(false);
						btns1[i].setBackground(new Color(27, 64, 170));

						btns1[i].setBorderPainted(false);
						state1 = i;
						option = btns1[i].getText();
					}
				}
		    }
			
			
		}

		}
		public void Action(JButton b1,MyBooking myBooking) {
			b1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String seat =option;
					if(seat!=""){
						int getOption= JOptionPane.showConfirmDialog(null, "Please make sure that the seat number you choose is:  "+
								"\n\n Seat :  "+seat );
						if(getOption == JOptionPane.YES_OPTION){
							PersonalController control = PersonalController.getController();
							SeatController seatcontrol = SeatController.getController();
							if(bookingNumberStored!=null){
								Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
								coursework.Entity.Seat seats = seatcontrol.getStatusBySeat(option);
								reservations.setGate(seat);
								seats.setStatus(true);
								control.updateReservations(reservations);
								seatcontrol.updateSeats(seats);
								myBooking.moveToPage("pp3");
							}else if (IDnumStored!=null) {
								Reservations reservations = control.getReservationsInformByID(IDnumStored);
								coursework.Entity.Seat seats = seatcontrol.getStatusBySeat(option);
								reservations.setGate(seat);
								seats.setStatus(true);
								control.updateReservations(reservations);
								seatcontrol.updateSeats(seats);
								myBooking.moveToPage("pp3");
							}
						}else{

						}
					}else{
						JOptionPane.showMessageDialog(null, "You don't select any gate please choose again!" );
					}

				}
			});
		}

    

}