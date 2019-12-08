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
<body>
<div class="container">
    <div class="col-md-offset-1 col-md-10">
        <h3 class="text-center">Course list</h3>
        <hr />

        <input type="button" value="Add Course"
               onclick="window.location.href='showForm'; return false;"
               class="btn btn-primary" /> <br />
        <br />
        <div class="panel panel-info">
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Max</th>
                        <th>Course</th>
                        <th>Location</th>
                        <th>Actions</th>
                    </tr>

                    <!-- loop over and print our clients -->
                    <c:forEach var="tempCourseSession" items="${courseSessions}">

                        <!-- construct an "update" link with client id -->
                        <c:url var="updateLink" value="/course-session/update">
                            <c:param name="id" value="${tempCourseSession.id}" />
                        </c:url>

                        <!-- construct an "delete" link with client id -->
                        <c:url var="deleteLink" value="/course-session/delete">
                            <c:param name="id" value="${tempCourseSession.id}" />
                        </c:url>

                        <tr>
                            <td>${tempCourseSession.startDate}</td>
                            <td>${tempCourseSession.endDate}</td>
                            <td>${tempCourseSession.max}</td>
                            <td>${tempCourseSession.course.title}</td>
                            <td>${tempCourseSession.location.city}</td>
                            <td>
                            <!-- display the update link --> <a href="${updateLink}">Update</a>
                            | <a href="${deleteLink}"
                                 onclick="if (!(confirm('Are you sure you want to delete this course session?'))) return false">Delete</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
<div class="footer">
    <p>Footer</p>
</div>
</body>

