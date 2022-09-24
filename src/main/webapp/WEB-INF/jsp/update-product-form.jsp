<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/20/2022
  Time: 9:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE CATEGORY</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <%--    SCRIPTS     --%>
    <script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>UPDATE CATEGORY</h1>

    <c:if test="${product != null}">
    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/products/update-form" method="post">

                <input type="hidden" name="id" value="${product.id}">
                <div class="mb-3">
                    <label for="name" class="form-label">NAME</label>
                    <input name="name" type="text" class="form-control" id="name" value="${product.name}">
                </div>
                <div class="mb-3">
                    <label for="cost" class="form-label">COST</label>
                    <input name="cost" type="number" class="form-control" id="cost" value="${product.cost}">
                </div>
                <div class="mb-3">
                    <label for="description">DESCRIPTION</label>
                    <textarea class="form-control" id="description" name="description" rows="5" cols="25" >${product.description}</textarea>
                </div>
                <div class="form-group">
                    <label for="POSITION">POSITION</label>
                    <select id="POSITION"
                            class="selectpicker form-control"
                            aria-label="Please select categories"
                            name="category_id">
                        <c:forEach items="${category}" var="val">
                            <c:choose>
                                <c:when test="${product.category_id==val.id}">
                                    <option selected value="${val.id}">${val.category_name}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${val.id}">${val.category_name}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">UPDATE</button>
            </form>
        </div>
    </div>
</div>
</c:if>

</body>
</html>
