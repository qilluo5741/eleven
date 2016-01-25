package com.cloth.dao;


import java.util.List;

import com.cloth.entity.SizeInfo;
import com.cloth.util.Pager;

public interface ISizeInfoDao {
	public Pager<SizeInfo> queryAllSize(int pageIndex,int pageSize);//��ҳ��ѯ���еĳߴ�
	public boolean insertSize(SizeInfo sizes);//�����ߴ�
	public List<SizeInfo> selectAllToList();//��ѯ���гߴ緵��list
	public boolean selectIsExistsSize(String sizeName,String goodsTypeName);//��ѯ�Ƿ����
}
