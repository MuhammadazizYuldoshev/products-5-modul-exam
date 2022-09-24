<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/15/2022
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <title>VIEW CATEGORY</title>
</head>
<body>


<div class="container text-center">

    <h1>CATEGORIES LIST</h1>

    <a class="btn btn-outline-primary my-4" href="/category/add-category-form">ADD NEW CATEGORY</a>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categories}" var="category" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>
                                ${category.id}
                        </td>

                        <td>
                                ${category.category_name}
                        </td>
                        <td>
                            <a class="btn btn-warning" href="/category/edit/${category.id}">EDIT</a>
                            <a class="btn btn-danger" href="/category/delete/${category.id}">DELETE</a>
                        </td>




                    </tr>

                </c:forEach>

                </tbody>
            </table>

        </div>
    </div>

    <hr>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="btn btn-outline-primary" href="/category/${currentPage - 1}">Previous</a></li>

            <%--             Math.ceil(   totalElementsCount / size  )    --%>
            <c:forEach varStatus="loop" begin="1" end="${Math.ceil(totalElementsCount/size)}">
                <li class="page-item">
                    <a
                            class="btn btn-outline-success"
                            href="/category/${loop.index}">
                            ${loop.index}
                    </a>
                </li>
            </c:forEach>

            <li class="page-item"><a class="btn btn-outline-primary" href="/category/${currentPage + 1}">Next</a></li>
        </ul>
    </nav>

</div>




</body>
</html>
