package com.lukegjpotter.spring.application.parse.y2017;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lukegjpotter.spring.application.model.PopupDetails;
import com.lukegjpotter.spring.application.parse.Parsable;
import com.lukegjpotter.spring.application.util.PhoneNumberUtilsService;
import com.lukegjpotter.spring.application.util.UtilsService;

/**
 * Extracts the Date, Time, Province, Category, Promoting Club, Contact
 * Person's Information and the More Info Link from the Popup;
 * 
 * @author lukegjpotter - Luke GJ Potter
 */
@Component
class PopupDetailsParser implements Parsable<Element, PopupDetails> {
    
    @Autowired UtilsService utils;
    @Autowired PhoneNumberUtilsService phoneNumberUtils;

    @Override public PopupDetails parse(Element htmlElementToParse) {
        
        PopupDetails popupDetails = new PopupDetails();
        
        popupDetails.setStartDate(extractPopupDate(htmlElementToParse));
        popupDetails.setProvince(extractProvince(htmlElementToParse));
        popupDetails.setCategory(extractCategory(htmlElementToParse));
        popupDetails.setPromotingClub(extractPromotingClub(htmlElementToParse));
        popupDetails.setOrganiserName(extractOrganiserName(htmlElementToParse));
        popupDetails.setOrganiserEmail(extractOrganiserEmail(htmlElementToParse));
        popupDetails.setOrganiserPhoneNumber(extractOrganiserPhoneNumber(htmlElementToParse));
        popupDetails.setMoreInfoUrl(extractMoreInfoURL(htmlElementToParse));
        
        return popupDetails;
    }

    private Date extractPopupDate(Element element) {
        
        String rawDateString = element.getElementById("event_date").text();
        int indexOfSeperator = rawDateString.indexOf("|");
        int indexOfComma = rawDateString.indexOf(",") + 1;
        String dateString = rawDateString.substring(indexOfComma, indexOfSeperator).trim();
        
        return utils.convertMMMMDDYYYYToDate(dateString);
    }
    
    public String extractProvince(Element htmlElementToParse) {
        return htmlElementToParse.getElementsByAttributeValue("href", "#location0").first().text().trim();
    }
    
    private String extractCategory(Element htmlElementToParse) {

        return htmlElementToParse.getElementById("cw_category_span").text().trim().replace("Category:  ", "");
    }
    
    private String extractPromotingClub(Element htmlElementToParse) {
        return htmlElementToParse.getElementsByAttributeValue("style", "word-wrap: break-word").first().text().trim();
    }
    
    private String extractOrganiserName(Element htmlElementToParse) {
        
        String contact = "Contact:", email = "Email:";
        
        String orgNameRaw = htmlElementToParse.getElementsContainingText(contact).first().text();
        int contactEndIndex = orgNameRaw.indexOf(contact) + contact.length();
        int emailIndex = orgNameRaw.indexOf(email);
        
        return orgNameRaw.substring(contactEndIndex, emailIndex).trim();
    }
    
    private String extractOrganiserEmail(Element htmlElementToParse) {
        return htmlElementToParse.getElementsByAttributeValueContaining("href", "mailto:").first().text().trim();
    }
    
    private String extractOrganiserPhoneNumber(Element htmlElementToParse) {

        String phone = "Phone:", moreInfo = "More Info:";
        
        String orgPhoneNumberRaw = htmlElementToParse.getElementsContainingText(phone).first().text();
        int phoneEndIndex = orgPhoneNumberRaw.indexOf(phone) + phone.length();
        int moreInfoIndex = orgPhoneNumberRaw.indexOf(moreInfo);
        
        orgPhoneNumberRaw = orgPhoneNumberRaw.substring(phoneEndIndex, moreInfoIndex).trim();
        String phoneNumber = phoneNumberUtils.formatPhoneNumber(orgPhoneNumberRaw);
        
        return phoneNumber;
    }
    
    private URL extractMoreInfoURL(Element htmlElementToParse) {
        
        String url = htmlElementToParse.getElementsByAttributeValue("onclick", "openmoreinfo(); return false;").first().text().trim();
        
        try {
            return new URL(url);
        } catch (MalformedURLException e) { e.printStackTrace(); }
        
        return null;
    }
}
