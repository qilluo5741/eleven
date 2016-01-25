package com.cloth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.ILeaveMessageInfoDao;
import com.cloth.entity.LeaveMessageInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class LeaveMessageInfoServiceImpl implements ILeaveMessageInfoService {

	@Autowired
	private ILeaveMessageInfoDao leaveMsgDao;
	
	public boolean insertOne(LeaveMessageInfo leaveMsg) {
		return this.leaveMsgDao.insertOne(leaveMsg);
	}

	public Pager<LeaveMessageInfo> selectAllByPager(int pageIndex, int pageSize) {
		return this.leaveMsgDao.selectAllByPager(pageIndex, pageSize);
	}

}
