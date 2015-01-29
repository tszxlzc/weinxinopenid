<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>答题活动</title>
</head>
<body>
<h1>Welcome To Struts 2!</h1>
<input id="openid" style="display: none;" name=<%=request.getSession().getAttribute("openId") %>></input>
<span>微信用户的openid为：<%=request.getSession().getAttribute("openId") %></span>
<button onclick="">抽奖</button>
<script type="text/javascript">
window.onload = function ifLotteryed(){
	var openid = document.getElementById("openid").name;
	if(openid =="null"){
		window.location.href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxcf9a0d487b39f127&redirect_uri=http%3A%2F%2Fweixinopenid.vipsinaapp.com%2Findex&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
	}
};
</script>
</body>
</html>