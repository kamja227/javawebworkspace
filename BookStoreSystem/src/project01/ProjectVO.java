package project01;

import java.util.ArrayList;
import java.util.List;

public class ProjectVO {

   private int userNum;
   public int getUserNum() {
      return userNum;
   }
   public void setUserNum(int userNum) {
      this.userNum = userNum;
   }
   private String userId;
   private String userPwd;
   private String name;
   private String tel;
   
   public ProjectVO() {         
   }
   public ProjectVO(String userID, String userPwd, String name, String tel) {
   
      this.userId=userId;
      this.userPwd=userPwd;
      this.name=name;
      this.tel=tel;
      
   }
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

@Override
public boolean equals(Object obj) {
   if (this == obj)
      return true;
   if (obj == null)
      return false;
   if (getClass() != obj.getClass())
      return false;
   ProjectVO other = (ProjectVO) obj;
   if (userNum != other.userNum)
      return false;
   return true;
}
   
   
}