package com.example.junkyard.pages.FormsDemo;


import com.example.junkyard.components.CustomForm;
import com.example.junkyard.model.Address;
import com.example.junkyard.model.Honorific;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */

public class NoValidationBubbles2 {
    @Property
    private CustomForm editAddressForm;

    private Address address;
    @Property
    private String firstName;
    @Property
    private String lastName;
    @Property
    private String street1;
    @Property
    private String street2;
    @Property
    private String city;
    @Property
    private String state;
    @Property
    private String zip;
    @Property
    private String email;
    @Property
    private String phone;
    @Property
    private Honorific honorific;

    @InjectPage
    private FoundationFormsDemo fHome;

    @Log
    void setupRender() {



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



    Object onSuccess() {
        return fHome;
    }


}
