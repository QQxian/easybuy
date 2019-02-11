<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="text/javascript">
	  var contextPath = "${ctx}";
	</script>
    <link type="text/css" rel="stylesheet" href="${ctx}/statics/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="${ctx}/statics/css/ShopShow.css" />
	<link rel="stylesheet" type="text/css" href="${ctx}/statics/css/MagicZoom.css" />
    <title>易买网</title>
  </head>
  
  <body>
<!--Begin Login Begin-->
<div id="fade1" class="black_overlay"></div>
<div id="MyDiv1" class="white_content">
  <div class="white_d">
    <div class="notice_t">
      <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="${ctx}/statics/images/close.gif" /></span>
    </div>
    <div class="notice_c">
      <table border="0" align="center" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td width="40"><img src="${ctx}/statics/images/suc.png"></td>
          <td>
            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>
<div class="log_bg">	
    <div class="top">
        <div class="logo"><a href="Index.html"><img src="${ctx}/statics/images/logo.png" /></a></div>
    </div>
	<div class="regist">
    	<div class="log_img"><img src="${ctx}/statics/images/l_img.png" width="611" height="425" /></div>
		<div class="reg_c">
        	<form id="register">
                <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册</span>
                            <span class="fr">已有商城账号，<a href="${ctx}/login.do" style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>登录用户名 &nbsp;</td>
                        <td><input type="text" value="" name="loginName" class="l_user"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" value="" name="password" class="l_pwd"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" value="" name="confirmPassword" class="l_pwd"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;真实姓名 &nbsp;</td>
                        <td><input type="text" value="" name="userName" class="l_user"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                        <td>
                            <input type="radio" name="sex" value="1" checked="checked">&nbsp;男&nbsp;&nbsp;
                            <input type="radio" name="sex" value="0">&nbsp;女
                        </td>
                    </tr>

                    <tr height="50">
                        <td align="right">&nbsp;身份证号 &nbsp;</td>
                        <td><input type="text" value="" name="identityCode" class="l_user"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right">&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" value="" name="email" class="l_email"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right">&nbsp;手机 &nbsp;</td>
                        <td><input type="text" value="" name="mobile" class="l_tel"/></td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="button" value="立即注册" class="log_btn" onclick="register();"/></td>
                    </tr>
                </table>
            </form>
	        </div>
	    </div>
	</div>
	<!--End Login End--> 
	<!--Begin Footer Begin-->
	<div class="btmbg">
	    <div class="btm">
	       	 备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
	        <img src="${ctx}/statics/images/b_1.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_2.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_3.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_4.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_5.gif" width="98" height="33" /><img src="${ctx}/statics/images/b_6.gif" width="98" height="33" />
	    </div>    	
	</div>
	<!--End Footer End --> 
  
  	<script type="text/javascript" src="${ctx}/statics/js/common/jquery-1.11.1.min_044d0927.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/jquery.bxslider_e88acd1b.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/menu.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/select.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/iban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/fban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/f_ban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/mban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/bban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/hban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/tban.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/lrscroll_1.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/MagicZoom.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/num.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/p_tab.js"></script>
	<script type="text/javascript" src="${ctx}/statics/js/common/shade.js"></script>
    <script type="text/javascript" src="${ctx}/statics/js/register/register.js"></script>
    </body>
</html>
