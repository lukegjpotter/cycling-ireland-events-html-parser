package com.lukegjpotter.spring.application.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlMonthService {
    
    @Value("${url.basic}") private String urlBasicWithPlaceholders;

    public List<String> compileUrlsForRemainYearMonths() {
        
        List<String> urls = new ArrayList<>();
        
        int currentMonthNumber = Calendar.getInstance().get(Calendar.MONTH) + 1;
        int maxMonthNumber = 12;
        int currentYear = 2017;
        
        while (currentMonthNumber <= maxMonthNumber) {
            
            String formattedUrl = String.format(urlBasicWithPlaceholders, currentMonthNumber, currentYear);
            urls.add(formattedUrl);
            
            currentMonthNumber++;
        }
        
        return urls;
    }

}
