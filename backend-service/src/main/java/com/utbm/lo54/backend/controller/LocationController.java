package com.utbm.lo54.backend.controller;

import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/locations")
public class LocationController {

    private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<Location>> listLocations() {
        return ResponseEntity.ok(locationService.getLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findLocation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(locationService.getLocation(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        LOG.info("Saving location {}", location);
        locationService.save(location);
        return ResponseEntity.ok(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location location) {
        LOG.info("Updating CourseSession {}", location);
        Location updatedCourseSession = null;
        try {
            updatedCourseSession = locationService.getLocation(id);
            updatedCourseSession
                    .setId(location.getId())
                    .setCity(location.getCity());

            locationService.save(updatedCourseSession);
            return ResponseEntity.ok(updatedCourseSession);
        } catch (ResourceNotFoundException e) {
            return (ResponseEntity<Location>) ResponseEntity.notFound();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok(id);
    }
}