package com.utbm.lo54.adminwebapp.controller.helper;

import com.utbm.lo54.adminwebapp.domain.CourseSessionModel;
import com.utbm.lo54.adminwebapp.service.CourseService;
import com.utbm.lo54.adminwebapp.service.LocationService;
import com.utbm.lo54.core.domain.Course;
import com.utbm.lo54.core.domain.CourseSession;
import com.utbm.lo54.core.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelHelper {

    @Autowired
    private LocationService locationService;
    @Autowired
    private CourseService courseService;

    private List<Course> courses;
    private List<Location> locations;

    public CourseSessionModel getCourseSessionModel(CourseSession courseSession) {
        getLists();
        return new CourseSessionModel(courseSession, courses, locations);
    }

    private void getLists() {
        courses = courseService.getCourses();
        locations = locationService.getLocations();
    }
}
