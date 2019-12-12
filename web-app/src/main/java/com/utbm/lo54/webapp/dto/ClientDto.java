package com.utbm.lo54.webapp.dto;


import java.io.Serializable;
import java.util.Objects;

public class ClientDto implements Serializable {

    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private CourseSessionDto courseSession;

    public ClientDto() { }

    public ClientDto(Long id, String lastName, String firstName, String email, String address, CourseSessionDto courseSessionDto) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.courseSession = courseSessionDto;
    }

    public ClientDto(String lastName, String firstName, String email, String address, CourseSessionDto courseSessionDto) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
    }

    public ClientDto(String lastName, String firstName, String email, String address) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public ClientDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ClientDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ClientDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public CourseSessionDto getCourseSession() {
        return courseSession;
    }

    public ClientDto setCourseSession(CourseSessionDto courseSession) {
        this.courseSession = courseSession;
        return this;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", courseSessionDto=" + courseSession +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDto clientDto = (ClientDto) o;
        return Objects.equals(id, clientDto.id) &&
                Objects.equals(lastName, clientDto.lastName) &&
                Objects.equals(firstName, clientDto.firstName) &&
                Objects.equals(email, clientDto.email) &&
                Objects.equals(address, clientDto.address) &&
                Objects.equals(courseSession, clientDto.courseSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, email, address, courseSession);
    }

}
