package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class StageDetailsParserTestResources {

    @Autowired
    private UtilsService utils;

    public Element getJsoupElementFromPopup() {

        try {
            return Jsoup.parse(new File("src/test/resources/20180805-Stages-OldcastleGP.html"), Constants.FILE_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public StageDetail getExpectedOldcastleStageDetail() {
        StageDetail stageDetail = new StageDetail();
        stageDetail.setDate(utils.convertDDMMMYYYYToDate("5 Aug 2018"));
        stageDetail.setVenue("Show Hall Oldcastle");
        stageDetail.setRaceNumber(1);
        stageDetail.setStageNumber("1");
        stageDetail.setRaceType("Road Race");
        stageDetail.setKilometers(60D);
        stageDetail.setMiles(62.1);
        stageDetail.setCategory("Women");
        stageDetail.setSignOnTime("09:00");
        stageDetail.setStartTime("13:00");
        stageDetail.setRouteLinkUrl("");
        stageDetail.setStageName("Oldcastle GP");

        return stageDetail;
    }

    public String getExpectedOldcastleAddress() {
        return "Oldcastle, Co Meath, Oldcastle, Ireland";
    }
}
