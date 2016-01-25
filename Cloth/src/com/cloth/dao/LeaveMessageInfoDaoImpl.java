package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.LeaveMessageInfo;
import com.cloth.util.Pager;

@Repository
public class LeaveMessageInfoDaoImpl extends HibernateDaoSupport implements
		ILeaveMessageInfoDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	/**
	 * 插入单个
	 * */
	public boolean insertOne(LeaveMessageInfo leaveMsg) {
		try {
			this.getSessionFactory().getCurrentSession().save(leaveMsg);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询所有分页
	 * */
	@SuppressWarnings("unchecked")
	public Pager<LeaveMessageInfo> selectAllByPager(int pageIndex, int pageSize) {
		Pager<LeaveMessageInfo> pager = new Pager<LeaveMessageInfo>();
		pager.setPageIndex(pageIndex);
		pager.setPageSize(pageSize);
		List<LeaveMessageInfo> list = getSessionFactory().getCurrentSession().createQuery("from LeaveMessageInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)getSessionFactory().getCurrentSession().createQuery("select count(*) from LeaveMessageInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}

}
