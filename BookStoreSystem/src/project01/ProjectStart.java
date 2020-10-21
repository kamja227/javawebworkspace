package project01;
import java.util.*;


public class ProjectStart {
   Scanner scan = new Scanner(System.in);
   ArrayList<ProjectVO>  memberList = new ArrayList<ProjectVO>();
   ArrayList<ProjectBookVO> bookList= new ArrayList<ProjectBookVO>();

   
   public ProjectStart() {
      
      //기본 Book 데이터 생성
   bookList.add(new ProjectBookVO(111,"백설공주","김뱃살",7));
   bookList.add(new ProjectBookVO(123,"신데렐라","슬리퍼",8));
   bookList.add(new ProjectBookVO(126,"여고괴담","김중딩",5));
   bookList.add(new ProjectBookVO(145,"피노키오","김구라",4));
   bookList.add(new ProjectBookVO(232,"해리포터","1톤트럭",1));

      //기본 Member 데이터 생성
   memberList.add(new ProjectVO("admin0000", "1234", "개똥", "010-1111-1111"));
   memberList.add(new ProjectVO("admin0001", "1111", "김개똥", "010-2222-2222"));
   memberList.add(new ProjectVO("admin0002", "2222", "박개똥", "010-3333-3333"));
   memberList.add(new ProjectVO("admin0003", "3333", "이개똥", "010-4444-4444"));

  
   System.out.println("=========================  도서 재고 관리 시스템  =============================");   
 
      int check = 0;
      ProjectVO newMember = new ProjectVO ();
      //문자열과 1,2 외의 오류를 잡기위해 한번에 잡기위해 try/catch문을   String 으로 대체 nextLine(); 
      String menu = "";
      while(true) {
         System.out.print("1: 신규회원 , 2: 기존회원   >> ");
            menu = scan.nextLine();
            if(menu.equals("1") || menu.equals("2")) break; // 1과 2 외에는 break ; 이 외의 숫자와 문자는 초기화면으로 이동
             else {
              System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
              System.out.println();
             }
      }
               int cnt = 0; // 회원 번호 // 자동으로 1씩 커짐 (회원번호로 회원수 확인가능 현재기능없음x)
               if(menu.equals("1")) {    

                  cnt++;
                  newMember.setUserNum(cnt);
                  //id 중복체크 
                  while(true) {
                     System.out.print("아이디를 입력하세요 >> ");
                     String id = scan.nextLine();
                     newMember.setUserId(id);
                     check = 0;
                     for(ProjectVO old  : memberList){
                        if(old.getUserId().equals(newMember.getUserId())) {
                           check++;
                           System.out.println("이미 존재하는 아이디 입니다. 다른 아이디를 입력해주세요.");
                        }
                     }
                     if(check == 0) break;
                  }
                  System.out.print("비밀번호를 입력하세요 >> ");
                  String pwd = scan.nextLine();
                  newMember.setUserPwd(pwd);
                  System.out.print("이름을 입력하세요 >> ");
                  String name = scan.nextLine();
                  newMember.setName(name);
                  //연락처 중복체크
                  while(true) {
                  System.out.print("연락처를 입력하세요 >> ");
                  String tel = scan.nextLine();
                  newMember.setTel(tel);
                  check = 0;
                  for(ProjectVO old  : memberList){
                     if(old.getTel().equals(newMember.getTel())) {
                        check++;
                        System.out.println("이미 존재하는 연락처 입니다. 연락처를 확인해주세요.");
                        }
                     }
                    if(check == 0) break;
                  }   

                  memberList.add(newMember);
                  
                  System.out.println("회원가입이 완료 되었습니다.");
                  System.out.println();
                  check++; //check 수가 1로 변하면서 반복문을 나감.
               }
               else if (menu.equals("2")){
                  int loginCnt=0;
                  
                  do {
                     ProjectVO findMember = new ProjectVO();
                  
                     System.out.print("아이디를 입력하세요 >> ");
                     String id = scan.nextLine();
                     findMember.setUserId(id);
                     System.out.print("비밀번호를를 입력하세요 >> ");
                     String pwd = scan.nextLine();
                     findMember.setUserPwd(pwd);
                     for(ProjectVO member : memberList) {
                        if(findMember.getUserId().equals(member.getUserId()) && findMember.getUserPwd().equals(member.getUserPwd())) {
                           check++; // check 수가 1로 변하면서 반복문을 나감.
                           System.out.println(findMember.getUserId() + "님이 로그인 하셨습니다.");
                           System.out.println();
                        }loginCnt=3; // 로그인 성공시 카운트수를 3으로 올려 브레이크 와 동일효과 메뉴목록으로 진행
                     }
                     if(check == 0 ) {
                        System.out.println("ID 또는 패스워드가 일치하지않습니다. 다시 로그인 해주세요.");
                        System.out.println();
                        loginCnt++;
                     }
                     if(loginCnt == 3)break;  
                  }while(true);   
               } else {}
         if(check > 0) { 
            do {   
               String mainmenu = conInput(" 메뉴( 0:회원목록,1:도서목록(검색),2:도서등록,3:수량수정,4:도서삭제,5:종료 ");
            if(mainmenu.equals("0")) {
               Member();
            }else if(mainmenu.equals("1")) {
                  LibraryList();                 
            }else if(mainmenu.equals("2")) {
               LibraryInsert();
            }else if (mainmenu.equals("3")) {
               LibraryEdit();
            }else if(mainmenu.equals("4")) {
              LibraryDelete();
            }else if(mainmenu.equals("5")) {
               System.out.println("프로그램이 종료되었습니다.");
               System.exit(5);   
            }else{
               System.out.println("메뉴를 잘못 선택하였습니다. 다시 선택하세요");
               System.out.println();
            }

         }while(true);
         
      }
   }
   public String conInput(String msg) {
      System.out.print(msg+"=  ");
      return scan.nextLine();
   }

