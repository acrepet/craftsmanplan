package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;

import java.io.IOException;
import java.util.*;

public class ScheduleService {
    private Set<Appointment> appointmentList = new TreeSet<Appointment>(new Comparator<Appointment>() {
        @Override
        public int compare(Appointment app1, Appointment app2) {
            return app1.getBeginning().compareTo(app2.getBeginning()) ;
        }
    });

    public void addAppointment(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public int getNumberOfAppointments() {
        return appointmentList.size();
    }

    public StringBuilder print() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        for (Appointment appointment : appointmentList){
            stringBuilder.append(appointment.toString()).append("\n");
        }
        return stringBuilder;
    }
}
