package com.utbm.lo54.webapp.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CourseFilter implements Serializable {
    private String title;
    private String search;
    private Date date;
    private LocationDto location;

    public CourseFilter(String title, String search, Date date, LocationDto location) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.search = search;
    }

    public CourseFilter() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public String getSearch() {
        return search;
    }

    public CourseFilter setSearch(String search) {
        this.search = search;
        return this;
    }

    @Override
    public String toString() {
        return "CourseFilter{" +
                "title='" + title + '\'' +
                ", search='" + search + '\'' +
                ", date=" + date +
                ", location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseFilter that = (CourseFilter) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(search, that.search) &&
                Objects.equals(date, that.date) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, search, date, location);
    }

}
