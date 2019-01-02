package com.niit.s190127.ecomm.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Simple POJO class for order details

@Entity
@Table
public class CustomerOrder {

	@Id
	@GeneratedValue
	private int orderId;
	private String userName;
	private Date dateOfOrder;
	private int orderPrice;
	private String paymentMode;
	/**
	 * @return the orderId
	 */
	public int getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the dateOfOrder
	 */
	public Date getDateOfOrder() {
		return dateOfOrder;
	}
	/**
	 * @param dateOfOrder the dateOfOrder to set
	 */
	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}
	/**
	 * @return the orderPrice
	 */
	public int getOrderPrice() {
		return orderPrice;
	}
	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}
	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
