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
 * ��Ʒ��
 * @author Administrator
 *
 */

@Entity
@Table
public class GoodsInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	@Column(length=40)
	private String goodsId;
	private String goodsNo;//--��Ʒ���
	private String goodsName;//
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="colorId")
	private ColorInfo color;//--��Ʒ��ɫ
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="sizeId")
	private SizeInfo size;//--��Ʒ��ţ���ע ����ͨ����ŵõ���Ʒ���ͣ�
	private int goodsNum;//--��Ʒ����
	private String goodsCode;// --������
	private String goodsImg;//--��ƷͼƬ
	private double goodsInPrice;//--��Ʒ����
	private double goodsOutPrice;//--��Ʒ�ۼ�
	private double goodsDiscount;//--��Ʒ�ۿ�
	private String goodsRemark;//--��Ʒ˵��
	private Date enterTime;//��Ʒ¼��ʱ��
	@ManyToOne(cascade=CascadeType.REMOVE,fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="procurementId")
	private ProcurementInfo procurement;//--�ɹ��������
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(String goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public ColorInfo getColor() {
		return color;
	}
	public void setColor(ColorInfo color) {
		this.color = color;
	}
	public SizeInfo getSize() {
		return size;
	}
	public void setSize(SizeInfo size) {
		this.size = size;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public double getGoodsInPrice() {
		return goodsInPrice;
	}
	public void setGoodsInPrice(double goodsInPrice) {
		this.goodsInPrice = goodsInPrice;
	}
	public double getGoodsOutPrice() {
		return goodsOutPrice;
	}
	public void setGoodsOutPrice(double goodsOutPrice) {
		this.goodsOutPrice = goodsOutPrice;
	}
	public double getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(double goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	public String getGoodsRemark() {
		return goodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}
	public Date getEnterTime() {
		return enterTime;
	}
	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}
	public ProcurementInfo getProcurement() {
		return procurement;
	}
	public void setProcurement(ProcurementInfo procurement) {
		this.procurement = procurement;
	}
	public GoodsInfo(String goodsId, String goodsNo, String goodsName,
			ColorInfo color, SizeInfo size, int goodsNum, String goodsCode,
			String goodsImg, double goodsInPrice, double goodsOutPrice,
			double goodsDiscount, String goodsRemark, Date enterTime,
			ProcurementInfo procurement) {
		this.goodsId = goodsId;
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.color = color;
		this.size = size;
		this.goodsNum = goodsNum;
		this.goodsCode = goodsCode;
		this.goodsImg = goodsImg;
		this.goodsInPrice = goodsInPrice;
		this.goodsOutPrice = goodsOutPrice;
		this.goodsDiscount = goodsDiscount;
		this.goodsRemark = goodsRemark;
		this.enterTime = enterTime;
		this.procurement = procurement;
	}
	public GoodsInfo() {
		// TODO Auto-generated constructor stub
	}
}
