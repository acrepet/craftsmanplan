package com.ninja_squad.craftsmanplan.service;

import com.ninja_squad.craftsmanplan.domain.Appointment;

import java.util.List;

/**
 * DistanceMaxScheduleConstraint for the schedule : all the appointments of the schedule have a limit on their travel distance (km)
 * User: agnes007
 * Date: 11/17/13
 */
public class DistanceMaxScheduleConstraint implements ScheduleConstraint{

    private final static int NBKMMAX = 80;

    public void check(Appointment proposedAppointment, List<Appointment> schedule) throws ConstraintException{
         // compute the sum of the km of all the travels
        int sum = 0;
        for (Appointment app : schedule){
           sum += app.getTravelkm();
        }
        sum += proposedAppointment.getTravelkm();
        if (sum > NBKMMAX)  {
            throw new ConstraintException("attention limite de KM max atteinte!");
        }
    }
}
