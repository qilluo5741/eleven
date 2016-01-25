package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IDistributionInfoDao;
import com.cloth.entity.DistributionInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class DistributionInfoServiceImpl implements IDistributionInfoService {

	@Autowired
	private IDistributionInfoDao dao;
	
	/**
	 * 添加
	 */
	public boolean insert(DistributionInfo distribution) {
		// TODO Auto-generated method stub
		return dao.insert(distribution);
	}

	/**
	 * 分页
	 */
	public Pager<DistributionInfo> querySelectAll(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.querySelectAll(pageIndex, pageSize);
	}

	/**
	 * 查询全部
	 */
	public List<DistributionInfo> selectListAll() {
		// TODO Auto-generated method stub
		return dao.selectListAll();
	}
	
	/**
	 * 查询单个
	 */
	public DistributionInfo selectOne(String distributionId) {
		// TODO Auto-generated method stub
		return dao.selectOne(distributionId);
	}

	/**
	 * 配货，修改时间和是否配货
	 */
	public boolean updateIsAcceptance(String distributionId,int isAcceptance) {
		// TODO Auto-generated method stub
		return dao.updateIsAcceptance(distributionId,isAcceptance);
	}
}
