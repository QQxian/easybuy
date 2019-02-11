<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String rootPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ "/" + request.getContextPath() + "/files/";
%>
<%
	String path = request.getRequestURL().toString();
	String action=path.substring((path.indexOf("WEB-INF/jsp/")+11), (path.length()-4));
 %>
<%
	int i = 1;
	%>
	
<%
int bb=-40;
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>


<script type="text/javascript">
  var contextPath = "/EasyBuy";
</script>
<div class="soubg">
  <div class="sou">
    <!--Begin 所在收货地区 Begin-->
    	<span class="s_city_b">
        	<span class="fl">送货至：</span>
            <span class="s_city">
            	<span>四川</span>
                <div class="s_city_bg">
                  <div class="s_city_t"></div>
                  <div class="s_city_c">
                    <h2>请选择所在的收货地区</h2>
                    <table class="c_tab" style="width:235px; margin-top:10px;">
                      <tr>
                        <th>A</th>
                        <td class="c_h"><span>安徽</span><span>澳门</span></td>
                      </tr>
                      <tr>
                        <th>B</th>
                        <td class="c_h"><span>北京</span></td>
                      </tr>
                      <tr>
                        <th>C</th>
                        <td class="c_h"><span>重庆</span></td>
                      </tr>
                      <tr>
                        <th>F</th>
                        <td class="c_h"><span>福建</span></td>
                      </tr>
                      <tr>
                        <th>G</th>
                        <td class="c_h"><span>广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
                      </tr>
                      <tr>
                        <th>H</th>
                        <td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
                      </tr>
                      <tr>
                        <th>J</th>
                        <td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
                      </tr>
                      <tr>
                        <th>L</th>
                        <td class="c_h"><span>辽宁</span></td>
                      </tr>
                      <tr>
                        <th>N</th>
                        <td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
                      </tr>
                      <tr>
                        <th>Q</th>
                        <td class="c_h"><span>青海</span></td>
                      </tr>
                      <tr>
                        <th>S</th>
                        <td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span class="c_check">四川</span><span>陕西</span></td>
                      </tr>
                      <tr>
                        <th>T</th>
                        <td class="c_h"><span>台湾</span><span>天津</span></td>
                      </tr>
                      <tr>
                        <th>X</th>
                        <td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
                      </tr>
                      <tr>
                        <th>Y</th>
                        <td class="c_h"><span>云南</span></td>
                      </tr>
                      <tr>
                        <th>Z</th>
                        <td class="c_h"><span>浙江</span></td>
                      </tr>
                    </table>
                  </div>
                </div>
            </span>
        </span>
        <!--End 所在收货地区 End-->
        <span class="fr">
          <c:if test="${sessionScope.loginUser==null}">
            <span class="fl">你好，请<a href="${ctx}/login.do?action=<%=action %>"  style="color:#ff4e00;">登录</a>&nbsp;<a href="${ctx}/register.do" style="color:#ff4e00;">免费注册</a>&nbsp;&nbsp;</span>
          </c:if>
          <c:if test="${sessionScope.loginUser!=null}">
            <span class="fl">你好<a href="${ctx}/admin/user?action=index">${sessionScope.loginUser.loginname}</a>&nbsp;|&nbsp;<a href="${ctx}/admin/order?action=index&userId=${sessionScope.loginUser.id}">我的订单</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null && sessionScope.loginUser.type==1}">
            <span class="fl">|&nbsp;<a href="${ctx}/admin/product?action=index&userId=${sessionScope.loginUser.id}">后台管理</a>&nbsp;</span>
          </c:if>
           <c:if test="${sessionScope.loginUser!=null}">
             <span class="fl">|&nbsp;<a href="${ctx}/loginOut.do" >注销</a></span>
          </c:if>
        </span>
  </div>
</div>
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
<div id="fade1" class="black_overlay"></div>
<div id="MyDiv1" class="white_content">
  <div class="white_d">
    <div class="notice_t">
      <span class="fr" style="margin-top:10px; cursor:pointer;" onclick="CloseDiv_1('MyDiv1','fade1')"><img src="/EasyBuy/statics/images/close.gif" /></span>
    </div>
    <div class="notice_c">
      <table border="0" align="center" cellspacing="0" cellpadding="0">
        <tr valign="top">
          <td width="40"><img src="/EasyBuy/statics/images/suc.png"></td>
          <td>
            <span style="color:#3e3e3e; font-size:18px; font-weight:bold;" id="showMessage">操作成功</span><br />
          </td>
        </tr>
      </table>
    </div>
  </div>
</div>
<link type="text/css" rel="stylesheet" href="/EasyBuy/statics/css/style.css"/>
<script type="text/javascript" src="/EasyBuy/statics/js/common/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/menu.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/select.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/lrscroll.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/iban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/fban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/f_ban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/mban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/bban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/hban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/tban.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/lrscroll_1.js"></script>

