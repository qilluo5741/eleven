package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IJoiningTraderDao;
import com.cloth.entity.JoiningTraderInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class JoiningTraderServiceImpl implements IJoiningTraderService {
	
	@Autowired
	private IJoiningTraderDao dao;

	/**
	 * ����µļ�����
	 */
	public boolean insertOneJoiningTrader(JoiningTraderInfo join) {
		// TODO Auto-generated method stub
		return dao.insertOneJoiningTrader(join);
	}

	/**
	 * ��ѯ����������
	 */
	public JoiningTraderInfo selectOneById(String joiningTraderId) {
		// TODO Auto-generated method stub
		return dao.selectOneById(joiningTraderId);
	}

	/**
	 * ��ѯ���еļ����̷���list
	 */
	public List<JoiningTraderInfo> selectAllToList() {
		return dao.selectAllToList();
	}

	/**
	 * �޸ļ����̵Ļ�������
	 */
	public boolean updateJoininfTraderByid(JoiningTraderInfo joiningTrader) {
		return dao.updateJoininfTraderByid(joiningTrader);
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	public Pager<JoiningTraderInfo> queryAllToJoining(int pageIndex,
			int pageSize) {
		return dao.queryAllToJoining(pageIndex, pageSize);
	}
	
	/**
	 * �ü�����ͨ�����
	 */
	public boolean passVerify(String joiningTraderId) {
		return dao.passVerify(joiningTraderId);
	}
	
	/**
	 * �ü����̲�ͨ�����
	 */
	public boolean noPassVerify(String joiningTraderId) {
		return dao.noPassVerify(joiningTraderId);
	}
}
