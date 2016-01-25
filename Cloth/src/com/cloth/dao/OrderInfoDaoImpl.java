package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.GoodsInfo;
import com.cloth.entity.OrderInfo;
import com.cloth.util.Pager;
@Repository
@SuppressWarnings("unchecked")
public class OrderInfoDaoImpl extends HibernateDaoSupport implements IOrderInfoDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	/*
	 *ɾ��
	 * */
	public boolean deleteOrderInfoInfo(String orderId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("delete OrderInfo o where o.orderId = :orderId")
			.setString("orderId", orderId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void insert(OrderInfo order) {
		this.getSessionFactory().getCurrentSession().save(order);
	}
	
	/**
	 * ��ҳ
	 */
	public Pager<OrderInfo> selectAll(int pageIndex, int pageSize) {
		Pager<OrderInfo> pager=new Pager<OrderInfo>();
		//���õ�ǰҳ��
		pager.setPageIndex(pageIndex);
		//����ÿҳ�Ĵ�С
		pager.setPageSize(pageSize);
		List<OrderInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from OrderInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from OrderInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}
	/**
	 * ��ѯ����
	 */
	public List<OrderInfo> selectAllList() {
		List<OrderInfo> list= this.getSessionFactory().getCurrentSession().createQuery("from OrderInfo order by OrderInfo desc").list();
		return list;
	}
	
	/**
	 * ��ѯ����
	 */
	public OrderInfo selectOneById(String orderId) {
		
		return (OrderInfo) getSessionFactory().getCurrentSession().get(OrderInfo.class,orderId);
	}
	/* order.goodsId = :order.goodsId,*/
	public boolean updateOrderInfoBy(OrderInfo order) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update OrderInfo order set order.goodsNum = :goodsNum,order.joiningTraderId=:joiningTraderId,order.isdo=:isdo,order.orderRemark=:orderRemark where order.orderId=:orderId")
			/*.setString("goodsId",order.getGoods().getGoodsId())*/
			.setInteger("goodsNum",order.getGoodsNum())
			.setString("joiningTraderId", order.getJoiningTrader().getJoiningTraderId())
			.setInteger("isdo", order.getIsdo())
			.setString("orderRemark",order.getOrderRemark())
			.setString("orderId", order.getOrderId())
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ѯδ����Ķ���
	 */
	public List<OrderInfo> selectIsDo() {
		List<OrderInfo> list= this.getSessionFactory().getCurrentSession().createQuery("from OrderInfo o where o.isdo = 1").list();
		return list;
	}
	/**
	 * ��ѯ������Ʒ����*---------------*�ж�����
	 */
	public boolean selectOrderById(String orderId) {
		//��ѯ��Ʒid
		int goodsId = ((Long)this.getSessionFactory().getCurrentSession().createQuery("select o.goods.goodsId from OrderInfo o where o.orderId = :orderId").setString("orderId", orderId).uniqueResult()).intValue();
		//��ѯ����Ʒ��������Ϣ
		List<GoodsInfo> list = this.getSessionFactory().getCurrentSession().createQuery("from GoodsInfo g where g.goodsId = :goodsId").setString("goodsId", goodsId+"").list();
		GoodsInfo goods = null;
		if(list.size() > 0){
			goods = list.get(0);
		}
		String colorName = goods.getColor().getColorName();
		String  sizeName = goods.getSize().getSizeName();
		String goodsName = goods.getGoodsName();
		//��ѯ��Ʒ��������
		int goodsNum = ((Long)this.getSessionFactory().getCurrentSession().createQuery("select goodsNum from GoodsInventoryInfo g where g.goodsName = :goodsName and colorName = :colorName and sizeName = :sizeName").setString("goodsName", goodsName).setString("colorName", colorName).setString("sizeName", sizeName).uniqueResult()).intValue();
		//��ѯ�������Ʒ����
		int rows = ((Long)this.getSessionFactory().getCurrentSession().createQuery("select o.goodsNum from OrderInfo o where o.orderId = :orderId").setString("orderId", orderId).uniqueResult()).intValue();
		if(goodsNum >= rows ){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean passVerify(String orderId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update OrderInfo order set order.isdo = 0 where order.orderId = :orderId")
			.setString("orderId", orderId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean noPassVerify(String orderId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update OrderInfo order set order.isdo = 2 where order.orderId = :orderId")
			.setString("orderId", orderId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
