<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<div class="theme-bule">
    <div class="main-content clearfix">
        <div class="row clearfix">
            <c:if test="${not empty message}">
                <div id="message" class="alert alert-success">
                    <button data-dismiss="alert" class="close">X</button>
                    ${message}
                </div>
            </c:if>
            <form:form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleInputFile" class="control-label">选择上传文件</label>
                    <input type="file" id="exampleInputFile" name="file" class="form-control"/>
                </div>

                <div>
                    <button class="btn btn-primary" type="submit">上传</button>
                    <button class="btn btn-default" onclick="history.go(-1)">取消</button>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
