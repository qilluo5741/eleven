package com.cloth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * ��Ӧ��
 * @author Administrator
 *
 */
@Entity
@Table(name="SupplierInfo")
public class SupplierInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	@Column(length=40)
	private String supplierId;//��Ӧ�̱��
	private String supplierName;//��Ӧ������
	private String supplierPeople;//��ϵ������
	private String supplierAddress;//��Ӧ�̵�ַ
	private String supplierTel;//��Ӧ�̵绰
	private String supplierRemark;//��ע
	public String getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public String getSupplierPeople() {
		return supplierPeople;
	}
	public void setSupplierPeople(String supplierPeople) {
		this.supplierPeople = supplierPeople;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierTel() {
		return supplierTel;
	}
	public void setSupplierTel(String supplierTel) {
		this.supplierTel = supplierTel;
	}
	public String getSupplierRemark() {
		return supplierRemark;
	}
	public void setSupplierRemark(String supplierRemark) {
		this.supplierRemark = supplierRemark;
	}
	public SupplierInfo() {
	}
	public SupplierInfo(String supplierId, String supplierName,
			String supplierPeople, String supplierAddress, String supplierTel,
			String supplierRemark) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierPeople = supplierPeople;
		this.supplierAddress = supplierAddress;
		this.supplierTel = supplierTel;
		this.supplierRemark = supplierRemark;
	}
}
