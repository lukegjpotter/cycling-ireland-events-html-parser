package com.lukegjpotter.spring.application.testresources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.RaceTypesHolder;
import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * This class is to reduce the boilerplate needed to create Road Race Events
 * in the other actual test classes.
 * 
 * @author lukegjpotter
 */
@Component
public class StageDetailsRaceTypesServiceTestResources {

    @Autowired UtilsService utils;
    
    public List<StageDetail> getStageDetailsAllTypes() {
        List<StageDetail> stageDetails = new ArrayList<>();
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "APlus", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "A1", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 2, 1, "A2", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 3, 1, "A3", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 4, 1, "A4", 70.0, 43.5, "Road", "10:00", "12:15", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "Vets", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 1, 1, "Junior", 105.0, 65.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 5, 1, "U16", 35.7, 22.2, "Road", "10:00", "13:15", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 6, 1, "U14", 18.0, 11.2, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 7, 1, "U12", 10.7, 6.6, "Road", "10:00", "12:00", "http://www.dungarvancc.com", ""));
        stageDetails.add(new StageDetail(utils.convertDDMMYYYYToDate("03/04/2016"), "Soccer Club", 8, 1, "Women", 70.0, 43.5, "Road", "09:00", "11:00", "http://www.dungarvancc.com", ""));
        
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
