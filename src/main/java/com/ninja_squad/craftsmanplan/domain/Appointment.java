package com.ninja_squad.craftsmanplan.domain;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * An Appointment for a craftsman
 * User: agnes007
 * Date: 11/10/13
 */
public class Appointment {
    private DateTime beginning;
    private DateTime end;
    private Duration travelduration;
    private int travelkm;
    private String city;
    private String customer;
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    public Appointment(String city, Duration travelDuration, String customer, String beginning, String end, int travelkm) {
        this.city = city;
        this.travelduration = travelDuration;
        this.customer = customer;
        this.beginning = dateTimeFormatter.parseDateTime(beginning);
        this.end = dateTimeFormatter.parseDateTime(end);
        this.travelkm = travelkm;
    }


    public DateTime getBeginning() {
        return beginning;
    }
    public DateTime getRealBeginning() {
        return beginning.minus(getTravelduration());
    }


    public DateTime getRealEnd() {
        return end.plus(getTravelduration());
    }


    public Duration getTravelduration() {
        return travelduration;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public int getTravelkm() {
        return travelkm;
    }

    public void setTravelkm(int travelkm) {
        this.travelkm = travelkm;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer + " " + city + " " + beginning.toString(dateTimeFormatter);
    }

}
