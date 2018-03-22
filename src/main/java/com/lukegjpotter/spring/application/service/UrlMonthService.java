package com.lukegjpotter.spring.application.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class UrlMonthService {
    
    @Value("${url.basic}") private String urlBasicWithPlaceholders;

    public List<String> compileUrlsForRemainingYearMonths() {
        
        List<String> urls = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        int currentMonthNumber = calendar.get(Calendar.MONTH) + 1;
        int currentYear = calendar.get(Calendar.YEAR);
        int maxMonthNumber = 12;

        while (currentMonthNumber <= maxMonthNumber) {
            
            String formattedUrl = String.format(urlBasicWithPlaceholders, currentMonthNumber, currentYear);
            urls.add(formattedUrl);
            
            currentMonthNumber++;
        }
        
        return urls;
    }

}
