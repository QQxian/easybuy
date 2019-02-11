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



<title>商品增加</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta http-equiv="Content-Type" content="multipart/form-data;         charset=utf-8" />
</head>

<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-article-add" enctype="multipart/form-data">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="articletitle" name="articletitle">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品价格：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="price" name="price">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商品库存：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="stock" name="stock">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>一级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="articlecolumn1" class="select" id="articlecolumn1">
					<option value="">请选择分类</option>
					<c:forEach items="${list1}" var="list1">
							<option value="${list1.id}">${list1.name}</option>
					</c:forEach>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>二级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="articlecolumn2" class="select" id="articlecolumn2">
					<option value="" id="op2">请选择分类</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>三级分类：</label>
			<div class="formControls col-xs-8 col-sm-9"> <span class="select-box">
				<select name="articlecolumn3" class="select" id="articlecolumn3">
					<option value="" id="op3">请选择分类</option>
				</select>
				</span> </div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">上传图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="uploader-thum-container" id="sc">
					<div id="fileList" class="uploader-list"></div>
<!-- 					<div id="filePicker">选择图片</div> -->
					<input type = "file" accept="image/*" id = "file" name = "file">
<!-- 					<input type="file" name="file" id="file"/> -->
<!-- 					<input type="button" id="btn-star" class="btn btn-default btn-uploadstar radius ml-10" value="开始上传"/> -->
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-2">商品描述：</label>
			<div class="formControls col-xs-8 col-sm-9"> 
				<script type="text/plain" id="content"
					style="width: 800px; height: 350px;"></script> 
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
				<button onClick="article_save_submit();" class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 保存并提交</button>
			</div>
		</div>
	</form>
	
</article>
<!-- <form action="" enctype="multipart/form-data"> -->
	
<!-- </form> -->
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="statics/back/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="statics/back/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="statics/back/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="statics/back/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="statics/back/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="statics/back/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="statics/back/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="statics/back/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="statics/back/lib/webuploader/0.1.5/webuploader.min.js"></script> 
<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/ueditor.config.js"></script> 
<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/ueditor.all.min.js"> </script> 
<script type="text/javascript" src="statics/back/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	}); 	
	
	var ue = UE.getEditor('content');
	
	//表单验证
	$("#form-article-add").validate({
		rules:{
			articletitle:{
				required:true,
			},
			articlecolumn1:{
				required:true,
			},
			articlecolumn2:{
				required:true,
			},
			articlecolumn3:{
				required:true,
			},
			price:{
				required:true,
			},
			stock:{
				required:true,
			},
			xq:{
				required:true,
			},
			file:{
				required:true,
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){			
			$.post("backSp/insert.do",{
				name : $("#articletitle").val(),
				categoryLevel1Id : $("#articlecolumn1").val(),
				categoryLevel2Id : $("#articlecolumn2").val(),
				categoryLevel3Id : $("#articlecolumn3").val(),
				price : $("#price").val(),
				stock : $("#stock").val(),
				content : ue.getContent(),
				fileName : $("#fileName").val()
			},function(data) {
// 				$(form).ajaxSubmit();
// 				var index = parent.layer.getFrameIndex(window.name);
// 				parent.$('.btn-refresh').click();
// 				parent.layer.close(index);
				alert("新增成功！");
				window.parent.location.reload();  
			}, "JSON");
		
			//$(form).ajaxSubmit();
			//var index = parent.layer.getFrameIndex(window.name);
			//parent.$('.btn-refresh').click();
			//parent.layer.close(index);
		}
	});
	
// 	$list = $("#fileList"),
// 	$btn = $("#btn-star"),
// 	state = "pending",
// 	uploader;

// 	var uploader = WebUploader.create({
// 		auto: true,
// 		swf: 'lib/webuploader/0.1.5/Uploader.swf',
	
//		文件接收服务端。
// 		url: 'upload.do',
	
//		选择文件的按钮。可选。
//		内部根据当前运行是创建，可能是input元素，也可能是flash.
// 		pick: '#filePicker',
	
//		不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
// 		resize: false,
//		只允许选择图片文件。
// 		accept: {
// 			title: 'Images',
// 			extensions: 'gif,jpg,jpeg,bmp,png',
// 			mimeTypes: 'image/*'
// 		}
// 	});
// 	uploader.on( 'fileQueued', function( file ) {
// 		var $li = $(
// 			'<div id="' + file.id + '" class="item">' +
// 				'<div class="pic-box"><img></div>'+
// 				'<div class="info">' + file.name + '</div>' +
// 				'<p class="state">等待上传...</p>'+
// 			'</div>'
// 		),
// 		$img = $li.find('img');
// 		$list.append( $li );
	
//		创建缩略图
//		如果为非图片文件，可以不用调用此方法。
//		thumbnailWidth x thumbnailHeight 为 100 x 100
// 		uploader.makeThumb( file, function( error, src ) {
// 			if ( error ) {
// 				$img.replaceWith('<span>不能预览</span>');
// 				return;
// 			}
	
// 			$img.attr( 'src', src );
// 		}, thumbnailWidth, thumbnailHeight );
// 	});
//	文件上传过程中创建进度条实时显示。
// 	uploader.on( 'uploadProgress', function( file, percentage ) {
// 		var $li = $( '#'+file.id ),
// 			$percent = $li.find('.progress-box .sr-only');
	
//		避免重复创建
// 		if ( !$percent.length ) {
// 			$percent = $('<div class="progress-box"><span class="progress-bar radius"><span class="sr-only" style="width:0%"></span></span></div>').appendTo( $li ).find('.sr-only');
// 		}
// 		$li.find(".state").text("上传中");
// 		$percent.css( 'width', percentage * 100 + '%' );
// 	});
	
//	文件上传成功，给item添加成功class, 用样式标记上传成功。
// 	uploader.on( 'uploadSuccess', function( file ) {
// 		$( '#'+file.id ).addClass('upload-state-success').find(".state").text("已上传");
// 	});
	
//	文件上传失败，显示上传出错。
// 	uploader.on( 'uploadError', function( file ) {
// 		$( '#'+file.id ).addClass('upload-state-error').find(".state").text("上传出错");
// 	});
	
//	完成上传完了，成功或者失败，先删除进度条。
// 	uploader.on( 'uploadComplete', function( file ) {
// 		$( '#'+file.id ).find('.progress-box').fadeOut();
// 	});
// 	uploader.on('all', function (type) {
//         if (type === 'startUpload') {
//             state = 'uploading';
//         } else if (type === 'stopUpload') {
//             state = 'paused';
//         } else if (type === 'uploadFinished') {
//             state = 'done';
//         }

//         if (state === 'uploading') {
//             $btn.text('暂停上传');
//         } else {
//             $btn.text('开始上传');
//         }
//     });

//     $btn.on('click', function () {
//         if (state === 'uploading') {
//             uploader.stop();
//         } else {
//             uploader.upload();
//         }
//     });
	
//  	var ue = UE.getEditor('editor');
	
});



