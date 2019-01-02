package com.niit.s190127.ecomm.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier {
	
	@Id
	@GeneratedValue
	private int supplierId;
	private String supplierName;
	private String supplierAddr;
	/**
	 * @return the supplierId
	 */
	public int getSupplierId() {
		return supplierId;
	}
	/**
	 * @param supplierId the supplierId to set
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * @return the supplierName
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * @param supplierName the supplierName to set
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * @return the supplierAddr
	 */
	public String getSupplierAddr() {
		return supplierAddr;
	}
	/**
	 * @param supplierAddr the supplierAddr to set
	 */
	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}

}
