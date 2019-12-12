package com.utbm.lo54.webapp.controller.helper;

import com.utbm.lo54.webapp.domain.CourseSessionForm;
import com.utbm.lo54.webapp.domain.CourseSessionModel;
import com.utbm.lo54.webapp.dto.*;
import com.utbm.lo54.webapp.service.CourseService;
import com.utbm.lo54.webapp.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelHelper {

    private final Logger LOG = LoggerFactory.getLogger(ModelHelper.class);

    private final LocationService locationService;
    private final CourseService courseService;

    private List<CourseDto> courses;
    private List<LocationDto> locations;

    public ModelHelper(LocationService locationService, CourseService courseService) {
        this.locationService = locationService;
        this.courseService = courseService;
    }

    public CourseSessionModel getCourseSessionModel(CourseSessionDto courseSessionDto) {
        queryLists();
        return new CourseSessionModel(courseSessionDto, courses, locations);
    }

    public CourseSessionModel getCourseSessionModel(CourseSessionForm courseSessionForm) {
        queryLists();
        return new CourseSessionModel(courseSessionForm, courses, locations);
    }

    public CourseSessionForm toEmptyForm(CourseSessionDto courseSession) {
        return new CourseSessionForm();
    }

    public CourseSessionForm toForm(CourseSessionDto courseSession) {
        CourseSessionForm courseSessionForm = new CourseSessionForm();
        courseSessionForm
                .setId(courseSession.getId())
//                .setCourse(courseSession.getCourse().getCode())
                .setStartDate(courseSession.getStartDate())
                .setEndDate(courseSession.getEndDate())
                .setLocation(courseSession.getLocation().getCity())
                .setMax(courseSession.getMax());
        return courseSessionForm;
    }

    public CourseSessionDto toDto(CourseSessionForm form) {
        CourseSessionDto dto = new CourseSessionDto();
        CourseSessionModel model = getCourseSessionModel(dto);

        List<CourseDto> courses = model.getCourses()
                .stream().filter(course -> course.getCode().equals(form.getCourse())).collect(Collectors.toList());
        if (courses.size() != 1) {
            LOG.warn("0 or Multiple courses have been found for CourseSessionForm {}", form);
            courses = null;
        }

        List<LocationDto> locations = model.getLocations()
                .stream().filter(course -> course.getCity().equals(form.getLocation())).collect(Collectors.toList());
        if (locations.size() != 1) {
            LOG.warn("0 or Multiple locations have been found for CourseSessionForm {}", this);
            locations = null;
        }

        dto
                .setId(form.getId())
                .setStartDate(form.getStartDate())
                .setEndDate(form.getEndDate())
                .setMax(form.getMax())
                .setCourse(courses != null ? courses.get(0) : null)
                .setLocation(locations != null ? locations.get(0) : null);

        LOG.info("Converted {} to DTO {}", form, dto);
        return dto;
    }

    private void queryLists() {
        courses = courseService.getCourses();
        locations = locationService.getLocations();
    }
}
