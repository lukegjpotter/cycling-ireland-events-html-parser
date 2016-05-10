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
        
        htmlToParse = wrapHtmlInTableTags(htmlToParse);
        
        Element body = Jsoup.parseBodyFragment(htmlToParse).body();
        Elements tableRows = body.getElementsByClass("trCourseItem");
        
        List<StageDetail> stageDetails = new ArrayList<>();
        StageDetail stageDetail = null;
        
         // The first row of the table is Headers, starts from 1.
        for (int i = 1; i < tableRows.size(); i++) {
            
            Elements rowData = tableRows.get(i).getElementsByTag("td");
            
            stageDetail = new StageDetail();
            stageDetail.setDate(utils.convertDDMMYYYYToDate(rowData.get(0).text()));
            stageDetail.setLocation(utils.stringNullCheck(rowData.get(1).text()));
            stageDetail.setRaceNumber(utils.integerNullCheck(rowData.get(2).text()));
            stageDetail.setStageNumber(utils.integerNullCheck(rowData.get(3).text()));
            stageDetail.setRaceType(utils.stringNullCheck(rowData.get(4).text()));
            stageDetail.setKilometers(utils.doubleNullCheck(rowData.get(5).text()));
            stageDetail.setMiles(utils.doubleNullCheck(rowData.get(6).text()));
            stageDetail.setCategory(utils.stringNullCheck(rowData.get(7).text()));
            stageDetail.setSignOnTime(utils.timeNullCheck(rowData.get(8).text()));
            stageDetail.setStartTime(utils.timeNullCheck(rowData.get(9).text()));
            stageDetail.setRouteLinkUrl(parseRouteLinkUrl(rowData.get(10)));
            
            stageDetails.add(stageDetail);
        }
        
        return stageDetails;
    }

    private String wrapHtmlInTableTags(String html) {
        String tableOpen = "<table>", tableClose = "</table>";
        
        if (!html.startsWith(tableOpen))
            html = tableOpen + html;
        
        if (!html.endsWith(tableClose))
            html = html + tableClose;
        
        return html;
    }
    
    private String parseRouteLinkUrl(Element link) {
        return utils.stringNullCheck(link.getElementsByTag("a").attr("onclick").replace("window.top.location = \"", "").replace("\"", "").trim());
    }

}