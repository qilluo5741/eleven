<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>PageAdmin网站管理系统</title>
<meta name="Author" content="PageAdmin CMS" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	
	<script src="../js/jquery-1.11.3.js" type="text/javascript"></script>
	<script src="../js/function.js" type="text/javascript"></script>
   	<script src="../js/comm.js" type="text/javascript"></script>
   	<script src="../js/lang.js" type="text/javascript"></script>
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
   	
	<link href="../css/styles.css" type="text/css" rel="stylesheet" />
	<link href="../css/bootstrap.min.css" type="text/css" rel="stylesheet"></link>
	
	<script type="text/javascript">
		$(function(){
			$("#select_year").change(function(){
				if($(this).val() == 2) {
					$("#id_money").val("30000");
				} else if($(this).val() == 3) {
					$("#id_money").val("35000");
				} else {
					$("#id_money").val("40000");
				}
			});		
		});
		function func1(){
			alert("申请发送成功   请耐心等待审核！！");
		};
	</script>
	
   	<style type="text/css">
   		#a_1245{margin-left: 900px;margin-top: -50px;}
   	</style>
</head>
<c:if test="${isOk == 1}">
	<body onload="func1();">
</c:if>
<c:if test="${isOk != 1}">
	<body>
</c:if>
<div class="page_style lanmupage page_l61">
<div class="top_box">
 <div class="top_box_inner">
   <div class="topcontent"></div><div class="clear"></div>
   <div class="logo"><a href=""><img src="../images/index/logo.jpg" border="0"></a></div>
   <div class="menu_box" id="Menu">
   	<ul>
		<li class="menu_style_homepage menu_current" id="MenuItem61" name="MenuItem"><a href="../index.jsp" class="menu">首页</a></li>
		<li class="menu_style" id="MenuItem93" name="MenuItem"><a href="../model/company.jsp" class="menu">公司简介</a></li>
		<li class="menu_style" id="MenuItem94" name="MenuItem"><a href="../model/joinMe.jsp" class="menu">加入我们</a></li>
		<li class="menu_style" id="MenuItem95" name="MenuItem"><a href="../model/produceCenter.jsp" class="menu">产品中心</a></li>
		<li class="menu_style" id="MenuItem96" name="MenuItem"><a href="../model/customer.jsp" class="menu">客户留言</a></li>
		<li class="menu_style" id="MenuItem97" name="MenuItem"><a href="../model/contact.jsp" class="menu">联系我们</a></li>
	</ul>
   </div>
 </div>
</div>
	<script type="text/javascript">
		var IsPageHome="1";var Lanmu_Id="61";var Sublanmu_Id="0";ShowSubMenu(Lanmu_Id);
	</script>
	<div class="banner">
		<script  type="text/javascript">var Show_Style=3;
			var Image_12=new Array();
			var Pics="../images/index/banner_tyww.jpg";
			var Links="";
			var Titles="";
			var Alts="";
			var Apic12=Pics.split('|');
			var ALink12=Links.split('|');
			var ATitle12=Titles.split('|');
			var AAlts12=Alts.split('|');
			var Show_Text=0;
			for(i=0;i<Apic12.length;i++)
			  {
			   Image_12.src = Apic12[i]; 
			  }
			  var FHTML='<div id="js_slide_focus_12" class="slide_focus focus_style3" style="height:466px">';
  				FHTML+='<ul class="inner">';
  			for(var i=0;i<Apic12.length;i++)
   			{
   			  if(ALink12.length<(i+1) || ALink12[i]=="")
     			 {
      				 ALink12[i]="javascript:void(0)";
     			 }
    		  if(AAlts12.length<(i+1))
     			 {
       				 AAlts12[i]="";
      			 }
    		  if(ATitle12.length<(i+1))
      			 {
       				ATitle12[i]="";
      			 }
    			FHTML+='<li><a href="'+ALink12[i]+'" target="_self" title="'+AAlts12[i]+'"><img src="'+Apic12[i]+'">';
    			FHTML+='<em>'+ATitle12[i]+'</em>';
   				 FHTML+='</a></li>';
  			 }
 			FHTML+='</ul>';
 			FHTML+='</div>';
 			document.write(FHTML);
			$(function(){Slide_Focus("js_slide_focus_12",1,5,1700,466,true);});
		</script>
</div>
<div class="main_box main_box_style1">
 <div class="main_box_inner">
   <div class="main_box_inner_left">
<div id="nav_142"  class="nav_box nav_box_menu">

<div  class="nav_title"><span  class="nav_sign">加入我们</span><span  class="nav_more"></span></div>
	<span class="nav-English">JOIN US</span><div id="nav_menu_142"  class="nav_menu">
	<ul id="rootul_142">
		<li id="sl677">
			<a id="showModel" class="btn" data-toggle="modal" data-target="#myModel1">加入我们</a>
			<a id="a_1245" href="company.jsp" class="sla677">公司简介</a>
		</li>
	</ul>
</div></div>
<script type="text/javascript">
shut_allsubnav("rootul_142");
expand_subnav("sl677","0");
</script>
</div>
   <div class="main_box_inner_right">
