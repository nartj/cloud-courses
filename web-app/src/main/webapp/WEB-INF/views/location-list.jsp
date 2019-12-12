<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>jCourses</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <%@ page isELIgnored="false"%>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Cloud Courses</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course-session/list">Sessions</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/location/list">Locations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/client/list">Clients</a>
            </li>
        </ul>
    </div>
</nav>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">Location list</h3>
        <hr />

        <input type="button" value="Add Location"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" /> <br />
        <br />
        <div class="panel panel-info">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>City</th>
                        <th>Actions</th>
                    </tr>

                    <!-- loop over and print our locations -->
                    <c:forEach var="tempLocation" items="${locations}">

                        <!-- construct an "update" link with locationDto id -->
                        <c:url var="updateLink" value="/location/update">
                            <c:param name="id" value="${tempLocation.id}" />
                        </c:url>

                        <!-- construct an "delete" link with locationDto id -->
                        <c:url var="deleteLink" value="/location/delete">
                            <c:param name="id" value="${tempLocation.id}" />
                        </c:url>

                        <tr>
                            <td>${tempLocation.city}</td>
                            <td>
                            <!-- display the update link --> <a href="${updateLink}">Update</a>
                            | <a href="${deleteLink}"
                                 onclick="if (!(confirm('Are you sure you want to delete this locationDto?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
<style>
    body {
        padding-top: 4%;
        padding-bottom: 15%;
    }
    footer {
        position: fixed;
        bottom: 0;
        width: 100%;
        height: 25%;
    }

    .navbar {
        position: fixed;
        top: 0;
        width: 100%;
    }

    .footer-container {
        padding: 2%;
    }

</style>
<footer class="page-footer font-small blue-grey pt-4" >
    <div class="container-fluid text-center text-md-left bg-light footer-container">
        <div class="row">
            <div class="col-md-6 mt-md-0 mt-3">
                <h5 class="text-uppercase">Project LO54</h5>
                <p>Spring Cloud, Hibernate, JSP demonstration.</p>
            </div>
            <hr class="clearfix w-100 d-md-none pb-3">
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-3 mb-md-0 mb-3">

                <h5 class="text-uppercase">Cloud Courses</h5>
                <ul class="list-unstyled">
                    <li>
                        <a href="${pageContext.request.contextPath}/course/list">Courses</a>
                    </li>
                </ul>
            </div>
            <div class="col-md-3 mb-md-0 mb-3">
                <ul class="list-unstyled">
                    <li>
                        <a href="${pageContext.request.contextPath}/course-session/list">Sessions</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/location/list">Location</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/client/list">Client</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright text-center py-3  bg-secondary footer-container text-white">© 2019 Copyright
        Jeremy Tran, Nicolas Iung @ UTBM.fr
    </div>
</footer>
</body>

</html>