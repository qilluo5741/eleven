package com.cloth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloth.entity.UserInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IJurisdictionService;
import com.cloth.service.IUserInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("User")
public class UserInfoController {
	private static final String Error = null;
	@Autowired
	private IUserInfoService IUserService;
	@Autowired
	private IJurisdictionService IJurisService;
	@Autowired
	private IEmpInfoService IempService;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	/*��ѯȫ��*/
	@RequestMapping("selectAll")
	public String queryMenuInfo(Pager<UserInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(4);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=IUserService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("IUserList", pager);
		//ȡ�ü���
		return "user/UserInfoManger";
	}
	/*��ѯ����*/
	@RequestMapping("selectOneUserInfo")
	public String selectOneMenuInfo(ModelMap model, String userId){
		model.addAttribute("user", IUserService.selectOneUserInfo(userId));
		model.addAttribute("Ijur", IJurisService.getRole());
		if(this.IUserService!=null && this.IJurisService!=null){
			return "user/updateUserInfo";
		}else{
			return Error;
		}
	}
	/*�޸�*/
	@RequestMapping("updateUserInfo")
	public String updateUserInfo(UserInfo user) {
		if(IUserService.updateUserInfoBy(user)) {
			return "redirect:selectAll.action";
		} else {
			return Error;
		}
	}
	@RequestMapping("selectUserAll")
	public String queryMenuInfoAll(ModelMap model,String userName){
		model.addAttribute("users",IempService.selectAll());
		if(this.IempService!=null){
			return "circles";
		}else{
			return Error;
		}
	}
}
