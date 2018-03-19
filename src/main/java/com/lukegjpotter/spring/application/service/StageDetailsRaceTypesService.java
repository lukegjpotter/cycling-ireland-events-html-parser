package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class StageDetailsRaceTypesService {

    @Autowired
    private UtilsService utils;
    
    public RaceTypesHolder determineRaceTypes(List<StageDetail> stageDetails) {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();

        stageDetails.forEach(stageDetail -> {
            String raceType = stageDetail.getRaceType().toLowerCase();
            
            if (raceType.contains("aplus")) raceTypesHolder.setAPlus(true);
            if (raceType.contains("a1")) raceTypesHolder.setA1(true);
            if (raceType.contains("a2")) raceTypesHolder.setA2(true);
            if (raceType.contains("a3")) raceTypesHolder.setA3(true);
            if (raceType.contains("a4")) raceTypesHolder.setA4(true);
            if (raceType.contains("vets")) raceTypesHolder.setVets(true);
            if (raceType.contains("women")) raceTypesHolder.setWoman(true);
            if (raceType.contains("junior")) raceTypesHolder.setJunior(true);
            if (hasYouthRaceTypes(raceType)) raceTypesHolder.setYouth(true);
            if (hasVetRaceTypes(raceType)) raceTypesHolder.setVets(true);
            if (hasParacyclingRaceTypes(raceType)) raceTypesHolder.setParacycling(true);
        });
        
        return raceTypesHolder;
    }

    private boolean hasYouthRaceTypes(String raceType) {
        return utils.isListElementInString(raceType, Constants.YOUTH_RACE_TYPES);
    }
    
    private boolean hasVetRaceTypes(String raceType) {
        return utils.isListElementInString(raceType, Constants.VETS_RACE_TYPES);
    }
    
    private boolean hasParacyclingRaceTypes(String raceType) {
        return utils.isListElementInString(raceType, Constants.PARACYCLING_RACE_TYPES);
    }

}
