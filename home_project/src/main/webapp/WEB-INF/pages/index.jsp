<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="<c:url value="../static/css/app.css" />" rel="stylesheet" type="text/css">
    <title>Spring Security Example</title>
</head>
<body class="security-app">

<form action="/image/upload" method="post" enctype="multipart/form-data">
    <div class="lc-block">
        <div>
            <input type="file" name="fileUpload" size="50"/>
        </div>
        <input type="submit" value="UPLOAD IMAGE">
    </div>
</form>
<form action="/user/add" method="post">
    <div class="lc-block">
        <div>
            <input type="text" class="style-4" name="username"
                   placeholder="User Name"/>
        </div>
        <div>
            <input type="text" class="style-4" name="email"
                   placeholder="User Email"/>
        </div>
        <div>
            <input type="password" class="style-4" name="password"
                   placeholder="Password"/>
        </div>
        <input type="submit" value="SUBMIT">
    </div>
</form>

</body>
</html>