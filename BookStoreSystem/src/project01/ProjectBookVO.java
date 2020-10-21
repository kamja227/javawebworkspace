package project01;

import java.util.ArrayList;
import java.util.List;

public class ProjectBookVO {
   public int num; //도서번호
   public String bookName;
   public String Writer;//글쓴이
   public int Ea;// 수량 
   
   public ProjectBookVO() {
   }
   public ProjectBookVO(int num , String bookName, String Writer, int Ea) {
      this.num=num;
      this.bookName=bookName;
      this.Writer=Writer;
      this.Ea=Ea;
   }
 
   public void bookOutput() {
      System.out.printf("%6d %10s %10s %6s \n",num,bookName,Writer,Ea,"\n");
   }
   public int getNum() {
      return num;
   }
   public void setNum(int num) {
      this.num = num;
   }
   public String getBookName() {
      return bookName;
   }
   public void setBookName(String bookName) {
      this.bookName = bookName;
   }
   public String getWriter() {
      return Writer;
   }
   public void setBookMaker(String bookMaker) {
      this.Writer = Writer;
   }
   public int getEa() {
      return Ea;
   }
   public void setEa(int Ea) {
      this.Ea = Ea;
   }
  
}