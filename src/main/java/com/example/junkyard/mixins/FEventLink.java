package com.example.junkyard.mixins;

import com.example.junkyard.domain.reference.IconGlyphs;
import com.starpoint.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.base.AbstractTextField;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.services.Heartbeat;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 2/14/12
 * Time: 8:44 AM
 * To change this template use File | Settings | File Templates.
 */
@MixinAfter
public class FEventLink {


    //Acceptable values are [button, link]
    @Parameter(name = "displayAs", required = true, allowNull = false, defaultPrefix = "literal")
    private String displayAs;

    @Property
    @Parameter(name = "value", required = false, allowNull = false, defaultPrefix = "literal")
    private String textOfButton;

    //Acceptable values are [primary, default , info, success, warning, danger, inverse]
    @Parameter(name = "type", required = false, allowNull = true, defaultPrefix = "literal")
    private String typeOfButton;

    //Acceptable values are [large, small, mini]
    @Parameter(name = "size", required = false, allowNull = true, defaultPrefix = "literal")
    private String sizeOfButton;

    //Acceptable values are [true, false]
    @Parameter(name = "disabled", required = false, allowNull = true, defaultPrefix = "literal")
    private String disabled;

    //Acceptable values are an any valid glyphs from Glyphicons
    @Parameter(name = "icon", required = false, allowNull = true, defaultPrefix = "literal")
    private String icon;

    //Acceptable values are [black, white]
    @Parameter(name = "icon-color", required = false, allowNull = true, defaultPrefix = "literal")
    private String iconColor;

    private Element pageLinkElement;

    @Environmental
    private Heartbeat heartbeat;

    private String bootstrapClassVariables;

    @InjectContainer
    private AbstractTextField field;


    void beginRender(final MarkupWriter writer) {
        bootstrapClassVariables = "";
        String buttonSize = "";
        String disableTheButton = "";
        String button = "";


        if (displayAs.equals("button")) {

            //Was the type parameter provided?
            if (typeOfButton != null) {
                typeOfButton.toLowerCase();
                if (typeOfButton.equals("default")) {
                    button = "";
                } else if (typeOfButton.equals("info")) {
                    button = " btn-info";
                } else if (typeOfButton.equals("success")) {
                    button = " btn-success";
                } else if (typeOfButton.equals("warning")) {
                    button = " btn-warning";
                } else if (typeOfButton.equals("danger")) {
                    button = " btn-danger";
                } else if (typeOfButton.equals("inverse")) {
                    button = " btn-inverse";
                } else if (typeOfButton.equals("primary")) {
                    button = " btn-primary";
                } else {
                    throw new BusinessException("Illegal parameter value provided to TYPE of FEventLink");
                }
            }

            //Was the disable parameter provided?
            if (disabled != null) {
                disabled.toLowerCase();
                if (disabled.equals("true")) {
                    disableTheButton = " disabled";
                } else if (disabled.equals("false")) {
                    disableTheButton = "";
                } else {
                    throw new BusinessException("Illegal parameter value provided to DISABLED of FEventLink");
                }
            }

            //Was the size parameter provided?
            if (sizeOfButton != null) {
                sizeOfButton.toLowerCase();
                if (sizeOfButton.equals("large")) {
                    buttonSize = " btn-large";
                } else if (sizeOfButton.equals("small")) {
                    buttonSize = " btn-small";
                } else if (sizeOfButton.equals("mini")) {
                    buttonSize = " btn-mini";
                } else {
                    throw new BusinessException("Illegal parameter value provided to SIZE of FEventLink");
                }
            }

            //Was the icon glyph provided?
            if (!StringUtils.isNotBlank(icon)) {
                icon = "icon-home";
            } else if (!IconGlyphs.isValidGlyph(icon)) {
                throw new BusinessException("Illegal parameter value provided to icon of FEventLink");
            }

            //Was the color of the icon provided?
            if (!StringUtils.isNotBlank(iconColor) || iconColor.equals("white")) {
                iconColor = "icon-white";
            } else if (iconColor.equals("black")) {
                iconColor = "";
            } else {
                throw new BusinessException("Illegal parameter value provided to iconColor of FEventLink");
            }

            bootstrapClassVariables = "btn" + button + buttonSize + disableTheButton;
        } else if (displayAs.equals("link")) {
            bootstrapClassVariables = "";
        }


        pageLinkElement = writer.getElement();
        final String iconClass = icon + " " + iconColor;
        Runnable command = new Runnable() {
            public void run() {

                pageLinkElement.forceAttributes("class", bootstrapClassVariables);
                if (displayAs.equals("button")) {
                    pageLinkElement.element("i", "class" ,iconClass);
                    if (StringUtils.isNotBlank(textOfButton))
                        pageLinkElement.text(" " + textOfButton);


                }


            }
        };

        heartbeat.defer(command);
    }

    void afterRender(MarkupWriter writer) {
        //   writer.end();
    }
}