<script type="text/javascript" src="/EasyBuy/statics/js/register/register.js"></script>
<link rel="stylesheet" type="text/css" href="/EasyBuy/statics/css/ShopShow.css" />
<link rel="stylesheet" type="text/css" href="/EasyBuy/statics/css/MagicZoom.css" />
<script type="text/javascript" src="/EasyBuy/statics/js/common/MagicZoom.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/num.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/p_tab.js"></script>
<script type="text/javascript" src="/EasyBuy/statics/js/common/shade.js"></script>


    <script type="text/javascript" src="/EasyBuy/statics/js/common/n_nav.js"></script>
    <script src="/EasyBuy/statics/js/cart/cart.js"></script>
    <title>易买网</title>
</head>
<body>
<!--Begin Header Begin-->
<div id="searchBar">
    


<script type="text/javascript">
    var contextPath = "/EasyBuy";
</script>
<div class="top">
    <div class="logo">
        <a href="/EasyBuy/Home?action=index"><img src="/EasyBuy/statics/images/logo.png"></a>
    </div>
    <div class="search">
        <form action="/EasyBuy/Product?action=queryProductList" method="post">
            <input type="text" value="" name="keyWord" class="s_ipt">
            <input type="submit" value="搜索" class="s_btn">
        </form>
        <!--推荐最热商品-->
    </div>
    <div class="i_car">
        <div class="car_t">
            购物车 [
            <span>
                
                
                    空
                
            </span>]
        </div>
        <div class="car_bg">
            <!--Begin 购物车未登录 Begin-->
            
                <div class="un_login">还未登录！<a href="/EasyBuy/Login?action=toLogin" style="color:#ff4e00;">马上登录</a></div>
            
            
            <!--End 购物车未登录 End-->
            <!--Begin 购物车已登录 Begin-->
            <ul class="cars">
                
            </ul>
            <div class="price_sum">共计&nbsp;<font color="#ff4e00">￥</font><span></span></div>
            
                <div class="price_a"><a href="/EasyBuy/Login?action=toLogin">去登录</a></div>
            
            
            <!--End 购物车已登录 End-->
        </div>
    </div>
</div>

</div>
<!--End Header End-->
<!--Begin Menu Begin-->
<div class="menu_bg">
    <div class="menu">
        <!--Begin 商品分类详情 Begin-->
        


<script type="text/javascript" src="/EasyBuy/statics/js/common/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
    var contextPath = "/EasyBuy";
</script>
<div class="nav">
    <div class="nav_t">全部商品分类</div>
    <div class="leftNav none" style="display: none;">
        <ul id="leftMenu">
               <c:forEach items="${newsDetail1}" var="news">
						
							<li>
								<div class="fj">
									<span class="n_img"><span></span><img
										src="statics/images/nav<%=i++%>.png" /></span> <span class="fl">
										${news.name} </span>
								</div>
								<div class="zj" style="top:-<%=(bb = bb + 40) %>px">
									<div class="zj_l">
										<div class="zj_l_c"style="height: 200px">
											<c:forEach items="${newsDetail2}" var="xo">
												<c:if test="${xo.parentid==news.id}">
													<h2>${xo.name}</h2>
													<c:forEach items="${newsDetail3}" var="parm">
														<c:if test="${parm.parentid==xo.id}">
															<a
																href="chakan.do?name=${parm.name}"
																style="padding: 0;"> ${parm.name}|</a>
														</c:if>
													</c:forEach>
												</c:if>
											</c:forEach>
										</div>
									</div>	
								</div>
							</li>
						</c:forEach>
        </ul>
    </div>
</div>
<ul class="menu_r">
    <li><a href="index.do">首页</a></li>
    <c:forEach items="${newsDe}" var="news">
    <li><a href="chakan.do?id=${news.id}">${news.username}</a></li>
    </c:forEach>
				
    
</ul>
<div class="m_ad">中秋送好礼！</div>
        <!--End 商品分类详情 End-->
    </div>
</div>
<!--End Menu End-->
<div class="i_bg">
    <!--Begin 筛选条件 Begin-->
    <!--End 筛选条件 End-->
    <div class="content mar_20">
        <div id="favoriteList">
        </div>
        <div class="l_list">
            <div class="list_t">
                <span class="fr">共发现${aa}件</span>
            </div>
            <div class="list_c">
                <ul class="cate_list">
                      <c:forEach items="${newsDetail}" var="news">
                        <li>
                            <div class="img">
                               
                                    <img src="<%=rootPath %>/${news.filename }" width="210" height="185"/>
                                
                            </div>
                            <div class="price">
                                <font>￥<span>${news.price }</span></font>
                            </div>
                            <div class="name">${news.name }</div>
                            <div class="carbg">
                                <a href="javascript:void(0);" class="ss" onclick="addFavorite('744')">收藏</a>
                                <a href="javascript:void(0);" class="j_car" onclick="addCartByParam('744',1);">加入购物车</a>
                            </div>
                        </li>
                       </c:forEach>
                    
                </ul>
                


