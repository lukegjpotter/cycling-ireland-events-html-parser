package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;

@Service public class StageDetailsRaceTypesService {

    public RaceTypesHolder determineRaceTypes(List<StageDetail> stageDetails) {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();
        List<String> categoryStrings = new ArrayList<>();
        
        for (StageDetail stageDetail : stageDetails) {
            categoryStrings.add(stageDetail.getRaceType().toLowerCase());
        }
        
        if (categoryStrings.contains("aplus")) raceTypesHolder.setAPlus(true);
        if (categoryStrings.contains("a1")) raceTypesHolder.setA1(true);
        if (categoryStrings.contains("a2")) raceTypesHolder.setA2(true);
        if (categoryStrings.contains("a3")) raceTypesHolder.setA3(true);
        if (categoryStrings.contains("a4")) raceTypesHolder.setA4(true);
        if (categoryStrings.contains("vets")) raceTypesHolder.setVets(true);
        if (categoryStrings.contains("women")) raceTypesHolder.setWoman(true);
        // TODO Determine a way to check for A3/Junior races.
        if (categoryStrings.contains("junior")) raceTypesHolder.setJunior(true);
        if (!Collections.disjoint(categoryStrings, Constants.YOUTH_CATEGORIES)) raceTypesHolder.setYouth(true);
        
        return raceTypesHolder;
    }

}
