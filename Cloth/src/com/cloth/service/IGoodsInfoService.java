package com.cloth.service;

import java.util.List;

import com.cloth.entity.GoodsInfo;
import com.cloth.util.Pager;

public interface IGoodsInfoService {
	public Pager<GoodsInfo> queryAllToIndex(int pageIndex,int pageSize);//��ҳ��ѯ���е���Ʒ
	public GoodsInfo selectOneById(String goodsId);//����goodsId��ѯ��Ʒ
	public boolean updateGoodsByid(GoodsInfo goods);//�޸���Ʒ��Ϣ
	public boolean updateGoodsNum(String goodsName,int goodsNum);//�޸���Ʒ����
	public boolean insertGoods(GoodsInfo goods);//������Ʒ
	public List<GoodsInfo> selectAllToList();//��ѯ��������Ʒ����list
	public List<GoodsInfo> queryAllByGoodsType(String goodTypeId);//������Ʒ���Ͳ�ѯ��Ʒ
	public List<GoodsInfo> queryAllSaleGood();//��ѯ������Ʒ
	public List<GoodsInfo> selectBygoodsName(String goodsName);//������Ʒ���Ʋ�ѯ��Ʒ
	public GoodsInfo selectOnebySize(String goodsName,String sizeName,String colorName);
}
