<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
    <script>
        $(document).ready(function() {
            let start_id = "#datepicker-start";
            $(start_id).datepicker({
                language: "fr",
                format: "yyyy/mm/dd"
            });
            // Trick to format potential existing date on load of document
            $(start_id).datepicker('show');
            $(start_id).datepicker('hide');
        });
    </script>
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
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course-session/list">Sessions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/location/list">Locations</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/client/list">Clients</a>
            </li>
        </ul>
        <div class="form-inline my-2 my-lg-0">
            <form:form action="search" cssClass="form-horizontal"
                       method="post" modelAttribute="coursesModel">
                <form:input path="filter.search" class="form-control mr-sm-2" placeholder="Search"/>
                <form:button class="btn btn-outline-success my-2 my-sm-0">Search</form:button>
            </form:form>
        </div>
    </div>
</nav>
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <br>
        <h3 class="text-center">Course list</h3>
        <br>
        <h5 class="text-left">Filters</h5>
        <hr />
        <div class="panel panel-info">
            <div class="panel-body">
                <div class="panel-body" style="display:flex">

                    <form:form action="search/title" cssClass="form-horizontal"
                               method="post" modelAttribute="coursesModel">
                        <div class="form-group">
                            <label for="filter.title" class="control-label">Title filter</label>
                            <div class="col-md-9">
                                <form:input path="filter.title" class="form-control" />
                            </div>
                        </div>
                        <form:button class="btn btn-outline-success my-2 my-sm-0">Filter</form:button>

                    </form:form>

                    <form:form action="search/date" cssClass="form-horizontal"
                               method="post" modelAttribute="coursesModel">
                        <div class="form-group">
                            <label for="filter.date" class="control-label">Date filter</label>
                            <div class="col-md-9">
                                <form:input path="filter.date" type="text" id="datepicker-start" class="form-control"/>
                            </div>
                        </div>
                        <form:button class="btn btn-outline-success my-2 my-sm-0">Filter</form:button>
                    </form:form>

                    <form:form action="search/location" cssClass="form-horizontal"
                               method="post" modelAttribute="coursesModel">
                        <div class="form-group">
                            <label for="filter.location.id" class="control-label">Location filter</label>
                            <div class="col-md-12">
                                <form:select path="filter.location.id" class="form-control" items="${coursesModel.locations}" itemLabel="city" itemValue="id"/>
                            </div>
                        </div>
                        <form:button class="btn btn-outline-success my-2 my-sm-0">Filter</form:button>
                    </form:form>

                </div>
            </div>
        </div>
        <br>
        <br>
        <h5 class="text-left">Courses</h5>
        <hr />
        <div class="panel panel-info">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Code</th>
                        <th>Title</th>
                        <th>Actions</th>
                    </tr>

                    <!-- loop over and print our clients -->
                    <c:forEach var="tempCourse" items="${coursesModel.courses}">

                        <c:url var="viewLink" value="/course-session/course/${tempCourse.id}"/>


                        <c:url var="updateLink" value="/course/update">
                            <c:param name="id" value="${tempCourse.id}" />
                        </c:url>

                        <c:url var="deleteLink" value="/course/delete">
                            <c:param name="id" value="${tempCourse.id}" />
                        </c:url>

                        <tr>
                            <td>${tempCourse.code}</td>
                            <td>${tempCourse.title}</td>
                            <td>
                                <a href="${viewLink}">View</a>
                                 | <a href="${updateLink}">Update</a>
                                 | <a href="${deleteLink}"
                                 onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>
                <input type="button" value="Add Course"
                       onclick="window.location.href='showForm'; return false;"
                       class="btn btn-primary" />
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