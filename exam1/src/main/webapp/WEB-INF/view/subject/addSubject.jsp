<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加科目</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/assets/css/bootstrap.min.css"/>

    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.validate.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/jquery.metadata.js"></script>
</head>
<body>
<form:form id="subject-form" method="post" action="add" modelAttribute="subject">
    <table align="center">
        <tr>
            <td colspan="2"><h4 style="text-align: center;">添加科目</h4></td>
        </tr>
<%--        <tr>--%>
<%--            <td><form:errors path="name" cssClass="error" cssStyle="color: red;"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td>科目名称</td>
            <td>
                <form:input path="subjectName" />
            </td>
        </tr>
<%--        <tr>--%>
<%--            <td><form:errors path="description" cssClass="error" cssStyle="color: red;"/></td>--%>
<%--        </tr>--%>
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
            <td>总分数</td>
            <td><form:input path="totalScore" />
            </td>
        </tr>

        <tr>
            <td>总时间</td>
            <td><form:input path="totalTime" />
            </td>
        </tr>

        <tr>
            <td>状态</td>
            <td><form:input path="status" />
            </td>
        </tr>
        <tr style="text-align: center;">
            <td colspan="2">
                <button type="submit">添加科目</button>
            </td>
        </tr>
    </table>
</form:form>
<%--<script type="text/javascript">--%>
<%--    $().ready(function () {--%>
<%--        $("#user-form").validate();--%>
<%--        $.extend($.validator.messages, {--%>
<%--            required: "这是必填字段",--%>
<%--            remote: "请修正此字段",--%>
<%--            email: "请输入有效的电子邮件地址",--%>
<%--            url: "请输入有效的网址",--%>
<%--            date: "请输入有效的日期",--%>
<%--            dateISO: "请输入有效的日期 (YYYY-MM-DD)",--%>
<%--            number: "请输入有效的数字",--%>
<%--            digits: "只能输入数字",--%>
<%--            creditcard: "请输入有效的信用卡号码",--%>
<%--            equalTo: "你的输入不相同",--%>
<%--            extension: "请输入有效的后缀",--%>
<%--            maxlength: $.validator.format("最多可以输入 {0} 个字符"),--%>
<%--            minlength: $.validator.format("最少要输入 {0} 个字符"),--%>
<%--            rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),--%>
<%--            range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),--%>
<%--            max: $.validator.format("请输入不大于 {0} 的数值"),--%>
<%--            min: $.validator.format("请输入不小于 {0} 的数值")--%>
<%--        });--%>
<%--    })--%>
<%--</script>--%>
</body>
</html>
