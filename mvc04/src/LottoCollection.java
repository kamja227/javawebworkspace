import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.TreeSet;
import java.util.Set;

public class LottoCollection {

   public LottoCollection() {      
   }   
   public void gameCount() {
      Scanner scan = new Scanner(System.in);
      System.out.print("���Ӽ��� �Է��ϼ��� = ");
      while(true) {

    	  try{
    		  int gameCount = scan.nextInt();
    		  for(int i = 0 ; i < gameCount; i++) {
    			  lotto();
    		  }
    		  
    		  System.out.print("��� �Ͻðڽ��ϱ�? 1.���  0.����  >> ");
        	  
        	  int newGame = scan.nextInt();
        	  if(newGame == 1){
        		  System.out.print("���Ӽ��� �Է��ϼ��� = ");
        	  } else if(newGame == 0) {
        		  System.out.println("������ �����մϴ�.");
        		  break;
        	  }
    	  }catch(InputMismatchException e){
    		  //e.printStackTrace(); 
    		  System.out.println("�߸��� �Է°��� �Է� �Ǿ� ���α׷��� �����մϴ�.");  
    	  } catch(Exception e){
    		  //e.printStackTrace();
    		  System.out.println("�߸��� �Է°��� �Է� �Ǿ� ���α׷��� �����մϴ�..");  
    	  } 
   
      }
     
   }
   
   public void lotto() {
      
      Set<Integer> num = new TreeSet<>();
   
      while(true) {
         int ran = (int)(Math.random()*45+1);
         if(num.add(ran)) {
            if(num.size()==6) {
               break;
            }
         }
      }
      System.out.println(num);
      
   }
   public static void main(String[] args) {
      new LottoCollection().gameCount();
      

   }

}