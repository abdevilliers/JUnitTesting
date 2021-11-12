package com.christy.Junit.exceptions;

public class RecordNotFoundException extends Exception{
    public RecordNotFoundException() {
        super("Not Records present with the given bookid");
    }

}
