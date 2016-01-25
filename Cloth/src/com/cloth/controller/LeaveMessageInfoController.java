package com.cloth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloth.entity.LeaveMessageInfo;
import com.cloth.service.ILeaveMessageInfoService;

@Controller
@RequestMapping("leaveMessage")
public class LeaveMessageInfoController {
	
	@Autowired
	private ILeaveMessageInfoService leaveMsgService;
	
	/**
	 * Ìí¼Óµ¥¸ö
	 * */
	@RequestMapping("insertOne")
	public String insertOne(LeaveMessageInfo leaveMsg,ModelMap model) {
		if(this.leaveMsgService.insertOne(leaveMsg)) {
			model.addAttribute("isOK", 1);
			return "model/customer";
		} else {
			return "error";
		}
	}
}
