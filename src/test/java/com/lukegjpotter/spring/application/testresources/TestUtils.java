package com.lukegjpotter.spring.application.testresources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

    @Autowired RoadRaceEventTestResources rretr;

    public String roadRaceHeaderRawHtml() {

        try {
            return new String(Files.readAllBytes(Paths.get(rretr.getOneDayRaceHeaderFileName()))).replace("\n", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
