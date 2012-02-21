package com.example.junkyard.domain;


import com.example.junkyard.model.USState;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 */
public class AddressChange {
    private String employeeName = null;
    private String address1 = null;
    private String address2 = null;
    private String city = null;
    private USState state = null;
    private String zipCode = null;
    private Date effectiveDate = null;
    private String telephoneNum = null;
    private String notes = null;

    private boolean medical = false;
    private boolean directDeposit = false;
    private boolean retirementPlan = false;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public USState getState() {
        return state;
    }

    public void setState(USState state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isMedical() {
        return medical;
    }

    public void setMedical(boolean medical) {
        this.medical = medical;
    }

    public boolean isDirectDeposit() {
        return directDeposit;
    }

    public void setDirectDeposit(boolean directDeposit) {
        this.directDeposit = directDeposit;
    }

    public boolean isRetirementPlan() {
        return retirementPlan;
    }

    public void setRetirementPlan(boolean retirementPlan) {
        this.retirementPlan = retirementPlan;
    }

    public String toString() {
        return new ToStringBuilder(this)
                .append("employeeName", employeeName)
                .append("address1", address1)
                .append("address2", address2)
                .append("city", city)
                .append("state", state)
                .append("zipCode", zipCode)
                .append("telephoneNum", telephoneNum)
                .append("effectiveDate", effectiveDate)
                .append("medical", isMedical())
                .append("directDeposit", isDirectDeposit())
                .append("401k", isRetirementPlan())
                .append("notes", notes)
                .toString();
    }

    public List<String> getEnrollments() {
        final List<String> result = new ArrayList<String>();

        if (isDirectDeposit()) {
            result.add("Direct Deposit");
        }

        if (isMedical()) {
            result.add("Medical");
        }

        if (isRetirementPlan()) {
            result.add("401K");
        }

        return result;
    }
}
