<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/15/2022
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UPDATE CATEGORY</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

<div class="container text-center">

    <h1>UPDATE CATEGORY</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/category/update-category" method="post">
                <input type="hidden" name="id" value="${category.id}">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">NAME</label>
                    <input name="category_name" type="text" class="form-control" id="bookTitle" value="${category.category_name}">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword">DESCRIPTION</label>
                    <textarea class="form-control" id="exampleInputPassword" rows="10" cols="45"  name="description">${category.description}</textarea>
                </div>

                <button type="submit" class="btn btn-primary">UPDATE</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
