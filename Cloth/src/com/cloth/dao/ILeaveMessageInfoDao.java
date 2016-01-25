package com.cloth.dao;

import com.cloth.entity.LeaveMessageInfo;
import com.cloth.util.Pager;

public interface ILeaveMessageInfoDao {
	public Pager<LeaveMessageInfo> selectAllByPager(int pageIndex,int pageSize);
	public boolean insertOne(LeaveMessageInfo leaveMsg);
}
