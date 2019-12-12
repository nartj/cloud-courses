package com.utbm.lo54.webapp.controller;

import com.utbm.lo54.webapp.dto.ClientDto;
import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.dto.LocationDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.ClientService;
import com.utbm.lo54.webapp.service.CourseSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/client")
public class ClientController {

    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;
    @Autowired
    private CourseSessionService courseSessionService;

    @GetMapping("/list")
    public String listClients(Model theModel) {
        List<ClientDto> clients = clientService.getClients();
        theModel.addAttribute("clients", clients);
        return "client-list";
    }

    @GetMapping("/showForm")
    public String createClient(Model theModel,
                               @RequestParam("id") Long id,
                               @RequestParam("max") Integer max,
                               @RequestParam("courseId") Long courseId,
                               @RequestParam("courseCode") String courseCode,
                               @RequestParam("courseTitle") String courseTitle,
                               @RequestParam("startDate") String startDate,
                               @RequestParam("endDate") String endDate,
                               @RequestParam("locationId") Long locationId,
                               @RequestParam("locationCity") String locationCity
    )
            throws ParseException {
        LOG.debug("inside show client creation form handler method");
        ClientDto client = new ClientDto();
        theModel.addAttribute("client", client);

        CourseDto course = new CourseDto();
        course
                .setId(courseId)
                .setCode(courseCode)
                .setTitle(courseTitle);

        LocationDto locationDto = new LocationDto();
        locationDto
                .setId(locationId)
                .setCity(locationCity);

        DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
        Date fStartDate =  df.parse(startDate);
        Date fEndDate =  df.parse(endDate);

        CourseSessionDto courseSessionDto = new CourseSessionDto();

        courseSessionDto
                .setId(id)
                .setMax(max)
                .setStartDate(fStartDate)
                .setEndDate(fEndDate)
                .setCourse(course)
                .setLocation(locationDto);

        client.setCourseSession(courseSessionDto);

        theModel.addAttribute("courseSession", courseSessionDto);
        return "client-form";
    }

    @PostMapping("/save")
    public String saveClient(@ModelAttribute("client") ClientDto client) {
        LOG.info("Registering client {} for CourseSession", client);
        clientService.save(client, null);
        return "redirect:/client/list";
    }

    @PostMapping("/save/course-session/{id}")
    public String saveClient(Model theModel, @ModelAttribute("client") ClientDto client, @PathVariable Long id) {
        LOG.info("Registering client {} for CourseSession", client);
        theModel.addAttribute("client", client);
        clientService.save(client, id);
        try {
            CourseSessionDto courseSession = courseSessionService.getCourseSession(id);
            theModel.addAttribute("courseSession", courseSession);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        return "client-form-validation";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateClient(@RequestParam("id") Long id,
                                    Model theModel) {
        ClientDto client = null;
        try {
            client = clientService.getClient(id);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }
        theModel.addAttribute("client", client);
        return "client-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteClient(@RequestParam("id") Long id) {
        clientService.deleteClient(id);
        return "redirect:/client/list";
    }
}
