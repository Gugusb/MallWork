package com.example.mallwork.Vo;

import com.example.mallwork.Entity.Product;

import java.util.List;

public class ProductFloorVo {
	private List<Product> oneFloor;//һ¥
	private List<Product> twoFloor;//��¥
	private List<Product> threeFloor;//��¥
	private List<Product> fourFloor;//��¥

	public List<Product> getOneFloor() {
		return oneFloor;
	}
	public void setOneFloor(List<Product> oneFloor) {
		this.oneFloor = oneFloor;
	}
	public List<Product> getTwoFloor() {
		return twoFloor;
	}
	public void setTwoFloor(List<Product> twoFloor) {
		this.twoFloor = twoFloor;
	}
	public List<Product> getThreeFloor() {
		return threeFloor;
	}
	public void setThreeFloor(List<Product> threeFloor) {
		this.threeFloor = threeFloor;
	}
	public List<Product> getFourFloor() {
		return fourFloor;
	}
	public void setFourFloor(List<Product> fourFloor) {
		this.fourFloor = fourFloor;
	}

}
