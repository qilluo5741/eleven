package com.cloth.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * �����˻�
 * @author Administrator
 *
 */

@Entity
@Table(name="LocalReturnInfo")
public class LocalReturnInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	@Column(length=40)
	private String returnId;
	private int returnOrExchange;//�ˣ�������0����  1��
	private Date returnTime;//�ˣ���������Ʒ����ʱ��
	private String returnRemark;//--�˻�˵��
	private String colorName;//�ˣ���������Ʒ��ɫ
	private String sizeName;//�ˣ���������Ʒ��С
	private String goodsName;////�ˣ���������Ʒ����
	private int goodsNum;//�ˣ���������Ʒ����
	private int returnStatus;//�ˣ�������״̬0����  1δ
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="warehouseId")
	private WarehouseInfo warehouse;//��Ҫ�˻���Ʒ���ڲֿ�
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public int getReturnOrExchange() {
		return returnOrExchange;
	}
	public void setReturnOrExchange(int returnOrExchange) {
		this.returnOrExchange = returnOrExchange;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnRemark() {
		return returnRemark;
	}
	public void setReturnRemark(String returnRemark) {
		this.returnRemark = returnRemark;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public WarehouseInfo getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(WarehouseInfo warehouse) {
		this.warehouse = warehouse;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public int getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(int returnStatus) {
		this.returnStatus = returnStatus;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public LocalReturnInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalReturnInfo(String returnId, int returnOrExchange,
			Date returnTime, String returnRemark, String colorName,
			String sizeName, String goodsName, int goodsNum, int returnStatus,
			WarehouseInfo warehouse) {
		super();
		this.returnId = returnId;
		this.returnOrExchange = returnOrExchange;
		this.returnTime = returnTime;
		this.returnRemark = returnRemark;
		this.colorName = colorName;
		this.sizeName = sizeName;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.returnStatus = returnStatus;
		this.warehouse = warehouse;
	}
}
