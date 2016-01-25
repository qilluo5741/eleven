package com.cloth.dao;


import java.util.List;

import com.cloth.entity.JoiningTraderInfo;
import com.cloth.util.Pager;


public interface IJoiningTraderDao {
	public JoiningTraderInfo selectOneById(String joiningTraderId);//��ѯ����
	public boolean insertOneJoiningTrader(JoiningTraderInfo join);//����µļ�����
	public List<JoiningTraderInfo> selectAllToList();//��ѯ���еļ����̷���list
	public boolean updateJoininfTraderByid(JoiningTraderInfo joiningTrader);//�޸ļ����̻�����Ϣ
	public Pager<JoiningTraderInfo> queryAllToJoining(int pageIndex,int pageSize);//��ҳ��ѯ
	public boolean passVerify(String joiningTraderId);//�ü�����ͨ�����
	public boolean noPassVerify(String joiningTraderId);//�ü����̲�ͨ�����
}
