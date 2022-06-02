package com.example.mallwork.Vo;

import java.math.BigDecimal;
import java.util.List;



public class OrderVo {
	private Long orderNo;//�������
	private BigDecimal amount;//�����۸�
	private Integer type;//֧������
	private String typeDess;//֧������
	private Integer fieight;//�ʷ�֧������
	private Integer status;//����״̬
	private String statusDesc;//����״̬����
	private String paymentTime;//֧��ʱ��
	private String finishTime;//�������ʱ��
	private String closeTime;//�����ر�ʱ��
	private String created;//��������ʱ��
	
	
	private List<OrderItemVo> orderItems;//��������
	private Integer addrId;//�ջ��ַId
	private String deliveryName;//�ջ�������
	private String deliveryTime;//�ջ�ʱ��
	private AddressVo address;//�ջ�������
	
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTypeDess() {
		return typeDess;
	}
	public void setTypeDess(String typeDess) {
		this.typeDess = typeDess;
	}
	public Integer getFieight() {
		return fieight;
	}
	public void setFieight(Integer fieight) {
		this.fieight = fieight;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public String getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public List<OrderItemVo> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemVo> orderItems) {
		this.orderItems = orderItems;
	}
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public AddressVo getAddress() {
		return address;
	}
	public void setAddress(AddressVo address) {
		this.address = address;
	}

}
