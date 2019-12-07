package com.utbm.lo54.locationservice.service.impl;

import com.utbm.lo54.core.domain.Location;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import com.utbm.lo54.locationservice.repository.LocationRepository;
import com.utbm.lo54.locationservice.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional(transactionManager = "coursesPlatformTransactionManager")
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

