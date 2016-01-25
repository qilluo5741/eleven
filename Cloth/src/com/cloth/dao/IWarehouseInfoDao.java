package com.cloth.dao;

import java.util.List;
import com.cloth.entity.WarehouseInfo;
import com.cloth.util.Pager;

public interface IWarehouseInfoDao {
	public WarehouseInfo selectOneById(String warehouseId);
	public List<WarehouseInfo> selectAllList();
	public Pager<WarehouseInfo> selectAll(int pageIndex, int pageSize);
	public boolean insert(WarehouseInfo warehouseInfo);
	public boolean updateWarehouseInfo(WarehouseInfo warehouseInfo);
	public boolean deleteWarehouseInfo(String warehouseId);
}
