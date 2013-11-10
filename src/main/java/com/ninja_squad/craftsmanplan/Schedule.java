package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;

import java.io.IOException;
import java.util.*;

public class Schedule {
    private List<Appointment> appointmentList = new LinkedList<Appointment>();

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
