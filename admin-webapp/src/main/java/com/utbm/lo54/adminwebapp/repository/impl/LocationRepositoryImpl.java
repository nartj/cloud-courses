package com.utbm.lo54.adminwebapp.repository.impl;

import com.utbm.lo54.adminwebapp.repository.LocationRepository;
import com.utbm.lo54.core.domain.Location;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepositoryImpl implements LocationRepository {
    @Override
    public String getServiceUrl() {
        return null;
    }

    @Override
    public List<Location> findAll() {
        return null;
    }

    @Override
    public Optional<Location> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Location save(Location entity) {
        return null;
    }

    @Override
    public Location update(Location entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
