package coursework.UI;
import javax.swing.*;
import java.awt.*;

public class ExtraMenuList extends JPanel {
    JPanel panel1;
    JLabel label1;
    JPanel panel2;
    JPanel panel3;
    JLabel label2;
    JPanel panel4;
    JPanel panel5;
    JLabel label3;
    JPanel panel11;
    JPanel panel12;
    JCheckBox checkBox2;
    JButton button6;
    JPanel panel13;
    JCheckBox checkBox3;
    JButton button7;
    JPanel panel14;
    JCheckBox checkBox4;
    JButton button8;
    JPanel panel15;
    JLabel label4;
    JPanel panel16;
    JPanel panel17;
    JCheckBox checkBox5;
    JButton button9;
    JPanel panel18;
    JCheckBox checkBox6;
    JButton button10;
    JPanel panel19;
    JCheckBox checkBox7;
    JButton button11;
    JPanel panel20;
    JButton button12;

    public void ExtraMenuList() {
        panel1 = new JPanel();
        label1 = new JLabel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label2 = new JLabel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        label3 = new JLabel();
        panel11 = new JPanel();
        panel12 = new JPanel();
        checkBox2 = new JCheckBox();
        button6 = new JButton();
        panel13 = new JPanel();
        checkBox3 = new JCheckBox();
        button7 = new JButton();
        panel14 = new JPanel();
        checkBox4 = new JCheckBox();
        button8 = new JButton();
        panel15 = new JPanel();
        label4 = new JLabel();
        panel16 = new JPanel();
        panel17 = new JPanel();
        checkBox5 = new JCheckBox();
        button9 = new JButton();
        panel18 = new JPanel();
        checkBox6 = new JCheckBox();
        button10 = new JButton();
        panel19 = new JPanel();
        checkBox7 = new JCheckBox();
        button11 = new JButton();
        panel20 = new JPanel();
        button12 = new JButton();


        //=========this.panel============
        setBackground(Color.white);
        setLayout(new BorderLayout(5, 5));

        //==========panel1==============
        {
            panel1.setBackground(new Color(60, 100, 210));
            panel1.setLayout(new GridLayout(1, 1));
            //------label1----------
            label1.setText("  Extra Options - Extra Meals  ");
            label1.setForeground(Color.white);
            label1.setFont(new Font("", Font.BOLD, 15));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            panel1.add(label1);
        }
        add(panel1, BorderLayout.NORTH);

        //==========panel2==============
        {
            panel2.setLayout(new BorderLayout());
            panel2.setBackground(Color.white);
            //=========panel3=========
            {
                panel3.setBackground(Color.white);
                panel3.setLayout(new BorderLayout());
                //--------label2-----------
                label2.setText("You are given the option to choose special meal with gourmet menu.\n" +
                        "These require an extra price. Select the meal you want and click Ok.");
                label2.setFont(new Font("Dialog", Font.ITALIC, 10));
                panel3.add(label2, BorderLayout.CENTER);
            }
            panel2.add(panel3, BorderLayout.NORTH);

            //=========panel4==========
            {
                panel4.setBackground(Color.white);
                panel4.setForeground(Color.white);
                panel4.setLayout(new GridLayout(2, 4));

                //=========panel5=========
                {
                    panel5.setLayout(new BorderLayout());
                    panel5.setBackground(Color.white);
                    //------label3-------
                    label3.setText("  Staple Food  ");
                    label3.setFont(new Font("", Font.BOLD, 10));
                    panel5.add(label3, BorderLayout.WEST);

                    //=======panel11=========
                    {
                        panel11.setLayout(new GridLayout(1, 3));
                        panel11.setBackground(Color.white);

                        //=======panel12=========
                        {
                            panel12.setLayout(new BorderLayout());
                            panel12.setBackground(Color.white);

                            //------checkBox2----
                            checkBox2.setText("Tacco");
                            checkBox2.setHorizontalAlignment(SwingConstants.CENTER);
                            panel12.add(checkBox2, BorderLayout.SOUTH);

                            //------button6------
                            button6.setBackground(Color.white);
                            button6.setIcon(new ImageIcon("Imgs/Tacco.jpg"));
                            panel12.add(button6, BorderLayout.CENTER);
                        }
                        panel11.add(panel12);

                        //=======panel13=========
                        {
                            panel13.setLayout(new BorderLayout());
                            panel13.setBackground(Color.white);

                            //------checkBox3----
                            checkBox3.setText("Tiramisu Cake");
                            checkBox3.setHorizontalAlignment(SwingConstants.CENTER);
                            panel13.add(checkBox3, BorderLayout.SOUTH);

                            //------button7------
                            button7.setBackground(Color.white);
                            button7.setIcon(new ImageIcon("Imgs/Tiramisu Cake.jpg"));
                            panel13.add(button7, BorderLayout.CENTER);
                        }
                        panel11.add(panel13);

                        //=======panel14=========
                        {
                            panel14.setLayout(new BorderLayout());
                            panel14.setBackground(Color.white);

                            //------checkBox4----
                            checkBox4.setText("Cheese Lasagna");
                            checkBox4.setHorizontalAlignment(SwingConstants.CENTER);
                            panel14.add(checkBox4, BorderLayout.SOUTH);

                            //------button8------
                            button8.setBackground(Color.white);
                            button8.setIcon(new ImageIcon("Imgs/Cheese Lasagna.jpg"));
                            panel14.add(button8, BorderLayout.CENTER);
                        }
                        panel11.add(panel14);
                    }
                    panel5.add(panel11, BorderLayout.CENTER);
                }
                panel4.add(panel5);

                //=======panel15==========
                {
                    panel15.setBackground(Color.white);
                    panel15.setLayout(new BorderLayout());
                    //------label4------
                    label4.setText("       Drinks       ");
                    label4.setFont(new Font("", Font.BOLD, 10));
                    panel15.add(label4, BorderLayout.WEST);

                    //========panel16==========
                    panel16.setLayout(new GridLayout(1, 3));
                    {
                        //=====panel17========
                        {
                            panel17.setLayout(new BorderLayout());
                            panel17.setBackground(Color.white);

                            //-----checkBox5------
                            checkBox5.setHorizontalAlignment(SwingConstants.CENTER);
                            checkBox5.setText("Coffee Latte");
                            panel17.add(checkBox5, BorderLayout.SOUTH);

                            //-----button9-------
                            button9.setBackground(Color.white);
                            button9.setIcon(new ImageIcon("Imgs/Coffee Latte.jpg"));
                            panel17.add(button9, BorderLayout.CENTER);
                        }
                        panel16.add(panel17);

                        //=====panel18========
                        {
                            panel18.setLayout(new BorderLayout());
                            panel18.setBackground(Color.white);

                            //-----checkBox6------
                            checkBox6.setHorizontalAlignment(SwingConstants.CENTER);
                            checkBox6.setText("Shaken Tea Lemonade");
                            panel18.add(checkBox6, BorderLayout.SOUTH);

                            //-----button10-------
                            button10.setBackground(Color.white);
                            button10.setIcon(new ImageIcon("Imgs/Shaken Tea Lemonade.jpg"));
                            panel18.add(button10, BorderLayout.CENTER);
                        }
                        panel16.add(panel18);

                        //======== panel19 ========
                        {
                            panel19.setBackground(Color.white);
                            panel19.setLayout(new BorderLayout());

                            //---- checkBox7 ----
                            checkBox7.setText("Frappuccino");
                            checkBox7.setBackground(Color.white);
                            checkBox7.setHorizontalAlignment(SwingConstants.CENTER);
                            panel19.add(checkBox7, BorderLayout.SOUTH);

                            //---- button11 ----
                            button11.setBackground(Color.white);
                            button11.setIcon(new ImageIcon("Imgs/Frappuccino.jpg"));
                            panel19.add(button11, BorderLayout.CENTER);
                        }
                        panel16.add(panel19);
                    }
                    panel15.add(panel16, BorderLayout.CENTER);
                }
                panel4.add(panel15);
            }
            panel2.add(panel4,BorderLayout.CENTER);

            //=======panel20=============
            {
                panel20.setBackground(Color.white);
                panel20.setLayout(new GridLayout(1,1));
                //-----button12--------
                button12.setText("OK");
                button12.setBackground(Color.white);
                button12.setAlignmentX(0.5F);
                panel20.add(button12);
            }
            panel2.add(panel20,BorderLayout.SOUTH);
        }
        add(panel2,BorderLayout.CENTER);

    }

}



