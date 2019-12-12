package com.utbm.lo54.webapp.service.impl;

import com.utbm.lo54.webapp.dto.CourseDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.CourseService;
import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
import com.utbm.lo54.webapp.service.feign.ServiceLayerFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    private final ServiceLayerFeignClient serviceLayerFeignClient;
    private final GatewayServiceFeignClient gatewayServiceFeignClient;

    public CourseServiceImpl(ServiceLayerFeignClient serviceLayerFeignClient,
                             GatewayServiceFeignClient gatewayServiceFeignClient) {
        this.serviceLayerFeignClient = serviceLayerFeignClient;
        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
    }

    @Override
    public CourseDto getCourse(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course with id " + id);
        return serviceLayerFeignClient.findCourse(id);
    }

    @Override
    public void save(CourseDto newCourse) {
        CourseDto course = serviceLayerFeignClient.saveCourse(newCourse);
        logger.debug("New Course saved " + course);
    }

    @Override
    public List<CourseDto> getCourses() {
        return serviceLayerFeignClient.findAllCourses();
    }

    @Override
    public void deleteCourse(Long id) {
        serviceLayerFeignClient.deleteCourse(id);
    }

    @Override
    public List<CourseDto> searchTitle(String search) {
        return serviceLayerFeignClient.filterCoursesByTitle(search);
    }

    @Override
    public List<CourseDto> searchLocation(Long id) {
        return serviceLayerFeignClient.filterCoursesByLocation(id);
    }

    @Override
    public List<CourseDto> searchDate(Date date) {
        logger.info("Search date : {}", date);
        return serviceLayerFeignClient.filterCoursesByDate(date);
    }
}
