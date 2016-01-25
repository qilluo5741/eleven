package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.dao.IInboundInfoDao;
import com.cloth.entity.InboundInfo;
import com.cloth.util.Pager;

@Service
public class InboundInfoServiceImpl implements IInboundInfoService {

	@Autowired
	private IInboundInfoDao dao;
	
	/**
	 * ���
	 */
	public boolean insert(InboundInfo inbound) {
		// TODO Auto-generated method stub
		return dao.insert(inbound);
	}

	/**
	 * ��ҳ
	 */
	public Pager<InboundInfo> querySelectAll(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.querySelectAll(pageIndex, pageSize);
	}

	/**
	 * ��ѯȫ��
	 */
	public List<InboundInfo> selectList() {
		return dao.selectList();
	}
}
