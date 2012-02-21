package com.example.junkyard.searchkeys;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 */
public class EmailUserSearchKeys {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private String forwardAddress;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getForwardAddress() {
        return forwardAddress;
    }

    public void setForwardAddress(String forwardAddress) {
        this.forwardAddress = forwardAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("firstName", firstName).
                append("lastName", lastName).
                append("emailAddress", emailAddress).
                append("forwardAddress", forwardAddress).
                toString();
    }
}
