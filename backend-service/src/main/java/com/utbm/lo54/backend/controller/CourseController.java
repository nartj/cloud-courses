package com.utbm.lo54.backend.controller;

import com.utbm.lo54.common.domain.courses.Course;
import com.utbm.lo54.common.exception.ResourceNotFoundException;
import com.utbm.lo54.backend.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;

    @GetMapping()
    public ResponseEntity<List<Course>> listCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourse(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseService.getCourse(id));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity
                    .notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        LOG.info("Saving course {}", course);
        courseService.save(course);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateClourse(@PathVariable Long id, @RequestBody Course course) {
        LOG.info("Updating client {}", course);
        Course updatedCourse = null;
        try {
            updatedCourse = courseService.getCourse(id);
            updatedCourse
                    .setId(course.getId())
                    .setCode(course.getCode())
                    .setTitle(course.getTitle());
            courseService.save(updatedCourse);
            return ResponseEntity.ok(updatedCourse);
        } catch (ResourceNotFoundException e) {
            return (ResponseEntity<Course>) ResponseEntity.notFound();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCourse(@PathVariable Long id) {
        LOG.info("Updating Course id {}", id);
        courseService.deleteCourse(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/search/title/{search}")
    public ResponseEntity<List<Course>> filterCoursesByTitle(@PathVariable String search) {
        LOG.info("Filtering Courses by title {}", search);
        List<Course> filteredCourse = courseService.filterCoursesByTitle(search);
        return ResponseEntity.ok(filteredCourse);
    }

    @GetMapping("/search/location/{id}")
    public ResponseEntity<List<Course>> filterCoursesByLocation(@PathVariable Long id) {
        LOG.info("Filtering Courses by Location id {}", id);
        List<Course> filteredCourse = courseService.filterCoursesByLocationId(id);
        return ResponseEntity.ok(filteredCourse);
    }

    @PostMapping("/search/date")
    public ResponseEntity<List<Course>> filterCoursesByLocation(@RequestBody Date date) {
        LOG.info("Filtering Courses by date {}", date);
        List<Course> filteredCourse = courseService.filterCoursesByDate(date);
        return ResponseEntity.ok(filteredCourse);
    }
}
