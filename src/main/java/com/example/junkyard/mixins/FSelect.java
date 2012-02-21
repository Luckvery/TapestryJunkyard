package com.example.junkyard.mixins;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.MixinAfter;
import org.apache.tapestry5.corelib.base.AbstractTextField;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.services.Heartbeat;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 2/13/12
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@MixinAfter
public class FSelect {


    private Element selectElement;

    @Environmental
    private Heartbeat heartbeat;

    private String foundationClassVariables;

    @InjectContainer
    private AbstractTextField field;

    void beforeRenderTemplate (final MarkupWriter writer) {


    }

    void beginRender(final MarkupWriter writer) {
        foundationClassVariables = "custom dropdown";
        selectElement = writer.getElement();
        Runnable command = new Runnable() {
            public void run() {
                selectElement.attributes("class", foundationClassVariables);
                // selectElement = writer.getElement().addClassName(foundationClassVariables);
            }
        };

        heartbeat.defer(command);
    }

    void afterRender(MarkupWriter writer) {
        // writer.end();
    }
}