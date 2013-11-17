package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;
import com.ninja_squad.craftsmanplan.service.ConstraintException;
import com.ninja_squad.craftsmanplan.service.DistanceMaxScheduleConstraint;
import com.ninja_squad.craftsmanplan.service.EarlyBeginingForbiddenScheduleConstraint;
import com.ninja_squad.craftsmanplan.service.ScheduleService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ScheduleStepdefs {
    private ScheduleService scheduleService = new ScheduleService();
    private StringBuilder schedulePrinted = new StringBuilder();
    private List<Appointment> proposedAppointments = new ArrayList<Appointment>();


    @Given("^an appointments list:$")
    public void an_appointments_list(List<AppointmentItem> items) throws Throwable {
        for (AppointmentItem item : items) {
            Appointment app = createAppointment(item);
            scheduleService.addAppointment(app);
        }
    }

    @Given(value = "^a new proposal for appointment:$")
    public void a_new_proposal_for_appointment(List<AppointmentItem> items) throws Throwable {
        for (AppointmentItem item : items) {
            Appointment app = createAppointment(item);
            proposedAppointments.add(app);
        }
    }

    @When("^I want to check my availability schedule to confirm the new proposal for appointment$")
    public void I_want_to_check_my_availability_schedule_and_print_it() throws Throwable {
        for (Appointment proposedAppointment : proposedAppointments) {
            scheduleService.addAppointment(proposedAppointment);
        }
        schedulePrinted = scheduleService.print();
    }

    @When("^I want to check my availability schedule to confirm the new proposal with a distance$")
    public void I_want_to_check_my_availability_schedule_and_print_it_distance_max() throws Throwable {
        scheduleService.addScheduleConstraint(new DistanceMaxScheduleConstraint());
        for (Appointment proposedAppointment : proposedAppointments) {
            try{
                scheduleService.addAppointment(proposedAppointment);
            }
            catch (ConstraintException e){
                e.getMessage() ;
            }
        }
        schedulePrinted = scheduleService.print();
    }

    @When("^I want to check my availability schedule to confirm the new proposal with a limit about beginning time$")
    public void I_want_to_check_my_availability_schedule_and_print_it_limit_beginning_time() throws Throwable {
        scheduleService.addScheduleConstraint(new EarlyBeginingForbiddenScheduleConstraint());
        for (Appointment proposedAppointment : proposedAppointments) {
            try{
                scheduleService.addAppointment(proposedAppointment);
            }
            catch (ConstraintException e){
                e.getMessage() ;
            }
        }
        schedulePrinted = scheduleService.print();
    }

    @When("^I print that list$")
    public void I_print_that_list() throws Throwable {
        schedulePrinted = scheduleService.print();
    }

    @Then("^it should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
        assertEquals(expected, schedulePrinted.toString());
    }


    private Appointment createAppointment(AppointmentItem item) {
        return new Appointment(item.getCity(), new Duration(item.getTravelduration()), item.getCustomer(),
                item.getBeginning(), item.getEnd(), item.getTravelkm());
    }

    // When converting tables to a List of objects it's usually better to
    // use classes that are only used in test (not in production). This
    // reduces coupling between scenarios and domain and gives you more control.
    public static class AppointmentItem {
        private String city;
        private String customer;
        private String beginning;
        private String end;
        private int travelduration;
        private int travelkm;


        public String getCity() {
            return city;
        }


        public String getCustomer() {
            return customer;
        }


        public String getBeginning() {
            return beginning;
        }


        public String getEnd() {
            return end;
        }



        public int getTravelduration() {
            return travelduration;
        }


        public int getTravelkm() {
            return travelkm;
        }


    }
}
