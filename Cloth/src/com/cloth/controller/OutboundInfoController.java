package com.cloth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloth.entity.OutboundInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IJoiningTraderService;
import com.cloth.service.IOutboundInfoService;
import com.cloth.service.IWarehouseInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("select")
public class OutboundInfoController {
	private static final String Error = null;
	@Autowired
	private IOutboundInfoService service;
	@Autowired
	private IEmpInfoService empservice;
	@Autowired
	private IWarehouseInfoService wareservice;
	@Autowired
	private IJoiningTraderService joinservice;
	/**
	 * ��ҳ��ѯ����
	 * */
	@RequestMapping("selectbyAlloutbound")
	public String selectbyAlloutbound(Pager<OutboundInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=service.selectbyAlloutbound(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pagerList", pager);
		//ȡ�ü���
		return "out/outbound";
	}
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insertTwo")
	public String insertTwo(ModelMap model) {
		model.addAttribute("emplist", empservice.selectAll());
		model.addAttribute("warlist", wareservice.selectAllList());
		model.addAttribute("joinlist", joinservice.selectAllToList());
		return "out/addOutboundInfo";
	}
	/**
	 * ��ӵ���
	 * */
	@RequestMapping("insertOne")
	public String insertOne(ModelMap model,OutboundInfo outb){
		outb.setOutboundTime(new Date());
		if(this.service.insertOne(outb)){
			return "redirect:selectbyAlloutbound.action";
		}
		return Error;
	}
	/**
	 * ��ѯ����
	 * */
	@RequestMapping("selectOutboundInfo")
	public String selectOutboundInfo(ModelMap model, String outboundId){
		model.addAttribute("emplist", empservice.selectAll());
		model.addAttribute("warlist", wareservice.selectAllList());
		model.addAttribute("joinlist", joinservice.selectAllToList());
		model.addAttribute("outb", service.selectOutboundInfo(outboundId));
		if(this.service!=null){
			return "out/updateOutboundInfo";
		}else{
			return Error;
		}
		
	}
	
	/*�޸�*/
	@RequestMapping("updateOutboundInfo")
	public String updateOutboundInfo(OutboundInfo outb) {
		System.out.println(outb.getOutboundId()+","+outb.getEmp().getEmpId()+","+outb.getOutboundRemark());
		if(service.updateOutboundInfo(outb)) {
			return "redirect:selectbyAlloutbound.action";
		} else {
			return Error;
		}
	}
	/*ɾ��*/
	@RequestMapping("deleteOutboundInfo")
	public String deleteOutboundInfo(String outboundId) {
		if(service.deleteOutboundInfo(outboundId)) {
			return "redirect:selectbyAlloutbound.action";
		} else {
			return Error;
		}
	}
}
