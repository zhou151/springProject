<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/helloSpring/webjars/jquery/1.8.3/jquery.js"></script> 
<title>标题</title>
</head>
<body>
	hello <span>${msg}</span>
	<div id="box01"></div>
</body>
<script src="/helloSpring/js/index.js"></script> 
<script>
$(function()
{
	$('#box01').text("webJar");
})
</script>
</html>