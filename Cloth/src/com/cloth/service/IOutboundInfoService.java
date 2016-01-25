package com.cloth.service;

import java.util.List;

import com.cloth.entity.OutboundInfo;
import com.cloth.util.Pager;

public interface IOutboundInfoService {
	public List<OutboundInfo> selectAllList();
	public Pager<OutboundInfo> selectbyAlloutbound(int pageIndex, int pageSize);
	public boolean insertOne(OutboundInfo outb);
	public OutboundInfo selectOutboundInfo(String outboundId);
	public boolean updateOutboundInfo(OutboundInfo outb);
	public boolean deleteOutboundInfo(String outboundId);
}
