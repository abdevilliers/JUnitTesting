package com.christy.Junit.exceptions;

public class TitleNotFoundException extends Exception {
    public TitleNotFoundException(){
        super("No records present with given title");
    }
}
