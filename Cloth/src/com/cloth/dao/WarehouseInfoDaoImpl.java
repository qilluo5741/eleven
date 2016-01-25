package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.cloth.entity.WarehouseInfo;
import com.cloth.util.Pager;
@Repository
public class WarehouseInfoDaoImpl extends HibernateDaoSupport implements IWarehouseInfoDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	public Pager<WarehouseInfo> selectAll(int pageIndex, int pageSize) {
		Pager<WarehouseInfo> pager=new Pager<WarehouseInfo>();
		//设置当前页数
		pager.setPageIndex(pageIndex);
		//设置每页的大小
		pager.setPageSize(pageSize);
		List<WarehouseInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from WarehouseInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from WarehouseInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}
	@SuppressWarnings("unchecked")
	public List<WarehouseInfo> selectAllList() {
		return this.getSessionFactory().getCurrentSession().createQuery("from WarehouseInfo").list();
	}
	public WarehouseInfo selectOneById(String warehouseId) {
		return (WarehouseInfo) getSessionFactory().getCurrentSession().get(WarehouseInfo.class,warehouseId);
	}
	public boolean deleteWarehouseInfo(String warehouseId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("delete WarehouseInfo w where w.warehouseId = :warehouseId")
			.setString("warehouseId",warehouseId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean insert(WarehouseInfo warehouseInfo) {
		try {
			Session session=getSessionFactory().getCurrentSession();
			session.save(warehouseInfo);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateWarehouseInfo(WarehouseInfo warehouseInfo) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update WarehouseInfo w set w.warehouseName =:warehouseName,w.warehouseAddress =:warehouseAddress,w.emp.empId =:empId where w.warehouseId=:warehouseId")
			.setString("warehouseName", warehouseInfo.getWarehouseName())
			.setString("warehouseAddress", warehouseInfo.getWarehouseAddress())
			.setString("empId",warehouseInfo.getEmp().getEmpId())
			.setString("warehouseId",warehouseInfo.getWarehouseId())
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
