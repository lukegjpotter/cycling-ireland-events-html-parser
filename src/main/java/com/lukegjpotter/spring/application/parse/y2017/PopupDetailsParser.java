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

    @Override public PopupDetails parse(Element popupElement) {
        
        PopupDetails popupDetails = new PopupDetails();
        
        popupDetails.setStartDate(extractPopupDate(popupElement));
        popupDetails.setProvince(extractProvince(popupElement));
        popupDetails.setCategory(extractCategory(popupElement));
        popupDetails.setPromotingClub(extractPromotingClub(popupElement));
        popupDetails.setOrganiserName(extractOrganiserName(popupElement));
        popupDetails.setOrganiserEmail(extractOrganiserEmail(popupElement));
        popupDetails.setOrganiserPhoneNumber(extractOrganiserPhoneNumber(popupElement));
        popupDetails.setMoreInfoUrl(extractMoreInfoURL(popupElement));
        
        return popupDetails;
    }

    private Date extractPopupDate(Element popupElement) {
        
        String dateStringRaw = popupElement.getElementById("event_date").text();
        int indexOfComma = dateStringRaw.indexOf(",") + 1;
        int indexOfSeperator = dateStringRaw.indexOf("|");
        
        String dateString = dateStringRaw.substring(indexOfComma, indexOfSeperator).trim();
        
        return utils.convertMMMMDDYYYYToDate(dateString);
    }
    
    public String extractProvince(Element popupElement) {
        return popupElement.getElementsByAttributeValue("href", "#location0").first().text().trim();
    }
    
    private String extractCategory(Element popupElement) {
        return popupElement.getElementById("cw_category_span").text().trim().replace("Category:  ", "");
    }
    
    private String extractPromotingClub(Element popupElement) {
        return popupElement.getElementsByAttributeValue("style", "word-wrap: break-word").first().text().trim();
    }
    
    private String extractOrganiserName(Element popupElement) {
        
        String contact = "Contact:", email = "Email:";
        
        String orgNameRaw = popupElement.getElementsContainingText(contact).first().text();
        int contactEndIndex = orgNameRaw.indexOf(contact) + contact.length();
        int emailIndex = orgNameRaw.indexOf(email);
        
        return orgNameRaw.substring(contactEndIndex, emailIndex).trim();
    }
    
    private String extractOrganiserEmail(Element popupElement) {
        return popupElement.getElementsByAttributeValueContaining("href", "mailto:").first().text().trim();
    }
    
    private String extractOrganiserPhoneNumber(Element popupElement) {

        String phone = "Phone:", moreInfo = "More Info:";
        
        String orgPhoneNumberRaw = popupElement.getElementsContainingText(phone).first().text();
        int phoneEndIndex = orgPhoneNumberRaw.indexOf(phone) + phone.length();
        int moreInfoIndex = orgPhoneNumberRaw.indexOf(moreInfo);
        
        orgPhoneNumberRaw = orgPhoneNumberRaw.substring(phoneEndIndex, moreInfoIndex).trim();
        
        return phoneNumberUtils.formatPhoneNumber(orgPhoneNumberRaw);
    }
    
    private URL extractMoreInfoURL(Element popupElement) {
        
        String url = popupElement.getElementsByAttributeValue("onclick", "openmoreinfo(); return false;").first().text().trim();
        
        try {
            return new URL(url);
        } catch (MalformedURLException e) { e.printStackTrace(); }
        
        return null;
    }
}
