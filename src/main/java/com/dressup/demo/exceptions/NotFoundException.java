package com.dressup.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Simple 404 error exception
 * @author Alexander Ferenets (aka Istamendil) – http://istamendil.info
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    /**
     * Default entity that has not been found. Could be page, account, product etc
     */
    protected String entity = "page";

    public NotFoundException() {
        super();
    }

    public NotFoundException(String entity) {
        super();
        this.entity = entity;
    }

    public String getEntity(){
        return entity;
    }
}