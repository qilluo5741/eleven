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
		//设置显示的条数
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//取得总数
		pager=iwlogService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("iwlogList",pager);
		//取得集合
		return "WarehousLog/WarehousLogManger";
	}
	
	/**
	 * 查询
	 * @return
	 */
	@RequestMapping("selectAllToList")
	public @ResponseBody List<WarehousLogInfo> selectAllToList(){
		List<WarehousLogInfo> list=iwlogService.selectAllList();
		return list;
	}
	/**
	 * 添加前的查询
	 * */
	@RequestMapping("insertOne")
	public String insertOne(ModelMap model) {
		model.addAttribute("io",ioService.selectAllList());
		model.addAttribute("iw",iwService.selectAllList());
		return "WarehousLog/insertwarehousLogManger";
	}
	/**
	 * 
	 * 添加
	 */
	@RequestMapping("addwarehousLog")
	public String addWarehousLogInfo(ModelMap model,WarehousLogInfo warehousLogInfo){
		if(this.iwlogService.insert(warehousLogInfo)){
			return "redirect:selectAll.action";
		}
		return "Error";
	}
	/**
	 * 删除
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
	 * 查询单个
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
	 * 修改
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
