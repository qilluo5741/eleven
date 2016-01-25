package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.ISupplierInfoDao;
import com.cloth.entity.SupplierInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class SupplierInfoServiceImpl implements ISupplierInfoService {

	@Autowired
	private ISupplierInfoDao dao;
	
	/**
	 * ��ҳ��ѯȫ��
	 */
	public Pager<SupplierInfo> querySelectAll(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.querySelectAll(pageIndex, pageSize);
	}

	/**
	 * ��ѯȫ��
	 */
	public List<SupplierInfo> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
	
	/**
	 * ���
	 */
	public boolean insert(SupplierInfo supplier) {
		// TODO Auto-generated method stub
		return dao.insert(supplier);
	}

	/**
	 *  ��ѯ����
	 */
	public boolean selectOne(String supplierName, String supplierPeople, String supplierAddress) {
		// TODO Auto-generated method stub
		return dao.selectOne(supplierName, supplierPeople, supplierAddress);
	}
}
