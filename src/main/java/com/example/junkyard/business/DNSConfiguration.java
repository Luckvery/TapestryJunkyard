package com.example.junkyard.business;

/**
 */
public interface DNSConfiguration {

    String getInternalIp();
    int getInternalPort();

    String getExternalIp();
    int getExternalPort();

    String getTSIGKeyName();
    String getTSIGKey();
}
