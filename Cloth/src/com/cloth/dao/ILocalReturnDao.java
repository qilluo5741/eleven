package com.cloth.dao;

import com.cloth.entity.LocalReturnInfo;
import com.cloth.util.Pager;

public interface ILocalReturnDao {
	public Pager<LocalReturnInfo> queryLocalAll(int pageIndex,int pageSize);//��ѯ�����˻���¼
	public boolean updateReturnStatus(String returnId);//�ı��˻�״̬
	public LocalReturnInfo selectOntByReturnId(String returnId);//����Id��ѯ�����˻���¼
	public boolean returnGoods(LocalReturnInfo locals,String empId,String outboundId);//�����˻�
}
