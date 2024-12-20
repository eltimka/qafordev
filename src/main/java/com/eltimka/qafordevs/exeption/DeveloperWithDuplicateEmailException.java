package com.eltimka.qafordevs.exeption;

public class DeveloperWithDuplicateEmailException extends RuntimeException{

    public DeveloperWithDuplicateEmailException(String message) {
        super(message);
    }
}
