package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cloth.dao.IJurisdictionDao;
import com.cloth.entity.MenuInfo;
import com.cloth.entity.MenuRoleInfo;
import com.cloth.entity.MenuType;
import com.cloth.entity.RoleInfo;
import com.cloth.util.Pager;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)

public class JurisdictionServiceImpl implements IJurisdictionService {
	@Autowired
	private IJurisdictionDao dao;
	public List<RoleInfo> getRole() {
		// TODO Auto-generated method stub
		return dao.getRole();
	}
	public boolean updateRole(RoleInfo role) {
		// TODO Auto-generated method stub
		return dao.updateRole(role);
	}
	public boolean deleteRole(RoleInfo role) {
		// TODO Auto-generated method stub
		return dao.deleteRole(role);
	}
	public boolean addReole(RoleInfo role) {
		// TODO Auto-generated method stub
		return dao.addReole(role);
	}
	public Pager<MenuType> getMenuType(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return dao.getMenuType(pageIndex, pageSize);
	}
	public boolean updateMenuType(MenuType mt) {
		// TODO Auto-generated method stub
		return dao.updateMenuType(mt);
	}
	public boolean addMenuType(MenuType mt) {
		// TODO Auto-generated method stub
		return dao.addMenuType(mt);
	}
	public boolean deleteMenuType(MenuType mt) {
		// TODO Auto-generated method stub
		return dao.deleteMenuType(mt);
	}
	public RoleInfo getReoleMenu(RoleInfo role) {
		// TODO Auto-generated method stub
		return dao.getReoleMenu(role);
	}
	public boolean deleteRoleMenu(RoleInfo r) {
		// TODO Auto-generated method stub
		return dao.deleteRoleMenu(r);
	}
	public List<MenuInfo> getMenuisNoadd(RoleInfo r) {
		// TODO Auto-generated method stub
		return dao.getMenuisNoadd(r);
	}
	public boolean addMenuRole(MenuRoleInfo mr) {
		// TODO Auto-generated method stub
		return dao.addMenuRole(mr);
	}
}
