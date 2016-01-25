package com.cloth.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cloth.entity.FinancialInfo;
import com.cloth.service.IFinancialInfoService;
import com.cloth.service.IProcurementInfoService;
import com.cloth.service.ISalesRecordService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("select")
public class FinancialInfoController {
	private static final String Error = null;
	@Autowired
	private IFinancialInfoService service;
	@Autowired
	private IProcurementInfoService proservice;
	@Autowired
	private ISalesRecordService salservice;
	/**
	 * ��ҳ��ѯ����
	 * */
	@RequestMapping("selectbyAll")
	public String selectbyAll(Pager<FinancialInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=service.selectbyAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pagerList", pager);
		//ȡ�ü���
		return "Financial/fina";
	}
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insert")
	public String insert(ModelMap model) {
		model.addAttribute("prolist", proservice.selectAllList());
		model.addAttribute("sallist", salservice.queryAllSalesRecordInfo());
		return "Financial/addFinancialInfo";
	}
	/**
	 * ��ӵ���
	 * */
	@RequestMapping("insertOneFinancialInfo")
	public String insertOneFinancialInfo(ModelMap model,FinancialInfo fina){
		fina.setFinancialTime(new Date());
		if(this.service.insertOneFinancialInfo(fina)){
			return "redirect:selectbyAll.action";
		}
		return Error;
	}
	/**
	 * ��ѯ����
	 * @param fina
	 * @return
	 */
	@RequestMapping("selectFinancialInfo")
	public String selectFinancialInfo(ModelMap model, String financialId){
		model.addAttribute("prolist", proservice.selectAllList());
		model.addAttribute("sallist", salservice.queryAllSalesRecordInfo());
		model.addAttribute("fina", service.selectFinancialInfo(financialId));
			if(this.service!=null){
				return "Financial/updateFinancialInfo";
			}else{
				return Error;
			}
	}
	/*�޸�*/
	@RequestMapping("updateFinancialInfo")
	public String updateFinancialInfo(FinancialInfo fina) {
		if(service.updateFinancialInfo(fina)) {
			return "redirect:selectbyAll.action";
		} else {
			return Error;
		}
	}
	/*ɾ��*/
	@RequestMapping("deleteFinancialInfo")
	public String deleteFinancialInfo(String financialId) {
		if(service.deleteFinancialInfo(financialId)) {
			return "redirect:selectbyAll.action";
		} else {
			return Error;
		}
	}
}