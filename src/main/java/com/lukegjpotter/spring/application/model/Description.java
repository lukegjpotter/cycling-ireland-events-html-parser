package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class Description {

    private Date bookingsOpenDate, bookingsCloseDate;
    private String organiserPhoneNumber, organiserEmail, location, province;
    
    public Description() {
        setBookingsOpenDate(new Date(0L));
        setBookingsCloseDate(new Date(0L));
        setOrganiserPhoneNumber("");
        setOrganiserEmail("");
        setLocation("");
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
            
            return this.getBookingsOpenDate().equals(other.getBookingsOpenDate())
                    && this.getBookingsCloseDate().equals(other.getBookingsCloseDate())
                    && this.getOrganiserPhoneNumber().equals(other.getOrganiserPhoneNumber())
                    && this.getOrganiserEmail().equals(other.getOrganiserEmail())
                    && this.getLocation().equals(other.getLocation())
                    && this.getProvince().equals(other.getProvince());
        }
        
        return false;
    }
    
}
