<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="top">
    <div class="logo"><a href="Index.html"><img src="statics/images/logo.png" /></a></div>
<div class="search">
        <form action="proList.do" method="post">
            <input type="text" value="${name}" name="name" class="s_ipt" />
            <input type="submit" value="搜索" class="s_btn"/>
        </form>
	<span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
</div>

