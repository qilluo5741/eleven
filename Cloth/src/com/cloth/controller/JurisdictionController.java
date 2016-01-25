package com.cloth.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.MenuInfo;
import com.cloth.entity.MenuRoleInfo;
import com.cloth.entity.MenuType;
import com.cloth.entity.RoleInfo;
import com.cloth.service.IJurisdictionService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("jurisdiction")
public class JurisdictionController {
	@Autowired
	private IJurisdictionService service;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	
	//��ɫ��ѯ
	@RequestMapping("getReole")
	public String getReole(ModelMap model){
		model.addAttribute("role", service.getRole());
		return "Jurisdiction/roleInfo";
	}
	//�޸Ľ�ɫ
	@RequestMapping("updateReole")
	public @ResponseBody  String updateReole(ModelMap model,RoleInfo role){
		if(service.updateRole(role)){
			return "0";
		}
		return "1";
	}
	//ɾ����ɫ
	@RequestMapping("deleteReole")
	public @ResponseBody String deleteRole(ModelMap model,RoleInfo role){
		try {
			if(service.deleteRole(role)){
				return "0";
			}
		} catch (Exception e) {
			return "1"; 
		}
		return "1";
	}
	//��ӽ�ɫ
	@RequestMapping("addReole")
	public @ResponseBody String addReole(ModelMap model,RoleInfo role){
		if(service.addReole(role)){
			return "0";
		}
	
		return "1";
	}
	//��ѯ�˵�����
	@RequestMapping("getMenuType")
	public String getMenuType(ModelMap model,int pageIndex){
		Pager<MenuType> p=service.getMenuType(pageIndex, 5);
		if(p.getList().size()==0){
			 p=service.getMenuType(pageIndex-1, 5);
		}
		model.addAttribute("pager", p);
		return "Jurisdiction/menuType";
	}
	//�޸Ĳ˵�����
	@RequestMapping("updateMenuType")
	public @ResponseBody String updateMenuTyep(ModelMap model,MenuType mt){
		if(service.updateMenuType(mt)){
			return "0";
		}
		return "1";
	}
	//��Ӳ˵�����
	@RequestMapping("addMenuType")
	public @ResponseBody String addMenuTyep(ModelMap model,MenuType mt){
		if(service.addMenuType(mt)){
			return "0";
		}
		return "1";
	}
	//ɾ���˵�����
	@RequestMapping("deleteMenuType")
	public @ResponseBody String deleteMenuType(ModelMap model,MenuType mt)
	{
		try {
			if(service.deleteMenuType(mt)){
				return "0";
			}
		} catch (Exception e) {
			return "1";
		}
		return "1";
	}
	
	//��ѯ��ɫ�������еĲ˵�
	@RequestMapping("getRoleMenu")
	public String getRoleMenu(ModelMap model,RoleInfo r){
		model.addAttribute("roleInfo",service.getReoleMenu(r));
		return "Jurisdiction/roleMenu";
	}
	//ɾ����ɫ�е�һ���˵�
	@RequestMapping("deleteRoleMenu")
	public @ResponseBody String deleteRoleMenu(ModelMap model,RoleInfo r){
		if(service.deleteRoleMenu(r)){
			return "0";
		}
		return "1";
	}
	//���ݽ�ɫId��ѯΪ��ӵĲ˵�
	@RequestMapping("getMenuisNoadd")
	public @ResponseBody String getMenuisNoadd(ModelMap map,RoleInfo r){
		JsonConfig cfg = new JsonConfig();
	    cfg.setJsonPropertyFilter(new PropertyFilter()
	    {
	         public boolean apply(Object source, String name, Object value) {
	           if(name.equals("menuType")) {
	             return true;
	           } else {
	             return false;
	          }
	        }
	    });
		List<MenuInfo> list=service.getMenuisNoadd(r);
		System.out.println("*****"+list.size());
		JSONArray ja=JSONArray.fromObject(list,cfg);
		return ja.toString();
	}
	//��ɫ��Ӳ˵�
	@RequestMapping("addMenuRole")
	public @ResponseBody String addMenuRole(MenuRoleInfo m){
		if(service.addMenuRole(m)){
			return "0";
		}
		return "1";
	}
}
