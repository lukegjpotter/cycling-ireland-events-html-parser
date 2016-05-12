package com.lukegjpotter.spring.application.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StageRouteMappingHolder {
    
    private static Map<String, List<String>> nameDateRouteMap = new HashMap<>();

    public void putRouteUrlMapping(String eventName, Date startDate, List<String> routeLinks) {
        String key = eventName + startDate.getTime();
        nameDateRouteMap.put(key, routeLinks);
    }

    public String getRouteUrlMapping(String eventName, Date startDate, Integer stageNumber) {
        String key = eventName + startDate.getTime();
        return nameDateRouteMap.get(key).get(stageNumber.intValue() - 1);
    }

}