<div class="sublanmu_box sublanmu_box_677">
	<div class="sublanmu_content sublanmu_content_introduct">
		<p>
			<br />
		</p>
		<p>
			<span style="font-family:'Microsoft YaHei';color:#434343;">
				<span style="font-size:14px;line-height:22px;">&nbsp;唯衣服装分销平台是一家大型的专业从事服装以及相关产品 销售、代理为一体的服饰公司，并拥有专业的广告喷绘分公司，企业的长远规划为公司打造百年品牌奠定了坚实基础。</span>
			</span> 
		</p>
		<p>
			<span style="font-family:'Microsoft YaHei';color:#434343;">
			<span style="font-size:14px;line-height:22px;">&nbsp; &nbsp; &nbsp; &nbsp; 公司始终坚持 “ 产品的创新，差异化；市场的整合，全局化；利益共享化，在变化中找准自我定位 ” 的经营理念，以 “ 追求客户最大满意 ” 为服务宗旨，紧随时代流行趋势，使各类服饰产品始终走在市场前沿，做到款款流行。</span></span> 
		</p>
		<p>
			<span style="font-family:'Microsoft YaHei';color:#434343;"><span style="font-size:14px;line-height:22px;">&nbsp;
			 &nbsp; &nbsp; &nbsp; 
			公司拥有各类先进的基础设施，拥有一支数千人的精良队伍，保证了产品的高质量和骄人的市场业绩，随着公司关于 ISO—9001 
			国际质量体系认证和环境质量体系认证进入验收实施阶段，企业的产品品质和服务质量将得到更大程度提升。　　公司自主研发设计生产的各类高中档西服、职业
			装、工装、校服、医疗服装、广告 T 
			恤、文化衫及各行业服务用装，已服务于省内外众多著名企业集团，各类服饰产品为各大市场畅销品。我们将进一步依托高素质的员工队伍，先进精良的生产设备，
			通过诚信创新的营销服务，争做中国服饰第一品牌。　　我们这支团结而奋进的团队，在最大限度地张扬着年轻、激情、独特的个性，进步、发展、无不处处挥洒美
			泰来人永争第一的壮志与豪情。</span></span> 
		</p>
		<p>
			<br />
		</p>
		<div class="pro-img-1">
			<img src="../images/17_0cbm.jpg"/>
			<img src="../images/8yki.jpg"/>
			<img src="../images/tij6.jpg"/>
		</div>
		</div>
		</div>
	</div>
 </div>
 <div class="clear main_box_inner_bottom"></div>
</div>
<div class="bottom_box"><div style="width:1000px;margin:0px auto;clear:both;overflow:hidden;">
	<div class="bottom-left">
		<span>重庆市沙坪坝区微电园产业园区 </span> <span>Chong Qing city</span> <span> Wei Dian Yuan, 16th</span> <span>联系电话：023-64956871</span> 
	</div>
	<div class="bottom-right">
		<span>ICP备15629784号&nbsp;公网安备14562502003564号&nbsp;&copy;2016</span><span>网址：www.weiyi.net</span> 
	</div>
</div></div><div align='center' style='padding:5px'>Powered by <a href='http://www.pageadmin.net' target='_blank'><strong>Wei Yi</strong></a></div></div></body><script type="text/javascript">TongJi(1)</script></html>


<div class="modal fade" id="myModel1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button>
	            <h3 class="modal-title" id="myModalLabel">
	             		加盟商注册
	            </h3>
	         </div>
	         <div class="modal-body" style="height:auto; overflow:auto;">
	         <CENTER>
		    	<form action="<%=basePath%>join/insertOneJoiningTrader.action" method="post">
			   		<table class="table table-bordered">
			   			<tr><th>加盟类型：</th>
			   				<td>
				   				<select name="isSubsidiary">
				   					<option value="0">子公司</option>
		   							<option value="1">加盟商</option>
				   				</select>
				   			</td>
			   			</tr>
			   			<tr><th>加盟名称：</th><td><input name="joiningTraderName"/></td></tr>
			   			<tr><th>加盟年限：</th>
			   				<td>
				   				<select id="select_year" name="joiningTraderYear">
			   						<option value="2" selected="selected">2年</option>
		   							<option value="3">3年</option>
		   							<option value="4">4年</option>
				   				</select>
				   			</td>
			   			</tr>
			   			<tr><th>加盟资金：</th><td><input id="id_money" value="30000" name="joiningTraderMoney" readonly="readonly"/></td></tr>
			   			<tr><th>联系方式：</th><td><input name="joiningTraderTel"/></td></tr>
			   			<tr><th>联系人：</th><td><input name="joiningTraderPeople"/></td></tr>
			   			<tr><th>所在地：</th><td><input name="joiningTraderAddress"/></td></tr>
						<tr><td colspan="2"><center><input class="btn btn-default" value="申请加入" type="submit"/></center></td></tr>
			    	</table>
		    	</form>
		    </CENTER>
		</div><!-- /.modal -->
	</div>