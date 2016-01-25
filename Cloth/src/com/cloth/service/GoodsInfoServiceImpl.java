package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IGoodsInfoDao;
import com.cloth.entity.GoodsInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class GoodsInfoServiceImpl implements IGoodsInfoService {

	@Autowired
	private IGoodsInfoDao dao;
	
	/**
	 * ��ҳ��ѯ���� 
	 */
	public Pager<GoodsInfo> queryAllToIndex(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.queryAllToIndex(pageIndex, pageSize);
	}

	/**
	 * ����Id��ѯ������Ʒ
	 */
	public GoodsInfo selectOneById(String goodsId) {
		// TODO Auto-generated method stub
		return dao.selectOneById(goodsId);
	}

	public boolean updateGoodsByid(GoodsInfo goods) {
		// TODO Auto-generated method stub
		return dao.updateGoodsByid(goods);
	}
	
	public boolean updateGoodsNum( String goodsName, int goodsNum) {
		// TODO Auto-generated method stub
		return dao.updateGoodsNum( goodsName, goodsNum);
	}
	
	/**
	 * �����Ʒ
	 */
	public boolean insertGoods(GoodsInfo goods) {
		// TODO Auto-generated method stub
		return dao.insertGoods(goods);
	}
	
	/**
	 * ��ѯ������Ʒ����list
	 */
	public List<GoodsInfo> selectAllToList() {
		// TODO Auto-generated method stub
		return dao.selectAllToList();
	}
	public List<GoodsInfo> queryAllByGoodsType(String goodTypeId) {
		return dao.queryAllByGoodsType(goodTypeId);
	}
	
	/**
	 * ��ѯ������Ʒ
	 */
	public List<GoodsInfo> queryAllSaleGood() {
		// TODO Auto-generated method stub
		return dao.queryAllSaleGood();
	}
	public List<GoodsInfo> selectBygoodsName(String goodsName) {
		// TODO Auto-generated method stub
		return dao.selectBygoodsName(goodsName);
	}
	
	public GoodsInfo selectOnebySize(String goodsName, String sizeName,
			String colorName) {
		// TODO Auto-generated method stub
		return dao.selectOnebySize(goodsName, sizeName, colorName);
	}
}
