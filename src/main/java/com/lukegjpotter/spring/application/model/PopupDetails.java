package com.lukegjpotter.spring.application.model;

import java.net.URL;
import java.util.Date;

public class PopupDetails {

    private Date startDate;
    private String province, category, promotingClub, organiserName, organiserEmail, organiserPhoneNumber;
    private URL moreInfoUrl;
    
    public PopupDetails() {}

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPromotingClub() {
        return promotingClub;
    }

    public void setPromotingClub(String promotingClub) {
        this.promotingClub = promotingClub;
    }

    public String getOrganiserName() {
        return organiserName;
    }

    public void setOrganiserName(String organiserName) {
        this.organiserName = organiserName;
    }

    public String getOrganiserEmail() {
        return organiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        this.organiserEmail = organiserEmail;
    }

    public String getOrganiserPhoneNumber() {
        return organiserPhoneNumber;
    }

    public void setOrganiserPhoneNumber(String organiserPhoneNumber) {
        this.organiserPhoneNumber = organiserPhoneNumber;
    }

    public URL getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(URL moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
    }
}
