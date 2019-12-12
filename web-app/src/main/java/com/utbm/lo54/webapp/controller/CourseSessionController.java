package com.utbm.lo54.webapp.controller;

import com.utbm.lo54.webapp.controller.helper.FilledCourseSessionModel;
import com.utbm.lo54.webapp.controller.helper.ModelHelper;
import com.utbm.lo54.webapp.domain.CourseSessionModel;
import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.CourseService;
import com.utbm.lo54.webapp.service.CourseSessionService;
import com.utbm.lo54.webapp.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/course-session")
public class CourseSessionController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionController.class);

    private final CourseSessionService courseSessionService;
    private final CourseService courseService;
    private final LocationService locationService;
    private final ModelHelper modelHelper;

    public CourseSessionController(CourseSessionService courseSessionService, CourseService courseService, LocationService locationService, ModelHelper modelHelper) {
        this.courseSessionService = courseSessionService;
        this.modelHelper = modelHelper;
        this.courseService = courseService;
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public String listCourseSessions(Model theModel) {
        List<CourseSessionDto> courseSessions = courseSessionService.getCourseSessions();
        List<FilledCourseSessionModel> filledCourseSessionModels = new ArrayList<>();
        for (CourseSessionDto courseSession : courseSessions) {
            FilledCourseSessionModel model = new FilledCourseSessionModel(courseSession,
                    courseSessionService.getCourseSessionFilling(courseSession.getId()));
            filledCourseSessionModels.add(model);
        }
        theModel.addAttribute("courseSessions", filledCourseSessionModels);
        return "course-session-list";
    }

    @GetMapping("/showForm")
    public String createCourseSession(Model theModel) {
        LOG.debug("inside show courseSession creation form handler method");
        theModel.addAttribute("courseSessionModel", modelHelper.getCourseSessionModel(new CourseSessionDto()));
        return "course-session-form";
    }

    @PostMapping("/save")
    public String saveCourseSession(@ModelAttribute("courseSessionModel") CourseSessionModel courseSessionModel) {
        LOG.info("Saving course session :  {}", courseSessionModel.getCourseSessionForm());
        CourseSessionDto courseSession = modelHelper.toDto(courseSessionModel.getCourseSessionForm());
        LOG.info("Saving DTO : {}", courseSession);
        courseSessionService.save(courseSession);
        return "redirect:/course-session/list";
    }

    @PostMapping("location/save")
    public String saveLocation(@ModelAttribute("courseSessionModel") CourseSessionModel courseSessionModel) {
        LOG.info("Saving location :  {}", courseSessionModel.getCourseSessionForm());
        CourseSessionDto courseSession = modelHelper.toDto(courseSessionModel.getCourseSessionForm());
        LOG.info("Saving DTO : {}", courseSession);
        locationService.save(courseSession.getLocation());
        return "redirect:/showForm";
    }

    @PostMapping("course/save")
    public String saveCourse(@ModelAttribute("courseSessionModel") CourseSessionModel courseSessionModel) {
        LOG.info("Saving course session :  {}", courseSessionModel.getCourseSessionForm());
        CourseSessionDto courseSession = modelHelper.toDto(courseSessionModel.getCourseSessionForm());
        LOG.info("Saving DTO : {}", courseSession);
        courseService.save(courseSession.getCourse());
        return "redirect:/showForm";
    }

    @RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.PUT })
    public String updateCourseSession(@RequestParam("id") Long id,
                               Model theModel) throws ResourceNotFoundException {
        CourseSessionDto courseSession = courseSessionService.getCourseSession(id);
        LOG.info("Retrieved CourseSession {} for update action.", courseSession);
        theModel.addAttribute("courseSessionModel", modelHelper.getCourseSessionModel(modelHelper.toForm(courseSession)));
        return "course-session-form";
    }

    @RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.DELETE })
    public String deleteCourseSession(@RequestParam("id") Long id) throws ResourceNotFoundException {
        courseSessionService.deleteCourseSession(id);
        return "redirect:/course-session/list";
    }

    @GetMapping(value = "/course/{id}")
    public String listCourseSessionsByCourse(Model theModel, @PathVariable Long id) {
        List<CourseSessionDto> courseSessions = courseSessionService.getCourseSessionsByCourseId(id);
        List<FilledCourseSessionModel> filledCourseSessionModels = new ArrayList<>();
        for (CourseSessionDto courseSession : courseSessions) {
            FilledCourseSessionModel model = new FilledCourseSessionModel(courseSession,
                    courseSessionService.getCourseSessionFilling(courseSession.getId()));
            filledCourseSessionModels.add(model);
        }
        theModel.addAttribute("courseSessions", filledCourseSessionModels);
        return "course-session-list";
    }
}
