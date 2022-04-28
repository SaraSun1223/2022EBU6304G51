package coursework.UI;
import coursework.Controller.PersonalController;
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
	public void Seat2(JPanel t2){

        num =40;
	    JPanel pans[] = new JPanel[num];
        btns = new JButton[num];		
        t2.setLayout(new GridLayout(10,4));
		
        for (int i = 0; i <num; i++) {
            String seat;
			int number=i/4+1;
			if((i+1)%4==1){
			    seat= number+"A";}
			else if((i+1)%4==2){
			    seat= number+"B";}
			else if((i+1)%4==3){
			    seat= number+"C";}	
			
			else{
			    seat= number+"D";}
            btns[i] = new JButton(seat);   
            pans[i] = new JPanel();
            btns[i].setSize(5, 5);
            btns[i].setBackground(new Color(170,100,110));
            btns[i].setForeground(Color.white);
			btns[i].addMouseListener(this);
            pans[i].add(btns[i]);
			t2.add(pans[i]); 
			
			
		}
    }
	public void mouseClicked(MouseEvent e){
        //Botton list
		for(int i = 0; i <num; i++){
		    if(e.getSource()==btns[i]){
				if(state==-1){
			        btns[i].setBackground(new Color(55,45,140));
				    state=i;
					option=btns[i].getText();
				}
				else if(state==i){
					btns[state].setBackground(new Color(170,100,110));
					state=-1;
					option="";
				}
				else{
			        btns[state].setBackground(new Color(170,100,110));
					btns[i].setBackground(new Color(55,45,140));
				    state=i;
					option=btns[i].getText();
				}
		    }
		}
		}


	public void Action(JButton b2) {
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String seat =option;
				if(seat!=""){
					int getOption= JOptionPane.showConfirmDialog(null, "Please make sure that the seat number you choose is:  "+
							"\n\n Seat :  "+seat );
					if(getOption == JOptionPane.YES_OPTION){
						PersonalController control = PersonalController.getController();
						if(bookingNumberStored!=null){
							Reservations reservations = control.getReservationsInfbyBookingnum(bookingNumberStored);
							reservations.setGate(seat);
							reservations.setIfExtraRoom(true);
							control.updateReservations(reservations);
						}else if (IDnumStored!=null) {
							Reservations reservations = control.getReservationsInformByID(IDnumStored);
							reservations.setGate(seat);
							reservations.setIfExtraRoom(true);
							control.updateReservations(reservations);
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
						}else if (IDnumStored!=null) {
							Reservations reservations = control.getReservationsInformByID(IDnumStored);
							reservations.setIfExtraRoom(false);
							control.updateReservations(reservations);
						}
					}else{

					}
				}
			}
		});
	}
}