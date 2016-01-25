package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.WarehousLogInfo;
import com.cloth.util.Pager;
@Repository
public class WarehousLogInfoDaoImpl extends HibernateDaoSupport implements IWarehousLogInfoDao {
	
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public Pager<WarehousLogInfo> selectAll(int pageIndex, int pageSize) {
		Pager<WarehousLogInfo> pager=new Pager<WarehousLogInfo>();
		//设置当前页数
		pager.setPageIndex(pageIndex);
		//设置每页的大小
		pager.setPageSize(pageSize);
		List<WarehousLogInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from WarehousLogInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from WarehousLogInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}
	
	@SuppressWarnings("unchecked")
	public List<WarehousLogInfo> selectAllList() {
		return this.getSessionFactory().getCurrentSession().createQuery("from WarehousLogInfo").list();
	}

	public boolean deleteWarehousLogInfo(String warehousLogId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("delete WarehousLogInfo w where w.warehousLogId = :warehousLogId")
			.setString("warehousLogId",warehousLogId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public WarehousLogInfo selectOneById(String warehousLogId) {
		return (WarehousLogInfo) getSessionFactory().getCurrentSession().get(WarehousLogInfo.class,warehousLogId);
	}

	public boolean updateWarehousLogInfo(WarehousLogInfo warehousLogInfo) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update WarehousLogInfo w set w.isIncrease =:isIncrease,w.outbound.outboundId =:outboundId,w.warehouse.warehouseId =:warehouseId,w.warehousLogRemark =:warehousLogRemark where w.warehousLogId =:warehousLogId")
			.setInteger("isIncrease", warehousLogInfo.getIsIncrease())
			.setString("outboundId", warehousLogInfo.getOutbound().getOutboundId())
			.setString("warehouseId",warehousLogInfo.getWarehouse().getWarehouseId())
			.setString("warehousLogRemark",warehousLogInfo.getWarehousLogRemark())
			.setString("warehousLogId",warehousLogInfo.getWarehousLogId())
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(WarehousLogInfo warehousLogInfo) {
		try {
			Session session=getSessionFactory().getCurrentSession();
			session.save(warehousLogInfo);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
