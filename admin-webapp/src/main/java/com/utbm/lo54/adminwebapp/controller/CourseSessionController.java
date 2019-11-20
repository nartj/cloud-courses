package com.utbm.lo54.adminwebapp.controller;

import com.utbm.lo54.adminwebapp.controller.helper.ModelHelper;
import com.utbm.lo54.adminwebapp.domain.CourseSessionModel;
import com.utbm.lo54.adminwebapp.service.CourseSessionService;
import com.utbm.lo54.core.courses.domain.CourseSession;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course-session")
public class CourseSessionController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionController.class);

    @Autowired
    private CourseSessionService courseSessionService;
    @Autowired
    private ModelHelper modelHelper;

    @GetMapping("/list")
    public String listCourseSessions(Model theModel) {
        List<CourseSession> courseSessions = courseSessionService.getCourseSessions();
        theModel.addAttribute("courseSessions", courseSessions);
        return "course-session-list";
    }

    @GetMapping("/showForm")
    public String createCourseSession(Model theModel) {
        LOG.debug("inside show courseSession creation form handler method");
        CourseSession courseSession = new CourseSession();
        theModel.addAttribute("courseSessionModel", modelHelper.getCourseSessionModel(courseSession));
        return "course-session-form";
    }

    @PostMapping("/save")
    public String saveCourseSession(@ModelAttribute("courseSessionModel") CourseSessionModel courseSessionModel) {
        courseSessionService.save(courseSessionModel.getCourseSession());
        LOG.debug("Saved new Course Session {}", courseSessionModel.toString());
        return "redirect:/course-session/list";
    }

    @PutMapping("/update")
    public String updateCourseSession(@RequestParam("id") Long id,
                               Model theModel) throws ResourceNotFoundException {
        CourseSession courseSession = courseSessionService.getCourseSession(id);
        theModel.addAttribute("courseSessionModel", modelHelper.getCourseSessionModel(courseSession));
        return "course-session-form";
    }

    @GetMapping("/delete")
    public String deleteCourseSession(@RequestParam("id") Long id) throws ResourceNotFoundException {
        courseSessionService.deleteCourseSession(id);
        return "redirect:/course-session/list";
    }
}
