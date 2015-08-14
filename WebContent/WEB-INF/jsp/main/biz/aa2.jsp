<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=basePath%>main/biz/aa4.do" method="post">  
        <div class="f_left">会员1号:</div>  
        <div class="f_left">  
        <input name="attorneyrecords[0].attorney" value="张三"/>  
        </div>  
        <div class="clear"></div>  
        <div class="f_left">会员2号:</div>  
        <div class="f_left">  
        <input name="attorneyrecords[1].attorney" value="李四"/>  
        </div>  
        <div class="clear"></div>  
        <div class="f_left">会员3号:</div>  
        <div class="f_left">  
        <input name="attorneyrecords[2].attorney" value="王五"/>  
        </div>  
        <div class="clear"></div> 
        <div><input type="submit" value="提交表单"/></div>
        <input type="text" name="token" value="${token}"/>
    </form>  
</body>
</html>