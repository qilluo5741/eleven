package com.cloth.dao;

import java.util.List;
import com.cloth.entity.OrderInfo;
import com.cloth.util.Pager;

public interface IOrderInfoDao {
	public OrderInfo selectOneById(String orderId);
	public List<OrderInfo> selectAllList();
	public Pager<OrderInfo> selectAll(int pageIndex, int pageSize);
	public void insert(OrderInfo order);
	public boolean updateOrderInfoBy(OrderInfo order);
	public boolean deleteOrderInfoInfo(String orderId);
	/**
	 * ��ѯ��������������Ʒ����
	 * @param orderId
	 * @return
	 */
	public boolean selectOrderById(String orderId);
	public List<OrderInfo> selectIsDo();
	
	public boolean passVerify(String orderId);
	public boolean noPassVerify(String orderId);
}
