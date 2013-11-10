package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;

import java.io.IOException;
import java.util.*;

public class Schedule {
    private Set<Appointment> appointmentList = new TreeSet<Appointment>(new Comparator<Appointment>() {
        @Override
        public int compare(Appointment app1, Appointment app2) {
            if (app1.getBeginning().isBefore(app2.getBeginning()))
                return -1;
            if (app2.getBeginning().isBefore(app1.getBeginning()))
                return 1;
            return 0;
        }
    });

    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public StringBuilder print() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Appointment appointment : appointmentList){
            stringBuilder.append(appointment.toString()).append("\n");
        }
        return stringBuilder;
    }
}