$("#articlecolumn1").change(function() {
	$.post("backSp/name1.do", {
		name : $(this).val()
	}, function(res) {
		if (res.list2 != null && res.list2 != "") {
		var list = res.list2;
//		var list1 = res.list3;
			for (var ep in list){
				$("#articlecolumn2").append("<option value=\"" + list[ep].id + "\">" + list[ep].name+ "</option>");
			};
// 			for (var eq in list1){
// 				$("#articlecolumn3").append("<option value=\"" + list1[eq].id + "\">" + list1[eq].name+ "</option>");
// 			};
// 			$("#op2").next().attr("selected", "selected");
// 			$("#op3").next().attr("selected", "selected");	
		} else {
			return false;
		}
	}, "JSON");
});
$("#articlecolumn1").focus(function() {
	$("#op2").siblings().remove();
	$("#op3").siblings().remove();
});
$("#articlecolumn2").change(function() {
	$.post("backSp/name2.do", {
		name : $(this).val()
	}, function(res) {
		if (res.list3 != null && res.list3 != "") {
		var list = res.list3;
			for (var ep in list){
				$("#articlecolumn3").append("<option value=\"" + list[ep].id + "\">" + list[ep].name+ "</option>");
			};		
// 			$("#op3").next().attr("selected", "selected");			
		} else {
					return false;
		}
	}, "JSON");
});
$("#articlecolumn2").focus(function() {
	$("#op3").siblings().remove();
});
$("#articlecolumn2").click(function () {
	if ($("#articlecolumn1").val() == null || $("#articlecolumn1").val() == "") {
		alert("请选择一级分类！！");
		return false;
	};
});
$("#articlecolumn3").click(function () {
	if ($("#articlecolumn2").val() == null || $("#articlecolumn2").val() == "") {
		alert("请选择二级分类！！");
		return false;
	};
});

$("#tp").click(function(){
	$("#sc").append("<input type='file' name='attachs'/>");
});

$("#tp").click(function(){
	
});

function readURL(input) {
	if (input.files && input.files[0]) {
		var formData = new FormData();
		formData.append('file', $('#file')[0].files[0]);	      
		$.ajax({
			url: 'backSp/dUpload.do',
			type: 'POST',
			cache: false,
			data: formData,
			processData: false,
			contentType: false,
			ataType : "json"
		}).done(function(res) {
			$("#form-article-add").append("<input type='hidden' id='fileName' value=\"" + res.name + "\">");
		}).fail(function(res) {});
	}	
}

$("#file").change(function(){	
	readURL(this);   
});
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>

</html>
 