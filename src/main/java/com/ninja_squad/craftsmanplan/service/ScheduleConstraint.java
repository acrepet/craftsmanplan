package com.ninja_squad.craftsmanplan.service;

import com.ninja_squad.craftsmanplan.domain.Appointment;

import java.util.List;

/**
 * Constraint to add an appointment in a schedule
 * User: agnes007
 * Date: 11/17/13
 */
public interface ScheduleConstraint {

    /**
     * check the condition on the proposedAppointment and the schedule
     * @param proposedAppointment
     * @param schedule
     * @throws ConstraintException if the condition is not satisfied
     */
    public void check(Appointment proposedAppointment, List<Appointment> schedule) throws ConstraintException;
}
