package com.utbm.lo54.common.domain.courses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utbm.lo54.common.domain.GenericWrapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course  extends GenericWrapper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @JsonIgnore
    @OneToMany
    private List<CourseSession> courseSessions;

    public Course() { }

    public Course(Long id, String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Course(String code, String title) {
        this.id = id;
        this.code = code;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Course setCode(String code) {
        this.code = code;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Course setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "Course{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code) &&
                Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, title);
    }
}
