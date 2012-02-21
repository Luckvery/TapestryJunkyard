package com.example.junkyard.model;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 1/30/12
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.tapestry5.EventConstants;


/**
 * Analog to {@link EventConstants}-
 *
 * @author criedel
 */

public class JQueryEventConstants {

        /**
         * Triggered when a file has been uploaded via {@link AjaxUpload}.
         */
        public static final String AJAX_UPLOAD = "ajaxFileUpload";

        /**
         * Triggered when a file has been uploaded via {@link AjaxUpload} via a regular post (applies to IE browsers).
         */
        public static final String NON_XHR_UPLOAD = "fileUpload";

        /**
         * Triggered by the DataTable component
         */
        public static final String DATA = "Data";


        /**
         * Triggered by the ZoneRefresh component
         */
        public static final String REFRESH = "Refresh";


        /**
         * Triggered by the ZoneDrop component
         */
        public static final String DROP = "Drop";

        /**
         * Triggered by the {@link Tabs} component whenever a tab is changed.
         */
        public static final String SELECT_TAB = "SelectTab";

    }

