package com.example.junkyard.components.JEditTable;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.InitializationPriority;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: rbaptiste
 * Date: 6/21/12
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class EditableText {


    @Environmental
    private JavaScriptSupport javaScriptSupport;

    @Inject
    private ComponentResources componentResources;

    @Import(library = {"context:js/jquery.jeditable.js",
            "context:js/jquery.jeditable.ini.js"})
    public void afterRender() {

        JSONObject spec = new JSONObject(
                "elementId", componentResources.getId(),
                "elementClass", "editable"
        );
        javaScriptSupport.addInitializerCall(InitializationPriority.LATE, "editDemo", spec);
    }
}

