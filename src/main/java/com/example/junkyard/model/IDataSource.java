package com.example.junkyard.model;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 11:00 AM
 * To change this template use File | Settings | File Templates.
 */

import java.util.List;

public interface IDataSource {
    public List<Celebrity> getAllCelebrities();
    public Celebrity getCelebrityById(long id);
    public void addCelebrity(Celebrity c);
    public List<Celebrity> getRange(int indexFrom, int indexTo);
}
