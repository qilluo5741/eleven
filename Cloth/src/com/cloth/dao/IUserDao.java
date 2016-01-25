package com.cloth.dao;

import java.util.List;

import com.cloth.entity.MenuType;
import com.cloth.entity.UserInfo;

public interface IUserDao {
	public UserInfo selectOneByUserId(String userId);
	//��½
	public UserInfo login(UserInfo user);
	//��ѯ�˵�
	public List<MenuType> getMenu(String roleId);
}
