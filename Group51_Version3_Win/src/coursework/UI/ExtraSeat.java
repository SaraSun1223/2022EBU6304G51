package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Controller.SeatController;
import coursework.Entity.Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;

public class ExtraSeat extends MouseAdapter{

	JButton btns[];

	int num;

	int state=-1;
	String option="";
	SeatController seatcontrol = SeatController.getController();
	public void Seat2(JPanel t2){

		num =40;
		JPanel pans[] = new JPanel[num];
		btns = new JButton[num];
		ImageIcon icon = new ImageIcon("./Imgs/seat.png");
		JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(280,800));
		p.setLayout(new GridLayout(10,4));

		for (int i = 0; i <num; i++) {
			String seat;
			int number=i/4+1;
			if((i+1)%4==1){
				seat= "S"+number+"A";}
			else if((i+1)%4==2){
				seat= "S"+number+"B";}
			else if((i+1)%4==3){
				seat= "S"+number+"C";}
			else{
				seat= "S"+number+"D";}
			btns[i] = new JButton();
			btns[i].setSize(45, 45);
			Image temp = icon.getImage().getScaledInstance(btns[i].getWidth(),
					btns[i].getHeight(), icon.getImage().SCALE_DEFAULT);
			icon = new ImageIcon(temp);
			btns[i] = new JButton(seat,icon);
			btns[i].setHorizontalTextPosition(SwingConstants.CENTER);
			pans[i] = new JPanel();
			pans[i] = new JPanel();

			btns[i].setBackground(new Color(170,100,110));
			btns[i].setForeground(Color.white);
			btns[i].addMouseListener(this);
			pans[i].add(btns[i]);
			p.add(pans[i]);


		}
		JScrollPane jsp = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setViewportView(p);
		jsp.setPreferredSize(new Dimension(320,380));
		t2.add(jsp);
		for (int i = 0; i <num; i++) {

			if(seatcontrol.getStatusBySeat(btns[i].getText()).getStatus()){
				btns[i].setBackground(new Color(120, 120, 120));
			}

		}
	}
	public void mouseClicked(MouseEvent e){
		//Botton list
		for(int i = 0; i <num; i++){
			if(e.getSource()==btns[i]){
				if(state==-1){
					if(seatcontrol.getStatusBySeat(btns[i].getText()).getStatus()){

					}
					else{
						btns[i].setBackground(new Color(55,45,140));
						state=i;
						option=btns[i].getText();

					}
				}
				else if(state==i){
					if(seatcontrol.getStatusBySeat(btns[i].getText()).getStatus()){

					}
					else {
						btns[state].setBackground(new Color(170,100,110));
						state = -1;
						option = "";
					}
				}
				else{
					if(seatcontrol.getStatusBySeat(btns[i].getText()).getStatus()){

					}
					else {
						btns[state].setBackground(new Color(170,100,110));
						btns[i].setBackground(new Color(55, 45, 140));
						state = i;
						option = btns[i].getText();
					}
				}
			}
		}
	}


	public void Action(JButton b2, MyBooking myBooking) {
		b2.addActionListener(new ActionListener() {
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
							reservations.setIfExtraRoom(true);
							seats.setStatus(true);
							control.updateReservations(reservations);
							seatcontrol.updateSeats(seats);
							myBooking.confirmationUpdate();
							myBooking.moveToPage("pp6");
						}else if (IDnumStored!=null) {
							Reservations reservations = control.getReservationsInformByID(IDnumStored);
							coursework.Entity.Seat seats = seatcontrol.getStatusBySeat(option);
							reservations.setGate(seat);
							reservations.setIfExtraRoom(true);
							seats.setStatus(true);
							control.updateReservations(reservations);
							seatcontrol.updateSeats(seats);
							myBooking.confirmationUpdate();
							myBooking.moveToPage("pp6");
						}
					}else{

					}
				}else{
					int getOption= JOptionPane.showConfirmDialog(null, "Do you confirm not to choose the seat with extra room?" );
					if(getOption == JOptionPane.YES_OPTION){
						PersonalController control = PersonalController.getController();
						if(bookingNumberStored!=null){
							Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
							reservations.setIfExtraRoom(false);
							control.updateReservations(reservations);
							myBooking.confirmationUpdate();
							myBooking.moveToPage("pp6");
						}else if (IDnumStored!=null) {
							Reservations reservations = control.getReservationsInformByID(IDnumStored);
							reservations.setIfExtraRoom(false);
							control.updateReservations(reservations);
							myBooking.confirmationUpdate();
							myBooking.moveToPage("pp6");
						}
					}else{

					}
				}
			}
		});
	}
}