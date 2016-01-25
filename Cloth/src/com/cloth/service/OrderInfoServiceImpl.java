package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IOrderInfoDao;
import com.cloth.entity.OrderInfo;
import com.cloth.util.Pager;
@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class OrderInfoServiceImpl implements IOrderInfoService {
	@Autowired
	private IOrderInfoDao dao;
	public boolean deleteOrderInfoInfo(String orderId) {
		return dao.deleteOrderInfoInfo(orderId);
	}

	public void insert(OrderInfo order) {
		dao.insert(order);
	}

	public Pager<OrderInfo> selectAll(int pageIndex, int pageSize) {
		return dao.selectAll(pageIndex, pageSize);
	}

	public List<OrderInfo> selectAllList() {
		return dao.selectAllList();
	}

	public OrderInfo selectOneById(String orderId) {
		return dao.selectOneById(orderId);
	}

	public boolean updateOrderInfoBy(OrderInfo order) {
		return dao.updateOrderInfoBy(order);
	}

	/**
	 * ��ѯδ����Ķ���
	 */
	public List<OrderInfo> selectIsDo() {
		// TODO Auto-generated method stub
		return dao.selectIsDo();
	}

	/**
	 * ��ѯ���뵥����Ʒ�������Ƿ��㹻
	 */
	public boolean selectOrderById(String orderId) {
		return dao.selectOrderById(orderId);
	}
	public boolean passVerify(String orderId) {
		return dao.passVerify(orderId);
	}
	public boolean noPassVerify(String orderId) {
		return dao.noPassVerify(orderId);
	}
}
