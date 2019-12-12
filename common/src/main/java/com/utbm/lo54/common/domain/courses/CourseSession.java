package com.utbm.lo54.common.domain.courses;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utbm.lo54.common.domain.GenericWrapper;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course_sessions")
public class CourseSession  extends GenericWrapper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "startDate")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "max")
    private Integer max;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="course_id" , referencedColumnName="id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Course course;

    @ManyToOne()
    @JoinColumn(name="location_id" , referencedColumnName="id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Location location;

    @JsonIgnore
    @Transient
    private List<Client> clients;


    public CourseSession() { }

    public CourseSession(Long id, Date startDate, Date endDate, Integer max, Course course, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public CourseSession(Date startDate, Date endDate, Integer max, Course course, Location location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public CourseSession setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public CourseSession setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public CourseSession setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public CourseSession setMax(Integer max) {
        this.max = max;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public CourseSession setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public CourseSession setLocation(Location location) {
        this.location = location;
        return this;
    }

    public List<Client> getClients() {
        return clients;
    }

    public CourseSession setClients(List<Client> clients) {
        this.clients = clients;
        return this;
    }

    public List<Client> addClient(Client client) {
        this.clients.add(client);
        return this.clients;
    }

    @Override
    public String toString() {
        return "CourseSession{" +
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
        CourseSession that = (CourseSession) o;
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
