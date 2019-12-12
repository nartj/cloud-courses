package com.utbm.lo54.webapp.dto;

import java.io.Serializable;
import java.util.Objects;

public class LocationDto implements Serializable {

    private Long id;
    private String city;

    public LocationDto() { }

    public LocationDto(String city) {
        this.city = city;
    }
    public LocationDto(Long id, String city) {
        this.id = id;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public LocationDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public LocationDto setCity(String city) {
        this.city = city;
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
        LocationDto locationDto = (LocationDto) o;
        return Objects.equals(id, locationDto.id) &&
                Objects.equals(city, locationDto.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city);
    }
}
