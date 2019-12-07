package com.utbm.lo54.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "user_id")
    private Long userId;

    public Client() { }

    public Client(Long id, String lastname, String firstname, String email, String address, Long userId) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.userId = userId;
    }

    public Client(String lastname, String firstname, String email, String address, Long userId) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.email = email;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public Client setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Client setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public Client setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Client setAddress(String address) {
        this.address = address;
        return this;
    }


    public Long getUserId() {
        return userId;
    }

    public Client setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(lastname, client.lastname) &&
                Objects.equals(firstname, client.firstname) &&
                Objects.equals(address, client.address) &&
                Objects.equals(email, client.email) &&
                Objects.equals(userId, client.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, address, email, userId);
    }
}
