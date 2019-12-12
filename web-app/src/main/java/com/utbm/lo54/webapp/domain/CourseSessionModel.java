package com.utbm.lo54.webapp.domain;


import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.dto.LocationDto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CourseSessionModel implements Serializable {
    private CourseSessionForm courseSessionForm;
    private CourseSessionDto courseSessionDto;
    private List<CourseDto> courses;
    private List<LocationDto> locations;

    public CourseSessionModel() {
        courseSessionForm = new CourseSessionForm();
        courseSessionDto = new CourseSessionDto();
        courses = new ArrayList<>();
        locations = new ArrayList<>();
    }

    public CourseSessionModel(CourseSessionForm courseSessionForm, List<CourseDto> courses, List<LocationDto> locations) {
        this.courseSessionForm = courseSessionForm;
        this.courses = courses;
        this.locations = locations;
    }

    public CourseSessionModel(CourseSessionDto courseSessionDto, List<CourseDto> courses, List<LocationDto> locations) {
        this.courseSessionDto = courseSessionDto;
        this.courses = courses;
        this.locations = locations;
    }

    public CourseSessionForm getCourseSessionForm() {
        return courseSessionForm;
    }

    public CourseSessionModel setCourseSessionForm(CourseSessionForm courseSessionForm) {
        this.courseSessionForm = courseSessionForm;
        return this;
    }

    public CourseSessionDto getCourseSessionDto() {
        return courseSessionDto;
    }

    public CourseSessionModel setCourseSessionDto(CourseSessionDto courseSessionDto) {
        this.courseSessionDto = courseSessionDto;
        return this;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public CourseSessionModel setCourses(List<CourseDto> courses) {
        this.courses = courses;
        return this;
    }

    public List<LocationDto> getLocations() {
        return locations;
    }

    public CourseSessionModel setLocations(List<LocationDto> locations) {
        this.locations = locations;
        return this;
    }

    @Override
    public String toString() {
        return "CourseSessionModel{" +
                "courseSessionForm=" + courseSessionForm +
                ", courseSessionDto=" + courseSessionDto +
                ", courses=" + courses +
                ", locations=" + locations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSessionModel that = (CourseSessionModel) o;
        return Objects.equals(courseSessionForm, that.courseSessionForm) &&
                Objects.equals(courseSessionDto, that.courseSessionDto) &&
                Objects.equals(courses, that.courses) &&
                Objects.equals(locations, that.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseSessionForm, courseSessionDto, courses, locations);
    }
}
