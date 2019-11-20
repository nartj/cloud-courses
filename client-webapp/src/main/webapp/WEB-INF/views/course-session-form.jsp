<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h3 class="text-center">Create a course session</h3>
        <div class="panel panel-info">
            <div class="panel-body">
                <form:form action="save" cssClass="form-horizontal"
                           method="post" modelAttribute="courseSessionModel">

                    <!-- need to associate this data with course session id -->
                    <form:hidden path="courseSession.id" />

                    <div class="form-group">
                        <label for="courseSession.startDate" class="col-md-3 control-label">Start Date</label>
                        <div class="col-md-9">
                            <form:input path="courseSession.startDate" type="text" id="datepicker-start" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseSession.endDate" class="col-md-3 control-label">End Date</label>
                        <div class="col-md-9">
                            <form:input path="courseSession.endDate" type="text" id="datepicker-end" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="courseSession.max" class="col-md-3 control-label">Max participants</label>
                        <div class="col-md-9">
                            <form:input path="courseSession.max" class="form-control" />
                        </div>
                    </div>

<%--                    <form:select path="course">--%>
<%--                        <form:option value="NONE"> --SELECT--</form:option>--%>
<%--                        <form:options modelAttribute="courses" items="${courses}" itemValue="id" itemLabel="title"></form:options>--%>
<%--                    </form:select>--%>

                    <div class="form-group">
                        <label for="courseSession.course" class="col-md-3 control-label">Course</label>
                        <div class="col-md-9">
                        <c:if test="${fn:length(courseSessionModel.courses) gt 0}">
                            <form:select path="courseSession.course" items="${courseSessionModel.courses}" itemLabel="title" itemValue="id"/>
                        </c:if>
                        <c:if test="${fn:length(courseSessionModel.courses) lt 0}">
                            <p>No Courses available</p>
                        </c:if>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="courseSession.location" class="col-md-3 control-label">Location</label>
                        <div class="col-md-9">
                            <c:if test="${fn:length(courseSessionModel.locations) gt 0}">
                                <form:select path="courseSession.location" items="${courseSessionModel.locations}" itemLabel="city" itemValue="id"/>
                            </c:if>
                            <c:if test="${fn:length(courseSessionModel.locations) lt 0}">
                                <p>No Locations available</p>
                            </c:if>
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

