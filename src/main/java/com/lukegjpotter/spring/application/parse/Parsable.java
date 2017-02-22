package com.lukegjpotter.spring.application.parse;

public interface Parsable<Input, Output> {
    
    public Output parse(Input htmlToParse);
}
