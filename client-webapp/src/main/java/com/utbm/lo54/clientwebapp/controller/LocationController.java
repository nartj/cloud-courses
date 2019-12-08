package com.utbm.lo54.clientwebapp.controller;

import com.utbm.lo54.clientwebapp.service.LocationService;
import com.utbm.lo54.common.domain.courses.Location;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/location")
public class LocationController {

    private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping("/list")
    public String listLocations(Model theModel) {
        List<Location> locations = locationService.getLocations();
        theModel.addAttribute("locations", locations);
        return "location-list";
    }

    @GetMapping("/showForm")
    public String createLocation(Model theModel) {
        LOG.debug("inside show location creation form handler method");
        Location location = new Location();
        theModel.addAttribute("location", location);
        return "location-form";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("location") Location location) {
        LOG.info("Sending location {} to save", location);
        locationService.save(location);
        return "redirect:/location/list";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateLocation(@RequestParam("id") Long id,
                               Model theModel) throws ResourceNotFoundException {
        Location location = locationService.getLocation(id);
        theModel.addAttribute("location", location);
        return "location-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteLocation(@RequestParam("id") Long id) throws ResourceNotFoundException {
        locationService.deleteLocation(id);
        return "redirect:/location/list";
    }
}

