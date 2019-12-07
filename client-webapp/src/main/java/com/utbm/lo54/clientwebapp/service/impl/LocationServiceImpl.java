package com.utbm.lo54.clientwebapp.service.impl;

import com.utbm.lo54.clientwebapp.repository.LocationRepository;
import com.utbm.lo54.clientwebapp.service.LocationService;
import com.utbm.lo54.core.domain.Location;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    final static Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public Location getLocation(Long id) throws ResourceNotFoundException {
        logger.debug("Getting location with id " + id);
        return locationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public void save(Location newLocation) {
        Location location = locationRepository.save(newLocation);
        logger.debug("New location saved " + location);
    }

    @Override
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}

