package com.cloth.dao;

import java.util.List;

import com.cloth.entity.SupplierInfo;
import com.cloth.util.Pager;

public interface ISupplierInfoDao {
	
	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<SupplierInfo> selectAll();
	
	/**
	 * ��ѯ����
	 * @param supplierId
	 * @return
	 */
	public boolean selectOne(String supplierName, String supplierPeople, String supplierAddress);
	
	/**
	 * ��ҳ��ѯȫ��
	 * @return
	 */
	public Pager<SupplierInfo> querySelectAll(int pageIndex,int pageSize);
	
	/**
	 * ���
	 * @param supplier
	 * @return
	 */
	public boolean insert(SupplierInfo supplier);
	
	
}
