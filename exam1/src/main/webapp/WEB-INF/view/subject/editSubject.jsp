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
    <title>科目修改</title>
</head>
<body>
<form:form method="post" action="${subject.subId}" modelAttribute="subject">
    <table align="center">
        <tr><td colspan="2"><h2>修改科目</h2></td></tr>
        <table align="center">
            <tr>
                <td>科目ID</td>
                <td>
                    <form:input path="subId" readonly="true" />
                </td>
            </tr>
            <tr>
                <td>科目名称</td>
                <td><form:input path="subjectName" />
                </td>
            </tr>
            <tr>
                <td>科目描述</td>
                <td><form:input path="description" />
                </td>
            </tr>
            <tr>
                <td>测试次数</td>
                <td><form:input path="testCount" />
                </td>
            </tr>
            <tr>
                <td>总分</td>
                <td><form:input path="totalScore"/>
                </td>
            </tr>
            <tr>
                <td>总次数</td>
                <td><form:input path="totalTime"/>
                </td>
            </tr>
            <tr>
                <td>状态</td>
                <td><form:input path="status" />
                </td>
            </tr>
            <tr style="text-align: center;">
                <td colspan="2"><button type="submit">修改</button></td>
            </tr>
    </table>
</form:form>
</body>
</html>
