package com.cloth.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloth.entity.WarehouseInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IWarehouseInfoService;
import com.cloth.util.Pager;
@Controller
@RequestMapping("Warehouse")
public class WarehouseInfoContrller {
	@Autowired
	private IWarehouseInfoService IwService;
	@Autowired
	private IEmpInfoService empService;
	
	@RequestMapping("selectAll")
	public String queryWarehouse(Pager<WarehouseInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=IwService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("IwList", pager);
		//ȡ�ü���
		return "warehouse/WarehouseManger";
	}
	/**
	 * ��ѯ
	 * @return
	 */
	@RequestMapping("selectAllToList")
	public @ResponseBody List<WarehouseInfo> selectAllToList(){
		List<WarehouseInfo> list=IwService.selectAllList();
		return list;
	}
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insertOne")
	public String insertOne(ModelMap model) {
		model.addAttribute("empList",empService.selectAll());
		return "warehouse/insertwarehouseManger";
	}
	/**
	 * 
	 * ���
	 */
	@RequestMapping("addwarehouseInfo")
	public String addWarehouseInfo(ModelMap model,WarehouseInfo warehouseInfo){
		if(this.IwService.insert(warehouseInfo)){
			return "redirect:selectAll.action";
		}
		return "Error";
	}
	/**
	 * ɾ��
	 * 
	 */
	@RequestMapping("deleteWarehouseInfo")
	public String deleteWarehouseInfo(String warehouseId) {
		if(IwService.deleteWarehouseInfo(warehouseId)) {
			return "redirect:selectAll.action";
		} else {
			return "Error";
		}
	}
	/**
	 * ��ѯ����
	 **/
	@RequestMapping("selectOneById")
	public String selectOneById(String warehouseId,ModelMap model){
		WarehouseInfo warehouseInfo=IwService.selectOneById(warehouseId);
		model.addAttribute("empList", empService.selectAll());
		model.addAttribute("w", IwService.selectOneById(warehouseId));
		if(warehouseInfo!=null){
			model.addAttribute("warehouseInfo",warehouseInfo);
			return "warehouse/updateWarehouseInfoManger";
		}else{
			return "error";
		}
	}
	
	/**
	 * �޸�
	 */
	@RequestMapping("updateWarehouseInfo")
	public String updateWarehouseInfo(WarehouseInfo warehouseInfo) {
		if(IwService.updateWarehouseInfo(warehouseInfo)) {
			return "redirect:selectAll.action";
		} else {
			return "Error";
		}
	}
}
