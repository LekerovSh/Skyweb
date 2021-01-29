package com.java.skywebtz.dto;

import java.time.LocalTime;

public class AdminDTO {
    private Long value;
    private String message;
    private Long time;

    public AdminDTO(Long value, String message, Long time) {
        this.value = value;
        this.message = message;
        this.time = time;
    }


    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
