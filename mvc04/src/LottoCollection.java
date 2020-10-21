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
      System.out.print("게임수를 입력하세요 = ");
      while(true) {

    	  try{
    		  int gameCount = scan.nextInt();
    		  for(int i = 0 ; i < gameCount; i++) {
    			  lotto();
    		  }
    		  
    		  System.out.print("계속 하시겠습니까? 1.계속  0.종료  >> ");
        	  
        	  int newGame = scan.nextInt();
        	  if(newGame == 1){
        		  System.out.print("게임수를 입력하세요 = ");
        	  } else if(newGame == 0) {
        		  System.out.println("게임을 종료합니다.");
        		  break;
        	  }
    	  }catch(InputMismatchException e){
    		  //e.printStackTrace(); 
    		  System.out.println("잘못된 입력값이 입력 되어 프로그램을 종료합니다.");  
    	  } catch(Exception e){
    		  //e.printStackTrace();
    		  System.out.println("잘못된 입력값이 입력 되어 프로그램을 종료합니다..");  
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