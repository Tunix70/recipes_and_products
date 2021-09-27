package com.syncretis.recipes_and_products.handler;

import com.syncretis.recipes_and_products.exception.UnsupportedUnitException;
import com.syncretis.recipes_and_products.exception.UserGoalNotFountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionsHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String missingServletHandler(MissingServletRequestParameterException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UnsupportedUnitException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String unsupportedUnitHandler(UnsupportedUnitException e) {
        return e.getMessage();
    }

    @ExceptionHandler(UserGoalNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String goalNotFoundHandler(UserGoalNotFountException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<String> invalidWeightHandler(ConstraintViolationException e) {
        return e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String mainHandler(Exception e) {
        LOGGER.error(e.getMessage(), e);
        return "Internal server error. Contact the administrator.";
    }
}