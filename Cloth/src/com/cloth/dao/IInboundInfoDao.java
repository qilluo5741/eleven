package com.cloth.dao;

import java.util.List;

import com.cloth.entity.InboundInfo;
import com.cloth.util.Pager;

public interface IInboundInfoDao {

	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<InboundInfo> selectList();
	
	/**
	 * ���
	 * @param inbound
	 * @return
	 */
	public boolean insert(InboundInfo inbound);
	
	/**
	 * ��ҳ��ѯ
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<InboundInfo> querySelectAll(int pageIndex, int pageSize);
	
	
	
}
