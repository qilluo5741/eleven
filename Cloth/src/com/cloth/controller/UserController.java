package com.cloth.controller;
 
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.UserInfo;
import com.cloth.service.IUserService;
@Controller
@RequestMapping("user")
public class UserController  {
	@Autowired
	private IUserService service;
	@Autowired
	private HttpSession session;
	@RequestMapping("login")
	public @ResponseBody String login(ModelMap model,UserInfo user){
		//��½
		UserInfo userinfo=service.login(user);
		if(userinfo!=null){
			//��½�ɹ���
			session.setAttribute("user",userinfo);
			return "0";
		}
		return "1";
	}
	
	@RequestMapping("frontdesklogin")
	public @ResponseBody String frontdesklogin(ModelMap model,UserInfo user){
		//��½
		UserInfo userinfo=service.login(user);
		if(userinfo!=null){
			//ǰ̨�û���½�ɹ���
			session.setAttribute("frontuser",userinfo);
			return "0";
		}
		return "1";
	}
	
	//��ѯ���û���Ȩ��
	@RequestMapping("index")
	public String index(ModelMap model){
		UserInfo userInfo=(UserInfo) session.getAttribute("user");
		if(userInfo==null){
			return "login";
		}
		session.setAttribute("menutype",service.getMenu(userInfo.getRole().getRoleId()));
		return "main";
	}

}
