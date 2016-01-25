package com.cloth.service;

import java.util.List;

import com.cloth.entity.MenuInfo;
import com.cloth.entity.MenuRoleInfo;
import com.cloth.entity.MenuType;
import com.cloth.entity.RoleInfo;
import com.cloth.util.Pager;

public interface IJurisdictionService {
	public List<RoleInfo> getRole();
	//�޸Ľ�ɫ����
	public boolean updateRole(RoleInfo role);
	//ɾ����ɫ
	public boolean deleteRole(RoleInfo role);
	//��ӽ�ɫ
	public boolean addReole(RoleInfo role);
	//��ҳ��ѯ�˵�����
	public Pager<MenuType> getMenuType(int pageIndex,int pageSize);
	//�޸Ĳ˵���Ϣ
	public boolean updateMenuType(MenuType mt);
	//��Ӳ˵�����
	public boolean addMenuType(MenuType mt);
	//ɾ���˵�����
	public boolean deleteMenuType(MenuType mt);
	//��ѯ��ɫ�����Ӧ�Ĳ˵�
	public RoleInfo getReoleMenu(RoleInfo role);
	//ɾ����ϵ��˵�����
	public boolean deleteRoleMenu(RoleInfo r);
	//����һ���û� ��ѯ�û�û�з���Ĳ˵�
	public List<MenuInfo> getMenuisNoadd(RoleInfo r);
	// ��ӽ�ɫ�˵�
	public  boolean addMenuRole(MenuRoleInfo mr);
}
