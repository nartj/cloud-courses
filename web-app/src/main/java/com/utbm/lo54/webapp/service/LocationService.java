package com.utbm.lo54.webapp.service;


import com.utbm.lo54.webapp.dto.LocationDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface LocationService {
    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    LocationDto getLocation(Long id) throws ResourceNotFoundException;

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    void save(LocationDto location);

    @Secured ({"ROLE_USER", "ROLE_ADMIN"})
    List<LocationDto> getLocations();

    @Secured({"ROLE_ADMIN"})
    void deleteLocation(Long id);
}
