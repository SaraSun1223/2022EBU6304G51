package coursework.UI;
import coursework.Controller.PersonalController;
import coursework.Entity.Reservations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static coursework.UI.ButtonListener2test.bookingNumberStored;
import static coursework.UI.MyButtonListener.IDnumStored;


public class Seat extends MouseAdapter{

//	public static int confirmSeat = 0;
	JButton btns1[];
	int num1;
	int state1=-1;
	String option="";
    public void Seat1(JPanel t2){
        num1 =60;
	    JPanel pans1[] = new JPanel[num1];
        btns1 = new JButton[num1];		
        t2.setLayout(new GridLayout(10,6));
		
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
            btns1[i] = new JButton(seat1);   
            pans1[i] = new JPanel();
            btns1[i].setSize(5, 5);
            btns1[i].setBackground(new Color(60,100,210));
            btns1[i].setForeground(Color.white);
			btns1[i].addMouseListener(this);
            pans1[i].add(btns1[i]);
			t2.add(pans1[i]); 
		}
    }

	public void mouseClicked(MouseEvent e){
        //Botton list1
		for(int i = 0; i <num1; i++){
		    if(e.getSource()==btns1[i]){
				if(state1==-1){
			        btns1[i].setBackground(new Color(55,45,140));
				    state1=i;
					option=btns1[i].getText();
				}
				else if(state1==i){
					btns1[state1].setBackground(new Color(60,100,210));
					state1=-1;
					option="";
				}
				else{
			        btns1[state1].setBackground(new Color(60,100,210));
					btns1[i].setBackground(new Color(55,45,140));
				    state1=i;
					option=btns1[i].getText();
				}
		    }
			
			
		}
		}
		public void Action(JButton b1) {
			b1.addActionListener(new ActionListener() {
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
								control.updateReservations(reservations);
							}else if (IDnumStored!=null) {
								Reservations reservations = control.getReservationsInformByID(IDnumStored);
								reservations.setGate(seat);
								control.updateReservations(reservations);
							}
//							confirmSeat =  1;
						}else{

						}
					}else{
						JOptionPane.showMessageDialog(null, "You don't select any gate please choose again!" );
					}

				}
			});
		}
		
    

}