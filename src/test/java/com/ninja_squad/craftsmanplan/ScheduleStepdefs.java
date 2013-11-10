package com.ninja_squad.craftsmanplan;

import com.ninja_squad.craftsmanplan.domain.Appointment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.joda.time.DateTime;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ScheduleStepdefs {
    private Schedule schedule = new Schedule();
    private StringBuilder schedulePrinted;

    @Given("^an appointments list:$")
    public void an_appointments_list(List<AppointmentItem> items) throws Throwable {
        for (AppointmentItem item : items) {
            DateTime beginning  = new DateTime(item.getDatebeginning());
            Appointment app = new Appointment(item.getCity(),item.getCustomer(), beginning);
            schedule.addAppointment(app);
        }
    }

    @When("^I print that list$")
    public void I_print_that_list() throws Throwable {
        schedulePrinted = new StringBuilder();
        schedulePrinted = schedule.print();
    }

    @Then("^it should look like:$")
    public void it_should_look_like(String expected) throws Throwable {
        assertEquals(expected, schedulePrinted.toString());
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
