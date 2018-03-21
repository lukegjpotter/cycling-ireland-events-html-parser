package com.lukegjpotter.spring.application.model;

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
            return nameDateRouteMap.get(keyEventId).get(Integer.parseInt(stageNumberQuery) - 1);
        } catch (IndexOutOfBoundsException | NumberFormatException | NullPointerException ignored) {
            return "";
        }
    }
    
    @Override public boolean equals(Object o) {
        
        return o instanceof StageRouteMappingHolder
                && this.nameDateRouteMap.equals(((StageRouteMappingHolder) o).nameDateRouteMap);
    }
}
