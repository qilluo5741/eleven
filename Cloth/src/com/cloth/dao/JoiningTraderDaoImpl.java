package com.cloth.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.JoiningTraderInfo;
import com.cloth.util.Pager;

@Repository
@SuppressWarnings("unchecked")
public class JoiningTraderDaoImpl extends HibernateDaoSupport implements IJoiningTraderDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	/**
	 *��ѯ����
	 */
	public JoiningTraderInfo selectOneById(String joiningTraderId) {
		// TODO Auto-generated method stub
		return (JoiningTraderInfo) this.getSessionFactory().getCurrentSession().get(JoiningTraderInfo.class, joiningTraderId);
	}
	
	/**
	 * ����µļ�����
	 */
	public boolean insertOneJoiningTrader(JoiningTraderInfo join){
		try {
			this.getSessionFactory().getCurrentSession().save(join);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * ��ѯ���еļ����̷���list
	 */
	public List<JoiningTraderInfo> selectAllToList() {
		// TODO Auto-generated method stub
		return this.getSessionFactory().getCurrentSession().createQuery("from JoiningTraderInfo").list();
	}

	/**
	 * �޸ļ����̵Ļ�������
	 */
	public boolean updateJoininfTraderByid(JoiningTraderInfo joiningTrader) {
		// TODO Auto-generated method stub
		try {
			this.getSessionFactory().getCurrentSession().createQuery("update JoiningTraderInfo joining set joining.joiningTraderTel=?,joining.joiningTraderPeople=?,joining.joiningTraderAddress=? where joining.joiningTraderId=?").setString(0, joiningTrader.getJoiningTraderTel()).setString(1, joiningTrader.getJoiningTraderPeople()).setString(2, joiningTrader.getJoiningTraderAddress()).setString(3, joiningTrader.getJoiningTraderId()).executeUpdate();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * ��ҳ��ѯ
	 */
	public Pager<JoiningTraderInfo> queryAllToJoining(int pageIndex,
			int pageSize) {
		// TODO Auto-generated method stub
		Pager<JoiningTraderInfo> pager=new Pager<JoiningTraderInfo>();
		//���õ�ǰҳ��
		pager.setPageIndex(pageIndex);
		//����ÿҳ�Ĵ�С
		pager.setPageSize(pageSize);
		List<JoiningTraderInfo> list=this.getSessionFactory().getCurrentSession().createQuery("from JoiningTraderInfo").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list();
		pager.setList(list);
		pager.setTotalRecords(((Long)this.getSessionFactory().getCurrentSession().createQuery("select count(*) from JoiningTraderInfo").uniqueResult()).intValue());
		pager.setTotalPages();
		return pager;
	}

	/**
	 * �ü�����ͨ�����
	 */
	public boolean passVerify(String joiningTraderId) {
		// TODO Auto-generated method stub
		int i=this.getSessionFactory().getCurrentSession().createQuery("update JoiningTraderInfo joining set joining.joiningTraderStatus=1 where joining.joiningTraderId=?").setString(0, joiningTraderId).executeUpdate();
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * �ü����̲�ͨ�����
	 */
	public boolean noPassVerify(String joiningTraderId) {
		// TODO Auto-generated method stub
		int i=this.getSessionFactory().getCurrentSession().createQuery("update JoiningTraderInfo joining set joining.joiningTraderStatus=2 where joining.joiningTraderId=?").setString(0, joiningTraderId).executeUpdate();
		if(i!=0){
			return true;
		}else{
			return false;
		}
	}

}
