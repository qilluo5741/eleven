package com.cloth.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloth.entity.EmpInfo;
import com.cloth.entity.GoodsInventoryInfo;
import com.cloth.entity.InboundInfo;
import com.cloth.entity.JoiningTraderReturnInfo;
import com.cloth.entity.UserInfo;
import com.cloth.entity.WarehouseInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IGoodsInventoryService;
import com.cloth.service.IInboundInfoService;
import com.cloth.service.IJoiningTraderReturnInfoService;
import com.cloth.service.IWarehouseInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("joiningTraderReturn")
public class JoiningTraderReturnController {
	
	@Autowired
	private IJoiningTraderReturnInfoService jtriService;
	@Autowired
	private IGoodsInventoryService giService;
	@Autowired
	private IInboundInfoService ibService;
	@Autowired
	private IWarehouseInfoService iwiService;
	@Autowired
	private IEmpInfoService empService;
	@Autowired
	private HttpSession session;
	
	/**
	 * ��ѯ����
	 * */
	@RequestMapping("selectOne")//  http://localhost:8080/Cloth/joiningTraderReturn/selectOne.action?joiningTraderReturnId=24333928814870563
	public String selectOne(ModelMap model,String joiningTraderReturnId) {
		model.addAttribute("joiningTraderReturn", jtriService.selectOne(joiningTraderReturnId));
		return "join/joiningTraderReturnIndex";
	}
	
	/**
	 * ��ѯ����
	 * */
	@RequestMapping("selectAllByPager")//  http://localhost:8080/Cloth/joiningTraderReturn/selectAllByPager.action
	public String selectAllByPager(ModelMap model,Pager<JoiningTraderReturnInfo> pager) {
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		pager = jtriService.selectAllPager(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pager", pager);
		return "join/joiningTraderReturnIndex";
	}
	
	/**
	 * ͨ����ˣ��޸�״̬  ������  �޸Ŀ�棩
	 * */
	@RequestMapping("updateOneByStatus")
	public String updateOneByStatus(ModelMap model,JoiningTraderReturnInfo join) {
		//��õ�ǰ��¼�û������Ӧ��Ա��
		UserInfo user = (UserInfo) session.getAttribute("user");
		EmpInfo emp = empService.selectOneByUser(user);
		//�����˻����ʼ�ֿ�
		WarehouseInfo warehouse = iwiService.selectOneById("24333928814870687");
		
		System.out.println(warehouse.getWarehouseId());
		
		//�����������
		InboundInfo inbound = new InboundInfo(null, new Date(), emp, join.getGoodsName(), null, warehouse, join.getReturnRemark());
		//������Ʒ������
		GoodsInventoryInfo goodsInventory = new GoodsInventoryInfo(null, join.getGoodsName(), join.getColorName(), join.getSizeName(), join.getGoodsNum(), warehouse);
		//�жϸ���Ʒ�Ƿ����   ������  ���޸�   ������  �����
		goodsInventory = giService.selectOneBy(join.getGoodsName(), join.getColorName(), join.getSizeName());
		if(goodsInventory != null)
		{
			if(jtriService.updateOneByStatus(join.getJoiningTraderReturnId()) && ibService.insert(inbound) && giService.updateOneAdd(goodsInventory.getGoodsInventoryId(), join.getGoodsNum())) {
				return "redirect:selectAllByPager.action";
			} else {
				return "error";
			}
		} else {
			goodsInventory = new GoodsInventoryInfo(null, join.getGoodsName(), join.getColorName(), join.getSizeName(), join.getGoodsNum(), warehouse);
			if(jtriService.updateOneByStatus(join.getJoiningTraderReturnId()) && ibService.insert(inbound) && giService.insertOne(goodsInventory)) {
				return "redirect:selectAllByPager.action";
			} else {
				return "error";
			}
		}
	}
}
