package com.ninja_squad.craftsmanplan.service;

import com.ninja_squad.craftsmanplan.domain.Appointment;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.List;

/**
 * the appointment must not start before a specific hour
 * User: agnes007
 * Date: 11/17/13
 */
public class EarlyBeginingForbiddenScheduleConstraint implements ScheduleConstraint{

    private final static LocalTime EARLYHOUR = new LocalTime(8,0);

    public void check(Appointment proposedAppointment, List<Appointment> schedule) throws ConstraintException{
        LocalTime localTime = proposedAppointment.getRealBeginning().toLocalTime();
        if (localTime.isBefore(EARLYHOUR))  {
            throw new ConstraintException("Je ne démarre pas ma journée avant 8H!");
        }
    }
}
