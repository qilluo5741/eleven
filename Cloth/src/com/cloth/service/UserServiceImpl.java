package com.cloth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.dao.IUserDao;
import com.cloth.entity.MenuType;
import com.cloth.entity.UserInfo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	
	/**
	 * ��ѯ�����û�
	 */
	public UserInfo selectOneByUserId(String userId) {
		// TODO Auto-generated method stub
		return dao.selectOneByUserId(userId);
	}
	/**
	 * ��½
	 */
	public UserInfo login(UserInfo user) {
		// TODO Auto-generated method stub
		return dao.login(user);
	}
	/**
	 * ��ѯ�˵�
	 */
	public List<MenuType> getMenu(String roleId) {
		// TODO Auto-generated method stub
		return dao.getMenu(roleId);
	}
	
}
