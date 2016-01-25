package com.cloth.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cloth.entity.PositionInfo;
import com.cloth.service.IPositionInfoService;
import com.cloth.util.Pager;



@Controller
@RequestMapping("select")
public class PositionInfoController {
	private static final String Error = null;
	@Autowired
	private IPositionInfoService service;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	
	@RequestMapping("queryAllPositionInfo")
	public String queryAllPositionInfo(ModelMap model){
		List<PositionInfo> list = this.service.queryAllPositionInfo();
		model.addAttribute("position", list);
		return "position/position";
	}
	@RequestMapping("addPositionInfo")
	public String addPositionInfo(ModelMap model,PositionInfo posi){
		this.service.addPositionInfo(posi);
		if(this.service!=null){
			return "redirect:selectByPager.action";
		}
		return Error;
	}
	@RequestMapping("deletePositionInfo")
	public String deletePositionInfo(String positionId) {
		if(service.deletePositionInfo(positionId)) {
			return "redirect:selectByPager.action";
		} else {
			return Error;
		}
	}
	/*��ѯ����*/
	@RequestMapping("selectOnePositionInfo")
	public String selectOnePositionInfo(ModelMap model, String positionId){
		model.addAttribute("posi", service.selectOnePositionInfo(positionId));
		if(this.service!=null){
			return "position/updatePositionInfo";
		}else{
			return Error;
		}
		
	}
	/*�޸�*/
	@RequestMapping("updatePositionInfo")
	public String updatePositionInfo(PositionInfo posi) {
		if(service.updatePositionInfo(posi)) {
			return "redirect:selectByPager.action";
		} else {
			return Error;
		}
	}
	/**
	 * ��ҳ��ѯ����
	 * */
	@RequestMapping("selectByPager")
	public String selectByPager(Pager<PositionInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=service.selectByPager(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pagerList", pager);
		//ȡ�ü���
		return "position/position";
	}
}
