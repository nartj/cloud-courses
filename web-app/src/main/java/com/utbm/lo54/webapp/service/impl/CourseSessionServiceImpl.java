package com.utbm.lo54.webapp.service.impl;

import com.utbm.lo54.webapp.dto.CourseSessionDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.CourseSessionService;
import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
import com.utbm.lo54.webapp.service.feign.ServiceLayerFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionServiceImpl implements CourseSessionService {
    final static Logger logger = LoggerFactory.getLogger(CourseSessionServiceImpl.class);

    private final ServiceLayerFeignClient serviceLayerFeignClient;
    private final GatewayServiceFeignClient gatewayServiceFeignClient;

    public CourseSessionServiceImpl(ServiceLayerFeignClient serviceLayerFeignClient,
                             GatewayServiceFeignClient gatewayServiceFeignClient) {
        this.serviceLayerFeignClient = serviceLayerFeignClient;
        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
    }

    @Override
    public CourseSessionDto getCourseSession(Long id) throws ResourceNotFoundException {
        logger.debug("Getting course session with id " + id);
        CourseSessionDto courseSessionDto = serviceLayerFeignClient.findCourseSession(id);
        courseSessionDto.setCourse(serviceLayerFeignClient.findCourseByCourseSessionId(id));
        return courseSessionDto;
    }

    @Override
    public void save(CourseSessionDto newCourseSession) {
        CourseSessionDto courseSession = serviceLayerFeignClient.saveCourseSession(newCourseSession);
        logger.debug("New course session saved " + courseSession);
    }

    @Override
    public List<CourseSessionDto> getCourseSessions() {
        List<CourseSessionDto> courseSessions = serviceLayerFeignClient.findAllCourseSessions();
        for (CourseSessionDto courseSession : courseSessions)
            courseSession.setCourse(serviceLayerFeignClient.findCourseByCourseSessionId(courseSession.getId()));
        return courseSessions;
    }

    @Override
    public void deleteCourseSession(Long id) {
        serviceLayerFeignClient.deleteCourseSession(id);
    }

    @Override
    public List<CourseSessionDto> getCourseSessionsByCourseId(Long id) {
        List<CourseSessionDto> courseSessions = serviceLayerFeignClient.findAllCourseSessionsByCourseId(id);
        for (CourseSessionDto courseSession : courseSessions)
            courseSession.setCourse(serviceLayerFeignClient.findCourseByCourseSessionId(courseSession.getId()));
        return courseSessions;
    }

    @Override
    public Integer getCourseSessionFilling(Long id) {
        return serviceLayerFeignClient.findCourseSessionNbClient(id);
    }
}
