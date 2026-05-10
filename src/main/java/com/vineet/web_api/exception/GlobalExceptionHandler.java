package com.vineet.web_api.exception;

import com.vineet.web_api.dao.ExceptionLogRepository;
import com.vineet.web_api.entity.ExceptionLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionLogRepository exceptionLogRepository;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception ex, HttpServletRequest request) {
        ExceptionLog log = new ExceptionLog(
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                request.getRequestURI(),
                500,
                LocalDateTime.now(),
                request.getRemoteAddr()
        );

        exceptionLogRepository.save(log);
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        System.out.println(log.toString());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        ExceptionLog log = new ExceptionLog(
                ex.getClass().getSimpleName(),
                ex.getMessage(),
                request.getRequestURI(),
                500,
                LocalDateTime.now(),
                request.getRemoteAddr()
        );

        exceptionLogRepository.save(log);
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.BAD_REQUEST.value());
        System.out.println(log.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}