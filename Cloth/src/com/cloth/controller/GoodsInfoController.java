package com.cloth.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.cloth.entity.GoodsInfo;
import com.cloth.service.IGoodsInfoService;
import com.cloth.service.IProcurementInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("goods")
public class GoodsInfoController {
	
	@Autowired
	private IGoodsInfoService goodsService;
	@Autowired
	private IProcurementInfoService proservice;
	
	/**
	 * ��ҳ��ѯ���е���Ʒ
	 * @param pager
	 * @param model
	 * @return
	 */
	@RequestMapping("queryallBypager")
	public String queryallBypager(Pager<GoodsInfo> pager,ModelMap model){
		//������ʾ������
		pager.setPageSize(4);
		pager.setPageIndex(pager.getPageIndex());
		//ȡ������
		pager=goodsService.queryAllToIndex(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pagerGoods", pager);
		//ȡ�ü���
		return "goods/goodsIndex";
	}
	
	/**
	 * ��ѯ������Ʒ
	 * @param goodsId
	 * @param map
	 * @return
	 */
	@RequestMapping("selectOneById")
	public String selectOneById(String goodsId,ModelMap map){
		GoodsInfo goods=goodsService.selectOneById(goodsId);
		if(goods!=null){
			map.addAttribute("goods", goods);
			return "goods/goodsUpdate";
		}else{
			return "error";
		}
	}
	
	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods
	 * @return
	 */
	@RequestMapping("updateGoodsByid")
	public @ResponseBody String updateGoodsByid(GoodsInfo goods){
		if(goodsService.updateGoodsByid(goods)){
			return "0";
		}else{
			return "1";
		}
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("insertGoods")
	public String insertGoods(GoodsInfo goods,MultipartFile imgGoods,HttpServletRequest request) throws IllegalStateException, IOException{
		if(imgGoods != null){
			String fileName = imgGoods.getOriginalFilename();
			String newFileName = request.getRealPath("/")+"/images/"+fileName.toString();
			//����ͼƬ�ϴ�����������֮����ļ�
			File file = new File(newFileName);
			//��photoFileд�뵽file
			imgGoods.transferTo(file);
			goods.setGoodsImg(file.getName());
			goods.setProcurement(proservice.selectOneById("24333928814870697"));
		}
		if(goodsService.insertGoods(goods)){
			return "redirect:queryallBypager.action";
		}
		else{
			return "error";
		}
	}
	
	/**
	 * ������Ʒ���Ͳ�ѯ��Ʒ
	 */
	@RequestMapping("queryAllByGoodsType")
	public @ResponseBody String queryAllByGoodsType(ModelMap model,String goodTypeId){
		List<GoodsInfo> list = goodsService.queryAllByGoodsType(goodTypeId);
		JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		jsonConfig.setExcludes(new String[]{"procurement", "size", "color"});  //�˴������㣬����������ֶ�
		JSONArray ja=JSONArray.fromObject(list,jsonConfig);
		return ja.toString();
	}
	
	/**
	 * ��ѯ������Ʒ
	 * @return
	 */
	@RequestMapping("queryAllSaleGood")
	public @ResponseBody String queryAllSaleGood(){
		List<GoodsInfo> list = goodsService.queryAllSaleGood();
		JsonConfig jsonConfig = new JsonConfig();  //���������ļ�
		jsonConfig.setIgnoreDefaultExcludes(false);  //����Ĭ�Ϻ���
		jsonConfig.setExcludes(new String[]{"procurement", "size", "color"});  //�˴������㣬ֻҪ����������ֶ�
		JSONArray ja=JSONArray.fromObject(list,jsonConfig);
		return ja.toString();
	}
	
	@RequestMapping("selectBygoodsName")
	public String selectBygoodsName(String goodsId,ModelMap model) throws UnsupportedEncodingException{
		GoodsInfo goods=goodsService.selectOneById(goodsId);
		List<GoodsInfo> glist=goodsService.selectBygoodsName(goods.getGoodsName());
		model.addAttribute("glist", glist);
		model.addAttribute("goods", goods);
		return "model/detail";
	}
}
