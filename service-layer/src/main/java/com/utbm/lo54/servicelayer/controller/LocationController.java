package com.utbm.lo54.servicelayer.controller;

import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/location")
public class LocationController {

    private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping("/all")
    public ResponseEntity<List<Location>> listLocations() {
        return ResponseEntity.ok(locationService.getLocations());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findLocation(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(locationService.getLocation(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        LOG.info("Saving location {}", location);
        locationService.save(location);
        return ResponseEntity.ok(location);
    }

    @PostMapping("/update")
    public ResponseEntity<Location> updateLocation(@RequestBody Location location) {
        LOG.info("Saving location {}", location);
        locationService.save(location);
        return ResponseEntity.ok(location);
    }

    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public ResponseEntity<Long> deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.ok(id);
    }
}