package com.example.junkyard.pages.AjaxForms;


import com.example.junkyard.model.Address;
import com.example.junkyard.model.Honorific;
import com.example.junkyard.pages.Index;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */

public class AjaxDemo {

    static final private String[] ALL_MAKES = new String[] { "Honda", "Toyota" };
    static final private String[] NO_MODELS = new String[] {};
    static final private String[] HONDA_MODELS = new String[] { "Accord", "Civic", "Jazz" };
    static final private String[] TOYOTA_MODELS = new String[] { "Camry", "Corolla" };

    // Screen fields

    @Property
    private String carMake;

    @Property
    private String carModel;

    @Property
    private String keywords;

    @Property
    private String[] carMakes;

    @Property
    @SuppressWarnings("unused")
    private String[] carModels;


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

    @Property
    private List<String> Names;

    @Property
    @Component
    private Zone carModelZone;

    @InjectPage
    private Index index;

    @Inject
    private Request request;


    @Log
    void setupRender() {

        if (address == null) {
            address = new Address();
        }

        if (carMakes == null) {
            carMakes = ALL_MAKES;
            carModels = NO_MODELS;
        }

        Names = new ArrayList();


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


    @Log
    Object onValidateFromEditAddressForm() {

        return index;
    }

    @Log
    void onActivate() {
        if (address == null) {
            address = new Address();
        }
    }

    Object onValueChangedFromCarMake(String carMake) {
        this.carMake = carMake;
        carMakes = ALL_MAKES;

        if (carMake == null) {
            carModels = NO_MODELS;
        }
        else if (carMake.equals(carMakes[0])) {
            carModels = HONDA_MODELS;
        }
        else if (carMake.equals(carMakes[1])) {
            carModels = TOYOTA_MODELS;
        }
        else {
            carModels = NO_MODELS;
        }
        carModel = null;

        return request.isXHR() ? carModelZone.getBody() : null;
    }


}
