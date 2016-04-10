package com.lukegjpotter.spring.application.parse;

public interface Parsable<T> {
    
    public T parse(String htmlToParse);
}
