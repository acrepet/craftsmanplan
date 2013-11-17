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
    private String city;
    private String customer;
    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");

    public Appointment(String city, Duration travelDuration, String customer, String beginning, String end) {
        this.city = city;
        this.travelduration = travelDuration;
        this.customer = customer;
        this.beginning = dateTimeFormatter.parseDateTime(beginning);
        this.end = dateTimeFormatter.parseDateTime(end);
    }


    public DateTime getBeginning() {
        return beginning;
    }
    public DateTime getRealBeginning() {
        return beginning.minus(getTravelduration());
    }

    public void setBeginning(DateTime beginning) {
        this.beginning = beginning;
    }


    public DateTime getEnd() {
        return end;
    }

    public DateTime getRealEnd() {
        return end.plus(getTravelduration());
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Duration getTravelduration() {
        return travelduration;
    }

    public void setTravelduration(Duration travelDuration) {
        this.travelduration = travelDuration;
    }

    @Override
    public String toString() {
        return customer + " " + city + " " + beginning.toString(dateTimeFormatter);
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
}
