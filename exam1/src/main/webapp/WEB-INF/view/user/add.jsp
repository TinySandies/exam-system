<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css"/>

<%--    <script type="text/javascript"--%>
<%--            src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>--%>
    <script src="https://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.metadata.js"></script>
</head>
<body>
<form:form id="user-form" method="post" action="add" modelAttribute="student">
    <table align="center">
        <tr>
            <td colspan="2">添加用户</td>
        </tr>
        <tr>
            <td><form:errors path="userId" cssClass="error" cssStyle="color: red;"/></td>
        </tr>
        <tr>
            <td>ID</td>
            <td>
                <form:input path="userId" cssClass="{required: true, maxlength: 18}"/>
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
            <td colspan="2">
                <button type="submit">添加</button>
            </td>
        </tr>
    </table>
</form:form>
<script type="text/javascript">
    $().ready(function () {
        $("#user-form").validate();
        $.extend($.validator.messages, {
            required: "这是必填字段",
            remote: "请修正此字段",
            email: "请输入有效的电子邮件地址",
            url: "请输入有效的网址",
            date: "请输入有效的日期",
            dateISO: "请输入有效的日期 (YYYY-MM-DD)",
            number: "请输入有效的数字",
            digits: "只能输入数字",
            creditcard: "请输入有效的信用卡号码",
            equalTo: "你的输入不相同",
            extension: "请输入有效的后缀",
            maxlength: $.validator.format("最多可以输入 {0} 个字符"),
            minlength: $.validator.format("最少要输入 {0} 个字符"),
            rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
            range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
            max: $.validator.format("请输入不大于 {0} 的数值"),
            min: $.validator.format("请输入不小于 {0} 的数值")
        });
    })
</script>
</body>
</html>
