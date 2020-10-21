package vo;

public class BookVO {
	 private int bookNum;
	 private String bookname;
	 private String writer;
	 private int bookMoney;
	 
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBookMoney() {
		return bookMoney;
	}
	public void setBookMoney(int bookMoney) {
		this.bookMoney = bookMoney;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookVO other = (BookVO) obj;
		if (bookNum != other.bookNum)
			return false;
		return true;
	}
	
	
}
