package com.utbm.lo54.webapp.controller.helper;

import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.dto.LocationDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FilledCourseSessionModel implements Serializable {
    private Integer nbClients;
    private CourseSessionDto courseSession;

    public FilledCourseSessionModel(Integer nbClients) {
        this.nbClients = nbClients;
    }

    public FilledCourseSessionModel(CourseSessionDto courseSessionDto, Integer nbClients) {
        courseSession = new CourseSessionDto(courseSessionDto);
        this.nbClients = nbClients;
    }

    public CourseSessionDto getCourseSession() {
        return courseSession;
    }

    public FilledCourseSessionModel setCourseSession(CourseSessionDto courseSession) {
        this.courseSession = courseSession;
        return this;
    }

    public Integer getNbClients() {
        return nbClients;
    }

    public FilledCourseSessionModel setNbClients(Integer nbClients) {
        this.nbClients = nbClients;
        return this;
    }

    @Override
    public String toString() {
        return "FilledCourseSessionModel{" +
                "nbClients=" + nbClients +
                ", courseSession=" + courseSession +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FilledCourseSessionModel that = (FilledCourseSessionModel) o;
        return Objects.equals(nbClients, that.nbClients) &&
                Objects.equals(courseSession, that.courseSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nbClients, courseSession);
    }

    public Long getId() {
        return courseSession.getId();
    }

    public Integer getMax() {
        return courseSession.getMax();
    }

    public Date getStartDate() {
        return courseSession.getStartDate();
    }

    public Date getEndDate() {
        return courseSession.getEndDate();
    }

    public LocationDto getLocation() {
        return courseSession.getLocation();
    }

    public CourseDto getCourse() {
        return courseSession.getCourse();
    }

}
