package com.cloth.service;

import java.util.List;

import com.cloth.entity.MenuType;
import com.cloth.entity.UserInfo;

public interface IUserService {
	//��ѯһ���û�
	public UserInfo selectOneByUserId(String userId);
	//��½
	public UserInfo login(UserInfo user);
	//��ѯ�˵�
	public List<MenuType> getMenu(String roleId);
}
