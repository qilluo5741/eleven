package com.cloth.service;

import com.cloth.entity.LocalReturnInfo;
import com.cloth.util.Pager;

public interface ILocalReturnService {
	public Pager<LocalReturnInfo> queryLocalAll(int pageIndex,int pageSize);//��ѯ���еı����˻���¼
	public boolean updateReturnStatus(String returnId);//�ı��˻�״̬
	public LocalReturnInfo selectOntByReturnId(String returnId);//����Id��ѯ�����˻���¼
	public boolean returnGoods(LocalReturnInfo locals,String empId,String outboundId);//�����˻�
}
