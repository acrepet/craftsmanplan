package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScheduleStepdefs {
    private ScheduleService scheduleService = new ScheduleService();
    private StringBuilder schedulePrinted;
    private List<Appointment> proposedAppointments = new ArrayList<Appointment>();

    @Given("^an appointments list:$")
    public void an_appointments_list(List<AppointmentItem> items) throws Throwable {
        for (AppointmentItem item : items) {
            Appointment app = new Appointment(item.getCity(),item.getCustomer(), new DateTime(item.getDatebeginning()));
            scheduleService.addAppointment(app);
        }
    }
    @Given(value = "^a new proposal for appointment:$")
    public void a_new_proposal_for_appointment(List<AppointmentItem> items) throws Throwable {
        for (AppointmentItem item : items) {
            Appointment app = new Appointment(item.getCity(),item.getCustomer(), new DateTime(item.getDatebeginning()));
            proposedAppointments.add(app);
        }
    }
    @When("^I want to check my availability schedule$")
    public void I_want_to_check_my_availability_schedule() throws Throwable {
        for (Appointment proposedAppointment : proposedAppointments) {
            scheduleService.addAppointment(proposedAppointment);
        }
    }

    @When("^I print that list$")
    public void I_print_that_list() throws Throwable {
        schedulePrinted = new StringBuilder();
        schedulePrinted = scheduleService.print();
    }

    @Then("^it should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
        assertEquals(3, scheduleService.getNumberOfAppointments());
        assertEquals(expected, schedulePrinted.toString());
    }

    @Then("^the number of appointemps of my schedule should be (\\d+)$")
    public void the_number_of_appointemps_of_my_schedule_should_be(int expected) throws Throwable {
        assertEquals(expected, scheduleService.getNumberOfAppointments());
    }
    // When converting tables to a List of objects it's usually better to
    // use classes that are only used in test (not in production). This
    // reduces coupling between scenarios and domain and gives you more control.
    public static class AppointmentItem {
        private String city;
        private String customer;
        private String datebeginning;


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

        public String getDatebeginning() {
            return datebeginning;
        }

        public void setDatebeginning(String datebeginning) {
            this.datebeginning = datebeginning;
        }


    }
}
