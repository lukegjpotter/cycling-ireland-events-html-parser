package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class Description {

    private Date bookingsOpenDate, bookingsCloseDate;
    private String organiserPhoneNumber, organiserEmail, location, province;
    
    public Description() {
        setProvince("");
    }

    public Date getBookingsOpenDate() {
        return bookingsOpenDate;
    }

    public void setBookingsOpenDate(Date bookingsOpenDate) {
        this.bookingsOpenDate = bookingsOpenDate;
    }

    public Date getBookingsCloseDate() {
        return bookingsCloseDate;
    }

    public void setBookingsCloseDate(Date bookingsCloseDate) {
        this.bookingsCloseDate = bookingsCloseDate;
    }

    public String getOrganiserPhoneNumber() {
        return organiserPhoneNumber;
    }

    public void setOrganiserPhoneNumber(String organiserPhoneNumber) {
        this.organiserPhoneNumber = organiserPhoneNumber;
    }

    public String getOrganiserEmail() {
        return organiserEmail;
    }

    public void setOrganiserEmail(String organiserEmail) {
        this.organiserEmail = organiserEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override public boolean equals(Object obj) {
        
        if (obj instanceof Description) {
            Description other = (Description) obj;
            
            if (performNullEqualsChecks(this, other))
                return true;
            
            return this.getBookingsOpenDate().equals(other.getBookingsOpenDate())
                    && this.getBookingsCloseDate().equals(other.getBookingsCloseDate())
                    && this.getOrganiserPhoneNumber().equals(other.getOrganiserPhoneNumber())
                    && this.getOrganiserEmail().equals(other.getOrganiserEmail())
                    && this.getLocation().equals(other.getLocation())
                    && this.getProvince().equals(other.getProvince());
        }
        
        return false;
    }
    
    private boolean performNullEqualsChecks(Description desc, Description other) {

        return desc.getBookingsOpenDate() == other.getBookingsOpenDate()
                && desc.getBookingsCloseDate() == other.getBookingsCloseDate()
                && desc.getOrganiserPhoneNumber() == other.getOrganiserPhoneNumber()
                && desc.getOrganiserEmail() == other.getOrganiserEmail()
                && desc.getLocation() == other.getLocation()
                && desc.getProvince() == other.getProvince();
    }
}
