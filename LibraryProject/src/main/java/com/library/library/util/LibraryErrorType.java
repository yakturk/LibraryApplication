package com.library.library.util;

/*
it is used to send custom error message
 */
public class LibraryErrorType {
    private String errorMessage;

    public LibraryErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
