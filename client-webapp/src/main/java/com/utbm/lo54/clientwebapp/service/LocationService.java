package com.utbm.lo54.clientwebapp.service;


import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface LocationService {
    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    Location getLocation(Long id) throws ResourceNotFoundException;

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    void save(Location location);

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    List<Location> getLocations();

    @Secured({"ROLE_ADMIN"})
    void deleteLocation(Long id);
}
