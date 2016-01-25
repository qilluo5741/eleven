package com.cloth.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cloth.entity.JoiningTraderInfo;
import com.cloth.service.JoiningTraderServiceImpl;
import com.cloth.util.Pager;

@Controller
@RequestMapping("join")
public class JoiningTraderController {
	@Autowired
	private JoiningTraderServiceImpl joinservice;
	
	/**
	 * ��ѯ���зŻ�list
	 * @param map
	 * @return
	 */
	@RequestMapping("selectAllToList")
	public String selectAllToList(ModelMap map){
		List<JoiningTraderInfo> list=joinservice.selectAllToList();
		map.addAttribute("joinList", list);
		return "join/joinIndex";
	}
	
	/**
	 * ��ѯ����
	 */
	@RequestMapping("selectOneById")
	public String selectOneById(String joiningTraderId,ModelMap map){
		JoiningTraderInfo joiningTrader=joinservice.selectOneById(joiningTraderId);
		map.addAttribute("joiningTrader", joiningTrader);
		return "join/joinEdit";
	}
	/**
	 * �޸�
	 * @param joiningTrader
	 * @return
	 */
	@RequestMapping("updateJoininfTraderByid")
	public @ResponseBody String updateJoininfTraderByid(JoiningTraderInfo joiningTrader){
		if(joinservice.updateJoininfTraderByid(joiningTrader))
		{
			return "0";
		}
		else{
			return "1";
		}
	}
	/**
	 * ��ҳ��ѯ���еļ�����
	 * @param pager
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllToJoining")
	public String queryAllToJoining(Pager<JoiningTraderInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(7);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=joinservice.queryAllToJoining(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pager", pager);
		//ȡ�ü���
		return "join/joinIndex";
	}
	
	/**
	 * �ü�����ͨ�����
	 * @param joiningTraderId
	 * @return
	 */
	@RequestMapping("passVerify")
	public @ResponseBody String passVerify(String joiningTraderId){
		if(joinservice.passVerify(joiningTraderId)){
			return "0";
		}else{
			return "1";
		}
	}
	
	/**
	 * ���ü�����ͨ�����
	 * @param joiningTraderId
	 * @return
	 */
	@RequestMapping("noPassVerify")
	public @ResponseBody String noPassVerify(String joiningTraderId){
		if(joinservice.noPassVerify(joiningTraderId)){
			return "0";
		}else{
			return "1";
		}
	}
	
	/**
	 * ����µļ�����
	 * */
	@SuppressWarnings("deprecation")
	@RequestMapping("insertOneJoiningTrader")
	public String insertOneJoiningTrader(JoiningTraderInfo join,ModelMap model) {
		join.setJoiningTraderNo(6);
		join.setJoiningTraderTime((new Date()).toLocaleString());
		join.setJoiningTraderStatus(0);
		join.setJoiningWarning(0);
		join.setUser(null);
		if(joinservice.insertOneJoiningTrader(join)) {
			model.addAttribute("isOk", 1);
			return "model/joinMe";
		} else {
			return "error";
		}
	}
}
