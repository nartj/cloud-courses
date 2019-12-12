<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:id="http://illegalargumentexception.googlecode.com/clientId">
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>jCourses</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
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
            let end_id = "#datepicker-end";
            $(start_id).datepicker({
                language: "fr",
                format: "yyyy/mm/dd"
            });
            // Trick to format potential existing date on load of document
            $(start_id).datepicker('show');
            $(start_id).datepicker('hide');

            $(end_id).datepicker({
                language: "fr",
                format: "yyyy/mm/dd"
            });
            $(end_id).datepicker('show');
            $(end_id).datepicker('hide');
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
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">Create a Session</h3>
        <div class="panel panel-info">
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal"
                           method="post" modelAttribute="courseSessionModel">

                    <!-- need to associate this data with courseDto session id -->
                    <form:hidden path="courseSessionDto.id" />

                    <div class="form-group">
                        <label for="courseSessionDto.startDate" class="col-md-3 control-label">Start Date</label>
                        <div class="col-md-9">
                            <form:input path="courseSessionDto.startDate" type="text" id="datepicker-start" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseSessionDto.endDate" class="col-md-3 control-label">End Date</label>
                        <div class="col-md-9">
                            <form:input path="courseSessionDto.endDate" type="text" id="datepicker-end" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseSessionDto.max" class="col-md-3 control-label">Max participants</label>
                        <div class="col-md-9">
                            <form:input path="courseSessionDto.max" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseSessionDto.course" class="col-md-3 control-label">Course</label>
                        <div class="col-md-9">
                        <c:if test="${fn:length(courseSessionModel.courses) gt 0}">
                            <form:select class="form-control" path="courseSessionDto.course" items="${courseSessionModel.courses}" itemLabel="title" itemValue="code"/>
                        </c:if>
                        <c:if test="${fn:length(courseSessionModel.courses) lt 0}">
                            <p>No Courses available</p>
                        </c:if>
                        </div>
                    </div>
                    <%!  private boolean hideCourseForm = true; %>
                    <h:commandButton value="toggle"
                                     onclick="toggle('#{component.locationPanel.clientId}'); return false;" class="btn btn-outline-success" >Create Course</h:commandButton>
                        <div class="panel-body" hidden="<%=hideCourseForm %>">
                            <form:form action="course/save" cssClass="form-horizontal"
                                       method="post" modelAttribute="courseSessionModel">

                                <!-- need to associate this data with courseDto id -->
                                <form:hidden path="courseSessionDto.course.id" />

                                <div class="form-group">
                                    <label for="courseSessionDto.course.code" class="col-md-3 control-label">Code</label>
                                    <div class="col-md-9">
                                        <form:input path="courseSessionDto.course.code" class="form-control" />
                                    </div>
                                </div>
                                <div class="form-group" style="display: flex">
                                    <label for="courseSessionDto.course.title" class="col-md-3 control-label">Title</label>
                                    <div class="col-md-9" style="display: flex">
                                        <form:input path="courseSessionDto.course.title" class="form-control" />
                                        <form:button class="btn btn-primary">Submit</form:button>
                                    </div>
                                </div>
                                <hr />
                            </form:form>
                        </div>

                    <div class="form-group">
                        <label for="courseSessionDto.location" class="col-md-3 control-label">Location</label>
                        <div class="col-md-9">
                            <c:if test="${fn:length(courseSessionModel.locations) gt 0}">
                                <form:select class="form-control" path="courseSessionDto.location" items="${courseSessionModel.locations}" itemLabel="city" itemValue="city"/>
                            </c:if>
                            <c:if test="${fn:length(courseSessionModel.locations) lt 0}">
                                <p>No Locations available</p>
                            </c:if>
                        </div>
                    </div>

                    <%!  private boolean hideLocationForm = true; %>
                    <h:commandButton value="toggle"
                                     onclick="toggle('#{component.locationPanel.clientId}'); return false;" class="btn btn-outline-success" >Create Location</h:commandButton>
                    <%--@elvariable id="displayLocationForm" type="boolean" value="false"--%>
                        <h:div class="panel-body" hidden="<%=hideLocationForm%>" id="locationPanel">
                            <form:form action="/location/save" class="form-horizontal"
                                       method="post" modelAttribute="courseSessionModel">

                                <!-- need to associate this data with courseDto id -->
                                <form:hidden path="courseSessionDto.location.id" />

                                <div class="form-group">
                                    <label for="courseSessionDto.location.city" class="col-md-3 control-label">City</label>
                                    <div class="col-md-9" style="display: flex">
                                        <form:input path="courseSessionDto.location.city" class="form-control" />
                                        <form:button class="btn btn-primary  my-2 my-sm-0">Submit</form:button>
                                    </div>
                                </div>
                                </form:form>
                        </h:div>
                <script type="text/javascript">
                    function toggle(id) {
                        var element = document.getElementById(id);
                        if(element.style.display == 'block') {
                            element.style.display = 'none';
                        } else {
                            element.style.display = 'block'
                        }
                    }
                </script>

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
    <div class="footer-copyright text-center py-3  bg-secondary footer-container text-white">© 2019 Copyright
        Jeremy Tran, Nicolas Iung @ UTBM.fr
    </div>
</footer>
</body>


</html>

