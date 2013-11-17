package com.ninja_squad.craftsmanplan.service;

/**
 * Exception Constraint to add an appointment in a schedule
 * User: agnes007
 * Date: 11/17/13
 */
public class ConstraintException extends Exception {

    public ConstraintException() {
    }
    public ConstraintException(String message) {
        super(message);
    }
}
