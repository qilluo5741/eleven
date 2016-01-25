package com.cloth.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class LeaveMessageInfo {
	@Id
	@GeneratedValue(generator="uuid_")
	@GenericGenerator(name="uuid_",strategy="uuid")
	private String leaveMsgId;//¡Ù—‘Id
	private String callName;//¡Ù—‘’ﬂ≥∆∫Ù
	private String email;//¡Ù—‘’ﬂ” œ‰
	private String leaveMsgContent;//¡Ù—‘ƒ⁄»›
	private Date createTime;//¡Ù—‘ ±º‰
	private String tellPhone;//¡Ù—‘’ﬂ¡™œµ∑Ω Ω
	public String getLeaveMsgId() {
		return leaveMsgId;
	}
	public void setLeaveMsgId(String leaveMsgId) {
		this.leaveMsgId = leaveMsgId;
	}
	public String getCallName() {
		return callName;
	}
	public void setCallName(String callName) {
		this.callName = callName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLeaveMsgContent() {
		return leaveMsgContent;
	}
	public void setLeaveMsgContent(String leaveMsgContent) {
		this.leaveMsgContent = leaveMsgContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getTellPhone() {
		return tellPhone;
	}
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
	public LeaveMessageInfo(String leaveMsgId, String callName, String email, String leaveMsgContent, Date createTime, String tellPhone) {
		this.leaveMsgId = leaveMsgId;
		this.callName = callName;
		this.email = email;
		this.leaveMsgContent = leaveMsgContent;
		this.createTime = createTime;
		this.tellPhone = tellPhone;
	}
	public LeaveMessageInfo() {
	}
}
