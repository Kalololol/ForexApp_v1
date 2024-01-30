package com.example.ForexApp_v1.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "Currency")
@Entity
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String code;
    private double mid;
    public Currency(){}
    public Currency(LocalDate date, String code, double mid) {
        this.date = date;
        this.code = code;
        this.mid = mid;
    }
    public Long getId(){
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getCode() {
        return code;
    }
    public double getMid() {
        return mid;
    }
}