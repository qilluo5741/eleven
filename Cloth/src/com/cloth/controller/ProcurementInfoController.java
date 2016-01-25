package com.cloth.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.ProcurementInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IProcurementInfoService;
import com.cloth.service.ISupplierInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("Procure")
public class ProcurementInfoController {
	private static final String Error = null;
	@Autowired
	private IProcurementInfoService prService;
	@Autowired
	private ISupplierInfoService SuService;
	@Autowired
	private IEmpInfoService empService;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	/*��ѯȫ��*/
	@RequestMapping("selectAll")
	public String queryProcurement(Pager<ProcurementInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=prService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("procList", pager);
		//ȡ�ü���
		return "procurment/procurmentManger";
	}
	
	@RequestMapping("addprocurment")
	public String addPositionInfo(ModelMap model,ProcurementInfo procurement){
		procurement.setProcurementTime(new Date());
		if(this.prService.insert(procurement)){
			return "redirect:selectAll.action";
		}
		return Error;
	}
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insertOne")
	public String insertOne(ModelMap model) {
		model.addAttribute("suppList", SuService.selectAll());
		model.addAttribute("empList", empService.selectAll());
		return "procurment/insertProcurmentManger";
	}
	/**
	 * ��ѯ����
	 **/
	@RequestMapping("selectOneById")
	public String selectOneById(String ProcurementId,ModelMap map,ModelMap model){
		ProcurementInfo procurement=prService.selectOneById(ProcurementId);
		model.addAttribute("suppList", SuService.selectAll());
		model.addAttribute("empList", empService.selectAll());
		model.addAttribute("p", prService.selectOneById(ProcurementId));
		if(procurement!=null){
			map.addAttribute("procurement",procurement);
			return "procurment/updateProcurmentManger";
		}else{
			return "error";
		}
	}
	/*�޸�*/
	@RequestMapping("updateprocurment")
	public String updateProcurmentInfo(ProcurementInfo procurement) {
		if(prService.updateProcurementInfo(procurement)) {
			return "redirect:selectAll.action";
		} else {
			return Error;
		}
	}
	
	@RequestMapping("selectAllToList")
	public @ResponseBody List<ProcurementInfo> selectAllToList(){
		List<ProcurementInfo> list=prService.selectAllList();
		return list;
	}
	
	@RequestMapping("deleteProcurementInfo")
	public String deletePositionInfo(String procurementId) {
		if(prService.deleteProcurementInfo(procurementId)) {
			return "redirect:selectAll.action";
		} else {
			return Error;
		}
	}
}
