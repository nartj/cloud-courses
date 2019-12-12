package com.utbm.lo54.webapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CourseSessionDto implements Serializable {

    private Long id;
    private Date startDate;
    private Date endDate;
    private Integer max;
    private CourseDto course;
    private LocationDto location;


    public CourseSessionDto() { }

    public CourseSessionDto(Long id, Date startDate, Date endDate, Integer max, CourseDto course, LocationDto location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public CourseSessionDto(Date startDate, Date endDate, Integer max, CourseDto course, LocationDto location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public CourseSessionDto(CourseSessionDto courseSessionDto) {
        this
                .setId(courseSessionDto.getId())
                .setMax(courseSessionDto.getMax())
                .setLocation(courseSessionDto.getLocation())
                .setCourse(courseSessionDto.getCourse())
                .setStartDate(courseSessionDto.getStartDate())
                .setEndDate(courseSessionDto.getEndDate());
    }

    public Long getId() {
        return id;
    }

    public CourseSessionDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public CourseSessionDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CourseSessionDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public CourseSessionDto setMax(Integer max) {
        this.max = max;
        return this;
    }

    public CourseDto getCourse() {
        return course;
    }

    public CourseSessionDto setCourse(CourseDto course) {
        this.course = course;
        return this;
    }

    public LocationDto getLocation() {
        return location;
    }

    public CourseSessionDto setLocation(LocationDto location) {
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
        CourseSessionDto that = (CourseSessionDto) o;
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
