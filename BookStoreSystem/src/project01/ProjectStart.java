package project01;
import java.util.*;


public class ProjectStart {
   Scanner scan = new Scanner(System.in);
   ArrayList<ProjectVO>  memberList = new ArrayList<ProjectVO>();
   ArrayList<ProjectBookVO> bookList= new ArrayList<ProjectBookVO>();

   
   public ProjectStart() {
      
      //�⺻ Book ������ ����
   bookList.add(new ProjectBookVO(111,"�鼳����","����",7));
   bookList.add(new ProjectBookVO(123,"�ŵ�����","������",8));
   bookList.add(new ProjectBookVO(126,"������","���ߵ�",5));
   bookList.add(new ProjectBookVO(145,"�ǳ�Ű��","�豸��",4));
   bookList.add(new ProjectBookVO(232,"�ظ�����","1��Ʈ��",1));

      //�⺻ Member ������ ����
   memberList.add(new ProjectVO("admin0000", "1234", "����", "010-1111-1111"));
   memberList.add(new ProjectVO("admin0001", "1111", "�谳��", "010-2222-2222"));
   memberList.add(new ProjectVO("admin0002", "2222", "�ڰ���", "010-3333-3333"));
   memberList.add(new ProjectVO("admin0003", "3333", "�̰���", "010-4444-4444"));

  
   System.out.println("=========================  ���� ��� ���� �ý���  =============================");   
 
      int check = 0;
      ProjectVO newMember = new ProjectVO ();
      //���ڿ��� 1,2 ���� ������ ������� �ѹ��� ������� try/catch����   String ���� ��ü nextLine(); 
      String menu = "";
      while(true) {
         System.out.print("1: �ű�ȸ�� , 2: ����ȸ��   >> ");
            menu = scan.nextLine();
            if(menu.equals("1") || menu.equals("2")) break; // 1�� 2 �ܿ��� break ; �� ���� ���ڿ� ���ڴ� �ʱ�ȭ������ �̵�
             else {
              System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
              System.out.println();
             }
      }
               int cnt = 0; // ȸ�� ��ȣ // �ڵ����� 1�� Ŀ�� (ȸ����ȣ�� ȸ���� Ȯ�ΰ��� �����ɾ���x)
               if(menu.equals("1")) {    

                  cnt++;
                  newMember.setUserNum(cnt);
                  //id �ߺ�üũ 
                  while(true) {
                     System.out.print("���̵� �Է��ϼ��� >> ");
                     String id = scan.nextLine();
                     newMember.setUserId(id);
                     check = 0;
                     for(ProjectVO old  : memberList){
                        if(old.getUserId().equals(newMember.getUserId())) {
                           check++;
                           System.out.println("�̹� �����ϴ� ���̵� �Դϴ�. �ٸ� ���̵� �Է����ּ���.");
                        }
                     }
                     if(check == 0) break;
                  }
                  System.out.print("��й�ȣ�� �Է��ϼ��� >> ");
                  String pwd = scan.nextLine();
                  newMember.setUserPwd(pwd);
                  System.out.print("�̸��� �Է��ϼ��� >> ");
                  String name = scan.nextLine();
                  newMember.setName(name);
                  //����ó �ߺ�üũ
                  while(true) {
                  System.out.print("����ó�� �Է��ϼ��� >> ");
                  String tel = scan.nextLine();
                  newMember.setTel(tel);
                  check = 0;
                  for(ProjectVO old  : memberList){
                     if(old.getTel().equals(newMember.getTel())) {
                        check++;
                        System.out.println("�̹� �����ϴ� ����ó �Դϴ�. ����ó�� Ȯ�����ּ���.");
                        }
                     }
                    if(check == 0) break;
                  }   

                  memberList.add(newMember);
                  
                  System.out.println("ȸ�������� �Ϸ� �Ǿ����ϴ�.");
                  System.out.println();
                  check++; //check ���� 1�� ���ϸ鼭 �ݺ����� ����.
               }
               else if (menu.equals("2")){
                  int loginCnt=0;
                  
                  do {
                     ProjectVO findMember = new ProjectVO();
                  
                     System.out.print("���̵� �Է��ϼ��� >> ");
                     String id = scan.nextLine();
                     findMember.setUserId(id);
                     System.out.print("��й�ȣ���� �Է��ϼ��� >> ");
                     String pwd = scan.nextLine();
                     findMember.setUserPwd(pwd);
                     for(ProjectVO member : memberList) {
                        if(findMember.getUserId().equals(member.getUserId()) && findMember.getUserPwd().equals(member.getUserPwd())) {
                           check++; // check ���� 1�� ���ϸ鼭 �ݺ����� ����.
                           System.out.println(findMember.getUserId() + "���� �α��� �ϼ̽��ϴ�.");
                           System.out.println();
                        }loginCnt=3; // �α��� ������ ī��Ʈ���� 3���� �÷� �극��ũ �� ����ȿ�� �޴�������� ����
                     }
                     if(check == 0 ) {
                        System.out.println("ID �Ǵ� �н����尡 ��ġ�����ʽ��ϴ�. �ٽ� �α��� ���ּ���.");
                        System.out.println();
                        loginCnt++;
                     }
                     if(loginCnt == 3)break;  
                  }while(true);   
               } else {}
         if(check > 0) { 
            do {   
               String mainmenu = conInput(" �޴�( 0:ȸ�����,1:�������(�˻�),2:�������,3:��������,4:��������,5:���� ");
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
               System.out.println("���α׷��� ����Ǿ����ϴ�.");
               System.exit(5);   
            }else{
               System.out.println("�޴��� �߸� �����Ͽ����ϴ�. �ٽ� �����ϼ���");
               System.out.println();
            }

         }while(true);
         
      }
   }
   public String conInput(String msg) {
      System.out.print(msg+"=  ");
      return scan.nextLine();
   }

   //ȸ�� ���
   public void Member(){
      System.out.println("===============================================================================");
      System.out.println("id\t\t�̸�\t\t����ó");
      for(ProjectVO member : memberList) {
         System.out.print(member.getUserId() + " \t");
         System.out.print(member.getName() + "\t\t");
         System.out.print(member.getTel());
         System.out.println();
      }
      System.out.println("===============================================================================");
   }
   //���� ��� �޴�
   public void LibraryList() {
      
      System.out.println("===============================================================================");
      System.out.print("������ȣ\t������\t\t�۾���\t\t������\n");
      for(ProjectBookVO book : bookList) {
         System.out.print(book.getNum()+"\t\t"+book.getBookName()+"\t"+book.getWriter()+"\t\t"+book.getEa());
         System.out.println();         
      }
      System.out.println("===============================================================================");
      
      //��ϸ޴� �� �����˻� �߰�
      int check = 0;
      String bookName = conInput("�˻��� ���������� �Է��ϼ��� (�޴��� ������ : �ƹ�Ű�� �Է��ϼ���) ");
      System.out.println("===============================================================================");
      for(ProjectBookVO book : bookList) {
         if(book.getBookName().equals(bookName)) { // �˻��� bookname�� VO���� bookname�� ��
           check++; //check ���� 1�� ���ϸ鼭 �ݺ����� ����.
           //book.print();
            break; // �ٸ� ��¹��� ��µǹǷ� break;
         }    
      }
      if (check == 0) { // check �� 0�Ͻ� ��ġ������������ �Ǵ� �޼��� ���
          System.out.println("�ش� ������ �������� �ʽ��ϴ�. �޴��� �̵��մϴ�.");
          System.out.println();
       }
   }   

   // ���� ��� �޴�
   public void LibraryInsert() {
    
     int num = -1;
      try {
         while(true) {
        	int check = 0;
            num = Integer.parseInt(conInput("������ȣ")); 
            for(ProjectBookVO old  : bookList){
                if(old.getNum() == num ){
                   check++;         
                   System.out.println("�̹� �����ϴ� ������ȣ �Դϴ�. ������ȣ�� Ȯ�����ּ���.");
                   break;
                }
             }	
            if(check == 0) break;
         }
            String bookName = conInput("������");
            String Writer = conInput("�۾���");
            int Ea = Integer.parseInt(conInput("��������"));
      
      ProjectBookVO vo= new ProjectBookVO(num,bookName,Writer,Ea);
      bookList.add(vo); //bookList = VO ������� ����
             
         
      }catch(Exception e) {// int�� �䱸�ϴ� ��ĳ���� ���ڿ��Է½� Exception ���
         System.out.println("�߸��� �Է¹���Դϴ�.");
         System.out.println();
      }
   }
   // �������� ����

   public void LibraryEdit() {
      try {
      String bookName = conInput("��������");
      int check = 0;
      for(ProjectBookVO book : bookList) {
         if(book.getBookName().equals(bookName)) { // �˻��� bookname�� VO���� bookname�� ��
            check++; //��ġ�� check 1���� �ݺ��� out
            int cnt = Integer.parseInt(conInput("������ ������ �Է��ϼ���"));
            book.setEa(cnt);
         }
      }
      if (check == 0) {// check �� 0�Ͻ� ��ġ������������ �Ǵ� �޼��� ���
         System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
         System.out.println();
      }
      }catch(Exception e) {// int�� �䱸�ϴ� ��ĳ���� ���ڿ��Է½� Exception ���
         System.out.println("�߸��� �Է¹���Դϴ�.");
         System.out.println();
      }
   }

//���� �����޴�
  public void LibraryDelete() {
         String bookName = conInput("������ ���������� �Է��ϼ���");
         int check = 0; 
         for(ProjectBookVO book : bookList) {
            if(book.getBookName().equals(bookName)) {
               check++; //��ġ�� check 1���� �ݺ��� out
               bookList.remove(book);
               System.out.println("�ش� ������ �����Ǿ����ϴ�.");
               System.out.println();
               break; //������ �극��ũ 
            }      
         }
         if (check == 0) {
            System.out.println("�ش� ������ �������� �ʽ��ϴ�.");
            System.out.println();
         }
      }   
 
   public static void main(String[] args) {
      new ProjectStart();
   }
}