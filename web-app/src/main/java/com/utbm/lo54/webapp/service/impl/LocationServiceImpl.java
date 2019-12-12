package com.utbm.lo54.webapp.service.impl;

import com.utbm.lo54.webapp.dto.LocationDto;
import com.utbm.lo54.webapp.exception.ResourceNotFoundException;
import com.utbm.lo54.webapp.service.LocationService;
import com.utbm.lo54.webapp.service.feign.GatewayServiceFeignClient;
import com.utbm.lo54.webapp.service.feign.ServiceLayerFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    final static Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    private final ServiceLayerFeignClient serviceLayerFeignClient;
    private final GatewayServiceFeignClient gatewayServiceFeignClient;

    public LocationServiceImpl(ServiceLayerFeignClient serviceLayerFeignClient,
                                    GatewayServiceFeignClient gatewayServiceFeignClient) {
        this.serviceLayerFeignClient = serviceLayerFeignClient;
        this.gatewayServiceFeignClient = gatewayServiceFeignClient;
    }

    @Override
    public LocationDto getLocation(Long id) throws ResourceNotFoundException {
        logger.debug("Getting location with id " + id);
        return serviceLayerFeignClient.findLocation(id);
    }

    @Override
    public void save(LocationDto newLocation) {
        LocationDto location = serviceLayerFeignClient.saveLocation(newLocation);
        logger.debug("New location saved " + location);
    }

    @Override
    public List<LocationDto> getLocations() {
        return serviceLayerFeignClient.findAllLocations();
    }

    @Override
    public void deleteLocation(Long id) {
        serviceLayerFeignClient.deleteLocation(id);
    }
}

