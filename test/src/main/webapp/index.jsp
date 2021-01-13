<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>
        测试
    </title>
</head>
<body>
<h2>你好世界</h2>
<div>
<a href="theory/lifeCycle.jsp" target="_blank">生命周期</a>
</div>
<div>
    <a href="theory/use%25.jsp" target="_blank">%的使用</a>
</div>
<div>
    <a href="theory/controllLanguage.jsp" target="_blank">控制语句</a>
</div>
<div>
    <a href="theory/others.jsp" target="_blank">其他</a>
</div>
<h3>include动作实例</h3>
<jsp:include page="include/date.jsp" flush="true"/>
<h3>JavaBean实例</h3>
<jsp:useBean id="test" class="javaBean.TestBean"/>
<jsp:setProperty name="test" property="message" value="测试JavaBean"/>
<jsp:getProperty name="test" property="message"/>
</body>
</html>
