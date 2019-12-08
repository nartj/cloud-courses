package com.utbm.lo54.zuul.domain;

import com.utbm.lo54.common.domain.GenericWrapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tokens")
public class JwtToken extends GenericWrapper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public JwtToken setId(Long id) {
        this.id = id;
        return this;
    }

    public String getToken() {
        return token;
    }

    public JwtToken setToken(String token) {
        this.token = token;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JwtToken jwtToken = (JwtToken) o;
        return Objects.equals(token, jwtToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }

    @Override
    public String toString() {
        return "JwtToken{" +
                "token='" + token + '\'' +
                '}';
    }
}
