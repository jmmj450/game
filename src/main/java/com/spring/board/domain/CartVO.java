package com.spring.board.domain;

public class CartVO {

	private int cartNum;   // INTEGER primary key,  -- 카트번호
	private String userEmail;   // VARCHAR(30) not null,   --  유저메일
	private int cartAmount;   // INTEGER not null default 1,   -- 장바구니 수량
	private int proNum;   // INTEGER   not null -- 상품번호
	private String proName;     //VARCHAR(50) NOT NULL,  -- 상품명
	private int proPrice ;  	//INTEGER DEFAULT 0, -- 상품가격
	private String userName;
	private int money;
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public int getCartAmount() {
		return cartAmount;
	}
	public void setCartAmount(int cartAmount) {
		this.cartAmount = cartAmount;
	}
	public int getProNum() {
		return proNum;
	}
	public void setProNum(int proNum) {
		this.proNum = proNum;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", userEmail=" + userEmail
				+ ", cartAmount=" + cartAmount + ", proNum=" + proNum
				+ ", proName=" + proName + ", proPrice=" + proPrice
				+ ", userName=" + userName + ", money=" + money + "]";
	}
			
}
