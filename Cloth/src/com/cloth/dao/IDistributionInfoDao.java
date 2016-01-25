package com.cloth.dao;

import java.util.List;

import com.cloth.entity.DistributionInfo;
import com.cloth.util.Pager;

public interface IDistributionInfoDao {

	/**
	 * ��ѯȫ��
	 * @return
	 */
	public List<DistributionInfo> selectListAll();
	
	/**
	 * ��ѯ����
	 * @param distributionId
	 * @return
	 */
	public DistributionInfo selectOne(String distributionId);
	
	/**
	 * ��ҳ
	 * @return
	 */
	public Pager<DistributionInfo> querySelectAll(int pageIndex, int pageSize);
	
	/**
	 * ���
	 * @param distribution
	 * @return
	 */
	public boolean insert(DistributionInfo distribution);
	
	/**
	 * ����
	 * @return
	 */
	public boolean updateIsAcceptance(String distributionId,int isAcceptance);
}
