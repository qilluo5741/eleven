package com.cloth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IJoiningTraderReturnInfoDao;
import com.cloth.entity.JoiningTraderReturnInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class JoiningTraderReturnInfoServiceImpl implements
		IJoiningTraderReturnInfoService {

	@Autowired
	private IJoiningTraderReturnInfoDao jtriDao;
	
	/**
	 * 	��ѯ����
	 * */
	public JoiningTraderReturnInfo selectOne(String joiningTraderReturnId) {
		return jtriDao.selectOne(joiningTraderReturnId);
	}
	
	/**
	 * 	��ҳ��ѯ����
	 * */
	public Pager<JoiningTraderReturnInfo> selectAllPager(int pageIndex, int pageSize) {
		return jtriDao.selectAllByPager(pageIndex, pageSize);
	}
	
	/**
	 * 	�޸�״̬
	 * */
	public boolean updateOneByStatus(String joiningTraderReturnId) {
		return jtriDao.updateOneByStatus(joiningTraderReturnId);
	}
	
	/**
	 * ��ӵ���
	 * */
	public boolean insertOne(JoiningTraderReturnInfo joiningTraderReturn) {
		return jtriDao.insertOne(joiningTraderReturn);
	}

}
