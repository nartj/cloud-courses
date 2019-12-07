package com.utbm.lo54.adminwebapp.controller;

import com.utbm.lo54.adminwebapp.service.CourseService;
import com.utbm.lo54.core.domain.Course;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping("/list")
    public String listCourses(Model theModel) {
        List<Course> courses = courseService.getCourses();
        theModel.addAttribute("courses", courses);
        return "course-list";
    }

    @GetMapping("/showForm")
    public String createCourse(Model theModel) {
        LOG.debug("inside show course creation form handler method");
        Course course = new Course();
        theModel.addAttribute("course", course);
        return "course-form";
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {
        courseService.save(course);
        return "redirect:/course/list";
    }

    @PutMapping("/update")
    public String updateCourse(@RequestParam("id") Long id,
                               Model theModel) throws ResourceNotFoundException {
        Course course = courseService.getCourse(id);
        theModel.addAttribute("course", course);
        return "course-form";
    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("id") Long id) throws ResourceNotFoundException {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }
}

