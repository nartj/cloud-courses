package com.utbm.lo54.webapp.dto;

import java.io.Serializable;
import java.util.Objects;

public class CourseDto implements Serializable {

    private Long id;
    private String code;
    private String title;

    public CourseDto() { }


    public CourseDto(Long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public CourseDto(String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public CourseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CourseDto setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CourseDto setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseDto courseDto = (CourseDto) o;
        return Objects.equals(id, courseDto.id) &&
                Objects.equals(code, courseDto.code) &&
                Objects.equals(title, courseDto.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, title);
    }
}
