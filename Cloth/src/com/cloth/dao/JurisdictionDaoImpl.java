package com.cloth.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.cloth.entity.MenuInfo;
import com.cloth.entity.MenuRoleInfo;
import com.cloth.entity.MenuType;
import com.cloth.entity.RoleInfo;
import com.cloth.util.Pager;

@Repository
public class JurisdictionDaoImpl extends HibernateDaoSupport implements IJurisdictionDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	/**
	 * ��ѯ��ɫ
	 */
	@SuppressWarnings("unchecked")
	public List<RoleInfo> getRole() {
		Session session =getSessionFactory().getCurrentSession();
		return session.createQuery("from RoleInfo").list();
	}
	/**
	 * �޸Ľ�ɫ
	 * @param role
	 * @return
	 */
	public boolean updateRole(RoleInfo role){
		//�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			session.update(role);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ɾ����ɫ
	 * @param role
	 * @return
	 */
	public boolean deleteRole(RoleInfo role){
		//�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			session.delete(role);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ��ӽ�ɫ
	 * @param role
	 * @return
	 */
	public boolean addReole(RoleInfo role){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			session.save(role);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ��ҳ��ѯ�˵�����
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Pager<MenuType> getMenuType(int pageIndex,int pageSize){
		Pager<MenuType> pager=new Pager<MenuType>();
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		pager.setPageIndex(pageIndex);
		pager.setPageSize(pageSize);
		pager.setList(session.createQuery("from MenuType").setFirstResult((pageIndex-1)*pageSize).setMaxResults(pageSize).list());
		pager.setTotalRecords(Integer.parseInt(session.createQuery("select count(*) from MenuType").uniqueResult().toString()));
		pager.setTotalPages();
		return pager;
	}
	/**
	 * �޸Ĳ˵�����
	 * @param mt
	 * @return
	 */
	public boolean updateMenuType(MenuType mt){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			session.update(mt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ��Ӳ˵�����
	 * @param mt
	 * @return
	 */
	public boolean addMenuType(MenuType mt){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			session.save(mt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ɾ���˵�����
	 * @param mt
	 * @return
	 */
	public boolean deleteMenuType(MenuType mt){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try { 
			session.delete(mt);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	/**
	 * ��ѯһ����ɫ����Ĳ˵�
	 * @param role
	 * @return
	 */
	public RoleInfo getReoleMenu(RoleInfo role){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		return (RoleInfo) session.createQuery("from RoleInfo r left join fetch r.menuRole mr left join fetch mr.menu m left join fetch m.menuType mt   where  r.roleId=?").setString(0,role.getRoleId()).uniqueResult();
	}
	/**
	 * ɾ����ϵ��˵�����
	 * @param r
	 * @return
	 */
	public boolean deleteRoleMenu(RoleInfo r){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			if(session.createQuery("delete MenuRoleInfo  mr where mr.rmid=?").setString(0, r.getRoleId()).executeUpdate()>0){
				return true;
			}
			else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	/***
	 *����һ���û� ��ѯ�û�û�з���Ĳ˵�
	 * @param r
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MenuInfo> getMenuisNoadd(RoleInfo r){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		return session.createQuery("from MenuInfo m where m.menuId not in (select mr.menu.menuId from MenuRoleInfo mr where mr.role.roleId=?)").setString(0,r.getRoleId()).list();
	}
	/***
	 * ��ӽ�ɫ�˵�
	 * @param mr
	 * @return
	 */
	public  boolean addMenuRole(MenuRoleInfo mr){
		///�õ�session
		Session session =getSessionFactory().getCurrentSession();
		try {
			System.out.println(mr.getRole().getRoleId()+"===="+mr.getMenu().getMenuId());
			session.save(mr);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
