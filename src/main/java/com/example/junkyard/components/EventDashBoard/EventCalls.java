package com.example.junkyard.components.EventDashBoard;

import com.example.junkyard.model.EventCallType;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/20/12
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventCalls {

    private int position;
    private EventCallType event;


     EventCalls() {
        int position = 0;
        event.setEventCallType("noEventCalled");
    }

    public EventCalls(String newEvent, int newPosition) {
        position = newPosition;
        event.setEventCallType(newEvent);
    }

    public void setPositionOfEvent(int newPosition) {
        if (newPosition >= 0) {
            position = newPosition;
        } else {
            position = 0;
        }
    }

    public int getPositionOfEvent() {
        return position;
    }

   public void setEvent(String newEvent) {
        event.setEventCallType(newEvent);
    }

    public String getNameEvent() {
        return event.getEventCallType();
    }
}
