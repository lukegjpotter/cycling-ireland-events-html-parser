package com.lukegjpotter.spring.application.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.util.NullCheckUtilsService;
import com.lukegjpotter.spring.application.util.UtilsService;

@Component
public class StageDetailParser implements Parsable<String, List<StageDetail>> {
    
    @Autowired private UtilsService utils;
    @Autowired private NullCheckUtilsService nullCheckUtils;

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
            stageDetail.setLocation(nullCheckUtils.stringNullCheck(rowData.get(1).text()));
            stageDetail.setRaceNumber(nullCheckUtils.integerNullCheck(rowData.get(2).text()));
            stageDetail.setStageNumber(nullCheckUtils.integerNullCheck(rowData.get(3).text()));
            stageDetail.setRaceType(nullCheckUtils.stringNullCheck(rowData.get(4).text()));
            stageDetail.setKilometers(nullCheckUtils.doubleNullCheck(rowData.get(5).text()));
            stageDetail.setMiles(nullCheckUtils.doubleNullCheck(rowData.get(6).text()));
            stageDetail.setCategory(nullCheckUtils.stringNullCheck(rowData.get(7).text()));
            stageDetail.setSignOnTime(nullCheckUtils.timeNullCheck(rowData.get(8).text()));
            stageDetail.setStartTime(nullCheckUtils.timeNullCheck(rowData.get(9).text()));
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
        return nullCheckUtils.stringNullCheck(link.getElementsByTag("a").attr("onclick").replace("window.top.location = \"", "").replace("\"", "").trim());
    }

}