package java08_swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Packman extends JFrame implements KeyListener{
   
   Image img;
   int x = 0, y = 0, pack = 1;
   
   public Packman() {
      super("팩맨");
      setIconImage(Toolkit.getDefaultToolkit().getImage("img/left1.png"));
      
      x = this.getWidth()/2;
      y = this.getHeight()/2;
      addKeyListener(this);
            
      setLayout(null);
      setResizable(false);
      setBounds(300, 300, 400, 400);
      setBackground(Color.WHITE);
      setVisible(true);
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);

   }
      public void paint (Graphics g) { 
         switch (pack) {
         case 1:
         img = Toolkit.getDefaultToolkit().getImage("img/right0.png");
         break;
         case 2:
         img = Toolkit.getDefaultToolkit().getImage("img/right1.png");
         break;
         case 3:
         img = Toolkit.getDefaultToolkit().getImage("img/left0.png");
         break;
         case 4:
         img = Toolkit.getDefaultToolkit().getImage("img/left1.png");
         break;
         case 5:
         img = Toolkit.getDefaultToolkit().getImage("img/down0.png");
         break;
         case 6:
         img = Toolkit.getDefaultToolkit().getImage("img/down1.png");
         break;
         case 7:
         img = Toolkit.getDefaultToolkit().getImage("img/up0.png");
         break;
         case 8:
         img = Toolkit.getDefaultToolkit().getImage("img/up1.png");
         break;
         }
      }      
         
   public void keyPressed(KeyEvent ke) {
      int key = ke.getKeyCode();
      if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D){
         System.out.println("right");
            //1~2 번갈아가면서 이미지 
      }else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
         System.out.println("left");
            //3~4 번갈아가면서 이미지
      }else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
         System.out.println("up");
            //5~6 번갈아거면서 이미지
      }else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
         System.out.println("down");
            //7~8 번갈아가면서 이미지
      }repaint();
      
   }

   public static void main(String[] args) {
      new Packman();
   }
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
}