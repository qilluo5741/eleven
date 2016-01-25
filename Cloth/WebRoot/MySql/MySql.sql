/*��ת��test�û����ݿ�*/
use test;
/*������ɫ��*/
create table RoleInfo
(
 	roleId varchar(36) primary key not null,
    roleName varchar(100) not null
);
/*��������*/
insert into RoleInfo values('24333928814870528','����Ա');
insert into RoleInfo values('24333928814870529','������');
insert into RoleInfo values('24333928814870530','Ա��');
insert into RoleInfo values('24333928814870531','�ӹ�˾');
insert into RoleInfo values('24333928814870532','�ܾ���');
insert into RoleInfo values('24333928814870533','superAdmin');
insert into RoleInfo values('24333928814870534','�û�');
/*��ѯ*/
select * from RoleInfo;
/*�û���*/
create table UserInfo
(
    userId varchar(36) primary key not null,
    userName varchar(20) not null,
    userPwd varchar(20) not null,
	userStatus int not null,/*0 �����  1 �ɹ�  2ʧ��*/
    userTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
    userRemark varchar(500) not null,
    roleId varchar(36) not null /*��ɫ���*/
);
alter table UserInfo
         add constraint fk_UserInfo_roleId foreign key(roleId) references RoleInfo(roleId);
