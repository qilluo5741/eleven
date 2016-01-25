package com.cloth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloth.entity.WarehousLogInfo;
import com.cloth.service.IOutboundInfoService;
import com.cloth.service.IWarehousLogInfoService;
import com.cloth.service.IWarehouseInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("WarehousLog")
public class WarehousLogInfoController {
	@Autowired
	private IWarehousLogInfoService iwlogService;
	
	@Autowired
	private IOutboundInfoService ioService;
	
	@Autowired
	private IWarehouseInfoService iwService;
	
	@RequestMapping("selectAll")
	public String queryqueryProcurement(Pager<WarehousLogInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=iwlogService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("iwlogList",pager);
		//ȡ�ü���
		return "WarehousLog/WarehousLogManger";
	}
	
	/**
	 * ��ѯ
	 * @return
	 */
	@RequestMapping("selectAllToList")
	public @ResponseBody List<WarehousLogInfo> selectAllToList(){
		List<WarehousLogInfo> list=iwlogService.selectAllList();
		return list;
	}
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insertOne")
	public String insertOne(ModelMap model) {
		model.addAttribute("io",ioService.selectAllList());
		model.addAttribute("iw",iwService.selectAllList());
		return "WarehousLog/insertwarehousLogManger";
	}
	/**
	 * 
	 * ���
	 */
	@RequestMapping("addwarehousLog")
	public String addWarehousLogInfo(ModelMap model,WarehousLogInfo warehousLogInfo){
		if(this.iwlogService.insert(warehousLogInfo)){
			return "redirect:selectAll.action";
		}
		return "Error";
	}
	/**
	 * ɾ��
	 * 
	 */
	@RequestMapping("deleteWarehouseInfo")
	public String deleteWarehousLogInfo(String warehousLogId) {
		if(iwlogService.deleteWarehousLogInfo(warehousLogId)) {
			return "redirect:selectAll.action";
		} else {
			return "Error";
		}
	}
	/**
	 * ��ѯ����
	 **/
	@RequestMapping("selectOneById")
	public String selectOneById(String warehousLogId,ModelMap model){
		WarehousLogInfo warehousLogInfo=iwlogService.selectOneById(warehousLogId);
		model.addAttribute("io",ioService.selectAllList());
		model.addAttribute("iw",iwService.selectAllList());
		model.addAttribute("w", iwlogService.selectOneById(warehousLogId));
		if(warehousLogInfo!=null){
			model.addAttribute("warehousLogInfo",warehousLogInfo);
			return "WarehousLog/updateWarehousLogManger";
		}else{
			return "error";
		}
	}
	
	/**
	 * �޸�
	 */
	@RequestMapping("updateWarehousLogInfo")
	public String updateWarehouseInfo(WarehousLogInfo warehousLogInfo){
		if(iwlogService.updateWarehousLogInfo(warehousLogInfo)) {
			return "redirect:selectAll.action";
		} else {
			return "Error";
		}
	}
}
