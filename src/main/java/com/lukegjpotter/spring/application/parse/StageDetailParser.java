package com.lukegjpotter.spring.application.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class StageDetailParser implements Parsable<List<StageDetail>> {
    
    @Autowired private UtilsService utils;

    @Override public List<StageDetail> parse(String htmlToParse) {
        
        List<StageDetail> stageDetails = new ArrayList<>();
        StageDetail stageDetail = null;
        
        Element body = Jsoup.parseBodyFragment(htmlToParse).body();
        Elements tableRows = body.getElementsByClass("trCourseItem");
        
        int i = 1; // The first row of the table is Headers, start from 1.
        while (i < tableRows.size()) {
            
            stageDetail = new StageDetail();
            Elements rowData = tableRows.get(i).getElementsByTag("td");
            
            stageDetail.setDate(utils.convertDDMMYYYYToDate(rowData.get(0).text()));
            stageDetail.setLocation(rowData.get(1).text().trim());
            stageDetail.setRaceNumber(Integer.parseInt(rowData.get(2).text().trim()));
            stageDetail.setStageNumber(Integer.parseInt(rowData.get(3).text().trim()));
            stageDetail.setRaceType(rowData.get(4).text().trim());
            stageDetail.setKilometers(Double.parseDouble(rowData.get(5).text().trim()));
            stageDetail.setMiles(Double.parseDouble(rowData.get(6).text().trim()));
            stageDetail.setCategory(rowData.get(7).text().trim());
            stageDetail.setSignOnTime(rowData.get(8).text().trim().replace(".", ":"));
            stageDetail.setStartTime(rowData.get(9).text().trim().replace(".", ":"));
            stageDetail.setRouteLinkUrl(parseRouteLinkUrl(rowData.get(10)));
            
            stageDetails.add(stageDetail);
            i++;
        }
        
        return stageDetails;
    }

    private String parseRouteLinkUrl(Element link) {
        return link.getElementsByTag("a").attr("onclick").replace("window.top.location = \"", "").replace("\"", "").trim();
    }

}