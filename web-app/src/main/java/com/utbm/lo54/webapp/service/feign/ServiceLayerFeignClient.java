package com.utbm.lo54.webapp.service.feign;

import com.utbm.lo54.webapp.dto.ClientDto;
import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.dto.LocationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@FeignClient(name = "backend-service")
public interface ServiceLayerFeignClient {

    @PostMapping(value = "/services/api/clients/course-session/{id}")
    ClientDto saveClient(@RequestBody ClientDto client, @PathVariable("id") Long id);

    @GetMapping(value = "/services/api/clients")
    List<ClientDto> findAllClients();

    @GetMapping(value = "/services/api/clients/{id}")
    ClientDto findClient(@PathVariable("id") Long id);

    @PutMapping(value = "/services/api/clients/{id}/course-session/{idCourseSession}")
    ClientDto updateClient(@PathVariable("id") Long id, @PathVariable("idCourseSession") Long idCourseSession, @RequestBody ClientDto client);

    @DeleteMapping(value = "/services/api/clients/{id}")
    Long deleteClient(@PathVariable("id") Long id);


    @PostMapping(value = "/services/api/courses")
    CourseDto saveCourse(@RequestBody CourseDto course);

    @GetMapping(value = "/services/api/courses")
    List<CourseDto> findAllCourses();

    @GetMapping(value = "/services/api/courses/{id}")
    CourseDto findCourse(@PathVariable("id") Long id);

    @PutMapping(value = "/services/api/courses/{id}")
    CourseDto deleteCourse(@PathVariable("id") Long id, @RequestBody CourseDto course);

    @DeleteMapping(value = "/services/api/courses/{id}")
    Long deleteCourse(@PathVariable("id") Long id);

    @GetMapping(value = "/services/api/courses/search/title/{search}")
    List<CourseDto> filterCoursesByTitle(@PathVariable String search);

    @GetMapping(value = "/services/api/courses/search/location/{id}")
    List<CourseDto> filterCoursesByLocation(@PathVariable Long id);

    @PostMapping(value = "/services/api/courses/search/date")
    List<CourseDto> filterCoursesByDate(@RequestBody Date date);


    @PostMapping(value = "/services/api/locations")
    LocationDto saveLocation(@RequestBody LocationDto location);

    @GetMapping(value = "/services/api/locations")
    List<LocationDto> findAllLocations();

    @GetMapping(value = "/services/api/locations/{id}")
    LocationDto findLocation(@PathVariable("id") Long id);

    @PutMapping(value = "/services/api/locations/{id}")
    LocationDto deleteLocation(@PathVariable("id") Long id, @RequestBody LocationDto location);

    @DeleteMapping(value = "/services/api/locations/{id}")
    Long deleteLocation(@PathVariable("id") Long id);


    @PostMapping(value = "/services/api/course-sessions")
    CourseSessionDto saveCourseSession(@RequestBody CourseSessionDto courseSession);

    @GetMapping(value = "/services/api/course-sessions")
    List<CourseSessionDto> findAllCourseSessions();

    @GetMapping(value = "/services/api/course-sessions/{id}")
    CourseSessionDto findCourseSession(@PathVariable("id") Long id);

    @GetMapping(value = "/services/api/course-sessions/{id}/course")
    CourseDto findCourseByCourseSessionId(@PathVariable("id") Long id);

    @PutMapping(value = "/services/api/course-sessions/{id}")
    CourseSessionDto deleteCourseSession(@PathVariable("id") Long id, @RequestBody CourseSessionDto courseSession);

    @DeleteMapping(value = "/services/api/course-sessions/{id}")
    Long deleteCourseSession(@PathVariable("id") Long id);

    @GetMapping(value = "/services/api/course-sessions/course/{id}")
    List<CourseSessionDto> findAllCourseSessionsByCourseId(@PathVariable Long id);

    @GetMapping(value = "/services/api/clients/course-session/{id}/filling")
    Integer findCourseSessionNbClient(@PathVariable Long id);
}
