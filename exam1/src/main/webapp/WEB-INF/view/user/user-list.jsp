<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>User List</title>
    <style type="text/css">
        table {
            margin: 100px auto;
            border: 1px solid #000000;
            border-collapse: collapse;
        }

        tr, td {
            border: 1px solid #000000;
        }

    </style>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td colspan="5"><spring:message code="page.lang"/>:
            <a href="switchLang?localeType=zh_CN"><spring:message code="lang.cn"/></a>&nbsp;/&nbsp;
            <a href="switchLang?localeType=en_US"><spring:message code="lang.en"/></a>
        </td>
    </tr>
    <tr>
        <td><spring:message code="user.id"/></td>
        <td><spring:message code="user.name"/></td>
        <td><spring:message code="user.age"/></td>
        <td><spring:message code="action.operate"/></td>
        <td><a href="add"><spring:message code="action.add"/></a></td>

    </tr>

    <c:if test="${not empty message}">
        <script type="text/javascript">
            alert("${message}");
        </script>
    </c:if>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td><a href="/edit/${user.id}"><spring:message code="action.edit"/></a>&nbsp;
                /&nbsp;<a href="/delete/${user.id}"><spring:message code="action.delete"/></a></td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
