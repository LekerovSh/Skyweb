package com.java.skywebtz.models;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "LONGS")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long value;
    private String message;
    private Long time;

    public AdminModel(Long value, String message, Long time) {
        this.value = value;
        this.message = message;
        this.time = time;
    }

    public AdminModel() {
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
