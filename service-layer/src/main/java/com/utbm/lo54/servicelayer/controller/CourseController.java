package com.utbm.lo54.servicelayer.controller;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.servicelayer.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/course")
public class CourseController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> listCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/find")
    public ResponseEntity<Object> findCourse(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(courseService.getCourse(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        LOG.info("Saving course {}", course);
        courseService.save(course);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/update")
    public ResponseEntity<Course> updateClourse(@RequestBody Course course) {
        LOG.info("Saving course {}", course);
        courseService.save(course);
        return ResponseEntity.ok(course);
    }

    @RequestMapping(value = "/delete/{id}", method = { RequestMethod.GET, RequestMethod.DELETE })
    public ResponseEntity<Long> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(id);
    }
}
