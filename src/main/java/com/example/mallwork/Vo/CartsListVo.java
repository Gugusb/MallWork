package com.example.mallwork.Vo;

import java.math.BigDecimal;

public class CartsListVo {
	private Integer id;
	private Integer userId;
	private Integer productId; 	//��Ʒ���
	private String name;		//��Ʒ����
	private Integer quantity;	//��Ʒ����
	private BigDecimal price;	//��Ʒ�۸�
	private Integer status;		//��Ʒ״̬
	private BigDecimal totalPrice; //��Ʒ�ܼ�
	private Integer stock;			//���	
	private String iconUrl;			//��Ʒ��ͼƬ
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	private Integer checked;	//ѡ��״̬ 0δѡ�� 1ѡ��	
}
