package com.ninja_squad.craftsmanplan.domain;

import org.joda.time.DateTime;
import org.joda.time.Duration;


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

    public Appointment(String city, Duration travelDuration, String customer, DateTime beginning, DateTime end) {
        this.city = city;
        this.travelduration = travelDuration;
        this.customer = customer;
        this.beginning = beginning;
        this.end = end;
    }

    public Appointment(String city, String customer, DateTime beginning) {
        this.city = city;
        this.customer = customer;
        this.beginning = beginning;
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
        return customer + " " + city + " " + beginning;
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
