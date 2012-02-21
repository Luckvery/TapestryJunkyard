package com.example.junkyard.model;


import org.apache.tapestry5.annotations.Property;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/20/12
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 */
public enum EventCallType {
    //Default value
    NO_EVENT_CALLED("noEventCalled"),

    //Page Context
    ON_ACTIVATE("onActivate"), ON_PASSIVATE("onPassivate"), ON_PREPARE("onPrepare"),

    //Forms
    ON_SUCCESS("onSuccess"), ON_FAILURE("onFailure"),ON_VALIDATE("onValidate"), ON_ACTION("onAction"),

    //Life Cycle
    PAGE_LOADED("pageLoaded"), PAGE_ATTACHED("pageAttached"), PAGE_DETACHED("pageLoaded"),PAGE_RESET("pageReset"),

    //Render
    SETUP_RENDER("setupRender"), BEGIN_RENDER("beginRender"), BEFORE_RENDER_TEMPLATE("beforeRenderTemplate"), RENDER_TEMPLATE("renderTemplate"),
    BEFORE_RENDER_BODY("beforeRenderBody"), RENDER_BODY("renderBody"), AFTER_RENDER_TEMPLATE("afterRenderTemplate"), AFTER_RENDER("afterRender"),
    CLEAN_UP_RENDER("cleanUpRender");
    

    @Property
    private String method;


   EventCallType(String eventCall) {
        if (eventCall == null) {
            throw new RuntimeException("Unhandled EventCallType " + eventCall);
        } else if (eventCall.equals("onActivate")) {
            method = eventCall;
        } else if (eventCall.equals("onPassivate")) {
            method = eventCall;
        } else if (eventCall.equals("onPrepare")) {
            method = eventCall;
        } else if (eventCall.equals("onSuccess")) {
            method = eventCall;
        } else if (eventCall.equals("onFailure")) {
            method = eventCall;
        } else if (eventCall.equals("onValidate")) {
            method = eventCall;
        } else if (eventCall.equals("onAction")) {
            method = eventCall;
        } else if (eventCall.equals("pageLoaded")) {
            method = eventCall;
        } else if (eventCall.equals("pageAttached")) {
            method = eventCall;
        } else if (eventCall.equals("pageLoaded")) {
            method = eventCall;
        } else if (eventCall.equals("pageReset")) {
            method = eventCall;
        } else if (eventCall.equals("setupRender")) {
            method = eventCall;
        } else if (eventCall.equals("beginRender")) {
            method = eventCall;
        } else if (eventCall.equals("beforeRenderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("renderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("beforeRenderBody")) {
            method = eventCall;
        } else if (eventCall.equals("afterRenderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("afterRender")) {
            method = eventCall;
        } else if (eventCall.equals("cleanUpRender")) {
            method = eventCall;
        } else if (eventCall.equals("noEventCalled")) {
            method = eventCall;
        } else {
            throw new RuntimeException("Unhandled AlertType " + eventCall);
        }
    }
    EventCallType() {
        method = "noEventCalled";
    }
    public String getEventCallType() {
        return method;
    }

    public void setEventCallType(String eventCall) {
        if (eventCall == null) {
            throw new RuntimeException("Unhandled EventCallType " + eventCall);
        } else if (eventCall.equals("onActivate")) {
            method = eventCall;
        } else if (eventCall.equals("onPassivate")) {
            method = eventCall;
        } else if (eventCall.equals("onPrepare")) {
            method = eventCall;
        } else if (eventCall.equals("onSuccess")) {
            method = eventCall;
        } else if (eventCall.equals("onFailure")) {
            method = eventCall;
        } else if (eventCall.equals("onValidate")) {
            method = eventCall;
        } else if (eventCall.equals("onAction")) {
            method = eventCall;
        } else if (eventCall.equals("pageLoaded")) {
            method = eventCall;
        } else if (eventCall.equals("pageAttached")) {
            method = eventCall;
        } else if (eventCall.equals("pageLoaded")) {
            method = eventCall;
        } else if (eventCall.equals("pageReset")) {
            method = eventCall;
        } else if (eventCall.equals("setupRender")) {
            method = eventCall;
        } else if (eventCall.equals("beginRender")) {
            method = eventCall;
        } else if (eventCall.equals("beforeRenderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("renderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("beforeRenderBody")) {
            method = eventCall;
        } else if (eventCall.equals("afterRenderTemplate")) {
            method = eventCall;
        } else if (eventCall.equals("afterRender")) {
            method = eventCall;
        } else if (eventCall.equals("cleanUpRender")) {
            method = eventCall;
        }  else if (eventCall.equals("noEventCalled")) {
            method = eventCall;
        }  else {
            throw new RuntimeException("Unhandled AlertType " + eventCall);
        }
    }

}
