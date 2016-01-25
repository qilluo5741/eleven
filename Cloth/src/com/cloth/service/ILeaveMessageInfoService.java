package com.cloth.service;

import com.cloth.entity.LeaveMessageInfo;
import com.cloth.util.Pager;

public interface ILeaveMessageInfoService {
	public Pager<LeaveMessageInfo> selectAllByPager(int pageIndex,int pageSize);
	public boolean insertOne(LeaveMessageInfo leaveMsg);
}
