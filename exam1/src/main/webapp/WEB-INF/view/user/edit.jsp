<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: TINY
  Date: 2019/5/30
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
</head>
<body>
<form:form method="post" action="${user.userId}" modelAttribute="user">
    <table align="center">
        <tr><td colspan="2">修改用户信息</td></tr>
<%--        <tr><td>ID</td><td><form:input path="userId" readonly="true"/></td></tr>--%>
<%--        <tr><td>姓名</td><td><form:input path="userName"/></td></tr>--%>
<%--        <tr><td>年龄</td><td><form:input path="age"/></td></tr>--%>
        <table align="center">
            <tr>
                <td><form:errors path="userId" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>ID</td>
                <td>
                    <form:input path="userId" readonly="true" cssClass="{required: true, maxlength: 18}"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="userName" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>姓名</td>
                <td><form:input path="userName" cssClass="{required: true, maxlength: 15}"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="gender" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><form:input path="gender" cssClass="{required: true}"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="password" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><form:input path="password" cssClass="{required: true}" type="password"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="birthday" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><form:input path="birthday" cssClass="{required: true, date: true}"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="tel" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>电话</td>
                <td><form:input path="tel" cssClass="{required: true, digits: true"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="email" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><form:input path="email" cssClass="{required: true, email: true"/>
                </td>
            </tr>
            <tr>
                <td><form:errors path="address" cssClass="error" cssStyle="color: red;"/></td>
            </tr>
            <tr>
                <td>地址</td>
                <td><form:input path="address" cssClass="{required: true"/>
                </td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2"><button type="submit">修改</button></td>
            </tr>
    </table>
</form:form>
</body>
</html>
