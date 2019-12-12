package com.utbm.lo54.webapp.domain;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CourseSessionForm implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionForm.class);
    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer max;
    private String course;
    private String location;

    public CourseSessionForm() { }

    public CourseSessionForm(Long id, Date startDate, Date endDate, Integer max, String course, String location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public CourseSessionForm(Date startDate, Date endDate, Integer max, String course, String location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public CourseSessionForm setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public CourseSessionForm setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CourseSessionForm setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public CourseSessionForm setMax(Integer max) {
        this.max = max;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public CourseSessionForm setCourse(String course) {
        this.course = course;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public CourseSessionForm setLocation(String location) {
        this.location = location;
        return this;
    }


    @Override
    public String toString() {
        return "CourseSessionDto{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", max=" + max +
                ", course=" + course +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseSessionForm that = (CourseSessionForm) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(max, that.max) &&
                Objects.equals(course, that.course) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, max, course, location);
    }


}

