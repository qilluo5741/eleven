package com.cloth.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cloth.entity.EmpInfo;
import com.cloth.entity.PositionInfo;
import com.cloth.service.IEmpInfoService;
import com.cloth.service.IPositionInfoService;
import com.cloth.util.Pager;

@Controller
@RequestMapping("emp")
public class EmpController {
	
	@Autowired
	private IEmpInfoService empService;
	@Autowired
	private IPositionInfoService posService;

	/**
	 * ��ѯ����
	 * */
	@RequestMapping("selectOne")
	public String selectOne(ModelMap model, String empId, String a) {
		model.addAttribute("emp", empService.selectOne(empId));
		if(a.equals("1")) {
			return "emp/empUpdateLow";
		} else {
			model.addAttribute("posList", posService.queryAllPositionInfo());
			return "emp/empUpdateHigh";
		}
	}
	
	/**
	 * ��ѯ����
	 * */
	@RequestMapping("selectAll")
	public String selectAll(ModelMap model) {
		model.addAttribute("empList", empService.selectAll());
		return "emp/empIndex";
	}
	
	/**
	 * ��ҳ��ѯ����
	 * */
	@RequestMapping("selectAllByPager")
	public String selectAllByPager(ModelMap model,Pager<EmpInfo> pager) {
		pager.setPageSize(5);
		pager.setPageIndex(pager.getPageIndex());
		pager = empService.selectAllByPager(pager.getPageIndex(), pager.getPageSize());
		model.addAttribute("pager", pager);
		return "emp/empIndex";
	}
	
	/**
	 * ��ӵ���
	 * */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="insertOne", method = RequestMethod.POST) 
	public String insertOne(EmpInfo emp,@RequestParam(value = "imgEmp", required = false)MultipartFile imgEmp,HttpServletRequest request) throws IllegalStateException, IOException {
		//�ڽ�photoFile�ļ�д�뵽���������ļ�Ŀ¼
		if(imgEmp != null){
			//�õ���Ҫ�ϴ����ļ���
			String fileName = imgEmp.getOriginalFilename();
			//д�뵽ָ����Ŀ¼��E:\images\Desert.jpg��
			String newFileName = request.getRealPath("/")+"/images/"+fileName.substring(fileName.lastIndexOf("."));
			//����ͼƬ�ϴ�����������֮����ļ�
			File file = new File(newFileName);
			//��photoFileд�뵽file
			imgEmp.transferTo(file);
			emp.setEmpPhoto(file.getName());
		}
		if(empService.insertOne(emp)) {
			return "redirect:selectAllByPager.action";
		} else {
			return "error";
		}
	}
	
	/**
	 * ���ǰ�Ĳ�ѯ
	 * */
	@RequestMapping("insertOneBefore")
	public String insertOneBefore(ModelMap model) {
		model.addAttribute("posList", posService.queryAllPositionInfo());
		return "emp/empAdd";
	}
	
	/**
	 * ��ѯ����ְλ  ����Ajax
	 * */
	@RequestMapping("selectPostionAjax")
	public @ResponseBody List<PositionInfo> selectPostionAjax() {
		List<PositionInfo> list = posService.queryAllPositionInfo();
		return list;
	}
	/**
	 * �޸ĵ������������ϣ�
	 * */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="updateOneLow", method = RequestMethod.POST)
	public String updateOneLow(EmpInfo emp,@RequestParam(value = "imgEmp", required = false)MultipartFile imgEmp,HttpServletRequest request) throws IllegalStateException, IOException  {
		//�ڽ�photoFile�ļ�д�뵽���������ļ�Ŀ¼
		if(imgEmp != null){
			//�õ���Ҫ�ϴ����ļ���
			String fileName = imgEmp.getOriginalFilename();
			//д�뵽ָ����Ŀ¼��E:\images\Desert.jpg��
			String newFileName = request.getRealPath("/")+"/images/"+fileName.substring(fileName.lastIndexOf("."));
			//����ͼƬ�ϴ�����������֮����ļ�
			File file = new File(newFileName);
			//��photoFileд�뵽file
			imgEmp.transferTo(file);
			emp.setEmpPhoto(file.getName());
		}
		if(empService.updateOneLow(emp)) {
			return "redirect:selectAllByPager.action";
		} else {
			return "error";
		}
	}
	
	/**
	 * �޸ĵ������߼����ϣ�
	 * */
	@RequestMapping("updateOneHigh")
	public String updateOneHigh(EmpInfo emp) {
		if(empService.updateOneHigh(emp)) {
			return "redirect:selectAllByPager.action";
		} else {
			return "error";
		}
	}
	
	/**
	 * �޸ĵ������޸ľ�ְ״̬��
	 * */
	@RequestMapping("updateOneByStatus")
	public String updateOneByStatus(String empId,int isServing) {
		if(empService.updateOneByStatus(empId, isServing)) {
			return "redirect:selectAllByPager.action";
		} else {
			return "error";
		}
	}
}
