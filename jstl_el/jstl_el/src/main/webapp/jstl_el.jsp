<%@ page import="com.ming.vo.UserInfo" %>
<%@ page import="com.ming.servlet.ELServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>测试EL表达式 </title>
</head>
<body>

    <h1>测试EL表达式</h1><br>
    <p/>
    <li>普通字符串测试</li><br>
    strKey: <%= request.getAttribute("strKey")  %> </br>
    strKey1(EL):${requestScope.strKey} <br>
    strKey2(EL):${strKey}<br>
    strKey3(EL):${pageScope.strKey}<br>

    <li>结构测试</li><br>
    userInfo(username/groupName):<br>
    <%
        UserInfo userInfo = (UserInfo) request.getAttribute("userInfoKey");



    %>
        <%=userInfo.getUsername()%>
        <%=userInfo.getGroup().getgName()%><br>
    userInfo(username/groupName)[EL]:<br> ${requestScope.userInfoKey.username}
${requestScope.userInfoKey.group.gName}<br>

    <li>字符串数组测试</li><br>
    strArray (EL)</br>
    strArray[0] : ${strArrayKey[0]}<br>
    strArray[1] : ${strArrayKey[1]}<br>
    strArray[2] : ${strArrayKey[2]}<br>
    strArray[3] : ${strArrayKey[3]}<br>


    <li>自定义数组测试</li><br>
    userInfosKey (EL)</br>
    userInfosKey[0] : ${userInfosKey[0]}<br>
    userInfosKey[1] : ${userInfosKey[1]}<br>
    userInfosKey[2] : ${userInfosKey[2]}<br>
    userInfosKey[3] : ${userInfosKey[3]}<br>
    userInfosKey[4] : ${userInfosKey[4]}<br>
</body>
</html>
