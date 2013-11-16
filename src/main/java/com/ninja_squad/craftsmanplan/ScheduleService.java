package com.ninja_squad.craftsmanplan;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.ninja_squad.craftsmanplan.domain.Appointment;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.*;

public class ScheduleService {
    // the list of Appointment ordered by date beginning
    private List<Appointment> schedule = new LinkedList<Appointment>();

    public boolean addAppointment(Appointment newAppointment) {
        boolean insert = true;
        if (schedule.size() == 0) {
            schedule.add(newAppointment);
        } else {
            Appointment previous = null;
            Appointment next = null;

            int indexNewAppointment = findNextOf(newAppointment.getBeginning());
            if (indexNewAppointment == -1) {
                previous = schedule.get(schedule.size() - 1);
                indexNewAppointment = schedule.size();
            } else {
                next = schedule.get(indexNewAppointment);
                if (indexNewAppointment > 0) {
                    previous = schedule.get(indexNewAppointment - 1);
                }

            }

            if (insert && previous != null) {
                insert = isCompatible(previous, newAppointment);
            }
            if (insert && next != null) {
                insert = isCompatible(newAppointment, next);
            }
            if (insert) {
                schedule.add(indexNewAppointment, newAppointment);
            }

        }
        return insert;
    }

    private boolean isCompatible(Appointment first, Appointment second) {
        return first.getRealEnd().isBefore(second.getRealBeginning());
    }

    public int getNumberOfAppointments() {
        return schedule.size();
    }

    public StringBuilder print() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Appointment appointment : schedule) {
            stringBuilder.append(appointment.toString()).append(System.getProperty("line.separator"));
        }
        return stringBuilder;
    }

    private int findNextOf(final DateTime beginning) {
        return Iterables.indexOf(schedule, new Predicate<Appointment>() {
            @Override
            public boolean apply(Appointment input) {
                return beginning.isBefore(input.getBeginning());
            }
        });
    }
}
