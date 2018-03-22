package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class StageDetailsRaceTypesServiceTestResources {

    @Autowired
    private UtilsService utils;
    
    public List<StageDetail> getStageDetailsAllTypes() {
        List<StageDetail> stageDetails = new ArrayList<>();

        StageDetail stageDetail = new StageDetail();
        stageDetail.setRaceType("APlus");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("A1");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("A2");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("A3");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("A4");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("Vets");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("Junior");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("U16");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("U14");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("U12");
        stageDetails.add(stageDetail);
        stageDetail = new StageDetail();
        stageDetail.setRaceType("Women");
        stageDetails.add(stageDetail);

        return stageDetails;
    }
    
    public RaceTypesHolder getRaceTypesAllEnabled() {
        RaceTypesHolder raceTypesHolder = new RaceTypesHolder();
        raceTypesHolder.setAPlus(true);
        raceTypesHolder.setA1(true);
        raceTypesHolder.setA2(true);
        raceTypesHolder.setA3(true);
        raceTypesHolder.setA4(true);
        raceTypesHolder.setVets(true);
        raceTypesHolder.setWoman(true);
        raceTypesHolder.setJunior(true);
        raceTypesHolder.setYouth(true);
        
        return raceTypesHolder;
    }
}
