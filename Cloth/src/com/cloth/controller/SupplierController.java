package com.cloth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloth.entity.SupplierInfo;
import com.cloth.service.ISupplierInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("supplier")
public class SupplierController {

	@Autowired
	private ISupplierInfoService supplierService;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;

	/**
	 * ��ҳ
	 * @param pager
	 * @param map
	 * @return
	 */
	@RequestMapping("querySelectAll")
	public String querySelectAll(Pager<SupplierInfo> pager,ModelMap map){
		pager.setPageIndex(pager.getPageIndex());
		pager.setPageSize(5);
		pager = supplierService.querySelectAll(pager.getPageIndex(), pager.getPageSize());
		map.addAttribute("supplierPager", pager);
		return "supplier/supplierManger";
	}
	
	/**
	 * ���
	 * @param supplier
	 * @return
	 */
	@RequestMapping("insert")
	public String insert(SupplierInfo supplier){
		if(supplierService.insert(supplier)){
			return "supplier/supplierManger";
		}
		return "error";
	}
	
	/**
	 * ��ѯ����
	 */
	@RequestMapping("selectOne")
	public @ResponseBody String selectOne(String supplierName, String supplierPeople, String supplierAddress){
		if(supplierService.selectOne(supplierName, supplierPeople, supplierAddress)){
			return "true";
		}
		return "false";
	}
}
