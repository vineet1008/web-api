package com.vineet.web_api.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exception_log")
public class ExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exception_name", nullable = false)
    private String exceptionName;

    @Column(name = "message", length = 1000)
    private String message;

    @Column(name = "path")
    private String path;

    @Column(name = "status_code")
    private int statusCode;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "ip_address")
    private String ipAddress;

    public ExceptionLog() {}

    public ExceptionLog(String exceptionName, String message, String path, int statusCode, LocalDateTime timestamp, String ipAddress) {
        this.exceptionName = exceptionName;
        this.message = message;
        this.path = path;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.ipAddress = ipAddress;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getExceptionName() { return exceptionName; }
    public void setExceptionName(String exceptionName) { this.exceptionName = exceptionName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}