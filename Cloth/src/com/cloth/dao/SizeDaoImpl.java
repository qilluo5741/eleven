package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.SizeInfo;
import com.cloth.util.Pager;

@Repository
@SuppressWarnings("unchecked")
public class SizeDaoImpl extends HibernateDaoSupport implements ISizeInfoDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * ��ҳ��ѯ����
	 */
	public Pager<SizeInfo> queryAllSize(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Pager<SizeInfo> pager=new Pager<SizeInfo>();
		//���õ�ǰҳ��
		pager.setPageIndex(pageIndex);
		//����ÿҳ�Ĵ�С
		pager.setPageSize(pageSize);
		List<SizeInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from SizeInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from SizeInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}

	/**
	 * �����ߴ�
	 */
	public boolean insertSize(SizeInfo sizes) {
		// TODO Auto-generated method stub
		try {
			this.getSessionFactory().getCurrentSession().save(sizes);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ѯ���гߴ緵��list
	 */
	public List<SizeInfo> selectAllToList() {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().createQuery("from SizeInfo").list();
	}
	
	/**
	 * ��ѯ�Ƿ���ڳߴ�
	 */
	public boolean selectIsExistsSize(String sizeName,String goodsTypeName) {
		// TODO Auto-generated method stub
		int row=((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from SizeInfo sizes where sizes.sizeName=? and sizes.goodType.goodTypeName=?").setString(0, sizeName).setString(1, goodsTypeName).uniqueResult()).intValue();
		if(row!=0){
			return true;
		}else{
			return false;
		}
	}
}
