package com.cloth.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.DistributionInfo;
import com.cloth.service.IDistributionInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("distribution")
public class DistributionController {

	@Autowired
	private IDistributionInfoService distributionService;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	
	/**
	 * ��ҳ
	 * @return
	 */
	@RequestMapping("querySelectAll")
	public String querySelectAll(Pager<DistributionInfo> pager, ModelMap map){
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		pager = distributionService.querySelectAll(pager.getPageIndex(), pager.getPageSize());
		map.addAttribute("distributionPager", pager);
		return "distribution/distributionManger";
	}
	
	/**
	 * ���
	 * @param distribution
	 * @return
	 */
	@RequestMapping("insert")
	public String insert(DistributionInfo distribution){
		if(distributionService.insert(distribution)){
			return "distribution/distributionManger";
		}
		return "error";
	}
	
	/**
	 * ���Ajax
	 * @param distribution
	 * @return
	 */
	@RequestMapping("insertAjax")
	public @ResponseBody String insertAjax(DistributionInfo distribution){
		if(distributionService.insert(distribution)){
			return "ture";
		}
		return "false";
	}
	
	/**
	 * ��ѯ����
	 * @param distributionId
	 * @param map
	 * @return
	 */
	public String selectOne(String distributionId,ModelMap map){
		DistributionInfo distribution = distributionService.selectOne(distributionId);
		map.addAttribute("distr", distribution);
		return "distribution/distributionUpdate";
	}
	
	/**
	 * ����
	 * @return
	 */
	@RequestMapping("updateIsAcceptance")
	public @ResponseBody String updateIsAcceptance(String distributionId, int isAcceptance){
		if(distributionService.updateIsAcceptance(distributionId,isAcceptance)){
			return "true";
		}
		return "false";
	}
}
