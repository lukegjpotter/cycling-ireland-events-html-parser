package com.lukegjpotter.spring.application.parse.y2017;

import com.lukegjpotter.spring.application.model.StageDetail;
import com.lukegjpotter.spring.application.parse.Parsable;
import com.lukegjpotter.spring.application.util.NullCheckUtilsService;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
class StageDetailsParser implements Parsable<Element, List<StageDetail>> {
    
    @Autowired private UtilsService utils;
    @Autowired private NullCheckUtilsService nullCheckUtils;

    @Override public List<StageDetail> parse(Element htmlToParse) {
        
        List<StageDetail> stageDetails = new ArrayList<>();

        htmlToParse.getElementsByClass("az-lite-grid-table-row").forEach((Element tableRow) -> {

            Elements rowData = tableRow.getElementsByTag("td");
            
            StageDetail stageDetail = new StageDetail();
            stageDetail.setDate(utils.convertDDMMMYYYYToDate(rowData.get(0).text().trim()));
            stageDetail.setStartTime(nullCheckUtils.timeNullCheck(rowData.get(1).text()));
            stageDetail.setStageName(nullCheckUtils.stringNullCheck(rowData.get(2).text()));
            stageDetail.setKilometers(nullCheckUtils.doubleNullCheck(rowData.get(3).text()));
            stageDetail.setCategory(nullCheckUtils.stringNullCheck(rowData.get(4).text()));
            stageDetail.setRaceType(nullCheckUtils.stringNullCheck(rowData.get(5).text()));
            stageDetail.setVenue(nullCheckUtils.stringNullCheck(rowData.get(6).text()));

            //stageDetail.setRaceNumber(nullCheckUtils.integerNullCheck(rowData.get(1).text()));
            //stageDetail.setStageNumber(nullCheckUtils.stringNullCheck(rowData.get(2).text()));
            //stageDetail.setMiles(nullCheckUtils.doubleNullCheck(rowData.get(5).text()));
            //stageDetail.setSignOnTime(nullCheckUtils.timeNullCheck(rowData.get(7).text()));
            //stageDetail.setRouteLinkUrl(parseRouteLinkUrl(rowData.get(9)));
            
            stageDetails.add(stageDetail);
        });
        
        return stageDetails;
    }

    public String parseAddress(Element htmlToParse) {
        return htmlToParse.getElementById("h4Address").text().trim();
    }
    
    private String parseRouteLinkUrl(Element link) {

        return nullCheckUtils.stringNullCheck(link
                .getElementsByTag("a")
                .attr("onclick")
                .replace("window.top.location = \"", "")
                .replace("\"", "")
                .trim());
    }
}