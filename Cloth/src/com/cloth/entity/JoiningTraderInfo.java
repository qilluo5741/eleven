package com.cloth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * ������
 * @author Administrator
 *
 */
@Entity
@Table(name="JoiningTraderInfo")
public class JoiningTraderInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	@Column(length=36)
	private String joiningTraderId;
	private int isSubsidiary;//-- 0   1    0 �����ӹ�˾  1  ���������
	private int joiningTraderNo;//--�ڼ��ڼ���---------------------------------------
	private double joiningTraderYear;//--����
	private String joiningTraderTime;//--����ʱ��------------------------------------
	private double joiningTraderMoney;//--�����ʽ�
	private String joiningTraderTel;//��������ϵ��ʽ
	private int joiningTraderStatus;//����״̬---------------------------------------
	private int joiningWarning;//��������0,1�����ѹ���Ա�ü���������ʱ��---------------
	private String joiningTraderPeople;//��ϵ��
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private UserInfo user;//�����̶Ե��û�-------------------------------------------
	private String joiningTraderAddress;//--���������ڵص�
	private String joiningTraderName;//--��������
	public String getJoiningTraderId() {
		return joiningTraderId;
	}
	public void setJoiningTraderId(String joiningTraderId) {
		this.joiningTraderId = joiningTraderId;
	}
	public int getIsSubsidiary() {
		return isSubsidiary;
	}
	public void setIsSubsidiary(int isSubsidiary) {
		this.isSubsidiary = isSubsidiary;
	}
	public int getJoiningTraderNo() {
		return joiningTraderNo;
	}
	public void setJoiningTraderNo(int joiningTraderNo) {
		this.joiningTraderNo = joiningTraderNo;
	}
	public double getJoiningTraderYear() {
		return joiningTraderYear;
	}
	public void setJoiningTraderYear(double joiningTraderYear) {
		this.joiningTraderYear = joiningTraderYear;
	}
	public String getJoiningTraderTime() {
		return joiningTraderTime;
	}
	public void setJoiningTraderTime(String joiningTraderTime) {
		this.joiningTraderTime = joiningTraderTime;
	}
	public double getJoiningTraderMoney() {
		return joiningTraderMoney;
	}
	public void setJoiningTraderMoney(double joiningTraderMoney) {
		this.joiningTraderMoney = joiningTraderMoney;
	}
	public String getJoiningTraderTel() {
		return joiningTraderTel;
	}
	public void setJoiningTraderTel(String joiningTraderTel) {
		this.joiningTraderTel = joiningTraderTel;
	}
	public int getJoiningTraderStatus() {
		return joiningTraderStatus;
	}
	public void setJoiningTraderStatus(int joiningTraderStatus) {
		this.joiningTraderStatus = joiningTraderStatus;
	}
	public String getJoiningTraderPeople() {
		return joiningTraderPeople;
	}
	public void setJoiningTraderPeople(String joiningTraderPeople) {
		this.joiningTraderPeople = joiningTraderPeople;
	}
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	public String getJoiningTraderAddress() {
		return joiningTraderAddress;
	}
	public String getJoiningTraderName() {
		return joiningTraderName;
	}
	public void setJoiningTraderName(String joiningTraderName) {
		this.joiningTraderName = joiningTraderName;
	}
	public void setJoiningTraderAddress(String joiningTraderAddress) {
		this.joiningTraderAddress = joiningTraderAddress;
	}
	
	public int getJoiningWarning() {
		return joiningWarning;
	}
	public void setJoiningWarning(int joiningWarning) {
		this.joiningWarning = joiningWarning;
	}
	public JoiningTraderInfo() {
		// TODO Auto-generated constructor stub
	}
	public JoiningTraderInfo(String joiningTraderId, int isSubsidiary,
			int joiningTraderNo, double joiningTraderYear,
			String joiningTraderTime, double joiningTraderMoney,
			String joiningTraderTel, int joiningTraderStatus,
			int joiningWarning, String joiningTraderPeople, UserInfo user,
			String joiningTraderAddress, String joiningTraderName) {
		super();
		this.joiningTraderId = joiningTraderId;
		this.isSubsidiary = isSubsidiary;
		this.joiningTraderNo = joiningTraderNo;
		this.joiningTraderYear = joiningTraderYear;
		this.joiningTraderTime = joiningTraderTime;
		this.joiningTraderMoney = joiningTraderMoney;
		this.joiningTraderTel = joiningTraderTel;
		this.joiningTraderStatus = joiningTraderStatus;
		this.joiningWarning = joiningWarning;
		this.joiningTraderPeople = joiningTraderPeople;
		this.user = user;
		this.joiningTraderAddress = joiningTraderAddress;
		this.joiningTraderName = joiningTraderName;
	}
}
