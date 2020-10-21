package vo;

import java.util.ArrayList;

public class UserVO {
	  private String userId;
	  private String userPwd;
	  private String name;
	  private String tel;
	  private String email;
	  private ArrayList<BookVO> bookList;
	  
	  public String getUserId() {
		  return userId;
	  }
	  public void setUserId(String userId) {
		  this.userId = userId;
	  }
	  public String getUserPwd() {
		  return userPwd;
	  }
	  public void setUserPwd(String userPwd) {
		  this.userPwd = userPwd;
	  }
	  public String getName() {
		  return name;
	  }
	  public void setName(String name) {
		  this.name = name;
	  }
	  public String getTel() {
		  return tel;
	  }
	  public void setTel(String tel) {
		  this.tel = tel;
	  }
	  public String getEmail() {
		  return email;
	  }
	  public void setEmail(String email) {
		  this.email = email;
	  }
	  public ArrayList<BookVO> getBookList() {
		  return bookList;
	  }
	  public void setBookList(ArrayList<BookVO> bookList) {
		  this.bookList = bookList;
	  }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	  
	  
}
