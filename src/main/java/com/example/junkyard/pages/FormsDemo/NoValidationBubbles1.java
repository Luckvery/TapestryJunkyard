package com.example.junkyard.pages.FormsDemo;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 2/1/12
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
import com.example.junkyard.components.CustomForm;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;

/* This annotation tells Tapestry to declare the js file in the page so that the browser will pull it in. */
@Import(library = "context:style/javascripts/validators.js")
public class NoValidationBubbles1 {

    @Property
    private String firstName;

    @Property
    private String lastName;

    // Other pages

    @InjectPage
    private FoundationFormsDemo fHome;

    @Property
    private CustomForm names;

    // The code

    Object onSuccess() {
        return fHome;
    }
}
