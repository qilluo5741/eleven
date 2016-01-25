package com.cloth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.ILocalReturnDao;
import com.cloth.entity.LocalReturnInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class LocalReturnServiceImpl implements ILocalReturnService {
	
	@Autowired
	private ILocalReturnDao dao;

	/**
	 * ��ҳ��ѯ����
	 */
	public Pager<LocalReturnInfo> queryLocalAll(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryLocalAll(pageIndex, pageSize);
	}

	/**
	 * �޸ı����˻�״̬
	 */
	public boolean updateReturnStatus(String returnId) {
		// TODO Auto-generated method stub
		return dao.updateReturnStatus(returnId);
	}
	
	/**
	 * ����id��ѯ�����˻���¼
	 */
	public LocalReturnInfo selectOntByReturnId(String returnId) {
		// TODO Auto-generated method stub
		return dao.selectOntByReturnId(returnId);
	}

	public boolean returnGoods(LocalReturnInfo locals, String empId,
			String outboundId) {
		// TODO Auto-generated method stub
		return dao.returnGoods(locals, empId, outboundId);
	}
}
