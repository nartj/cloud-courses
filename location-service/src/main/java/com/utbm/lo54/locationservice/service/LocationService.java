package com.utbm.lo54.locationservice.service;


import com.utbm.lo54.core.courses.domain.Location;
import com.utbm.lo54.core.exception.ResourceNotFoundException;

import java.util.List;

public interface LocationService {

    Location getLocation(Long id) throws ResourceNotFoundException;

    void save(Location location);

    List<Location> getLocations();

    void deleteLocation(Long id);
}
