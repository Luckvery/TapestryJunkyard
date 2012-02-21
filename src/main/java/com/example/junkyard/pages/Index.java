package com.example.junkyard.pages;

import com.example.junkyard.model.Address;
import com.example.junkyard.pages.DashBoard.EventDashBoard;
import com.example.junkyard.pages.DataTables.DataTablesDemo;
import com.example.junkyard.pages.FormsDemo.FoundationFormsDemo;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;

import java.util.Date;

/**
 * Start page of application junkyard.
 */
public class Index
{
    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    @InjectComponent
    private Zone zone;

    @Persist
    @Property
    private int clickCount;


    @Property
    private String tellTheWorld;

    @Inject
    private AlertManager alertManager;


    @InjectPage
    private EventDashBoard newEventDashBoard;

    @InjectPage
    private DataTablesDemo newTablesDemo;

    @InjectPage
    private FoundationFormsDemo newFormsDemo;

    @PageActivationContext
    @Property
    private Address address;



    Object onActionFromEventDashBoard(){
            /* if (host.isHostReachable()){
                 tellTheWorld = "I pinged the host and the host talked back! Yay!!";
             } else
             {
                 tellTheWorld = "I pinged the host and they had nothing to say :(";
             }*/
        return newEventDashBoard;


    }

    Object onActionFromDataTables(){
        /* if (host.isHostReachable()){
            tellTheWorld = "I pinged the host and the host talked back! Yay!!";
        } else
        {
            tellTheWorld = "I pinged the host and they had nothing to say :(";
        }*/
        return newEventDashBoard;


    }



    public Date getCurrentTime()
    {
        return new Date();
    }

    void onActionFromIncrement()
    {
        alertManager.info("Increment clicked");

        clickCount++;
    }

    Object onActionFromIncrementAjax()
    {
        clickCount++;

        alertManager.info("Increment (via Ajax) clicked");

        return zone;
    }

   void  setupRender(){
       clickCount++;

    }

    @Log
    void onActivate(){
        if(address == null) {
            address = new Address();
        }
    }

}
