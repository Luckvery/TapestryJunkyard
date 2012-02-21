package com.example.junkyard.dao;

import com.example.junkyard.domain.EmailDestination;

/**
 */
public interface EmailDestinationDao {

    EmailDestination findEmailDest(String destAddr);

}
