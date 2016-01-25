package com.cloth.service;

import java.util.List;

import com.cloth.entity.ColorInfo;
import com.cloth.util.Pager;

public interface IColorInfoService {

	/**
	 * ��ѯ����
	 * @return
	 */
	public List<ColorInfo> selectAll();
	
	/**
	 * ��ҳ��ѯȫ��
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<ColorInfo> querySelectAll(int pageIndex, int pageSize);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	public ColorInfo selectOne(String colorId);
	
	/**
	 * ������ɫ���ѯ
	 * @return
	 */
	public ColorInfo selectName(String colorNo);
	
	/**
	 * ���
	 * @param color
	 * @return
	 */
	public boolean insertColorInfo(ColorInfo color);
	
	
}
