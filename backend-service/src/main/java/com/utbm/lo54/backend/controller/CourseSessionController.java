package com.utbm.lo54.backend.controller;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.domain.courses.CourseSession;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.service.CourseSessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/course-sessions")
public class CourseSessionController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseSessionController.class);

    @Autowired
    private CourseSessionService courseSessionService;

    @GetMapping
    public ResponseEntity<List<CourseSession>> listCourseSessions() {
        return ResponseEntity.ok(courseSessionService.getCourseSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseSession> findCourseSession(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseSessionService.getCourseSession(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<List<CourseSession>> findCourseSessionByCourseId(@PathVariable Long id) {
        return ResponseEntity.ok(courseSessionService.getCourseSessionByCourseId(id));
    }

    @GetMapping("/{id}/course")
    public ResponseEntity<Course> findCourseByCourseSessionId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseSessionService.getCourseByCourseSessionId(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CourseSession> createCourseSession(@RequestBody CourseSession courseSession) throws ResourceNotFoundException {
        LOG.info("Saving CourseSession {}", courseSession);
        courseSessionService.save(courseSession);
        return ResponseEntity.ok(courseSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseSession> updateCourseSession(@PathVariable Long id, @RequestBody CourseSession courseSession) {
        LOG.info("Updating CourseSession {}", courseSession);
        CourseSession updatedCourseSession = null;
        try {
            updatedCourseSession = courseSessionService.getCourseSession(id);
            updatedCourseSession
                    .setId(courseSession.getId())
                    .setStartDate(courseSession.getStartDate())
                    .setEndDate(courseSession.getEndDate())
                    .setMax(courseSession.getMax())
                    .setCourse(courseSession.getCourse())
                    .setLocation(courseSession.getLocation())
                    .setClients(courseSession.getClients());

            courseSessionService.save(updatedCourseSession);
            return ResponseEntity.ok(updatedCourseSession);
        } catch (ResourceNotFoundException e) {
            return (ResponseEntity<CourseSession>) ResponseEntity.notFound();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCourseSession(@PathVariable Long id) {
        courseSessionService.deleteCourseSession(id);
        return ResponseEntity.ok(id);
    }
}