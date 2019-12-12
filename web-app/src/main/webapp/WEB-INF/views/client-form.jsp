<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course/list">Courses</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/course-session/list">Sessions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/location/list">Locations</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/client/list">Clients</a>
            </li>
        </ul>
    </div>
</nav>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <br>
        <h3 class="text-center">Sign in</h3>
        <hr />
        <h5>Your course session information</h5>
        <hr />

        <form:form class="form-horizontal" action="save/course-session/${client.courseSession.id}"
                   modelAttribute="client">
        <div class="panel panel-info">
            <div class="panel-body">
                <div class="form-group">
                    <label for="courseSession.startDate" class="col-md-3 control-label">Start Date</label>
                    <div class="col-md-9">
                        <form:input path="courseSession.startDate" type="text" id="datepicker-start" class="form-control"
                                    placefolder="${client.courseSession.startDate}" disabled="true" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="courseSession.endDate" class="col-md-3 control-label">End Date</label>
                    <div class="col-md-9">
                        <form:input path="courseSession.endDate" type="text" id="datepicker-end" class="form-control"
                                    placefolder="${client.courseSession.endDate}" disabled="true" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="courseSession.course.title" class="col-md-3 control-label">Course</label>
                    <div class="col-md-9">
                        <form:input path="courseSession.course.title" class="form-control"
                                    placefolder="${client.courseSession.course.title}" disabled="true" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="courseSession.location.city" class="col-md-3 control-label">Location</label>
                    <div class="col-md-9">
                        <form:input path="courseSession.location.city" class="form-control"
                                    placefolder="${client.courseSession.location.city}" disabled="true" />
                    </div>
                </div>
            </div>
        </div>
        <br>
        <h5>Your client information</h5>
        <hr />
        <div class="panel panel-info">
            <div class="panel-body">
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label for="firstName" class="col-md-3 control-label">First
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="firstName" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-md-3 control-label">Last
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="lastName" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <form:input path="email" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="address" class="col-md-3 control-label">Address</label>
                        <div class="col-md-9">
                            <form:input path="address" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button class="btn btn-primary">Submit</form:button>
                        </div>
                    </div>

                </form:form>
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
    <div class="footer-copyright text-center py-3  bg-secondary footer-container text-white">� 2019 Copyright
        Jeremy Tran, Nicolas Iung @ UTBM.fr
    </div>
</footer>
</body>

</html>