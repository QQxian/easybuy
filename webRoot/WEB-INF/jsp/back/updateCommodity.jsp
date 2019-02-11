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
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="statics/back/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="statics/back/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="statics/back/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="statics/back/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="statics/back/static/h-ui.admin/css/style.css" />

<title>商品跟新</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="multipart/form-data;         charset=utf-8" />

<style>
.inner {
	width: 1000px;
	margin: 0 auto;
}

table {
	border: 0px solid #000;
}

th {
	background: cyan;
}

.td {
	width: 100px;
}

td {
	border: 0px solid #000;
}

img,a {
	vertical-align: middle;
}

.su {
	text-align: center;
}

tr {
	height: 100px
}

a {
	text-decoration: none;
}
</style>
</head>

<body>
	<div class="inner">
		<nav>商品更新 </nav>
<form class="form form-horizontal" id="form-article-add">
<input type="hidden" name="id" id="id" value="${id }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="name" id="name" size="100"
						value="${easybuyProduct.name }" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="price" id="price" size="100"
						value="${easybuyProduct.price }" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品库存：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" name="stock" id="stock" size="100"
						value="${easybuyProduct.stock }" />
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>一级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<input type="text" class="input-text" name="name1" id="categorylevel1id" size="100"
						value="${name1 }" readonly/>
				</span> </div>(不可修改)
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>二级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<input type="text" class="input-text" name="name2" id="categorylevel2id" size="100"
						value="${name2 }" readonly/>
				</span> </div>(不可修改)
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>三级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<input type="text" class="input-text" name="name3" id="categorylevel3id" size="100"
						value="${name3 }" readonly/>
				</span> </div>(不可修改)
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品描述：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script type="text/plain" id="content"
					style="width: 800px; height: 350px;">${easybuyProduct.description }</script> 
			</div>
		</div>
		
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="check();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
			
			</div>
		</div>
	</form>
		
	</div>
	<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/ueditor.config.js"></script> 
	<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
	<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript"
		src="statics/js/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
	$(function(){
		var ue = UE.getEditor('content');
	});

	
		var check = function() {
			if ($("#name").val() == null || $("#name").val() == "") {
				alert("商品名称不能为空！！！");
				return false;
			}
			if ($("#price").val() == null || $("#price").val() == "") {
				alert("商品价格不能为空！！！");
				return false;
			}
			if ($("#stock").val() == null || $("#stock").val() == "") {
				alert("商品库存不能为空！！！");
				return false;
			}
			var ue = UE.getEditor('content');
			$.post("backSp/updateAA.do", {
				id : $("#id").val(),
				name : $("#name").val(),
				description : ue.getContent(),
				price : $("#price").val(),
				stock : $("#stock").val()
			}, function(data) {
				if (data.code == 0) {
					alert("修改成功！");
					window.parent.location.reload();
				} else {
					alert("修改失败！");
				}
			}, "JSON");
		};

	</script>
</body>
</html>
