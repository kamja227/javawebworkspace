package vo;

import java.util.ArrayList;
import java.util.HashMap;

public class BookStoreVO {
	private ArrayList<UserVO> memberList; // ȸ�� ����Ʈ
	private ArrayList<BookVO> totalBookList; // ��ü ���� ����Ʈ
	private ArrayList<BookVO> rentalBookList; // �뿩(�뿩 �Ұ�) ����Ʈ
	private ArrayList<BookVO> availableBookList; // �뿩 ���� ����Ʈ
	private ArrayList<HashMap<UserVO, BookVO>> rentalList; // �뿩 ����Ʈ
	
	public ArrayList<UserVO> getMemberList() {
		return memberList;
	}
	public void setMemberList(ArrayList<UserVO> memberList) {
		this.memberList = memberList;
	}
	public ArrayList<BookVO> getTotalBookList() {
		return totalBookList;
	}
	public void setTotalBookList(ArrayList<BookVO> totalBookList) {
		this.totalBookList = totalBookList;
	}
	public ArrayList<BookVO> getRentalBookList() {
		return rentalBookList;
	}
	public void setRentalBookList(ArrayList<BookVO> rentalBookList) {
		this.rentalBookList = rentalBookList;
	}
	public ArrayList<BookVO> getAvailableBookList() {
		return availableBookList;
	}
	public void setAvailableBookList(ArrayList<BookVO> availableBookList) {
		this.availableBookList = availableBookList;
	}
	public ArrayList<HashMap<UserVO, BookVO>> getRentalList() {
		return rentalList;
	}
	public void setRentalList(ArrayList<HashMap<UserVO, BookVO>> rentalList) {
		this.rentalList = rentalList;
	}
}
