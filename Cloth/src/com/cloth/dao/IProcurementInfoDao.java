package com.cloth.dao;

import java.util.List;
import com.cloth.entity.ProcurementInfo;
import com.cloth.util.Pager;
public interface IProcurementInfoDao {
	public ProcurementInfo selectOneById(String ProcurementId);
	public List<ProcurementInfo> selectAllList();
	public Pager<ProcurementInfo> selectAll(int pageIndex, int pageSize);
	public boolean insert(ProcurementInfo procurement);
	public boolean updateProcurementInfo(ProcurementInfo procurement);
	public boolean deleteProcurementInfo(String procurementId);
}
