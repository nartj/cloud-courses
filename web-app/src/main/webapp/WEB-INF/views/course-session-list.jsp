<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>jCourses</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <%@ page isELIgnored="false"%>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
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
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/course-session/list">Sessions</a>
            </li>
            <li class="nav-item">
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
        <br>
        <h3 class="text-center">Sessions list</h3>
        <hr />

        <input type="button" value="Add Course"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" /> <br />
        <br />
        <div class="panel panel-info">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Course</th>
                        <th>Location</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Fill Rate</th>
                        <th>Actions</th>
                    </tr>

                    <!-- loop over and print our clients -->
                    <c:forEach var="courseSession" items="${courseSessions}">

                        <c:url var="inscriptionLink" value="/client/showForm">
                            <c:param name="id" value="${courseSession.id}" />
                            <c:param name="max" value="${courseSession.max}" />
                            <c:param name="courseId" value="${courseSession.course.id}" />
                            <c:param name="courseCode" value="${courseSession.course.code}" />
                            <c:param name="courseTitle" value="${courseSession.course.title}" />
                            <c:param name="startDate" value="${courseSession.startDate}" />
                            <c:param name="endDate" value="${courseSession.endDate}" />
                            <c:param name="locationId" value="${courseSession.location.id}" />
                            <c:param name="locationCity" value="${courseSession.location.city}" />
                        </c:url>

                        <tr>
                            <td>${courseSession.course.title}</td>
                            <td>${courseSession.location.city}</td>
                            <td>${courseSession.startDate}</td>
                            <td>${courseSession.endDate}</td>
                            <td>
                            <div class="progress">
                                <div class="progress-bar bg-success" role="progressbar"
                                     style="width:<fmt:formatNumber
                                             type="number" maxFractionDigits="0"
                                             value="${(courseSession.nbClients / courseSession.max)*100}"
                                     />%" aria-valuemin="0" aria-valuenow="${courseSession.nbClients}" aria-valuemax="${courseSession.max}"></div>
                            </div>
                            </td>
                            <td>
                            <a href="${inscriptionLink}">Sign in</a>
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

