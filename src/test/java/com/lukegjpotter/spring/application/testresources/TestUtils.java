package com.lukegjpotter.spring.application.testresources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUtils {

    @Autowired TestResources tr;

    public String headerRawHtml() {
        try {
            return new String(Files.readAllBytes(Paths.get(tr.getOneDayRaceHeaderFileName()))).replace("\n", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String descriptionRawHtml() {
        try {
            return new String(Files.readAllBytes(Paths.get(tr.getOneDayRaceDescriptionFileName()))).replace("\n", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

}
