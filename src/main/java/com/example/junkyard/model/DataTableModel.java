package com.example.junkyard.model;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.tapestry5.PropertyOverrides;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.GridSortModel;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.Request;

/**
 * Interface used when your dataTable load the data by using ajax. You will have to implement
 * the sendResponse.
 */
public interface DataTableModel {


    public abstract JSONObject sendResponse(Request request,
                                            GridDataSource source, BeanModel model, GridSortModel sortModel, PropertyOverrides overrides);
}
