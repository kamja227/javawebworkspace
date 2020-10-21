package jSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGB extends JFrame implements ChangeListener{
   
      Font fnt = new Font ("絡遺羹",Font.BOLD,30);
      Color c = new Color(125,125,125);
    
      JPanel northPane = new JPanel();
         JLabel title = new JLabel(getTitle());
      JPanel centerPane = new JPanel();
//         JLabel color = new JLabel("");
      JPanel aaa = new JPanel (new BorderLayout());
            JLabel subTitle = new JLabel ("收收收收收收收收收收收收收收收收  Color Slider  收收收收收收收收收收收收收收收收",JLabel.CENTER);
            JPanel subTitle2 = new JPanel(new GridLayout(3,0));
               JLabel redTxt = new JLabel("Red",JLabel.CENTER);
               JLabel greenTxt = new JLabel("Green",JLabel.CENTER);
               JLabel blueTxt = new JLabel("Blue",JLabel.CENTER);
            JPanel southPane = new JPanel(new GridLayout(3,0));
               JSlider red = new JSlider(0,255,125);
               JSlider green = new JSlider(0,255,125);
               JSlider blue = new JSlider(0,255,125);
            JPanel backGround = new JPanel(new GridLayout(3,0));   
               JLabel redBack = new JLabel();
               JLabel greenBack = new JLabel();
               JLabel blueBack = new JLabel();
         
      public RGB() {   
         super("RGB(125, 125, 125)");
       
         title.setFont(fnt);
         northPane.add(title);
         add(northPane, BorderLayout.NORTH);

         //color.setForeground(Color.RED);
         //color.setForeground(Color.green);
         //color.setForeground(Color.blue);
         
//         color.setBackground(Color.RED);
         //color.setOpaque(true);
         //color.setBackground(new Color(r,g,b));
         centerPane.setBackground(c);
        
//         centerPane.add(color);
         add(centerPane, BorderLayout.CENTER);
          
         
         red.setPaintLabels(true); //塭漣
         red.setPaintTicks(true); 
         red.setMinorTickSpacing(10); //濛擎換旎 
         red.setMajorTickSpacing(50); //贖換旎 
         red.setOpaque(true);
         green.setPaintLabels(true);
         green.setPaintTicks(true);
         green.setMinorTickSpacing(10);
         green.setOpaque(true);
         green.setMajorTickSpacing(50);
         blue.setPaintLabels(true);
         blue.setPaintTicks(true);
         blue.setMinorTickSpacing(10);
         blue.setMajorTickSpacing(50);
         blue.setOpaque(true);
         
         
         redBack.setBackground(bg);
         add(aaa, BorderLayout.SOUTH);
            aaa.add(subTitle,BorderLayout.NORTH);
            aaa.add(subTitle2,BorderLayout.WEST);
               subTitle2.add(redTxt);subTitle2.add(greenTxt);subTitle2.add(blueTxt);
            aaa.add(southPane,BorderLayout.CENTER);
               southPane.add(red);southPane.add(green);southPane.add(blue);
            aaa.add(backGround,BorderLayout.EAST);
               backGround.add(redBack);backGround.add(greenBack);backGround.add(blueBack);
               
            //   add(southPane, BorderLayout.SOUTH);
         setSize(500,400);
         setVisible(true);
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         
         //螃幗塭檜註 
         red.addChangeListener(this);
         green.addChangeListener(this);
         blue.addChangeListener(this);
      }
      
      public void stateChanged(ChangeEvent e) {
         int r = red.getValue();
         int g = green.getValue();
         int b = blue.getValue();
         
         Object obj = e.getSource();
         JSlider event = (JSlider)obj;
         if(event.equals(red)) {
            r = red.getValue();
         }else if (event.equals(green)) {
        	 g = green.getValue();
         }else if(event.equals(blue)) {
        	 b = blue.getValue();
         }

         centerPane.setBackground(new Color(r,g,b));
//         c = new Color(r,g,b);
//         centerPane.setBackground(c);
         title.setText("RGB(" + r + ", " + g + ", " + b + ")");
      }
      
      public void titleName() {
         
      }

      public static void main(String[] args) {
         new RGB();

      }

   }