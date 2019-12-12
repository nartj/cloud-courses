package com.utbm.lo54.webapp.controller;

import com.utbm.lo54.webapp.dto.LocationDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.LocationService;
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
        List<LocationDto> locations = locationService.getLocations();
        theModel.addAttribute("locations", locations);
        return "location-list";
    }

    @GetMapping("/showForm")
    public String createLocation(Model theModel) {
        LOG.debug("inside show location creation form handler method");
        LocationDto location = new LocationDto();
        theModel.addAttribute("location", location);
        return "location-form";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute("location") LocationDto location) {
        LOG.info("Sending location {} to save", location);
        locationService.save(location);
        return "redirect:/location/list";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateLocation(@RequestParam("id") Long id,
                               Model theModel) throws ResourceNotFoundException {
        LocationDto location = locationService.getLocation(id);
        theModel.addAttribute("location", location);
        return "location-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteLocation(@RequestParam("id") Long id) throws ResourceNotFoundException {
        locationService.deleteLocation(id);
        return "redirect:/location/list";
    }
}

