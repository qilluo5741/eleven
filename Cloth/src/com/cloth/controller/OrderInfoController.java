package com.cloth.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.OrderInfo;
import com.cloth.service.IOrderInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("Order")
public class OrderInfoController {
	@Autowired
	private IOrderInfoService OrderService;
	/**
	 * ��ҳ
	 * @param pager
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllByPager")
	public String queryAllOrder(Pager<OrderInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=OrderService.selectAll(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("OrderList",pager);
		//ȡ�ü���
		return "Order/OrderManger";
	}
	
	/**
	 * ��ѯδ����Ķ���
	 * @return
	 */
	@RequestMapping("selectIsDo")
	public String selectIsDo(ModelMap map){
		List<OrderInfo> list = OrderService.selectIsDo();
		map.addAttribute("isDoList", list);
		return "distribution/distributionInsert";
	}
	
	/**
	 * ��ѯ�����Ƿ���
	 * @return
	 */
	@RequestMapping("selectOrderById")
	public @ResponseBody String selectOrderById(String orderId ){
		if(OrderService.selectOrderById(orderId)){
			return "true";
		}
		return "false";
	}
	
	/**
	 * ��ѯ����
	 * @param orderId
	 * @return
	 */
	@RequestMapping("selectOneById")
	public @ResponseBody String selectOneById(String orderId){
		JsonConfig cfg = new JsonConfig();
		cfg.setJsonPropertyFilter(new PropertyFilter() {
			public boolean apply(Object source, String name, Object value) {
				
				if(name.equals("joiningTrader")){
					return true;
				}else {
					return false;
				}
			}
		});
		OrderInfo order = OrderService.selectOneById(orderId);
		JSONArray jo = JSONArray.fromObject(order,cfg);
		System.out.println(jo.toString());
		return jo.toString();
	}
	/*
	 * ���ͨ��
	 */
	@RequestMapping("passVerify")
	public @ResponseBody String passVerify(String orderId){
		if(OrderService.passVerify(orderId)){
			return "redirect:queryAllByPager.action";
		} else {
			return "error";
		}
	}
	/*
	 * ���ʧ��
	 */
	@RequestMapping("noPassVerify")
	public @ResponseBody String noPassVerify(String orderId){
		if(OrderService.noPassVerify(orderId)){
			return "redirect:queryAllByPager.action";
		} else {
			return "error";
		}
	}
}


