package com.utbm.lo54.webapp.controller;

import com.utbm.lo54.webapp.controller.helper.CoursesModel;
import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseFilter;
import com.utbm.lo54.webapp.dto.LocationDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.CourseService;
import com.utbm.lo54.webapp.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;
    @Autowired
    private LocationService locationService;

    @GetMapping("/list")
    public String listCourses(Model theModel) {
        List<CourseDto> courses = courseService.getCourses();
        List<LocationDto> locations = locationService.getLocations();
        CourseFilter filter = new CourseFilter();
        CoursesModel model = new CoursesModel(courses, filter, locations);
        theModel.addAttribute("coursesModel", model);
        return "course-list";
    }

    @GetMapping("/showForm")
    public String createCourse(Model theModel) {
        LOG.debug("inside show course creation form handler method");
        CourseDto course = new CourseDto();
        theModel.addAttribute("course", course);
        return "course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") CourseDto course) {
        courseService.save(course);
        return "redirect:/course/list";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateCourse(@RequestParam("id") Long id, Model theModel) {
        try {
            CourseDto course = courseService.getCourse(id);
            theModel.addAttribute("course", course);
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }

        return "course-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteCourse(@RequestParam("id") Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }

    @PostMapping(value = "/search")
    public String search(@ModelAttribute("coursesModel") CoursesModel coursesModel) {
        return "redirect:/course/list/filter/title/" + coursesModel.getFilter().getSearch();
    }

    @PostMapping(value = "/search/title")
    public String searchTitle(@ModelAttribute("coursesModel") CoursesModel coursesModel) {
        return "redirect:/course/list/filter/title/" + coursesModel.getFilter().getTitle();
    }

    @PostMapping(value = "/search/location")
    public String searchLocation(@ModelAttribute("coursesModel") CoursesModel coursesModel) {
        return "redirect:/course/list/filter/location/" + coursesModel.getFilter().getLocation().getId();
    }

    @PostMapping(value = "/search/date")
    public String searchDate(Model theModel, @ModelAttribute("coursesModel") CoursesModel coursesModel) {
        return listFilteredDateCourse(theModel, coursesModel, coursesModel.getFilter().getDate());
    }

    @GetMapping("/list/filter/title/{search}")
    public String listFilteredTitleCourse(Model theModel, @ModelAttribute("coursesModel") CoursesModel coursesModel, @PathVariable String search) {
        List<CourseDto> filteredCourses = courseService.searchTitle(search);
        List<LocationDto> locations = locationService.getLocations();
        LOG.info("Filtered search list : {}", filteredCourses);
        CourseFilter filter = new CourseFilter();
        theModel.addAttribute("coursesModel", new CoursesModel(filteredCourses, filter, locations));
        return "course-list";
    }

    @GetMapping("/list/filter/location/{id}")
    public String listFilteredLocationCourse(Model theModel, @ModelAttribute("coursesModel") CoursesModel coursesModel, @PathVariable Long id) {
        List<CourseDto> filteredCourses = courseService.searchLocation(id);
        List<LocationDto> locations = locationService.getLocations();
        LOG.info("Filtered search list : {}", filteredCourses);
        CourseFilter filter = new CourseFilter();
        theModel.addAttribute("coursesModel", new CoursesModel(filteredCourses, filter, locations));
        return "course-list";
    }

    @GetMapping("/list/filter/date")
    public String listFilteredDateCourse(Model theModel, @ModelAttribute("coursesModel") CoursesModel coursesModel, Date date) {
        List<CourseDto> filteredCourses = courseService.searchDate(date);
        List<LocationDto> locations = locationService.getLocations();
        LOG.info("Filtered search list : {}", filteredCourses);
        CourseFilter filter = new CourseFilter();
        theModel.addAttribute("coursesModel", new CoursesModel(filteredCourses, filter, locations));
        return "course-list";
    }

    @PostMapping("/list/filter/title/search/title")
    public String undoTitleFilteringCourses() {
        return "redirect:/course/list";
    }

    @GetMapping("/list/filter/title/")
    public String handleTitleEmptyFilterCourses() {
        return "redirect:/course/list";
    }

    @PostMapping("/list/filter/location/search/location")
    public String undoLocationFilteringCourses() {
        return "redirect:/course/list";
    }

    @GetMapping("/list/filter/location/")
    public String handleLocationEmptyFilterCourses() {
        return "redirect:/course/list";
    }

    @RequestMapping(value = "/search/search/date", method = {RequestMethod.GET, RequestMethod.POST})
    public String undoDateFilteringCourses() {
        return "redirect:/course/list";
    }

    @RequestMapping("/list/filter/date/")
    public String handleDateEmptyFilterCourses() {
        return "redirect:/course/list";
    }

    @RequestMapping("/course/list/filter/title/search")
    public String undoSearch() {
        return "redirect:/course/list";
    }

}

