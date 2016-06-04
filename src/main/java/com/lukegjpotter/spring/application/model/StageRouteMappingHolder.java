package com.lukegjpotter.spring.application.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StageRouteMappingHolder {
    
    private Map<String, List<String>> nameDateRouteMap;
    
    public StageRouteMappingHolder() {
        nameDateRouteMap = new HashMap<>();
    }

    public void putRouteUrlMapping(String eventName, Date startDate, List<String> routeLinks) {
        String key = eventName + startDate.getTime();
        nameDateRouteMap.put(key, routeLinks);
    }

    public String getRouteUrlMapping(String eventName, Date startDate, Integer stageNumber) {
        String key = eventName + startDate.getTime();
        try {
            return nameDateRouteMap.get(key).get(stageNumber.intValue() - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }
    
    @Override public boolean equals(Object o) {
        
        return o instanceof StageRouteMappingHolder
                && this.nameDateRouteMap.equals(((StageRouteMappingHolder) o).nameDateRouteMap);
    }

}
