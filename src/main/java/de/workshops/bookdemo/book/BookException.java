package de.workshops.bookdemo.book;

import lombok.Getter;

@Getter
public class BookException extends Exception {
    
    public  BookException(String errorCode) {
        this.errorCode = errorCode;
    }

    private String errorCode;
    private String errorParam;
}
