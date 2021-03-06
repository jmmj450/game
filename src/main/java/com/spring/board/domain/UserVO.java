package com.spring.board.domain;

public class UserVO {
	private int userID;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userAddr;
	private int userPoint;
	private int userLevel;
	private int userLoginCount;
	private String userDate;
	private int userValidate;
	private String userAdmin;
	
	
	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", userAddr=" + userAddr + ", userPoint="
				+ userPoint + ", userLevel=" + userLevel + ", userLoginCount=" + userLoginCount + ", userDate="
				+ userDate + ", userValidate=" + userValidate + ", userAdmin=" + userAdmin + "]";
	}

	public UserVO() {
	}
	
	public UserVO(String userEmail, String userPassword, String userName, String userPhone, String userAddr,
			int userPoint, int userLevel, int userLoginCount, String userDate, int userValidate, String userAdmin) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.userPoint = userPoint;
		this.userLevel = userLevel;
		this.userLoginCount = userLoginCount;
		this.userDate = userDate;
		this.userValidate = userValidate;
		this.userAdmin = userAdmin;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getUserLoginCount() {
		return userLoginCount;
	}
	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}
	public String getUserDate() {
		return userDate;
	}
	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}
	public int getUserValidate() {
		return userValidate;
	}
	public void setUserValidate(int userValidate) {
		this.userValidate = userValidate;
	}
	public String getUserAdmin() {
		return userAdmin;
	}
	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}

	
		
}