   //회원 목록
   public void Member(){
      System.out.println("===============================================================================");
      System.out.println("id\t\t이름\t\t연락처");
      for(ProjectVO member : memberList) {
         System.out.print(member.getUserId() + " \t");
         System.out.print(member.getName() + "\t\t");
         System.out.print(member.getTel());
         System.out.println();
      }
      System.out.println("===============================================================================");
   }
   //도서 목록 메뉴
   public void LibraryList() {
      
      System.out.println("===============================================================================");
      System.out.print("도서번호\t도서명\t\t글쓴이\t\t재고수량\n");
      for(ProjectBookVO book : bookList) {
         System.out.print(book.getNum()+"\t\t"+book.getBookName()+"\t"+book.getWriter()+"\t\t"+book.getEa());
         System.out.println();         
      }
      System.out.println("===============================================================================");
      
      //목록메뉴 안 도서검색 추가
      int check = 0;
      String bookName = conInput("검색할 도서제목을 입력하세요 (메뉴로 나가기 : 아무키나 입력하세요) ");
      System.out.println("===============================================================================");
      for(ProjectBookVO book : bookList) {
         if(book.getBookName().equals(bookName)) { // 검색한 bookname과 VO안의 bookname을 비교
           check++; //check 수가 1로 변하면서 반복문을 나감.
           //book.print();
            break; // 다른 출력물이 출력되므로 break;
         }    
      }
      if (check == 0) { // check 가 0일시 일치하지않음으로 판단 메세지 출력
          System.out.println("해당 도서는 존재하지 않습니다. 메뉴로 이동합니다.");
          System.out.println();
       }
   }   

   // 도서 등록 메뉴
   public void LibraryInsert() {
    
     int num = -1;
      try {
         while(true) {
        	int check = 0;
            num = Integer.parseInt(conInput("도서번호")); 
            for(ProjectBookVO old  : bookList){
                if(old.getNum() == num ){
                   check++;         
                   System.out.println("이미 존재하는 도서번호 입니다. 도서번호를 확인해주세요.");
                   break;
                }
             }	
            if(check == 0) break;
         }
            String bookName = conInput("도서명");
            String Writer = conInput("글쓴이");
            int Ea = Integer.parseInt(conInput("남은수량"));
      
      ProjectBookVO vo= new ProjectBookVO(num,bookName,Writer,Ea);
      bookList.add(vo); //bookList = VO 내용글을 저장
             
         
      }catch(Exception e) {// int를 요구하는 스캐너의 문자열입력시 Exception 출력
         System.out.println("잘못된 입력방식입니다.");
         System.out.println();
      }
   }
   // 도서수량 수정

   public void LibraryEdit() {
      try {
      String bookName = conInput("도서제목");
      int check = 0;
      for(ProjectBookVO book : bookList) {
         if(book.getBookName().equals(bookName)) { // 검색한 bookname과 VO안의 bookname을 비교
            check++; //일치시 check 1증가 반복문 out
            int cnt = Integer.parseInt(conInput("수정할 수량을 입력하세요"));
            book.setEa(cnt);
         }
      }
      if (check == 0) {// check 가 0일시 일치하지않음으로 판단 메세지 출력
         System.out.println("해당 도서는 존재하지 않습니다.");
         System.out.println();
      }
      }catch(Exception e) {// int를 요구하는 스캐너의 문자열입력시 Exception 출력
         System.out.println("잘못된 입력방식입니다.");
         System.out.println();
      }
   }

//도서 삭제메뉴
  public void LibraryDelete() {
         String bookName = conInput("삭제할 도서제목을 입력하세요");
         int check = 0; 
         for(ProjectBookVO book : bookList) {
            if(book.getBookName().equals(bookName)) {
               check++; //일치시 check 1증가 반복문 out
               bookList.remove(book);
               System.out.println("해당 도서가 삭제되었습니다.");
               System.out.println();
               break; //삭제후 브레이크 
            }      
         }
         if (check == 0) {
            System.out.println("해당 도서는 존재하지 않습니다.");
            System.out.println();
         }
      }   
 
   public static void main(String[] args) {
      new ProjectStart();
   }
}