package com.polarmushroom.domain.booking;

public class Booking {
    private Long customerId;
    private int time;
    private Days days;

    public Booking(Long customerId, int time, Days days) {
        this.customerId = customerId;
        this.time = time;
        this.days = days;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }
}
