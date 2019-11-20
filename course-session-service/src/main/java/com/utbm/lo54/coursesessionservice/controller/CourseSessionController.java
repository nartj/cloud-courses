package com.utbm.lo54.coursesessionservice.controller;

import com.utbm.lo54.core.courses.domain.Course;
import com.utbm.lo54.core.courses.domain.CourseSession;
import com.utbm.lo54.coursesessionservice.service.CourseSessionService;
import com.utbm.lo54.core.courses.domain.Client;
import com.utbm.lo54.core.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class CourseSessionController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionController.class);

    @Autowired
    private CourseSessionService courseSessionService;

    @GetMapping("/list")
    public ResponseEntity<List<CourseSession>> listCourseSessions() {
        return ResponseEntity.ok(courseSessionService.getCourseSessions());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findCourseSession(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseSessionService.getCourseSession(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CourseSession> createCourseSession(@RequestBody CourseSession courseSession) {
        LOG.info("Saving CourseSession {}", courseSession);
        courseSessionService.save(courseSession);
        return ResponseEntity.ok(courseSession);
    }

    @PostMapping("/update")
    public ResponseEntity<CourseSession> updateCourseSession(@RequestBody CourseSession courseSession) {
        LOG.info("Saving CourseSession {}", courseSession);
        courseSessionService.save(courseSession);
        return ResponseEntity.ok(courseSession);
    }

    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public ResponseEntity<Long> deleteCourseSession(@PathVariable Long id) {
        courseSessionService.deleteCourseSession(id);
        return ResponseEntity.ok(id);
    }
}