package com.lukegjpotter.spring.application.model;

import java.util.Date;

public class DayDateTimeModel {
    
    private String day, time;
    private Date date;
    
    public DayDateTimeModel(String day, Date date, String time) {
        setDay(day);
        setDate(date);
        setTime(time);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
