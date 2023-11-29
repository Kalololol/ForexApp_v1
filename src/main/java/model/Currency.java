package model;

import java.time.LocalDate;
import java.util.Date;

public class Currency {
    private final LocalDate date;
    private final String code;
    private final double mid;
    public Currency(LocalDate date, String code, double mid) {
        this.date = date;
        this.code = code;
        this.mid = mid;
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