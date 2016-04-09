package com.lukegjpotter.spring.application.parse;

public interface Parser<T> {
    
    public T parse(String htmlToParse);
}
