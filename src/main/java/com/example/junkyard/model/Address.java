package com.example.junkyard.model;


/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
public class Address {

    public Honorific honorific;

    public String firstName;

    public String lastName;

    public String street1;

    public String street2;

    public String city;

    public String state;

    public String zip;

    public String email;



    public Honorific getHonorific() {
        return honorific;
    }

    public void setHonorific(Honorific honorific) {
        this.honorific = honorific;
    }

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

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String phone;

     public Address() {
        firstName = "Mike";

        lastName = "Tyson";

        street1 = "253 Noears Lane.";

        street2 = "Apt CU";

        city = "New York";

        state = "NY";

        zip = "11001";

        email = "bunnies@aol.com";

         phone = "516-338-6654";

        honorific = Honorific.MR;


    }
}
