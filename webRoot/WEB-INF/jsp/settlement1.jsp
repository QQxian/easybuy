
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String rootPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ "/" + request.getContextPath() + "/files/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="statics/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui.admin/skin/default/skin.css" id="skin" />

<script type="text/javascript" src="statics/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="statics/js/menu.js"></script>

<script type="text/javascript" src="statics/js/select.js"></script>

<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="statics/back/static/h-ui.admin/css/style.css" />

<title></title>
<style type="">
.err {
	display: none;
	color: red;
	text-align: center;
}

.a1 {
	text-align: center;
}

.page {
	text-align: center;
	margin: 10px;
	text-decoration: underline;
}

a {
	margin: 10px;
}
</style>
</head>
<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 订单管理 <span class="c-gray en">&gt;</span>
	订单详情 <a class="btn btn-success radius r"
		style="line-height:1.6em;margin-top:3px"
		href="javascript:locatifon.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>

	<!--Begin 用户中心 Begin -->


	<div class="m_right" style="width:1200px">
		<div class="a1">
			<form class="Huiform" action="settlement1.do" method="post">
				<input type="text" placeholder="订单号" name="name" value="${name }"
					class="input-text" style="width:220px; height: 25px " /> <input
					type="submit" class="btn btn-primary upload-btn"
					style="width:50px; height: 30px; margin: 0px" value="搜索"
					" 
							onClick="javascript:select();" />
			</form>
		</div>
		<div class="mem_tit">我的订单</div>
		<table border="0" class="order_tab"
			style="width:930px; text-align:center; margin-bottom:30px;"
			cellspacing="0" cellpadding="0">
			<tr>
				<td width="5%">ID</td>
				<td width="20%">订单号</td>
				<td width="25%">下单时间</td>
				<td width="10%">订单总金额</td>
				<td width="25%">订单状态</td>
				<td width="15%">操作</td>
			</tr>
			<c:forEach items="${list}" var="list">
				<tr class="t${list.id}">
					<td>${list.id}</td>
					<td><font color="#ff4e00">${list.serialnumber}</font></td>
					<td><fmt:formatDate value="${list.createtime }"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${list.cost }</td>
					<td>未确认，未付款，未发货</td>
					<td><a href="javascript:del(${list.id})">取消订单</a></td>
				</tr>
			</c:forEach>
		</table>
		<div class="err">取消订单</div>
		<div class="page">
			<a href="settlement1.do?page=1&&name=${name }">首页</a><a
				href="settlement1.do?page=${page-1 }&&name=${name }">上一页</a><a
				href="settlement1.do?page=${page+1 }&&name=${name }">下一页</a><a
				href="settlement1.do?page=${totalpage }&&name=${name }">末页</a>第${page }页/共${totalpage}页
		</div>




	</div>

	<script type="text/javascript"
		src="statics/js/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		function del(id) {
			if (window.confirm("确认删除吗？")) {
				$.post("de.do?id=" + id, function(data) {
					if (data.code == 0) {
						$(".err").html("删除成功");
					} else {
						$(".err").html("删除失败");
					}
					$(".err").show();

					$(".t" + id).remove();
				}, "JSON");
			}
		}
	</script>

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
