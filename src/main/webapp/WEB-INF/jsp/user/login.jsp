<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录页面</title>
<script src="<c:url value="/lib/jquery-1.7.2.min.js"/>"></script>
<script src="<c:url value="/lib/layer/layer.min.js"/>"></script>
</head>
<body>
	<h3>用户登录页面</h3>
	<br> 用户名：
	<input type="text" id="username" value="张三丰">
	<br> 密码：
	<input type="password" id="password" value="1234567">
	<br>
	<input type="button" value="提交" onclick="submit()">
	<br>
	<input type="button" value="测试JavaWEB前端向服务器端发送对象" onclick="submitObject()">
</body>
<script type="text/javascript">
	var loadi;
	//提交信息
	function submit() {
		var username = $("#username").val();
		var password = $("#password").val();
		var dataInfo = {
			"username" : username,
			"password" : password
		};
		var url = "<c:url value="/user/saveUser.do"/>";
		$.ajax({
			data : dataInfo,
			url : url,
			dataType : 'json', // 服务器返回的格式类型
			type : 'post',
			success : function(data, status) {
				layer.close(loadi);
				console.info(data);
				if (data.result == "sucess") {
					//var to_url = "<c:url value='/legal/toConsultList.do?flag=user'/>";
					//window.location.href = to_url;
					alert("保存成功！");
				} else if (data.result == "failed") {
					alert("系统发生异常，请稍候提交");
				} else {
					alert("提交失败");
				}
			},
			beforeSend : function() {
				loadi = layer.load('正在提交，请稍候…');
			},
			error : function(data, status, e) {
				layer.close(loadi);
				console.info(data);
				alert("出错了，请重新提交！");
			}
		});
	}
	//测试js对象传给后台
	function submitObject() {

		var arr = new Array();
		arr.push("数组1");
		arr.push("数组2");
		arr.push("数组3");
		arr.push("数组4");

		/* ============== */
		var obj = {};
		obj.name = "张三";
		obj.age = "25";
		obj.tell = "18723056693";
		obj = JSON.stringify(obj);//将json对象转成字符串
		arr.push(obj);

		arr = arr.join("&&&");//将数组转成字符串

		/* =========== */
		var param = {};
		param.name = "张三3";
		param.age = "253";
		param.tell = "187230566933";

		var params = {};
		params.name = "张三2";
		params.age = "252";
		params.tell = "187230566932";
		params.param = param;

		obj2 = obj2Str(obj2);

		alert(obj2);
		var dataInfo = {
			"arr" : arr,
			"params" : params
		};
		var url = "<c:url value="/user/getObjectJS.do"/>";
		$.ajax({
			data : dataInfo,
			url : url,
			dataType : 'json', // 服务器返回的格式类型
			type : 'post',
			success : function(data, status) {
				layer.close(loadi);
				console.info(data);
				if (data.result == "sucess") {
					alert("测试成功！");
				} else if (data.result == "failed") {
					alert("系统发生异常，请稍候提交");
				} else {
					alert("提交失败");
				}
			},
			beforeSend : function() {
				loadi = layer.load('正在提交，请稍候…');
			},
			error : function(data, status, e) {
				layer.close(loadi);
				console.info(data);
				alert("出错了，请重新提交！");
			}
		});
	}

	//js对象转成json字符串
	function obj2Str(obj) {
		switch (typeof (obj)) {
		case 'object':
			var ret = [];
			if (obj instanceof Array) {
				for (var i = 0, len = obj.length; i < len; i++)
				{
					ret.push(obj2Str(obj[i]));
				}
				return '[' + ret.join(',') + ']';
			}
			else if (obj instanceof RegExp)
			{
				return obj.toString();
			}
			else
			{
				for ( var a in obj)
				{
					ret.push(a + ':' + obj2Str(obj[a]));
				}
				return '{' + ret.join(',') + '}';
			}
		case 'function':
			return 'function() {}';
		case 'number':
			return obj.toString();
		case 'string':
			return '"'
					+ obj.replace(/(\\|\")/g, '\\$1').replace(
							/\n|\r|\t/g,
							function(a)
							{
								return ('\n' == a) ? '\\n'
										: ('\r' == a) ? '\\r'
												: ('\t' == a) ? '\\t' : '';
							}) + '"';
		case 'boolean':
			return obj.toString();
		default:
			return obj.toString();
		}
	}
</script>
</html>