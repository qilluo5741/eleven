package com.cloth.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.cloth.entity.ProcurementInfo;
import com.cloth.util.Pager;
@Repository
public class ProcurementInfoDaoImpl extends HibernateDaoSupport implements IProcurementInfoDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	public boolean insert(ProcurementInfo procurement) {
		try {
			Session session=getSessionFactory().getCurrentSession();
			session.save(procurement);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Pager<ProcurementInfo> selectAll(int pageIndex, int pageSize) {
		Pager<ProcurementInfo> pager=new Pager<ProcurementInfo>();
		//���õ�ǰҳ��
		pager.setPageIndex(pageIndex);
		//����ÿҳ�Ĵ�С
		pager.setPageSize(pageSize);
		List<ProcurementInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from ProcurementInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from ProcurementInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}

	@SuppressWarnings("unchecked")
	public List<ProcurementInfo> selectAllList() {
		return this.getSessionFactory().getCurrentSession().createQuery("from ProcurementInfo").list();
	}
	
	public ProcurementInfo selectOneById(String ProcurementId) {
		return (ProcurementInfo) getSessionFactory().getCurrentSession().get(ProcurementInfo.class,ProcurementId);
	}
	public boolean deleteProcurementInfo(String procurementId) {
		try {
			getSessionFactory().getCurrentSession().createQuery("delete ProcurementInfo p where p.procurementId = :procurementId")
			.setString("procurementId",procurementId)
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateProcurementInfo(ProcurementInfo procurement) {
		try {
			getSessionFactory().getCurrentSession().createQuery("update ProcurementInfo p set p.supplier.supplierId =:supplierId,p.emp.empId = :empId,p.procuremenRemark = :procuremenRemark where p.procurementId=:procurementId")
			.setString("supplierId", procurement.getSupplier().getSupplierId())
			.setString("empId", procurement.getEmp().getEmpId())
			.setString("procuremenRemark",procurement.getProcuremenRemark())
			.setString("procurementId",procurement.getProcurementId())
			.executeUpdate();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
}
