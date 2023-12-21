package com.example.ForexApp_v1.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Table(name = "Currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final LocalDate date;
    private final String code;
    private final double mid;
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