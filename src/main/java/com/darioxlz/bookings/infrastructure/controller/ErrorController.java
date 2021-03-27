package com.darioxlz.bookings.infrastructure.controller;

import com.darioxlz.bookings.application.ApplicationException;
import com.darioxlz.bookings.application.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorController {
    private ErrorDTO errorDTO;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> exceptionHandler(HttpServletRequest request, Exception e) {
        errorDTO = new ErrorDTO();
        errorDTO.setCode(10);
        errorDTO.setMessage(e.getMessage());
        errorDTO.setUrl(request.getRequestURI());

        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorDTO> exceptionApplicationHandler(HttpServletRequest request, MissingServletRequestParameterException e) {
        errorDTO = new ErrorDTO();
        errorDTO.setCode(11);
        errorDTO.setMessage(e.getMessage());

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

//        StringBuilder errorMessage = new StringBuilder();
//
//        fieldErrors.forEach(field -> errorMessage.append(field.getField() + " " + field.getDefaultMessage() + " "));

        List<ErrorDTO> validationErrors = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            errorDTO = new ErrorDTO();
            errorDTO.setCode(12);
            errorDTO.setMessage(fieldError.getDefaultMessage());
            errorDTO.setUrl(request.getRequestURI());
            validationErrors.add(errorDTO);
        }

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorDTO> applicationExceptionHandler(HttpServletRequest request, ApplicationException e) {
        errorDTO = new ErrorDTO();
        errorDTO.setCode(13);
        errorDTO.setMessage(e.getMessage());
        errorDTO.setUrl(request.getRequestURI());

        return new ResponseEntity<>(errorDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
