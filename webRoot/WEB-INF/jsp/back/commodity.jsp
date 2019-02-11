<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

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

<title>商品管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<style type="text/css">
.fileimg{
	width: 180px;
	height: 160px;
}

.page {
	text-align: center;
}

.page a {
	margin: 10px;
	text-decoration: underline;
}

.err {
	color: red;
	text-align: center;
	display: none;
}
</style>

</head>

<body>
	<nav class="breadcrumb"> <i class="Hui-iconfont">&#xe67f;</i> 首页
	<span class="c-gray en">&gt;</span> 商品管理 <span class="c-gray en">&gt;</span>
	商品详情 <a class="btn btn-success radius r"
		style="line-height:1.6em;margin-top:3px"
		href="javascript:location.replace(location.href);" title="刷新"><i
		class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div class="page-container">
		<div class="text-c">
			<form class="Huiform" method="post" action="backSp/commodity.do"
				target="_self">
				<input type="text" placeholder="商品名称" name="name" value="${name }"
					class="input-text" style="width:220px"> <input
					type="submit" class="btn btn-primary upload-btn" value="搜索"
					onClick="javascript:select();" /> <input type="button"
					class="btn btn-success" id="" name="" value="添加商品"
					onclick="admin_add('添加商品','backSp/bumen.do')" />
			</form>
		</div>
		<div class="mt-20">
			<table class="table table-border table-bordered table-bg table-sort">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="70">ID</th>
						<th width="80">名称</th>
						<th width="80">图片</th>
						<th width="200">描述</th>
						<th width="100">分类</th>
						<th width="120">价格</th>
						<th width="40">库存</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr class="text-c" id="sc${list.id }">
							<td><input name="" type="checkbox" value=""></td>
							<td>${list.id }</td>
							<td>${list.name }</td>
							<td><img src="files/${list.filename }" class="fileimg"/></td>
							<td class="text-l">${list.description }</td>
							<td class="text-l"><select name="name">
									<c:forEach items="${list1}" var="list1">
										<c:if test="${list1.id ==list.categorylevel1id }">
											<option value="一级分类">一级分类：${list1.name}</option>
										</c:if>
									</c:forEach>
									<c:forEach items="${list2}" var="list2">
										<c:if test="${list2.id == list.categorylevel2id }">
											<option value="二级分类">二级分类：${list2.name}</option>
										</c:if>
									</c:forEach>
									<c:forEach items="${list3}" var="list3">
										<c:if test="${list3.id == list.categorylevel3id }">
											<option value="三级分类">三级分类：${list3.name}</option>
										</c:if>
									</c:forEach>
							</select></td>
							<td class="text-l">${list.price }</td>
							<td>${list.stock }</td>
							<td class="f-14 product-brand-manage"><a
								style="text-decoration:none" href="javascript:;" title="跟新商品信息"
								onclick="admin_edit('跟新商品信息','backSp/update.do?id=${list.id }','800','500')"
								class="ml-5"><i class="Hui-iconfont">&#xe6df;</i></a> <a
								style="text-decoration:none" class="ml-5"
								href="javascript:deleteNews(${list.id});" title="删除"><i
									class="Hui-iconfont">&#xe6e2;</i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="page">
		<a href="backSp/commodity.do?page=1&&name=${name }">首页</a><a
			href="backSp/commodity.do?page=${page-1 }&&name=${name }">上一页</a><a
			href="backSp/commodity.do?page=${page+1 }&&name=${name }">下一页</a><a
			href="backSp/commodity.do?page=${totalPage }&&name=${name }">末页</a>第${page }页/共${totalPage }页
	</div>
	<div class="err">删除成功</div>
	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript"
		src="statics/back/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="statics/back/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript"
		src="statics/back/static/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript"
		src="statics/back/static/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="statics/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="statics/back/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="statics/back/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript">
		function deleteNews(id) {
			if (window.confirm("确认删除改商品？")) {
				$.post("backSp/delete.do?id=" + id, function(data) {
					if (data.code == 0) {
						$(".err").html("删除成功");
					} else {
						$(".err").html("删除失败");
					}
					$(".err").show();

					$("#sc" + id).remove();
				}, "JSON");
			} else {
				alert("删除取消！！");
			}
		}

		// 		function admin_add(title, url, id, w, h) {
		// 			layer_show(title, url, w, h);
		// 		}

		function admin_edit(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		function admin_upload(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
		function admin_add(title, url) {
			var index = layer.open({
				type : 2,
				title : title,
				content : url
			});
			layer.full(index);
		}
	</script>
</body>
</html>
