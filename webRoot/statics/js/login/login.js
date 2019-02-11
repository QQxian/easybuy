/**
 * Created by bdqn on 2016/5/3.
 */
//登录的方法
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    if(loginName==null || loginName==""){
    	alert("请填写用户名");
    	return false;
    }
    if(password==null || password==""){
    	alert("请填写密码");
    	return false;
    }
}