package com.utbm.lo54.servicelayer.controller;

import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.service.CourseSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/course-session")
public class CourseSessionController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionController.class);

    @Autowired
    private CourseSessionService courseSessionService;

    @GetMapping("/all")
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