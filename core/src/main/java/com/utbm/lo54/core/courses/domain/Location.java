package com.utbm.lo54.core.courses.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

@Entity
@Table(name = "locations")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    @Cascade(SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<CourseSession> courseSessions;

    public Location() { }

    public Location(String city) {
        this.city = city;
    }
    public Location(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public Location setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public List<CourseSession> getCourseSessions() {
        return courseSessions;
    }

    public Location setCourseSessions(List<CourseSession> courseSessions) {
        this.courseSessions = courseSessions;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
