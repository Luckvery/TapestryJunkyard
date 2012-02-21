package com.example.junkyard.pages;

import org.apache.tapestry5.annotations.Property;

import java.net.InetAddress;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/19/12
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class HostInfo {
    @Property
    private String remoteHost;


    HostInfo(){
        remoteHost = "www.google.com";
    }

    Boolean isHostReachable(){

        boolean chkConnection = false;

        try
        {
            InetAddress address = InetAddress.getByName(remoteHost);
            chkConnection = address.isReachable(1000);
        }
        catch( Exception e)
        {
            //don't care!!!
        }
        return  chkConnection;
    }
}
