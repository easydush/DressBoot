package com.dressup.demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView notFound(HttpServletRequest req, Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("errors/500");
        log.error(exception.getMessage());
        return mav;
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<Object> exception(ConstraintViolationException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(exception.getCause().getMessage(), HttpStatus.CONFLICT);
    }

   
    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFoundException(HttpServletRequest request, Exception exception) {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", exception.getMessage());
        model.addObject("url", request.getRequestURI());
        model.setViewName("errors/404");
        log.error(exception.getMessage());
        return model;
    }

    @ExceptionHandler(value = UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView usernameNotFoundException(HttpServletRequest request, Exception exception) {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", exception.getMessage());
        model.addObject("url", request.getRequestURI());
        model.setViewName("errors/404");
        log.error(exception.getMessage());
        return model;
    }
}