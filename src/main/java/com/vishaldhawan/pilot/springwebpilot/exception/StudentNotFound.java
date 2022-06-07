package com.vishaldhawan.pilot.springwebpilot.exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound(String message) {
        super(message);
    }
}
