package com.lukegjpotter.spring.application.parse;

public class ParserFactory {

    public static Parser getPageOneParser(String pageLocation) {
        return new PageOneParser(pageLocation);
    }
}
