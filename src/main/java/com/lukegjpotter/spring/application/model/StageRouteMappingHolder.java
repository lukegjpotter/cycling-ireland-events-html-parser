package com.lukegjpotter.spring.application.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StageRouteMappingHolder {
    
    private Map<Long, List<String>> nameDateRouteMap;
    
    public StageRouteMappingHolder() {
        nameDateRouteMap = new HashMap<>();
    }

    public void putRouteUrlMapping(Long keyEventId, List<String> valueRoutes) {
        nameDateRouteMap.put(keyEventId, valueRoutes);
   }

    public String getRouteUrlMapping(Long keyEventId, String stageNumberQuery) {
        try {
            return nameDateRouteMap.get(keyEventId).get(Integer.getInteger(stageNumberQuery) - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }
    
    @Override public boolean equals(Object o) {
        
        return o instanceof StageRouteMappingHolder
                && this.nameDateRouteMap.equals(((StageRouteMappingHolder) o).nameDateRouteMap);
    }

    public void putRouteUrlMapping(String eventName, Date date, List<String> routes) {
        // TODO Delete this method after more tests are implemented for the 2017
        //      format, it's only here to stop the compiler complaining.
    }
    
    public String getRouteUrlMapping(String eventName, Date startDate, Integer stageNumber) {
        // TODO Delete this method after more tests are implemented for the 2017
        //      format, it's only here to stop the compiler complaining.
        return "";
    }

}
