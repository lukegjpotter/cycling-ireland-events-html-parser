package com.lukegjpotter.spring.application.service;

import com.lukegjpotter.spring.application.model.StageRouteMappingHolder;
import com.lukegjpotter.spring.application.util.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
// TODO: This should be a Builder Pattern, load the file location in the builder and then return the built service ready to act.
public class StageDetailsCsvReaderService {

    @Autowired UtilsService utils;

    @Value("${allroutelinkscsvfilepath}")
    private String csvFileLocation;

    public StageRouteMappingHolder readStageRouteFromCsvFile() {
        
        StageRouteMappingHolder mappingHolder = new StageRouteMappingHolder();

        // TODO: Try to replace with Files API.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFileLocation))) {
            String line, csvDelimiter = ",";

            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(csvDelimiter);
                
                Long eventId = Long.valueOf(strings[0].trim());
                List<String> routeLinks;

                if (strings.length == 1) {
                    routeLinks = Collections.singletonList("");
                } else {
                    routeLinks = getRouteUrlLinksList(strings[1]);
                }
                
                mappingHolder.putRouteUrlMapping(eventId, routeLinks);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
     * @param pipeSeparatedStageNumberAndRouteUrlString String looking like "2:http://www.strava.com/routes/456|1:http://www.strava.com/routes/123"
     * @return string[]
     */
    private List<String> getRouteUrlLinksList(String pipeSeparatedStageNumberAndRouteUrlString) {

        String[] stageNumberAndRouteUrlStrings = pipeSeparatedStageNumberAndRouteUrlString.trim().split("\\|");

        if (stageNumberAndRouteUrlStrings.length == 1)
            return Collections.singletonList(stageNumberAndRouteUrlStrings[0].trim());

        List<String> routeUrls = new ArrayList<>();

        for (String stageNumberAndRouteUrlString : stageNumberAndRouteUrlStrings) {
            String[] numberedStages = determineNumberedStagesFromString(stageNumberAndRouteUrlString);
            int stageNumber = Integer.parseInt(numberedStages[0]);
            routeUrls.add(stageNumber - 1, numberedStages[1]);
        }

        return routeUrls;
    }

    /**
     * Converts "1:http://www.strava.com/routes/123" into ["1", "http://www.strava.com/routes/123"].
     *
     * @param stageNumberAndRouteUrlString in the format of "1:http://www.strava.com/routes/123"
     * @return string[] in the format of ["1", "http://www.strava.com/routes/123"]
     */
    private String[] determineNumberedStagesFromString(String stageNumberAndRouteUrlString) {
        char colonDelimiter = ':';
        String[] numberedStages = new String[2];

        for (int i = 0; i < stageNumberAndRouteUrlString.length() - 1; i++) {

            if (stageNumberAndRouteUrlString.charAt(i) == colonDelimiter) {
                numberedStages[0] = stageNumberAndRouteUrlString.substring(0, i).trim(); // Does't include the ":".
                numberedStages[1] = stageNumberAndRouteUrlString.substring(++i).trim(); // Starts after the ":".

                return numberedStages;
            }
        }
        
        return numberedStages;
    }

    public void setCsvFileLocation(String csvFileLocation) {
        this.csvFileLocation = csvFileLocation;
    }
}
