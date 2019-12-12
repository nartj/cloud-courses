package com.utbm.lo54.webapp.controller.helper;

import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseFilter;
import com.utbm.lo54.webapp.dto.LocationDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CoursesModel implements Serializable {
    private List<CourseDto> courses;
    private CourseFilter filter;
    private List<LocationDto> locations;

    public CoursesModel() {
    }

    public CoursesModel(List<CourseDto> courses, CourseFilter filter, List<LocationDto> locations) {
        this.courses = courses;
        this.filter = filter;
        this.locations = locations;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

    public CourseFilter getFilter() {
        return filter;
    }

    public void setFilter(CourseFilter filter) {
        this.filter = filter;
    }

    public List<LocationDto> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDto> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "CoursesModel{" +
                "courses=" + courses +
                ", filter=" + filter +
                ", locationsDtos=" + locations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoursesModel that = (CoursesModel) o;
        return Objects.equals(courses, that.courses) &&
                Objects.equals(filter, that.filter) &&
                Objects.equals(locations, that.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courses, filter, locations);
    }
}