/*��������*/
insert into UserInfo values('24333928814870534','�¿�','123456',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870535','����','632541',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870536','��ΰ','632541',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870537','������','632541',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870538','������','632541',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870539','������','632541',1,default,'��һ����,ʲô��û����','24333928814870528');
insert into UserInfo values('24333928814870540','����','632541',1,default,'��һ����,ʲô��û����','24333928814870534');
insert into UserInfo values('24333928814870541','��Ǯ','111111',0,default,'��һ����,ʲô��û����','24333928814870534');
insert into UserInfo values('24333928814870542','����','111111',0,default,'��һ����,ʲô��û����','24333928814870534');
insert into UserInfo values('24333928814870543','����','111111',0,default,'��һ����,ʲô��û����','24333928814870534');
insert into UserInfo values('24333928814870544','֣��','111111',0,default,'��һ����,ʲô��û����','24333928814870534');
insert into UserInfo values('24333928814877777','������','111111',1,default,'��һ����,ʲô��û����','24333928814870533');
insert into UserInfo values('24333928814887777','�ɹ�Ա','111111',1,default,'��һ����,ʲô��û����','24333928814870530');
/*��ѯ*/
select * from UserInfo;

/*�˵�����*/
create table MenuType
(
	menuTypeId varchar(36) primary key not null,
	menuTypeName varchar(60) not null,
	remark varchar(100)
);
insert into MenuType values('24333928814870996','�û�����','�û�����');
insert into MenuType values('24333928814870997','�˵�����','�˵�����');
insert into MenuType values('24333928814870998','Ȩ�޹���','Ȩ�޹���');
insert into MenuType values('24333928814870999','�û�����','�û�����');
insert into MenuType values('24333928814871001','�˻�����','�˻�����');
insert into MenuType values('24333928814871002','���˹���','���˹���');
insert into MenuType values('24333928814871003','�ֿ����','�ֿ����');
insert into MenuType values('24333928814871004','��Ʒ����','��Ʒ����');
insert into MenuType values('24333928814871005','���͹���','���͹���');
insert into MenuType values('24333928814871006','�������','�������');
insert into MenuType values('24333928814871007','��Ӧ�̹���','��Ӧ�̹���');
insert into MenuType values('24333928814871008','�ɹ�����','�ɹ�����');
/*��ѯ*/
select * from MenuType;
/*�˵���*/
create table MenuInfo
(
 	   menuId varchar(36) primary key not null,
		 menuName varchar(30) not null,
		 href varchar(300) not null,
		 target varchar(100),
		 menuTypeId varchar(36) references MenuType(menuTypeId)
);
/*��������*/
insert into MenuInfo values('24333928814870545','�ɹ�','Procure/selectAll.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870546','ְλ','select/selectByPager.action','rightFrame','24333928814870999');
insert into MenuInfo values('24333928814870547','�����˻�','localReturn/queryLocalReturn.action','rightFrame','24333928814871001');
insert into MenuInfo values('24333928814870548','�������˻�','joiningTraderReturn/selectAllByPager.action','rightFrame','24333928814871001');
insert into MenuInfo values('24333928814870549','����','join/queryAllToJoining.action','rightFrame','24333928814871002');
insert into MenuInfo values('24333928814870550','��Ʒ����','select/selectAllByPager.action','rightFrame','24333928814871004');
insert into MenuInfo values('24333928814870551','���','goodsInventory/selectAllByPager.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870552','��Ʒ','goods/queryallBypager.action','rightFrame','24333928814871004');
insert into MenuInfo values('24333928814870553','Ա��','emp/selectAllByPager.action','rightFrame','24333928814870999');
insert into MenuInfo values('24333928814870554','��ɫ','color/querySelectAll.action','rightFrame','24333928814871004');
insert into MenuInfo values('24333928814870555','�ֿ�','Warehouse/selectAll.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870556','�ֿ��¼','WarehousLog/selectAll.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870772','����','size/queryAllSize.action','rightFrame','24333928814871004');
insert into MenuInfo values('24333928814870773','��Ӧ��','supplier/querySelectAll.action','rightFrame','24333928814871007');
insert into MenuInfo values('24333928814870774','����','select/selectbyAll.action','rightFrame','24333928814871006');
insert into MenuInfo values('24333928814870775','���ͼ�¼','distribution/querySelectAll.action','rightFrame','24333928814871005');
insert into MenuInfo values('24333928814870776','����','Order/queryAllByPager.action','rightFrame','24333928814871005');
insert into MenuInfo values('24333928814870777','����','select/selectbyAlloutbound.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870778','����','salesRecord/selectAllByPager.action','rightFrame','24333928814871004');
insert into MenuInfo values('24333928814870779','Ȩ��','jurisdiction/getReole.action','rightFrame','24333928814870998');
insert into MenuInfo values('24333928814870780','�˵�','Menu/selectAll.action','rightFrame','24333928814870997');
insert into MenuInfo values('24333928814870781','�û�','User/selectAll.action','rightFrame','24333928814870996');
insert into MenuInfo values('24333928814870782','�˵�����','jurisdiction/getMenuType.action?pageIndex=1','rightFrame','24333928814870997');
insert into MenuInfo values('24333928814870783','���','inbound/querySelectAll.action','rightFrame','24333928814871003');
insert into MenuInfo values('24333928814870784','�ɹ�','goodsinsert.jsp','rightFrame','24333928814871008');
/*��ѯ*/
select * from MenuInfo;
/*�˵������:*/
create table MenuRoleInfo
(
	rmid  varchar(36) primary key not null,
	menuId varchar(36) not null references MenuInfo(menuId),
	roleId varchar(36) null references RoleInfo(roleId)
);
/*��������*/
insert into MenuRoleInfo values('24333928814870557','24333928814870545','24333928814870528');
insert into MenuRoleInfo values('24333928814870558','24333928814870546','24333928814870528');
insert into MenuRoleInfo values('24333928814870559','24333928814870547','24333928814870528');
insert into MenuRoleInfo values('24333928814870560','24333928814870548','24333928814870528');
insert into MenuRoleInfo values('24333928814870561','24333928814870549','24333928814870528');
insert into MenuRoleInfo values('24333928814870562','24333928814870550','24333928814870528');
insert into MenuRoleInfo values('24333928814870563','24333928814870554','24333928814870528');
insert into MenuRoleInfo values('24333928814870775','24333928814870551','24333928814870528');
insert into MenuRoleInfo values('24333928814870776','24333928814870552','24333928814870528');
insert into MenuRoleInfo values('24333928814870777','24333928814870553','24333928814870528');
insert into MenuRoleInfo values('24333928814870778','24333928814870555','24333928814870528');
insert into MenuRoleInfo values('24333928814870779','24333928814870556','24333928814870528');
insert into MenuRoleInfo values('24333928814870780','24333928814870772','24333928814870528');
insert into MenuRoleInfo values('24333928814870781','24333928814870773','24333928814870528');
insert into MenuRoleInfo values('24333928814870782','24333928814870774','24333928814870528');
insert into MenuRoleInfo values('24333928814870783','24333928814870775','24333928814870528');
insert into MenuRoleInfo values('24333928814870784','24333928814870776','24333928814870528');
insert into MenuRoleInfo values('24333928814870785','24333928814870777','24333928814870528');
insert into MenuRoleInfo values('24333928814870786','24333928814870778','24333928814870528');
insert into MenuRoleInfo values('24333928814870787','24333928814870779','24333928814870533');
insert into MenuRoleInfo values('24333928814870788','24333928814870780','24333928814870533');
insert into MenuRoleInfo values('24333928814870789','24333928814870781','24333928814870533');
insert into MenuRoleInfo values('24333928814870790','24333928814870782','24333928814870533');
insert into MenuRoleInfo values('24333928814870791','24333928814870783','24333928814870528');
insert into MenuRoleInfo values('24333928814870792','24333928814870784','24333928814870530');
/*��ѯ*/
select * from MenuRoleInfo;
/*ְλ��*/
create table PositionInfo
(
	 positionId varchar(36) primary key not null,
	 positionName  varchar(36) not null,
     positionRemark varchar(500) not null
);
/*��������*/
insert into PositionInfo values('24333928814870568','���ž���','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870569','�г��ܼ�','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870570','�����ܼ�','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870571','�ֿ����Ա','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870572','�ɹ�Ա','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870573','����Ա','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870574','���˹�','��һ����,ʲô��û����');
insert into PositionInfo values('24333928814870583','���ۼ�¼Ա','��һ����,ʲô��û����');
/*��ѯ*/
select * from PositionInfo;

/*Ա����*/
create table EmpInfo
(
    empId  varchar(36) primary key not null,
    empName  varchar(36) not null,
    empGender varchar(36) not null,
    empAge int not null,
    empPhoto varchar(36) not null,
    empTel varchar(36) not null,
    empSal double not null,
    empCardNo  varchar(36) not null,
    empAddress varchar(36) not null,
    empRemark varchar(36) not null,
    positionId  varchar(36) not null,/*--ְλ���*/
	userId varchar(36) references userInfo(userId),
	isServing int not null default 0
);
alter table EmpInfo
         add constraint fk_EmpInfo_positionId foreign key(positionId) references PositionInfo(positionId);
/*��������*/
insert into EmpInfo values('24333928814870584','�¿�','��',18,'1.jpg','13854389438',10000,'500000199001021111','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870568','24333928814870534',0);
insert into EmpInfo values('24333928814870585','����','Ů',19,'2.jpg','13854389439',10000,'500000199001021112','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870569','24333928814870535',0);
insert into EmpInfo values('24333928814870586','������','��',19,'3.png','13854389439',10000,'500000199001021113','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870570','24333928814870536',0);
insert into EmpInfo values('24333928814870587','��ΰ','��',19,'4.png','13854389439',10000,'500000199001021114','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870571','24333928814870537',0);
insert into EmpInfo values('24333928814870588','������','Ů',19,'5.jpg','13854389439',10000,'500000199001021115','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870572','24333928814870538',0);
insert into EmpInfo values('24333928814870589','������','Ů',19,'1.jpg','13854389439',10000,'500000199001021116','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870573','24333928814870539',0);
insert into EmpInfo values('24333928814870590','����','Ů',19,'2.jpg','13854389439',10000,'500000199001021117','������ɳƺ��','��һ����,ʲô��û���£�','24333928814870573','24333928814870539',0);
/*��ѯ*/
select * from EmpInfo;	 
/*��Ӧ��*/  
create table SupplierInfo
(
	supplierId varchar(36) primary key not null,
	supplierName varchar(36) not null,
	supplierPeople varchar(36) not null,
	supplierAddress varchar(36) not null,
	supplierTel varchar(36) not null,
	supplierRemark varchar(500) not null
);

/*��������*/
insert into SupplierInfo values('24333928814870599','����Ӣ����˳���޹�˾','����','�����г�����','13854389440','��һ����, ʲô��û���£�');
insert into SupplierInfo values('24333928814870600','�㽭Ԫ�����޹�˾','����','�����г�����','13854389447','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870601','�������������޹�˾','����','�����г�����','13854389441','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870602','��Ȫ���Ƿ����³�','����','�����г�����','13854389442','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870603','��ˮ�������޹�˾','����','�����г�����','13854389443','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870604','��Ԫ��ɭ������רҵ������','����','�����г�����','13854389444','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870605','��Ȫ������޹�˾','����','�����г�����','13854389445','��һ����,ʲô��û���£�');
insert into SupplierInfo values('24333928814870606','��Ԫ�������̹�ʵҵ���޹�˾','����','�����г�����','13854389446','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from SupplierInfo;

/*�����˻���*/
create table LocalReturnInfo
(
	returnId varchar(36) primary key not null,
	returnOrExchange int not null,/*--�˻����ǻ���  0����  1��*/
	returnTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),/*--�˻�����ʱ��*/
	returnRemark varchar(500) not null,/*--�˻�˵��*/
	goodsName varchar(36) not null,/* �C�˻���Ʒ����*/
	colorName varchar(36) not null,/* �C�˻���Ʒ��ɫ*/
	sizeName varchar(36) not null,/* �C�˻���Ʒ��С*/
	goodsNum int not null,/*�˻�����Ʒ����*/
	returnStatus int not null,/*��(��)��״̬0:�� 1��δ*/
	warehouseId varchar(36) not null references WarehouseInfo(warehouseId)/*����������Ʒ�ֿ����ó�*/
);
/*��������*/
insert into LocalReturnInfo values('24333928814870771',0,default,'��һ����,ʲô��û���£�','ţ�п�','��ɫ','L',1,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814870772',0,default,'��һ����,ʲô��û���£�','ëƤ����','��ɫ','M',6,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814870773',1,default,'��һ����,ʲô��û���£�','���п�','��ɫ','26',10,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814870774',0,default,'��һ����,ʲô��û���£�','����װ','����ɫ','L',9,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814870775',1,default,'��һ����,ʲô��û���£�','���޷�','��ɫ','XL',9,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814870776',0,default,'��һ����,ʲô��û���£�','��׿�','��ɫ','L',9,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814870777',1,default,'��һ����,ʲô��û���£�','ְҵװ','��ɫ','M',9,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814170777',1,default,'��һ����,ʲô��û���£�','����','��ɫ','L',45,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814270777',1,default,'��һ����,ʲô��û���£�','ë��','��ɫ','M',65,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814370777',0,default,'��һ����,ʲô��û���£�','���п�','��ɫ','27',59,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814470777',1,default,'��һ����,ʲô��û���£�','ţ�п�','�亣��','26',87,0,'24333928814870687');
insert into LocalReturnInfo values('24333928814570777',0,default,'��һ����,ʲô��û���£�','����','��ɫ','M',34,1,'24333928814870687');
insert into LocalReturnInfo values('24333928814670777',1,default,'��һ����,ʲô��û���£�','ë��','��ɫ','M',19,0,'24333928814870687');
/*��ѯ*/
select * from LocalReturnInfo;
/*���˱�*/
create table JoiningTraderInfo
(
	joiningTraderId varchar(36) primary key not null,
	isSubsidiary  int not null,/*-- 0   1    0 �����ӹ�˾  1  ���������*/
	joiningTraderNo int not null,/*--�ڼ��ڼ���*/
	joiningTraderYear int not null,/*--����*/
	joiningTraderTime timestamp not NULL DEFAULT CURRENT_TIMESTAMP(),/*--����ʱ��*/
	joiningTraderName varchar(36) not null,/*--��������*/
	joiningTraderMoney double not null,/*--�����ʽ�*/
	joiningTraderTel varchar(20) not NULL,/*��������ϵ��ʽ*/
	joiningTraderStatus int not null, /* --����״̬  0 �����  1 �Ѿ����˳ɹ�  2���ʧ��*/
    joiningWarning int not null,/*��������0,1*/
	joiningTraderPeople varchar(30) not null,/*��ϵ��*/
	userId varchar(36) references userInfo(userId),/*--�����̶Ե��û�*/
	joiningTraderAddress varchar(36) not null/*--���˵ص�*/
);
/*��������*/
insert into JoiningTraderInfo values('24333928814870616',1,6,5,default,'��ѩ',6000000,'13060244511',1,0,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870617',0,6,3,'2015-04-01 10:53:24','���',7000000,'13060244531',0,0,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870618',0,3,6,'2010-05-15 10:53:24','ָ��',7000000,'13060244532',1,1,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870619',0,6,3,default,'�ǻ�',7000000,'13060244533',0,0,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870620',0,6,3,'2014-04-15 01:03:24','��Ÿ',7000000,'13060244534',0,0,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870621',0,6,3,'2015-11-12 11:12:24','��ͨ',7000000,'13060244535',1,0,'����','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870622',0,6,3,default,'�ƶ�',7000000,'13060244536',0,0,'ѧ��','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24333928814870623',0,6,3,default,'����',7000000,'13060245371',2,0,'լ��','24333928814870541','������ɳƺ��');
insert into JoiningTraderInfo values('24123959123471234',0,4,3,'2013-09-06 15:53:24','�ز�',2000000,'13060245671',1,1,'���','24333928814870541','�������山��');
/*��ѯ*/
select * from JoiningTraderInfo;

/*��Ʒ����*/
create table GoodTypeInfo
(
	goodTypeId varchar(36) primary key not null,
	goodTypeName varchar(36) not null,
	goodTypeRemark varchar(36) not null
);
/*��������*/
insert into GoodTypeInfo values('24333928814870633','ְҵ��װ','��һ����,ʲô��û���£�');
insert into GoodTypeInfo values('24333928814870634','����ϵ��','��һ����,ʲô��û���£�');
insert into GoodTypeInfo values('24333928814870635','��Ůϵ��','��һ����,ʲô��û���£�');
insert into GoodTypeInfo values('24333928814870636','�˶�ϵ��','��һ����,ʲô��û���£�');
insert into GoodTypeInfo values('24333928814870637','��װϵ��','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from GoodTypeInfo;

/*�����*/
create table SizeInfo
(
	sizeId varchar(36) primary key not null,
	sizeName varchar(36) not null,
	sizeRemark varchar(500) not null,
	goodTypeId  varchar(36) not null/*--��Ʒ����*/
);
alter table SizeInfo
         add constraint fk_SizeInfo_goodTypeId foreign key(goodTypeId) references GoodTypeInfo(goodTypeId);
/*��������*/
insert into SizeInfo values('24333928814870650','ss','��һ����,ʲô��û���£�','24333928814870633');/*ְҵ��װ*/
insert into SizeInfo values('24333928814870651','XL','��һ����,ʲô��û���£�','24333928814870634');/*����ϵ��*/
insert into SizeInfo values('24333928814870652','S','��һ����,ʲô��û���£�','24333928814870635');/*��Ůϵ��*/
insert into SizeInfo values('24333928814870653','M','��һ����,ʲô��û���£�','24333928814870636');/*�˶�ϵ��*/
insert into SizeInfo values('24333928814870654','L','��һ����,ʲô��û���£�','24333928814870637');/*��װϵ��*/
insert into SizeInfo values('24333928814870655','XXL','��һ����,ʲô��û���£�','24333928814870637');/*��װϵ��*/
insert into SizeInfo values('24333928814870656','35','��һ����,ʲô��û���£�','24333928814870634');/*����ϵ��*/
insert into SizeInfo values('24333928824870651','36','��һ����,ʲô��û���£�','24333928814870633');/*ְҵ��װ*/
insert into SizeInfo values('24333928834870652','37','��һ����,ʲô��û���£�','24333928814870634');/*����ϵ��*/
insert into SizeInfo values('24333928844870653','38','��һ����,ʲô��û���£�','24333928814870635');/*��Ůϵ��*/
insert into SizeInfo values('24333928854870654','26','��һ����,ʲô��û���£�','24333928814870636');/*�˶�ϵ��*/
insert into SizeInfo values('24333928864870655','27','��һ����,ʲô��û���£�','24333928814870637');/*��װϵ��*/
insert into SizeInfo values('24333928874870657','28','��һ����,ʲô��û���£�','24333928814870633');/*ְҵ��װ*/
insert into SizeInfo values('24333921874870657','39','��һ����,ʲô��û���£�','24333928814870634');/*����ϵ��*/
insert into SizeInfo values('24333922874870657','41','��һ����,ʲô��û���£�','24333928814870635');/*��Ůϵ��*/
insert into SizeInfo values('24333923874870657','42','��һ����,ʲô��û���£�','24333928814870636');/*�˶�ϵ��*/

/*��ѯ*/
select * from SizeInfo;
		 
		 
/*��ɫ��*/
create table ColorInfo
(
	colorId varchar(36) primary key not null,
	colorNo varchar(36) not null,
	colorName varchar(30) not null,
	colorRemark varchar(30) not null
);
/*��������*/
insert into ColorInfo values('24333928814870657','red','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870658','#FFFFFF','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870659','#000000','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870660','#FFFAF0','����ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870661','#FFF0F5','���Ϻ�','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870662','#2F4F4F','ī��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870663','#5F9EA0','����ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870664','#008000','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870665','#F5F5DC','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870666','#3CB371','�亣��','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870667','#F0FFF0','��ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928814870668','#87CEEB','����ɫ','��һ����,ʲô��û���£�');
insert into ColorInfo values('24333928863259668','gray','��ɫ','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from ColorInfo;

/*�ֿ��*/
create table WarehouseInfo
(
	warehouseId varchar(36) primary key not null,/*id*/
	warehouseName varchar(36) not null,/*�ֿ���*/
	warehouseAddress varchar(50) not null,/*�ֿ�����λ��*/
	empId varchar(36) not null/*--Ա�����ֿ����Ա��*/
);
alter table WarehouseInfo
         add constraint fk_WarehouseInfo_empId foreign key(empId) references EmpInfo(empId);
		 
/*��������*/
insert into WarehouseInfo values('24333928814870681','1�Ųֿ�','�Ϻ��мζ���','24333928814870584');
insert into WarehouseInfo values('24333928814870682','2�Ųֿ�','�Ϻ��мζ���','24333928814870585');
insert into WarehouseInfo values('24333928814870683','3�Ųֿ�','�Ϻ��мζ���','24333928814870586');
insert into WarehouseInfo values('24333928814870684','4�Ųֿ�','�Ϻ��мζ���','24333928814870587');
insert into WarehouseInfo values('24333928814870685','5�Ųֿ�','�Ϻ��мζ���','24333928814870588');
insert into WarehouseInfo values('24333928814870686','6�Ųֿ�','�Ϻ��мζ���','24333928814870589');
insert into WarehouseInfo values('24333928814870687','�ʼ�ֿ�','�Ϻ���������','24333928814870590');
/*��ѯ*/
select * from WarehouseInfo;

/*�ɹ���*/
create table ProcurementInfo
(
	procurementId varchar(36) primary key not null,
	procurementTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	supplierId varchar(36) not null references Supplierinfo(supplierId),/*��Ӧ�����*/
	empId varchar(36) not null,/*�ɹ��ˣ�Ա����*/
	procuremenRemark varchar(500)/*--˵��*/
);
alter table ProcurementInfo
			   add constraint fk_ProcurInfo_empId foreign key(empId) references EmpInfo(empId);
/*��������*/
insert into ProcurementInfo values('24333928814870697',default,'24333928814870599','24333928814870584','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870698',default,'24333928814870600','24333928814870585','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870699',default,'24333928814870601','24333928814870586','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870700',default,'24333928814870602','24333928814870587','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870701',default,'24333928814870603','24333928814870588','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870702',default,'24333928814870604','24333928814870589','��һ����,ʲô��û���£�');
insert into ProcurementInfo values('24333928814870703',default,'24333928814870605','24333928814870590','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from ProcurementInfo;

/*��Ʒ��*/
create table GoodsInfo
(
	goodsId varchar(36) primary key not null,
	goodsNo varchar(36) not null,/*--��Ʒ���*/
	goodsName varchar(36) not null,
	colorId varchar(36) not null references ColorInfo(colorId),/*--��Ʒ��ɫ*/
	sizeId varchar(36) not null references SizeInfo(sizeId),/*--��Ʒ��ţ���ע ����ͨ����ŵõ���Ʒ���ͣ�*/
	goodsNum int not null,/*--��Ʒ����*/
	goodsCode varchar(36) not null,/*--������*/
	goodsImg varchar(36) not null,/*--��ƷͼƬ*/
	goodsInPrice double not null,/*--��Ʒ����*/
	goodsOutPrice double not null,/*--��Ʒ�ۼ�*/
	goodsDiscount double not null,/*--��Ʒ�ۿ�*/
	goodsRemark varchar(500) not null,/*--��Ʒ˵��*/
	enterTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),/*��Ʒ¼��ʱ��*/
	procurementId varchar(36) not null/*--�ɹ��������*/
);
alter table GoodsInfo
		 add constraint fk_GoodsInfo_procurementId foreign key(procurementId) references ProcurementInfo(procurementId);
/*��������*/
insert into GoodsInfo values('24333928814870729','10021457','ְҵС��װ','24333928814870665','24333928814870650',500,'10021456.png','whiteZhi.jpeg',100,260,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870769','10021457','��ɫ��װ','24333928814870665','24333928814870650',500,'10021456.png','heixizhuangnan.jpg',500,760,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870770','10021457','����ְ��','24333928814870665','24333928814870650',500,'10021456.png','heixizhuang.jpg',300,560,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870771','10021457','����','24333928814870665','24333928814870650',500,'10021456.png','chenwhite.jpg',100,160,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870772','10021457','����','24333928814870667','24333928814870651',500,'10021456.png','whites.jpeg',120,200,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870730','10021456','���п�','24333928814870659','24333928814870651',500,'10021457.png','xiuxianku.jpg',300,400,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870698');
insert into GoodsInfo values('24333928814870731','10021458','���п�','24333928814870667','24333928814870653',500,'10021458.png','xiuxianku2.jpg',200,298,7.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870699');
insert into GoodsInfo values('24333928814870732','10021459','�˶���','24333928814870668','24333928814870653',500,'10021459.png','yundongkunan.jpg',200,356,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870700');
insert into GoodsInfo values('24333928814870733','10021460','ë��','24333928814870666','24333928814870654',500,'10021460.png','maoyi1.jpg',100,198,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870701');
insert into GoodsInfo values('24333928814870734','10021461','��MMë��','24333928814870665','24333928814870655',500,'10021461.png','maoyi2.jpg',50,100,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870702');
insert into GoodsInfo values('24333928814870735','10021462','���Ӵ���','24333928814870658','24333928814870654',500,'10021462.png','nizidayi.jpg',100,178,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333928814810729','10021457','�Ӵ����ͷ����','24333928814870659','24333928814870654',500,'10021457.png','taotouweiyi1.jpg',80,159,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814820730','10021457','����T��','24333928814870666','24333928814870651',500,'10021457.png','yundongTxunv.jpg',100,129,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870698');
insert into GoodsInfo values('24333928814830732','10021459','����ϵ���˶�����Ů','24333928814870658','24333928814870653',500,'10021459.png','yundongwaitaonv.jpg',300,420,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870700');
insert into GoodsInfo values('24333123654870735','10021462','�����T����','24333928814870658','24333928814870653',500,'10021462.png','yundongTxunan.jpg',80,120,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333123651236589','10021462','�������޷�','24333928863259668','24333928864870655',500,'10021457.png','tpic_t_25165659.jpg',350,550,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333123654123654','10021462','������˶�����','24333928814870658','24333928814870653',500,'10021461.png','yundongwaitaonan2.jpg',200,360,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333928814870755','10021457','��������','24333928814870665','24333928814870650',500,'10021456.png','chenyi.jpg',100,160,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814870756','10021456','ŷ������A��ȹ','24333928814870659','24333928814870652',500,'10021457.png','Aziqun.jpg',100,130,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870698');
insert into GoodsInfo values('24333928814870757','10021458','��ɫС����','24333928814870667','24333928814870652',500,'10021458.png','chunsewaitao.jpg',250,350,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870699');
insert into GoodsInfo values('24333928814870758','10021459','ײɫ�˶�Ь Ů','24333928814870668','24333928814870653',500,'10021459.png','yundongxie3.jpg',600,780,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870700');
insert into GoodsInfo values('24333928814870759','10021460','��ɯ�����׿�','24333928814870666','24333928814870654',500,'10021460.png','dadiku.jpg',30,49,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870701');
insert into GoodsInfo values('24333928814870760','10021461','��MMë��','24333928814870666','24333928814870653',500,'10021461.png','woollymi.jpg',39,60,9.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870702');
insert into GoodsInfo values('24333928814870761','10021462','���Ӵ���','24333928814870659','24333928814870652',500,'10021462.png','nizidayi1.jpg',210,320,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333928814810762','10021457','�Ӵ����ͷ����','24333928814870668','24333928864870655',500,'10021457.png','taotouweiyi2.jpg',100,160,8.0,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870697');
insert into GoodsInfo values('24333928814820763','10021457','�п��˶�Ь','24333928814870666','24333928814870653',500,'10021457.png','yundongxie2.jpg',500,680,7.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870698');
insert into GoodsInfo values('24333928814830764','10021459','����ϵ���˶�������','24333928814870658','24333928814870653',500,'10021459.png','yundongwaitaonan.jpg',200,330,8.5,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870700');
insert into GoodsInfo values('24333123654870766','10021462','������˶�T��Ů','24333928814870658','24333928814870653',500,'10021462.png','yundongTxunv.jpg',98,128,9.5,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333123651236567','10021462','������������','24333928814870666','24333923874870657',500,'10021457.png','overcoat.jpg',190,265,8.8,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');
insert into GoodsInfo values('24333123654123668','10021462','�п��˶�Ь','24333928814870658','24333923874870657',500,'10021461.png','yundongxie1.jpg',500,650,8.9,'��һ����,ʲô��û���£�',DEFAULT,'24333928814870703');

/*��ѯ*/
select * from GoodsInfo;

/*����*/
create table GoodsInventoryInfo
( 
	goodsInventoryId varchar(36) primary key not null,
	goodsName  varchar(36) not null,/*--��Ʒ����   �������*/
	colorName varchar(36) not null,/*��Ʒ��ɫ  �������*/
	sizeName varchar(36) not null,/*��Ʒ��ţ���ע ����ͨ����ŵõ���Ʒ���ͣ��������*/
	goodsNum int not null,/*��Ʒ����*/
	warehouseId varchar(36) not null references WarehouseInfo(warehouseId)/*�ֿ�*/
);
insert into GoodsInventoryInfo values('24333928814870735','ְҵС��װ','��ɫ','S',556,'24333928814870681');
insert into GoodsInventoryInfo values('24333928814870736','ְҵС��װ','��ɫ','M',684,'24333928814870681');
insert into GoodsInventoryInfo values('24333928814870737','��ɫ��װ','��ɫ','L',128,'24333928814870682');
insert into GoodsInventoryInfo values('24333928814870738','��ɫ��װ','��ɫ','M',257,'24333928814870682');
insert into GoodsInventoryInfo values('24333928814870739','����ְ��','��ɫ','S',681,'24333928814870683');
insert into GoodsInventoryInfo values('24333928814870740','����ְ��','��ɫ','M',1101,'24333928814870683');
insert into GoodsInventoryInfo values('24333928814870741','����','��ɫ','S',654,'24333928814870683');
insert into GoodsInventoryInfo values('24333928814870742','����','��ɫ','M',555,'24333928814870683');
insert into GoodsInventoryInfo values('24333928814870743','����','��ɫ','L',1547,'24333928814870683');
insert into GoodsInventoryInfo values('24331234514870744','���п�','��ɫ','M',663,'24333928814870687');
insert into GoodsInventoryInfo values('24331234514870745','���п�','��ɫ','M',963,'24333928814870687');
insert into GoodsInventoryInfo values('24334567814870746','�˶���','��ɫ','M',563,'24333928814870687');
insert into GoodsInventoryInfo values('24334567814870747','�˶���','��ɫ','L',745,'24333928814870687');
insert into GoodsInventoryInfo values('24339658414870748','ë��','��ɫ','M',152,'24333928814870687');
insert into GoodsInventoryInfo values('24339658414870749','ë��','��ɫ','M',65,'24333928814870687');
insert into GoodsInventoryInfo values('24333652114870750','��MMë��','��ɫ','L',83,'24333928814870687');
insert into GoodsInventoryInfo values('24333326544870751','���Ӵ���','��ɫ','L',368,'24333928814870687');
insert into GoodsInventoryInfo values('24333326544870752','���Ӵ���','��ɫ','M',845,'24333928814870687');
insert into GoodsInventoryInfo values('24333928814870753','�Ӵ����ͷ����','��ɫ','L',567,'24333928814870684');
insert into GoodsInventoryInfo values('24333928814870754','�Ӵ����ͷ����','����ɫ','27',457,'24333928814870684');
insert into GoodsInventoryInfo values('24333928814870755','����T��','��ɫ','M',225,'24333928814870685');
insert into GoodsInventoryInfo values('24333928814870756','����T��','��ɫ','M',225,'24333928814870685');
insert into GoodsInventoryInfo values('24333928814870757','�п��˶�Ь','��ɫ','41',300,'24333928814870686');
insert into GoodsInventoryInfo values('24333928814870758','�п��˶�Ь','��ɫ','40',400,'24333928814870686');
insert into GoodsInventoryInfo values('24333924814871259','�������޷�','��ɫ','M',600,'24333928814870687');
insert into GoodsInventoryInfo values('24333924814871260','�������޷�','��ɫ','M',500,'24333928814870687');
insert into GoodsInventoryInfo values('24333928814870761','������������','��ɫ','L',478,'24333928814870687');
insert into GoodsInventoryInfo values('24333928814870762','������������','��ɫ','M',650,'24333928814870687');
insert into GoodsInventoryInfo values('24333928814870763','�п��˶�Ь','��ɫ','40',425,'24333928814870687');
insert into GoodsInventoryInfo values('24333928814870764','�п��˶�Ь','��ɫ','41',93,'24333928814870687');
insert into GoodsInventoryInfo values('24123458814870765','����ϵ���˶�����Ů','��ɫ','M',698,'24333928814870687');
insert into GoodsInventoryInfo values('24123458814870766','����ϵ���˶�������','��ɫ','L',364,'24333928814870687');
insert into GoodsInventoryInfo values('24333123456871267','��ɯ�����׿�','��ɫ','M',630,'24333928814870685');
insert into GoodsInventoryInfo values('24333123456871268','��ɯ�����׿�','��ɫ','M',445,'24333928814870685');
insert into GoodsInventoryInfo values('24333695874870769','��ɫС����','��ɫ','M',362,'24333928814870685');
insert into GoodsInventoryInfo values('24333695874870770','��ɫС����','��ɫ','M',262,'24333928814870685');
insert into GoodsInventoryInfo values('24333928814870771','ŷ������A��ȹ','��ɫ','M',653,'24333928814870681');
insert into GoodsInventoryInfo values('24333928814870772','ŷ������A��ȹ','��ɫ','M',326,'24333928814870681');

/*��ѯ*/
select* from GoodsInventoryInfo;

/*�������˻���*/
create table JoiningTraderReturnInfo
(
	joiningTraderReturnId varchar(36) primary key not null,
	returnTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),/*--�˻�����ʱ��*/
	returnRemark varchar(500) not null,/*--�˻�˵��*/
	returnOrExchange int not null,/*0 �˻�  1����*/
	goodsName varchar(36) not null,/*�ˣ���������Ʒ���*/
	colorName varchar(36) not null,/*��Ʒ��ɫ*/
	sizeName varchar(36) not null,/*��Ʒ��С*/
	goodsNum int not null,/*�ˣ���������Ʒ����*/
  	returnStatus int not null,/*״̬  0  �����  1 �ɹ�  2 ʧ��*/
	joiningTraderId varchar(36) not null/*--����Id���*/
);
alter table JoiningTraderReturnInfo
         add constraint fk_JoiningTraderReturnInfo_joiningTraderId foreign key(joiningTraderId) references JoiningTraderInfo(joiningTraderId);
/*��������*/
insert into JoiningTraderReturnInfo values('24333928814870765',default,'��һ����,ʲô��û���£�',0,'ţ�п�','��ɫ','L','10',0,'24333928814870616');
insert into JoiningTraderReturnInfo values('24333928814870766',default,'��һ����,ʲô��û���£�',0,'ëƤ����','��ɫ','M','10',0,'24333928814870617');
insert into JoiningTraderReturnInfo values('24333928814870767',default,'��һ����,ʲô��û���£�',0,'���޷�','��ɫ','XL','10',0,'24333928814870618');
insert into JoiningTraderReturnInfo values('24333928814870768',default,'��һ����,ʲô��û���£�',0,'����װ','��ɫ','XXL','10',0,'24333928814870619');
insert into JoiningTraderReturnInfo values('24333928814870769',default,'��һ����,ʲô��û���£�',0,'���п�','��ɫ','M','10',0,'24333928814870620');
insert into JoiningTraderReturnInfo values('24333928814870770',default,'��һ����,ʲô��û���£�',0,'ë��','��ɫ','S','10',0,'24333928814870621');
insert into JoiningTraderReturnInfo values('24333928814870771',default,'��һ����,ʲô��û���£�',1,'ְҵװ','��ɫ','X','10',0,'24333928814870622');
/*��ѯ*/
select * from JoiningTraderReturnInfo;

/*����*/
create table InboundInfo
(
  	inboundId varchar(36) not null primary key,
	inboundTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),/*--���ʱ��*/
  	empId varchar(36) not null references empInfo(empId),/*����ˣ�����ˣ�*/
  	goodsName varchar(36),/*��Ʒ����*/
	procurementId varchar(36) references ProcurementInfo(procurementId),/* --�ɹ������ �ɹ������Σ�*/
	reOrPo int not null default 0,/*�˻���ɹ�     0���ɹ�   1���˻�*/
	warehouseId varchar(36) not null references WarehouseInfo(warehouseId),/* (�ֿ�)*/
  	inboundRemark varchar(36)/*--���˵��*/
);
/*��������*/
insert into InboundInfo values('24333928814870713',default,'24333928814870584',null,'24333928814870697',0,'24333928814870681','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870714',default,'24333928814870585',null,'24333928814870698',0,'24333928814870682','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870715',default,'24333928814870586',null,'24333928814870699',0,'24333928814870683','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870716',default,'24333928814870587',null,'24333928814870700',0,'24333928814870684','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870717',default,'24333928814870588',null,'24333928814870701',0,'24333928814870685','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870718',default,'24333928814870589',null,'24333928814870702',0,'24333928814870686','��һ����,ʲô��û���£�');
insert into InboundInfo values('24333928814870719',default,'24333928814870590',null,'24333928814870703',0,'24333928814870687','��һ����,ʲô��û���£�');

/*��ѯ*/
select * from InboundInfo;

/*�����*/
create table OrderInfo
(
	orderId varchar(36) primary key not null,
	orderTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	goodsNum varchar(36) not null,/*--����Ʒ����*/
	joiningTraderId varchar(36) not null,/*--������*/
	isdo int not null,/*-- �Ƿ���     0 �Ѵ���  1 δ����  2 �ܾ�����*/
	orderRemark varchar(500) not null
);
alter table OrderInfo
		 add constraint fk_OrderInfo_joiningTraderId foreign key(joiningTraderId) references JoiningTraderInfo(joiningTraderId);
/*��������*/		 
insert into OrderInfo values('24333928814870736',default,'666','24333928814870616',0,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870737',default,'777','24333928814870617',1,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870738',default,'111','24333928814870618',1,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870739',default,'222','24333928814870619',1,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870740',default,'333','24333928814870620',1,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870741',default,'555','24333928814870621',1,'��һ����,ʲô��û���£�');
insert into OrderInfo values('24333928814870742',default,'888','24333928814870622',2,'��һ����,ʲô��û���£�');
/*��ѯ*/
select * from OrderInfo;

/*��Ʒ������*/
create table goodsOrderInfo
(
		goodsOrderId varchar(36) primary key not null,
		goodsId VARCHAR(36) references goodsInfo(goodsId) ,
		orderId varchar(36) references OrderInfo(orderId)
);

/*��������*/		 
insert into goodsOrderInfo values('24333928814870773','24333928814870729','24333928814870736');
insert into goodsOrderInfo values('24333928814870774','24333928814870730','24333928814870737');
insert into goodsOrderInfo values('24333928814870775','24333928814870731','24333928814870738');
insert into goodsOrderInfo values('24333928814870776','24333928814870732','24333928814870739');
insert into goodsOrderInfo values('24333928814870777','24333928814870733','24333928814870740');
insert into goodsOrderInfo values('24333928814870778','24333928814870734','24333928814870741');
insert into goodsOrderInfo values('24333928814870779','24333928814870735','24333928814870742');
/*��ѯ*/
select * from goodsOrderInfo;
/*�����*/
create table DistributionInfo
(
	distributionId varchar(36) not null primary key,
	distributionTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),/*--����ʱ��*/
	isAcceptance int not null,/*--�Ƿ�����  1 ������ 0 δ���� 2 ����*/
	disAddress varchar(300) not null,
	orderId varchar(36)not null references OrderInfo(orderId),
	distributionRemark varchar(500)/*--���˵��*/
);
/*��������*/
insert into DistributionInfo values('24333928814870729',default,0,'������ɳƺ��','24333928814870736','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870730',null,0,'�Ϻ���������','24333928814870737','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870731',default,1,'�����г�����','24333928814870738','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870732',default,0,'�����г�����','24333928814870739','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870733',default,2,'�����г�����','24333928814870740','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870734',default,0,'�����г�����','24333928814870741','��һ����,ʲô��û���£�');
insert into DistributionInfo values('24333928814870735',default,0,'�����г�����','24333928814870742','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from DistributionInfo;

/* �����*/
create table OutboundInfo
(
	outboundId varchar(36) primary key not null,
	outboundTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	empId varchar(36) not null references EmpInfo(empId), /* --����ˣ�����ˣ�*/
	warehouseId varchar(36) not null references WarehouseInfo(warehouseId),/* (�ֿ�  ���Ǹ��ֿ����)*/
	goodsName varchar(36) not null,/*��Ʒ����*/
	goodsNum int not null,/*��Ʒ����*/
	isExitorSale int not null,/*�Ǳ����˻���������  0�������˻�  1������*/
	joiningTraderId varchar(36),/*-- ����Id���*/
    supplierId varchar(36) references SupplierInfo(supplierId),/*��Ӧ��*/
	outboundRemark varchar(500) not null/*-- ����˵��*/
);
alter table OutboundInfo
		 add constraint fk_OutboundInfo_joiningTraderId foreign key(joiningTraderId) references JoiningTraderInfo(joiningTraderId);
/* ��������*/		 
insert into OutboundInfo values('24333928814870742',default,'24333928814870584','24333928814870681','ë��',36,1,'24333928814870616',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870743',default,'24333928814870585','24333928814870682','��׿�',489,1,'24333928814870617',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870744',default,'24333928814870586','24333928814870683','ְҵװ',369,1,'24333928814870618',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870745',default,'24333928814870587','24333928814870684','ţ�п�',32,1,'24333928814870619',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870746',default,'24333928814870588','24333928814870685','ëƤ����',56,1,'24333928814870620',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870747',default,'24333928814870589','24333928814870686','���޷�',365,1,'24333928814870621',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870748',default,'24333928814870590','24333928814870687','����װ',65,1,'24333928814870622',null,'��һ����,ʲô��û���£�');
insert into OutboundInfo values('24333928814870772',default,'24333928814870590','24333928814870687','ë��',65,0,null,'24333928814870604','���ʼ�ֿ��˳�α����Ʒ��');
/*��ѯ*/
select * from OutboundInfo;

/*�ֿ��¼��:*/
create table WarehousLogInfo
(
	warehousLogId varchar(36) primary key not null,
	isIncrease int not null, /*--�Ƿ����   0���  1 ����*/
	outboundId  varchar(36) null references OutboundInfo(outboundId),/*������� ����Ϊ�գ�*/
	inboundId varchar(36) not null references InboundInfo(inboundId),/*������ ����Ϊ�գ�*/
	warehouseId varchar(36) not null,/*(�ֿ�  ���)*/
	warehousLogRemark varchar(500) not null
);
alter table WarehousLogInfo
		 add constraint fk_WarehousLogInfo_warehouseId foreign key(warehouseId) references WarehouseInfo(warehouseId);

/*��������*/		 
insert into WarehousLogInfo values('24333928814870749',1,'24333928814870742','24333928814870713','24333928814870681','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870750',1,'24333928814870743','24333928814870714','24333928814870682','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870751',0,'24333928814870744','24333928814870715','24333928814870683','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870752',1,'24333928814870745','24333928814870716','24333928814870684','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870753',0,'24333928814870746','24333928814870717','24333928814870685','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870754',1,'24333928814870747','24333928814870718','24333928814870686','��һ����,ʲô��û���£�');
insert into WarehousLogInfo values('24333928814870755',0,'24333928814870748','24333928814870719','24333928814870687','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from WarehousLogInfo;

/*���ۼ�¼��: */
create table SalesRecordInfo
(
	salesRecordId varchar(36) primary key not null,
	salesRecordTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	salesRecordMoney varchar(36) not null,
	goodsOrderId  varchar(36) not null,/*--�������*/
	salesRecordRemark varchar(500) not null
);
alter table SalesRecordInfo
         add constraint fk_SalesRecordInfo_goodsOrderId foreign key(goodsOrderId) references GoodsOrderInfo(goodsOrderId);
/*��������*/		 
insert into SalesRecordInfo values('24333928814870756',default,'400000','24333928814870773','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870757',default,'600000','24333928814870774','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870758',default,'600000','24333928814870775','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870759',default,'600000','24333928814870776','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870760',default,'600000','24333928814870777','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870761',default,'600000','24333928814870778','��һ����,ʲô��û���£�');
insert into SalesRecordInfo values('24333928814870762',default,'600000','24333928814870779','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from SalesRecordInfo;

/*�����*/
create table FinancialInfo
(
	financialId varchar(36) primary key not null,
	isSpending int not null,/*--�Ƿ�֧��  0 ֧�� 1 ���� */
	financialMoney varchar(36) not null,
	financialTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	procurementId varchar(36) not null,
	salesRecordId varchar(36) not null,
	financialRemark varchar(500)
);

/*��������*/		 
insert into FinancialInfo values('24333928814870763',1,'900000',default,'24333928814870697','24333928814870756','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870764',1,'900000',default,'24333928814870698','24333928814870757','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870765',0,'300000',default,'24333928814870699','24333928814870758','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870766',1,'900000',default,'24333928814870700','24333928814870759','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870767',1,'500000',default,'24333928814870701','24333928814870760','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870768',1,'600000',default,'24333928814870702','24333928814870761','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870769',0,'700000',default,'24333928814870703','24333928814870762','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870770',1,'900000',default,'24333928814870697','24333928814870756','��һ����,ʲô��û���£�');
insert into FinancialInfo values('24333928814870771',1,'900000',default,'24333928814870698','24333928814870757','��һ����,ʲô��û���£�');
/*��ѯ*/
select * from FinancialInfo;


/*���Ա�*/
create table LeaveMessageInfo
(
	leaveMsgId varchar(36) primary key not null,
	callName varchar(20) not null,
	email VARCHAR(30) not null,
	leaveMsgContent varchar(200) not null,
	createTime timestamp not null DEFAULT CURRENT_TIMESTAMP(),
	tellPhone varchar(20) not null
);

/*��������*/		 
insert into LeaveMessageInfo values('24333928814875656','����','15086600565@163.com','����һ������1',default,'15086600565');
insert into LeaveMessageInfo values('24333928814875657','����','15086600566@163.com','����һ������2',default,'15086600566');
insert into LeaveMessageInfo values('24333928814875658','����','15086600567@163.com','����һ������3',default,'15086600567');
insert into LeaveMessageInfo values('24333928814875659','����','15086600568@163.com','����һ������4',default,'15086600568');
insert into LeaveMessageInfo values('24333928814875660','����','15086600569@163.com','����һ������5',default,'15086600569');
insert into LeaveMessageInfo values('24333928814875661','�ΰ�','15086600570@163.com','����һ������6',default,'15086600570');
insert into LeaveMessageInfo values('24333928814875662','�ܾ�','15086600571@163.com','����һ������7',default,'15086600571');
insert into LeaveMessageInfo values('24333928814875663','Ԭʮ','15086600572@163.com','����һ������8',default,'15086600572');
/*��ѯ*/
select * from LeaveMessageInfo;

/*------------------------------�洢����---------------------------------*/
create PROCEDURE pro_localreturnGoods
(  
   return_returnId varchar(36),
   return_goodsName varchar(36),
   return_colorName varchar(36),
   return_sizeName varchar(36),
   return_goodsNum int,
   return_userId varchar(36),
   outboundids varchar(60)
)   
BEGIN   
   DECLARE proId varchar(36);
   declare sizeIds varchar(36);
   declare colorIds varchar(36);
   declare empIds varchar(36);
		declare supplierIds varchar(36);
		update localreturninfo locals set locals.returnStatus=0 where locals.returnId=return_returnId;
		select sizes.sizeId into sizeIds from sizeInfo sizes where sizes.sizeName=return_sizeName;
        select colors.colorId into colorIds from colorinfo colors where colors.colorName=return_colorName;
		select goods.procurementId into proId from goodsInfo goods where goods.goodsName=return_goodsName and goods.colorId=colorIds and goods.sizeId=sizeIds;
		select pro.supplierId into supplierIds from procurementinfo pro where pro.procurementId=proId;
		update goodsinventoryinfo goodsin set goodsin.goodsNum=goodsin.goodsNum - return_goodsNum where goodsin.goodsName=return_goodsName
		and goodsin.colorName=return_colorName and goodsin.sizeName=return_sizeName and goodsin.warehouseId='24333928814870687';
    select emp.empId into empIds from empinfo emp where emp.userId=	return_userId;	
    insert into outboundinfo values(outboundids,default,empIds,'24333928814870687',return_goodsName,return_goodsNum,0,null,supplierIds,'���ʼ�ֿ��˳�α����Ʒ��');
END;



/*¼����Ʒ�Ĵ洢����*/
create procedure proc_enteredGoods
(
		param_goodsNo varchar(36), 
		param_goodsName varchar(36), 
		param_sizeId varchar(36), 
		param_colorId varchar(36),
		param_goodsCode varchar(36),
		param_imgGoods varcahr(36), 
		param_goodsInPrice double, 
		param_goodsOutPrice double, 
		param_goodsNum int, 
		param_goodsRemark varchar(300),
		param_empName varchar(36)
)

BEGIN
	  declare goodsId varchar(36);
		declare goodsName varchar(36);
		declare sizeName varchar(36);
		declare colorName varchar(36);
		declare empId varchar(36);
		
/*procurementId varchar(36) primary key not null,
	procurementTime timestamp NULL DEFAULT CURRENT_TIMESTAMP(),
	supplierId varchar(36) not null references Supplierinfo(supplierId),/*��Ӧ�����
	empId varchar(36) not null,/*�ɹ��ˣ�Ա����
	procuremenRemark varchar(500)/*--˵��*/
	
END
/*
    call pro_localreturnGoods('24333928814570777','����','��ɫ','ss',45,'24333928814870538','231564859641236547123');
	select * from LocalReturnInfo;
	select * from goodsinventoryinfo;
	select * from OutboundInfo;
	select * from goodsInfo;
	DROP PROCEDURE pro_localreturnGoods;
	select * from userInfo;
*/