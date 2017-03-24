package com.lukegjpotter.spring.application.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.util.Constants;
import com.lukegjpotter.spring.application.util.UtilsService;

@Service
public class StageDetailsCsvReaderService {

    @Autowired UtilsService utils;
    
    @Value("${allroutelinkscsvfile.location}") private String csvFileLocation;
    private final String csvDelimiter = ",";

    public StageRouteMappingHolder readStageRouteFromCsvFile() {
        
        StageRouteMappingHolder mappingHolder = new StageRouteMappingHolder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(csvFileLocation));
            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(csvDelimiter);
                
                String eventName = strings[0].trim();
                Date startDate = utils.convertDDMMYYYYToDate(strings[1]);
                List<String> routeLinks = null;

                if (strings.length == 2) {
                    routeLinks = Arrays.asList("");
                } else {
                    routeLinks = getRouteUrlLinksList(strings[2]);
                }
                
                mappingHolder.putRouteUrlMapping(eventName, startDate, routeLinks);
            }

        } catch (IOException e) {
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {}
        }
        
        return mappingHolder;
    }

    /**
     * Transforms a string, separated by "|" into a {@code List<String>}, some strings will be have StageNumbers denoted on them, e.g. "1:" for stage one.
     * 
     * Examples of this are:
     *     "http://www.strava.com/routes/123" into ["http://www.strava.com/routes/123"]
     *     and 
     *     "1:http://www.strava.com/routes/123|2:http://www.strava.com/routes/456" into ["http://www.strava.com/routes/123", "http://www.strava.com/routes/456"]
     *     and
     *     "2:http://www.strava.com/routes/456|1:http://www.strava.com/routes/123" into ["http://www.strava.com/routes/123", "http://www.strava.com/routes/456"]
     *     etc.
     * 
     * @param string
     * @return string[]
     */
    private List<String> getRouteUrlLinksList(String string) {
        String[] strings = string.trim().split("\\|");

        if (strings.length == 1)
            return Arrays.asList(strings[0].trim());

        String[] routeUrls = new String[Constants.ARRAY_SIZE];

        for (int i = 0; i < strings.length; i++) {
            String[] numberedStages = determineNumberedStagesFromString(strings[i]);
            int stageNumber = Integer.parseInt(numberedStages[0]);
            routeUrls[stageNumber - 1] = numberedStages[1];
        }

        return padListWithEmptyStrings(Arrays.asList(routeUrls));
    }
    
    /**
     * Pads the {@code NULL} elements of the list with "", Empty Strings.
     * 
     * Example: ["link", null, "link"] will be ["link", "", "link"].
     * 
     * @param strings
     * @return
     */
    private List<String> padListWithEmptyStrings(List<String> strings) {
        int lastPositionOfStage = 0;
        
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i) == null) {
                strings.set(i, "");
            } else {
                lastPositionOfStage = i;
            }
        }

        return strings.subList(0, lastPositionOfStage+1);
    }

    /**
     * Converts "1:http://www.strava.com/routes/123" into ["1", "http://www.strava.com/routes/123"].
     * 
     * @param string in the format of "1:http://www.strava.com/routes/123"
     * @return string[] in the format of ["1", "http://www.strava.com/routes/123"]
     */
    private String[] determineNumberedStagesFromString(String string) {
        char delimiter = ':';
        String[] numberedStages = new String[2];
        
        for (int i = 0; i < string.length() - 1; i++) {
            
            if (string.charAt(i) == delimiter) {
                numberedStages[0] = string.substring(0, i).trim(); // Does't include the ":".
                numberedStages[1] = string.substring(++i).trim(); // Starts after the ":".
                return numberedStages;
            }
        }
        
        return numberedStages;
    }

    public void setCsvFileLocation(String csvFileLocation) {
        this.csvFileLocation = csvFileLocation;
    }
}