<script type="text/javascript">
    var contextPath = "/EasyBuy";
</script>
<div class="pages">
    
      <a href="chakan.do?page=1&&id=${id}" class="p_pre">首页</a>
                <a href="chakan.do?page=1&&id=${id}&&name=${name}&&categorylevel2id=${categorylevel2id}" class="cur">1</a>
                <a href="chakan.do?page=2&&id=${id}&&name=${name}&&categorylevel2id=${categorylevel2id}">2</a>
                <a href="chakan.do?page=${page + 1 }&&id=${id}&&name=${name}&&categorylevel2id=${categorylevel2id}">下一页</a>
            
         <c:if test="${page > 1 }"><a href="chakan.do?page=${page - 1 }&&id=${id}&&name=${name}&&categorylevel2id=${categorylevel2id}">上一页</a></c:if>
      
      <a href="chakan.do?page=${totalPage }" class="p_pre">第${page}页/共${totalPage}页</a>
    
    
</div>

            </div>
        </div>
    </div>
    <script>
        favoriteList();
    </script>
    
<div class="b_btm_bg b_btm_c" id="footer">
  <div class="b_btm">
    <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
      <tr>
        <td width="72"><img src="/EasyBuy/statics/images/b1.png" width="62" height="62" /></td>
        <td><h2>正品保障</h2>正品行货  放心购买</td>
      </tr>
    </table>
    <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
      <tr>
        <td width="72"><img src="/EasyBuy/statics/images/b2.png" width="62" height="62" /></td>
        <td><h2>满38包邮</h2>满38包邮 免运费</td>
      </tr>
    </table>
    <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
      <tr>
        <td width="72"><img src="/EasyBuy/statics/images/b3.png" width="62" height="62" /></td>
        <td><h2>天天低价</h2>天天低价 畅选无忧</td>
      </tr>
    </table>
    <table border="0" style="width:210px; height:62px; float:left; margin-left:75px; margin-top:30px;" cellspacing="0" cellpadding="0">
      <tr>
        <td width="72"><img src="/EasyBuy/statics/images/b4.png" width="62" height="62" /></td>
        <td><h2>准时送达</h2>收货时间由你做主</td>
      </tr>
    </table>
  </div>
</div>
<div class="b_nav">
  <dl>
    <dt><a href="#">新手上路</a></dt>
    <dd><a href="#">售后流程</a></dd>
    <dd><a href="#">购物流程</a></dd>
    <dd><a href="#">订购方式</a></dd>
    <dd><a href="#">隐私声明</a></dd>
    <dd><a href="#">推荐分享说明</a></dd>
  </dl>
  <dl>
    <dt><a href="#">配送与支付</a></dt>
    <dd><a href="#">货到付款区域</a></dd>
    <dd><a href="#">配送支付查询</a></dd>
    <dd><a href="#">支付方式说明</a></dd>
  </dl>
  <dl>
    <dt><a href="#">会员中心</a></dt>
    <dd><a href="#">资金管理</a></dd>
    <dd><a href="#">我的收藏</a></dd>
    <dd><a href="#">我的订单</a></dd>
  </dl>
  <dl>
    <dt><a href="#">服务保证</a></dt>
    <dd><a href="#">退换货原则</a></dd>
    <dd><a href="#">售后服务保证</a></dd>
    <dd><a href="#">产品质量保证</a></dd>
  </dl>
  <dl>
    <dt><a href="#">联系我们</a></dt>
    <dd><a href="#">网站故障报告</a></dd>
    <dd><a href="#">购物咨询</a></dd>
    <dd><a href="#">投诉与建议</a></dd>
  </dl>
  <div class="b_tel_bg">
    <a href="#" class="b_sh1">新浪微博</a>
    <a href="#" class="b_sh2">腾讯微博</a>
    <p>
      服务热线：<br />
      <span>400-123-4567</span>
    </p>
  </div>
  <div class="b_er">
    <div class="b_er_c"><img src="/EasyBuy/statics/images/er.gif" width="118" height="118" /></div>
    <img src="/EasyBuy/statics/images/ss.png" />
  </div>
</div>
<div class="btmbg">
  <div class="btm">
    备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 尤洪商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
    <img src="/EasyBuy/statics/images/b_1.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_2.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_3.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_4.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_5.gif" width="98" height="33" /><img src="/EasyBuy/statics/images/b_6.gif" width="98" height="33" />
  </div>
</div>

</div>
</body>
</html>
