package coursework.UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ExtraSeat extends MouseAdapter{
	
	JButton btns[];
	int num;
	int state=-1;
    
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
        //Botton list1
		//Botton list2
		for(int i = 0; i <num; i++){
		    if(e.getSource()==btns[i]){
				if(state==-1){
			        btns[i].setBackground(new Color(55,45,140));
				    state=i;
				}
				else if(state==i){
					btns[state].setBackground(new Color(170,100,110));
					state=-1;
				}
				else{
			        btns[state].setBackground(new Color(170,100,110));
					btns[i].setBackground(new Color(55,45,140));
				    state=i;
				}
		    }
		}
		}
		
		
		
    

}