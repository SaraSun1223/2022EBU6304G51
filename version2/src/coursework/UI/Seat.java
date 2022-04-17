package coursework.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Seat extends MouseAdapter{
	JButton btns1[];
	int num1;
	int state1=-1;
	
	JButton btns2[];
	int num2;
	int state2=-1;
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
	public void Seat2(JPanel t2){
        int num2 =40;
	    JPanel pans2[] = new JPanel[num2];
        JButton btns2[] = new JButton[num2];		
        t2.setLayout(new GridLayout(10,4));
		
        for (int i = 0; i <num2; i++) {
            String seat2;
			int number2=i/4+1;
			if((i+1)%4==1){
			    seat2= number2+"A";}
			else if((i+1)%4==2){
			    seat2= number2+"B";}
			else if((i+1)%4==3){
			    seat2= number2+"C";}	
			else{
			    seat2= number2+"D";}
			
            btns2[i] = new JButton(seat2);   
            pans2[i] = new JPanel();
            btns2[i].setSize(5, 5);
            btns2[i].setBackground(new Color(170,100,110));
            btns2[i].setForeground(Color.white);
			btns2[i].addMouseListener(this);
            pans2[i].add(btns2[i]);
			t2.add(pans2[i]); 
			
		}
    }
	public void mouseClicked(MouseEvent e){
        //Botton list1
		for(int i = 0; i <num1; i++){
		    if(e.getSource()==btns1[i]){
				if(state1==-1){
			        btns1[i].setBackground(new Color(55,45,140));
				    state1=i;
				}
				else if(state1==i){
					btns1[state1].setBackground(new Color(60,100,210));
					state1=-1;
				}
				else{
			        btns1[state1].setBackground(new Color(60,100,210));
					btns1[i].setBackground(new Color(55,45,140));
				    state1=i;
				}
		    }
			
			
		}
		for(int j = 0; j <num2; j++){
		    if(e.getSource()==btns2[j]){
				if(state2==-1){
			        btns2[j].setBackground(new Color(55,45,140));
				    state2=j;
				}
				else if(state2==j){
					btns2[state2].setBackground(new Color(170,100,110));
					state2=-1;
				}
				else{
			        btns2[state2].setBackground(new Color(170,100,110));
					btns2[j].setBackground(new Color(55,45,140));
				    state2=j;
				}
		    }
		}
		}
		//Botton list2
		
		
    

}