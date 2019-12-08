package com.utbm.lo54.common.domain.courses;

import com.utbm.lo54.common.domain.GenericWrapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client extends GenericWrapper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "user_id")
    private Long userId;

    public Client() { }

    public Client(Long id, String lastName, String firstName, String email, String address, Long userId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.email = email;
        this.userId = userId;
    }

    public Client(String lastName, String firstName, String email, String address, Long userId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
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

    public String getLastName() {
        return lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
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
                ", lastname='" + lastName + '\'' +
                ", firstname='" + firstName + '\'' +
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
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(address, client.address) &&
                Objects.equals(email, client.email) &&
                Objects.equals(userId, client.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, email, userId);
    }
}
