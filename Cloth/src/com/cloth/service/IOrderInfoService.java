package com.cloth.service;

import java.util.List;
import com.cloth.entity.OrderInfo;
import com.cloth.util.Pager;

public interface IOrderInfoService {
	/**
	 * ��ѯ����
	 * @param orderId
	 * @return
	 */
	public OrderInfo selectOneById(String orderId);
	/**
	 * ��ѯ���� list
	 * @return
	 */
	public List<OrderInfo> selectAllList();
	/**
	 * ��ҳ
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public Pager<OrderInfo> selectAll(int pageIndex, int pageSize);
	/**
	 * ���
	 * @param order
	 */
	public void insert(OrderInfo order);
	/**
	 * �޸�
	 * @param order
	 * @return
	 */
	public boolean updateOrderInfoBy(OrderInfo order);
	/**
	 * ɾ��
	 * @param orderId
	 * @return
	 */
	public boolean deleteOrderInfoInfo(String orderId);
	
	/**
	 * ��ѯ��������������Ʒ����
	 * @param orderId
	 * @return
	 */
	public boolean selectOrderById(String orderId);
	
	/**
	 * ��ѯδ����Ķ���
	 * @return
	 */
	public List<OrderInfo> selectIsDo();
	public boolean passVerify(String orderId);
	public boolean noPassVerify(String orderId);
}
