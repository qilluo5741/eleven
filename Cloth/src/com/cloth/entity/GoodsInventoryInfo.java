package com.cloth.entity;

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

@Entity
@Table
public class GoodsInventoryInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	@Column(length=40)
	private String goodsInventoryId;
	private String goodsName;/*--��Ʒ���   �������*/
	private String colorName;/*��Ʒ��ɫ  �������*/
	private String sizeName;/*��Ʒ��ţ���ע ����ͨ����ŵõ���Ʒ���ͣ��������*/
	private int goodsNum;/*��Ʒ����*/
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="warehouseId")
	private WarehouseInfo warehouse;/*�ֿ�*/
	
	public String getGoodsInventoryId() {
		return goodsInventoryId;
	}
	public void setGoodsInventoryId(String goodsInventoryId) {
		this.goodsInventoryId = goodsInventoryId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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
	public GoodsInventoryInfo() {
	}
	public GoodsInventoryInfo(String goodsInventoryId, String goodsName,
			String colorName, String sizeName, int goodsNum,
			WarehouseInfo warehouse) {
		this.goodsInventoryId = goodsInventoryId;
		this.goodsName = goodsName;
		this.colorName = colorName;
		this.sizeName = sizeName;
		this.goodsNum = goodsNum;
		this.warehouse = warehouse;
	}
}
