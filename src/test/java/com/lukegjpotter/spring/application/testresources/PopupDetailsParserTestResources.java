package com.lukegjpotter.spring.application.testresources;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class PopupDetailsParserTestResources {

    @Autowired
    private UtilsService utils;

    public Element popupElement() {
        return getJsoupElementFromPopup("src/test/resources/20180805-Popup-OldcastleGP.html");
    }

    public PopupDetails popupDetails() {
        URL moreInfoUrl = null;
        try {
            moreInfoUrl = new URL("https://cyclingireland.azolve.com/Workbench.mvc/public/eventDetails?EventId=1077385");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        PopupDetails popupDetails = new PopupDetails();
        popupDetails.setStartDate(utils.convertMMMDDYYYYToDate("Aug 5, 2018"));
        popupDetails.setProvince("Leinster");
        popupDetails.setPromotingClub("Oldcastle CC");
        popupDetails.setOrganiserName("Brian Sherry");
        popupDetails.setOrganiserPhoneNumber("+353874686123");
        popupDetails.setOrganiserEmail("oldcastlecc@gmail.com");
        popupDetails.setCategory("Road");
        popupDetails.setMoreInfoUrl(moreInfoUrl);

        return popupDetails;
    }

    public Element popupElementNoOrganiserEmail() {
        return getJsoupElementFromPopup("src/test/resources/20170701-Popup-BolivarGP-NoOrgEmail.html");
    }

    private Element getJsoupElementFromPopup(String fileName) {

        try {
            return Jsoup.parse(new File(fileName), Constants.FILE_FORMAT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
