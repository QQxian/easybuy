<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'upload.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.inner {
	width: 500px;
	margin: 0 auto;
}

th {
	color: blue;
}

tr {
	text-align: center;
}

td {
	height: 60px;
}
</style>
</head>

<body>
	<nav>商品跟新 </nav>
	<div class="inner">
		<form action="doUpload.do?id=${id }" enctype="multipart/form-data"
			onsubmit="return check();" method="post">
			<input type="hidden" name="id" id="id" value="${id }">
			<table border="1"
				style="width:370px; font-size:14px; margin-top:30px;">
				<tr>
					<th style="height: 60px;" colspan="2"><h1 style="margin: 0;">更新商品图片</h1></th>
				</tr>
				<tr>
					<td>商品图片:<input type="file" name="file" id="file" /></td>
				</tr>
				<tr>
					<td><input type="submit" style="margin-right: 20px;"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript"
		src="../statics/js/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript">
		var check = function() {
			if ($("#file").val() == null || $("#file").val() == "") {
				alert("请选择文件！！！");
				return false;
			}
		};
	</script>
</body>
</html>
