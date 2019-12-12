package com.utbm.lo54.backend.service;


import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.exception.ResourceNotFoundException;

import java.util.List;

public interface LocationService {

    Location getLocation(Long id) throws ResourceNotFoundException;

    void save(Location location);

    List<Location> getLocations();

    void deleteLocation(Long id);
}
