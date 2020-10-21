package vo;

import java.util.ArrayList;
import java.util.HashMap;

public class BookStoreVO {
	private ArrayList<UserVO> memberList; // 회원 리스트
	private ArrayList<BookVO> totalBookList; // 전체 도서 리스트
	private ArrayList<BookVO> rentalBookList; // 대여(대여 불가) 리스트
	private ArrayList<BookVO> availableBookList; // 대여 가능 리스트
	private ArrayList<HashMap<UserVO, BookVO>> rentalList; // 대여 리스트
	
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
