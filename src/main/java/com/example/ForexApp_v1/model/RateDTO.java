package com.example.ForexApp_v1.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import java.util.Date;

public class RateDTO {

    @JsonProperty("no")
    private String tableIDNumber;
    @JsonProperty("effectiveDate")
    private String effectiveDate;
    @JsonProperty("mid")
    private double mid;
    public RateDTO(){}
    public RateDTO(String tableIDNumber, String effectiveDate, double mid) {
        this.tableIDNumber = tableIDNumber;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }
    public String getTableIDNumber() {
        return tableIDNumber;
    }
    public String getEffectiveDate() {
        return effectiveDate;
    }
    public double getMid() {
        return mid;
    }

}
