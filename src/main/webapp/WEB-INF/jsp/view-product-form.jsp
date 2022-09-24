<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/15/2022
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIEW PRODUCT</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>


<div class="container text-center">

    <h1>PRODUCTS LIST</h1>

    <a class="btn btn-outline-primary my-4" href="/products/add-form">ADD NEW PRODUCT</a>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">COST</th>
                    <th scope="col">CATEGORY</th>
                    <th scope="col">ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>
                                ${product.id}
                        </td>

                        <td>
                                ${product.name}
                        </td>
                        <td>
                                ${product.cost}
                        </td>
                        <td>
                                ${product.category.category_name}
                        </td>
                        <td>
                            <a class="btn btn-warning" href="/products/edit/${product.id}">EDIT</a>
                            <a class="btn btn-danger" href="/products/delete/${product.id}">DELETE</a>
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
            <li class="page-item"><a class="btn btn-outline-primary" href="/products/${page - 1}">Previous</a></li>

            <%--             Math.ceil(   totalElementsCount / size  )    --%>
            <c:forEach varStatus="loop" begin="1" end="${Math.ceil(count/size)}">
                <li class="page-item">
                    <a
                            class="btn btn-outline-success"
                            href="/products/${loop.index}">
                            ${loop.index}
                    </a>
                </li>
            </c:forEach>

            <li class="page-item"><a class="btn btn-outline-primary" href="/products/${page + 1}">Next</a></li>
        </ul>
    </nav>

</div>



</body>
</html>
