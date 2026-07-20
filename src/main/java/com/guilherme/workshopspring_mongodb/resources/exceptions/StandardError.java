package com.guilherme.workshopspring_mongodb.resources.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {

    public Instant timestamp;
    public HttpStatus status;
    public String error;
    public String path;

    public StandardError(){

    }

    public StandardError(Instant timestamp, HttpStatus status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
