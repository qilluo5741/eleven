package com.cloth.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloth.entity.ColorInfo;
import com.cloth.service.IColorInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("color")
public class ColorController {	
	@Autowired
	private IColorInfoService colorService;
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession session;
	
	/**
	 * ��ѯ����
	 * @param map
	 * @return
	 */
	@RequestMapping("selectAllToAjax")
	public @ResponseBody List<ColorInfo> selectAllToAjax(ModelMap map){
		List<ColorInfo> list = colorService.selectAll();
		return list;
	}

	/**
	 * ��ҳ��ѯ����
	 * @param map
	 * @return
	 */
	@RequestMapping("querySelectAll")
	public String querySelectAll(Pager<ColorInfo> pager, ModelMap map){
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		pager = colorService.querySelectAll(pager.getPageIndex(), pager.getPageSize());
		map.addAttribute("colorPager", pager);
		return "color/colorInfoManger";
	}
	/**
	 * ��ѯ����
	 * @param map
	 * @param colorId
	 * @return
	 */
	@RequestMapping("selectColorOne") 
	public String selectOne(ModelMap map,String colorId){
		ColorInfo color = colorService.selectOne(colorId);
		map.addAttribute("color", color);
		return "color/colorInfoupdate";
	}
	/**
	 * ������ɫ���ѯ
	 * @param map
	 * @param colorId
	 * @return
	 */
	@RequestMapping("selectColorNo") 
	public @ResponseBody String selectColorNo(String colorNo){
		ColorInfo color = colorService.selectName(colorNo);
		if(color != null){
			return "true";
		}
		else{
			return "false";
		}
	}
	/**
	 * ���
	 * @param map
	 * @param colorId
	 * @return
	 */
	@RequestMapping("insert") 
	public String insert(ColorInfo color){
		if(this.colorService.insertColorInfo(color)){
			return "color/colorInfoManger";
		}
		return "error";
	}
}
