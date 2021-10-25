<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="main.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-link" href="home">Home</a>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Publisher
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="createPublisher">Add Publisher</a></li>
                        <li><a class="dropdown-item" href="updatePublisherList">Update Publisher</a></li>
                        <li><a class="dropdown-item" href="deletePublisherList">Delete Publisher</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Writer
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="createWriter">Add Writer</a></li>
                        <li><a class="dropdown-item" href="updateWriter">Update Writer</a></li>
                        <li><a class="dropdown-item" href="deleteWriter">Delete Writer</a></li>
                    </ul>
                </li>
                <a class="nav-link" href="deleteReviewListAdmin">Manage Reviews</a>
                <a class="nav-link" href="updateBookList">Manage Books</a>
                <a class="nav-link" href="updateUserList">Manage Users</a>
                <a class="nav-link" href="showBooksGuest">Logout</a>
            </div>
        </div>
    </div>
</nav>

<div class="container mt-2 col-lg-5">
    <div class="card-body card mt-5">
        <h2 class="mb-5">Update user<</h2>
        <form:form action="updateUser" modelAttribute="user">
            <form:hidden path="userId" value="${user.userId}"/>
            <label class="form-label">User name:</label>
            <form:input class="form-control mb-3" path="userName"/>
            <label class="form-label">Password:</label>
            <form:input class="form-control mb-3" path="password"/>
            <label class="form-label">Role:</label>
            <select class="form-control mb-3" name="role">
                <c:forEach items="${roles}" var="rol">
                    <option value="${rol}" ${rol == rol ? 'selected' : ''}><c:out value="${rol}"/></option>
                </c:forEach>
            </select>

            <br>
            <input class="btn btn-primary" type="submit" value="Update user">

        </form:form>
        <br>
        <div>${message}</div>

    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</body>
</html>