package com.example.junkyard.pages.DashBoard;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.tapestry5.annotations.Property;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Russell John-Baptiste & Tony Nelson
 * Date: 1/20/12
 * Time: 11:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class EventDashBoard {

    private static int positionOfCall = 1;

    static Logger log = Logger.getLogger("EventDashBoard");


    @Property
    private static List<String>  eventCallPath;
    
    @Property
    private String currentEvent;
    
/*    @Property
    private static EventCalls currentEvent;*/

    private int NUMBER_OF_EVENTS = 20;       //Current number of events which we expect in our List<EventCalls>

/*
    private List<EventCalls> eventCallPath;  //List of class EventCalls. Each class contains name of event call and
                                             // position which event was called represented as integers.
    @Property
    private SelectModel eventSelectModel;
*/




    public List<String> getFinalEventPath()
    {
        return eventCallPath;
    }


    
    void EventDashBoard(){
         return;
    }
    /*//Page Context
    void onActivate() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_ACTIVATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void onPassivate() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_PASSIVATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    //Forms
    void onSuccess() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_SUCCESS, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void onFailure() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_FAILURE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void onValidate() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_VALIDATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void onAction() {

        EventCalls currentEvent =  new EventCalls(EventCallType.ON_ACTION, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }*/

/*

    void pageAttached() {

        EventCalls currentEvent =  new EventCalls(EventCallType.PAGE_ATTACHED, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void pageDetached() {

        EventCalls currentEvent =  new EventCalls(EventCallType.PAGE_DETACHED, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void pageReset() {

        EventCalls currentEvent =  new EventCalls(EventCallType.PAGE_RESET, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    //Render
    void setupRender() {

        EventCalls currentEvent =  new EventCalls(EventCallType.SETUP_RENDER, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void beginRender() {

        EventCalls currentEvent =  new EventCalls(EventCallType.BEGIN_RENDER, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void beforeRenderTemplate() {

        EventCalls currentEvent =  new EventCalls(EventCallType.BEFORE_RENDER_TEMPLATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void renderTemplate() {
        EventCalls currentEvent =  new EventCalls(EventCallType.RENDER_TEMPLATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void beforeRenderBody() {

        EventCalls currentEvent =  new EventCalls(EventCallType.BEFORE_RENDER_BODY, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void renderBody() {
        EventCalls currentEvent =  new EventCalls(EventCallType.RENDER_BODY, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void afterRenderTemplate() {

        EventCalls currentEvent =  new EventCalls(EventCallType.AFTER_RENDER_TEMPLATE, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void afterRender() {

        EventCalls currentEvent =  new EventCalls(EventCallType.AFTER_RENDER, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

    void cleanUpRender() {

        EventCalls currentEvent =  new EventCalls(EventCallType.CLEAN_UP_RENDER, positionOfCall);
        eventCallPath.add(currentEvent);
        positionOfCall++;
    }

*/
//Life Cycle
void pageLoaded() {

    log.setLevel(Level.INFO);

    log.info("Look no hands!");
    eventCallPath.add("Page Loaded");

   /* currentEvent.setEvent("pageLoaded");
    currentEvent.setPositionOfEvent(positionOfCall);
    eventCallPath.add(currentEvent);*/
    positionOfCall++;
}

}
