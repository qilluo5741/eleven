package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.SupplierInfo;
import com.cloth.util.Pager;

@Repository
@SuppressWarnings("unchecked")
public class SupplierInfoImpl extends HibernateDaoSupport implements ISupplierInfoDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	/**
	 * ��ҳ��ѯȫ��
	 */
	public Pager<SupplierInfo> querySelectAll(int pageIndex,int pageSize) {
		// TODO Auto-generated method stub
		
		Pager<SupplierInfo> pager = new Pager<SupplierInfo>();
		pager.setPageIndex(pageIndex);
		pager.setPageSize(pageSize);
		List<SupplierInfo> list = this.getSessionFactory().getCurrentSession().createQuery("from SupplierInfo").setFirstResult((pageIndex - 1) * pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from SupplierInfo ").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}

	/**
	 * ��ѯȫ��
	 */
	
	public List<SupplierInfo> selectAll() {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().createQuery("from SupplierInfo").list();
	}
	/***
	 * ���
	 */
	public boolean insert(SupplierInfo supplier) {
		// TODO Auto-generated method stub
		try {
			this.getSessionFactory().getCurrentSession().save(supplier);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * ��ѯ����
	 */
	public boolean selectOne(String supplierName, String supplierPeople, String supplierAddress) {
		// TODO Auto-generated method stub
		List<SupplierInfo> list = this.getSessionFactory().getCurrentSession().createQuery("from SupplierInfo s where s.supplierName = :supplierName and s.supplierAddress = :supplierAddress and s.supplierPeople = :supplierPeople")
		.setString("supplierName", supplierName).setString("supplierPeople", supplierPeople).setString("supplierAddress", supplierAddress).list();
		if(list.size() > 0){
			return true;
		}
		return false;
	}
}
