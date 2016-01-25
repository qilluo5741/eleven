package com.cloth.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class OutboundInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	private String outboundId;
	private Date outboundTime;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empId")
	private EmpInfo emp;//--����ˣ�����ˣ�
    private int isExitorSale;//�Ǳ����˻���������  0�������˻�  1������
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouseId")
	private WarehouseInfo warehouse;//(�ֿ�  ���Ǹ��ֿ����)
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "joiningTraderId")
	private JoiningTraderInfo joiningTrader;//--����Id���
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supplierId")
	private SupplierInfo supplier;
	private String goodsName;//������Ʒ����
	private int goodsNum;//������Ʒ����
	private String outboundRemark;//--����˵��
	public String getOutboundId() {
		return outboundId;
	}
	public void setOutboundId(String outboundId) {
		this.outboundId = outboundId;
	}
	public Date getOutboundTime() {
		return outboundTime;
	}
	public void setOutboundTime(Date outboundTime) {
		this.outboundTime = outboundTime;
	}
	public EmpInfo getEmp() {
		return emp;
	}
	public void setEmp(EmpInfo emp) {
		this.emp = emp;
	}
	public WarehouseInfo getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(WarehouseInfo warehouse) {
		this.warehouse = warehouse;
	}
	public JoiningTraderInfo getJoiningTrader() {
		return joiningTrader;
	}
	public void setJoiningTrader(JoiningTraderInfo joiningTrader) {
		this.joiningTrader = joiningTrader;
	}
	public String getOutboundRemark() {
		return outboundRemark;
	}
	public void setOutboundRemark(String outboundRemark) {
		this.outboundRemark = outboundRemark;
	}
	
	public int getIsExitorSale() {
		return isExitorSale;
	}
	public void setIsExitorSale(int isExitorSale) {
		this.isExitorSale = isExitorSale;
	}
	public SupplierInfo getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierInfo supplier) {
		this.supplier = supplier;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public OutboundInfo() {
		
	}
	public OutboundInfo(String outboundId, Date outboundTime, EmpInfo emp,
			int isExitorSale, WarehouseInfo warehouse,
			JoiningTraderInfo joiningTrader, SupplierInfo supplier,
			String goodsName, int goodsNum, String outboundRemark) {
		super();
		this.outboundId = outboundId;
		this.outboundTime = outboundTime;
		this.emp = emp;
		this.isExitorSale = isExitorSale;
		this.warehouse = warehouse;
		this.joiningTrader = joiningTrader;
		this.supplier = supplier;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.outboundRemark = outboundRemark;
	}
}
