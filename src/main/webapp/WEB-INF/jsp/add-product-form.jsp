<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/20/2022
  Time: 8:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PRODUCT</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <%--    SCRIPTS     --%>
    <script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
</head>

<div class="container text-center">

    <h1>ADD NEW PRODUCT</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/products" method="post">

                <div class="mb-3">
                    <label for="name" class="form-label">NAME</label>
                    <input name="name" type="text" class="form-control" id="name">
                </div>
                <div class="mb-3">
                    <label for="cost" class="form-label">COST</label>
                    <input name="cost" type="number" class="form-control" id="cost">
                </div>
                <div class="mb-3">
                    <label for="description">DESCRIPTION</label>
                    <textarea class="form-control" id="description" name="description" rows="5" cols="25"></textarea>
                </div>
                <div class="form-group">
                    <label for="categoryId">Category:</label>
                    <select id="categoryId"
                            class="selectpicker form-control"
                            aria-label="Please select categories"
                            data-live-search="true"
                            name="category_id">
                        <c:forEach items="${categoryList}" var="val">
                            <option value="${val.id}">${val.category_name}</option>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">SAVE</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
