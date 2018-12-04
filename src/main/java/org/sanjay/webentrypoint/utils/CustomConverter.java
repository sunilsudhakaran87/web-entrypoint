package org.sanjay.webentrypoint.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.sanjay.webentrypoint.model.Flight;

import java.util.Map;

public class CustomConverter {
    public Flight convertFromMapToPojo(Map<String, Object> flightMap) {
        return new ObjectMapper().convertValue(flightMap, Flight.class);
    }
}
