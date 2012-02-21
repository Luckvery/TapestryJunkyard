package com.example.junkyard.services;

import com.example.junkyard.components.Letters;
import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.Validator;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Contribute;
import org.apache.tapestry5.ioc.annotations.Primary;
import org.apache.tapestry5.services.*;
import org.apache.tapestry5.services.transform.ComponentClassTransformWorker2;


/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to configure and extend
 * Tapestry, or to place your own service definitions. See
 * http://tapestry.apache.org/5.3.1/tapestry-ioc/module.html
 */
public class AppModule {


    @Contribute(MarkupRenderer.class)
    public static void deactiveDefaultCSS(OrderedConfiguration<MarkupRendererFilter> configuration)
    {
        configuration.override("InjectDefaultStylesheet", null);
    }
    // Add 2 services to those provided by Tapestry.
    // - CountryNames, and SelectIdModelFactory are used by pages which ask Tapestry to @Inject them.

    public static void bind(ServiceBinder binder) {
/*        binder.bind(CountryNames.class);
        binder.bind(SelectIdModelFactory.class, SelectIdModelFactoryImpl.class);*/

        // This next line addresses an issue affecting GlassFish and JBoss - see http://blog.progs.be/?p=52
        javassist.runtime.Desc.useContextClassLoader = true;
    }

    // Tell Tapestry about our custom validators, translators, and their message files.
    // We do this by contributing to Tapestry's FieldValidatorSource service, TranslatorSource service,
    // and ComponentMessagesSource service.

    @SuppressWarnings("rawtypes")
    public static void contributeFieldValidatorSource(MappedConfiguration<String, Validator> configuration) {
        configuration.add("letters", new Letters());
    }

/*    @SuppressWarnings("rawtypes")
    public static void contributeTranslatorSource(MappedConfiguration<Class, Translator> configuration) {
        configuration.add(Boolean.class, new YesNoTranslator());
    }*/

    public void contributeComponentMessagesSource(OrderedConfiguration<String> configuration) {
        configuration.add("myValidationMessages", "com/example/junkyard/validators/ValidationMessages");
       // configuration.add("myTranslationMessages", "jumpstart/web/translators/TranslationMessages");
    }

    // Tell Tapestry about our custom ValueEncoders.
    // We do this by contributing to Tapestry's ValueEncoderSource service.

    // @SuppressWarnings("rawtypes")
    // public static void contributeValueEncoderSource(MappedConfiguration<Class, Object> configuration) {
    // configuration.addInstance(Person.class, PersonEncoder.class);
    // }

    // Tell Tapestry which locales we support.
    // We do this by contributing to Tapestry's ApplicationDefaults service.

    public static void contributeApplicationDefaults(MappedConfiguration<String, String> configuration) {
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en_US,en_GB,fr");
        configuration.add(SymbolConstants.COMPRESS_WHITESPACE, "false");
        configuration.add(SymbolConstants.COMBINE_SCRIPTS, "false");
    }

    // Tell Tapestry how to block access to WEB-INF/, META-INF/, and assets that are not in our "whitelist".
    // We do this by contributing a custom RequestFilter to Tapestry's RequestHandler service.
    // - This is necessary due to https://issues.apache.org/jira/browse/TAP5-815 .
    // - RequestHandler is shown in http://tapestry.apache.org/request-processing.html#RequestProcessing-Overview .
    // - RequestHandler is described in http://tapestry.apache.org/request-processing.html
    // - Based on an entry in the Tapestry Users mailing list by martijn.list on 15 Aug 09.

    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
                                         PageRenderLinkSource pageRenderLinkSource) {
       /* final HashSet<String> ASSETS_WHITE_LIST = new HashSet<String>(Arrays.asList("jpg", "jpeg", "png", "gif", "js",
                "css", "ico"));
        configuration.add("AssetProtectionFilter", new AssetProtectionFilter(ASSETS_WHITE_LIST, pageRenderLinkSource),
                "before:*");*/
    }

    // Tell Tapestry how to prevent access to pages marked as @ProtectedPage unless logged in.
    // We do this by contributing a custom ComponentRequestFilter to Tapestry's ComponentRequestHandler service.
    // - ComponentRequestHandler is shown in
    // http://tapestry.apache.org/request-processing.html#RequestProcessing-Overview
    // - Based on http://tapestryjava.blogspot.com/2009/12/securing-tapestry-pages-with.html

    public void contributeComponentRequestHandler(OrderedConfiguration<ComponentRequestFilter> configuration) {
 /*       configuration.addInstance("PageProtectionFilter", PageProtectionFilter.class);*/
    }

    // Tell Tapestry how to handle JBoss 5, 6.0, or 6.1's classpath URLs - JBoss uses a "virtual file system".
    // See "Running Tapestry on JBoss" in http://wiki.apache.org/tapestry/Tapestry5HowTos .

    @SuppressWarnings("rawtypes")
    public static void contributeServiceOverride(MappedConfiguration<Class, Object> configuration) {
        // configuration.add(ClasspathURLConverter.class, new ClasspathURLConverterJBoss5());
        // configuration.add(ClasspathURLConverter.class, new ClasspathURLConverterJBoss60());
       /* configuration.add(ClasspathURLConverter.class, new ClasspathURLConverterJBoss61());*/
    }

    // Tell Tapestry how to handle @EJB in page and component classes
    // We do this by contributing to Tapestry's ComponentClassTransformWorker service.
    // - Based on http://wiki.apache.org/tapestry/JEE-Annotation, adapted to Tapestry 5.2 (from 5.3) and EJB 3.0 (from
    // 3.1).

    @Primary
    public static void contributeComponentClassTransformWorker(
         OrderedConfiguration<ComponentClassTransformWorker2> configuration) {
        //configuration.addInstance("EJB", EJBAnnotationWorker.class, "before:Property");
    }

    // Tell Tapestry how to coerce Joda Time types to and from Java Date types
    // We do this by contributing to Tapestry's TypeCoercer service.
    // - Based on http://tapestry.apache.org/typecoercer-service.html

   /* @SuppressWarnings("rawtypes")
    public static void contributeTypeCoercer(Configuration<CoercionTuple> configuration) {

        // From java.util.Date to DateMidnight

        Coercion<java.util.Date, DateMidnight> toDateMidnight = new Coercion<java.util.Date, DateMidnight>() {
            public DateMidnight coerce(java.util.Date input) {
                // TODO - confirm this conversion always works, esp. across timezones
                return JodaTimeUtil.toDateMidnight(input);
            }
        };

        configuration.add(new CoercionTuple<java.util.Date, DateMidnight>(java.util.Date.class, DateMidnight.class,
                toDateMidnight));

        // From DateMidnight to java.util.Date

        Coercion<DateMidnight, java.util.Date> fromDateMidnight = new Coercion<DateMidnight, java.util.Date>() {
            public java.util.Date coerce(DateMidnight input) {
                // TODO - confirm this conversion always works, esp. across timezones
                return JodaTimeUtil.toJavaDate(input);
            }
        };

        configuration.add(new CoercionTuple<DateMidnight, java.util.Date>(DateMidnight.class, java.util.Date.class,
                fromDateMidnight));

        // From java.util.Date to LocalDate

        Coercion<java.util.Date, LocalDate> toLocalDate = new Coercion<java.util.Date, LocalDate>() {
            public LocalDate coerce(java.util.Date input) {
                // TODO - confirm this conversion always works, esp. across timezones
                return JodaTimeUtil.toLocalDate(input);
            }
        };

        configuration.add(new CoercionTuple<java.util.Date, LocalDate>(java.util.Date.class, LocalDate.class,
                toLocalDate));

        // From LocalDate to java.util.Date

        Coercion<LocalDate, java.util.Date> fromLocalDate = new Coercion<LocalDate, java.util.Date>() {
            public java.util.Date coerce(LocalDate input) {
                // TODO - confirm this conversion always works, esp. across timezones
                return JodaTimeUtil.toJavaDate(input);
            }
        };

        configuration.add(new CoercionTuple<LocalDate, java.util.Date>(LocalDate.class, java.util.Date.class,
                fromLocalDate));

    }*/

}


/*

import java.io.IOException;

import org.apache.tapestry5.*;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Local;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.RequestFilter;
import org.apache.tapestry5.services.RequestHandler;
import org.apache.tapestry5.services.Response;
import org.slf4j.Logger;

*/
/**
 * This module is automatically included as part of the Tapestry IoC Registry, it's a good place to
 * configure and extend Tapestry, or to place your own service definitions.
 *//*

public class AppModule
{
    public static void bind(ServiceBinder binder)
    {
        // binder.bind(MyServiceInterface.class, MyServiceImpl.class);

        // Make bind() calls on the binder object to define most IoC services.
        // Use service builder methods (example below) when the implementation
        // is provided inline, or requires more initialization than simply
        // invoking the constructor.
    }

    public static void contributeFactoryDefaults(
            MappedConfiguration<String, Object> configuration)
    {
        // The application version number is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version number should also
        // change, to force the browser to download new versions. This overrides Tapesty's default
        // (a random hexadecimal number), but may be further overriden by DevelopmentModule or
        // QaModule.
        configuration.override(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT");
    }

    public static void contributeApplicationDefaults(
            MappedConfiguration<String, Object> configuration)
    {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en");
    }


    */
/**
     * This is a service definition, the service will be named "TimingFilter". The interface,
     * RequestFilter, is used within the RequestHandler service pipeline, which is built from the
     * RequestHandler service configuration. Tapestry IoC is responsible for passing in an
     * appropriate Logger instance. Requests for static resources are handled at a higher level, so
     * this filter will only be invoked for Tapestry related requests.
     * <p/>
     * <p/>
     * Service builder methods are useful when the implementation is inline as an inner class
     * (as here) or require some other kind of special initialization. In most cases,
     * use the static bind() method instead.
     * <p/>
     * <p/>
     * If this method was named "build", then the service id would be taken from the
     * service interface and would be "RequestFilter".  Since Tapestry already defines
     * a service named "RequestFilter" we use an explicit service id that we can reference
     * inside the contribution method.
     *//*

    public RequestFilter buildTimingFilter(final Logger log)
    {
        return new RequestFilter()
        {
            public boolean service(Request request, Response response, RequestHandler handler)
                    throws IOException
            {
                long startTime = System.currentTimeMillis();

                try
                {
                    // The responsibility of a filter is to invoke the corresponding method
                    // in the handler. When you chain multiple filters together, each filter
                    // received a handler that is a bridge to the next filter.

                    return handler.service(request, response);
                } finally
                {
                    long elapsed = System.currentTimeMillis() - startTime;

                    log.info(String.format("Request time: %d ms", elapsed));
                }
            }
        };
    }

    */
/**
     * This is a contribution to the RequestHandler service configuration. This is how we extend
     * Tapestry using the timing filter. A common use for this kind of filter is transaction
     * management or security. The @Local annotation selects the desired service by type, but only
     * from the same module.  Without @Local, there would be an error due to the other service(s)
     * that implement RequestFilter (defined in other modules).
     *//*

    public void contributeRequestHandler(OrderedConfiguration<RequestFilter> configuration,
                                         @Local
                                         RequestFilter filter)
    {
        // Each contribution to an ordered configuration has a name, When necessary, you may
        // set constraints to precisely control the invocation order of the contributed filter
        // within the pipeline.

        configuration.add("Timing", filter);
    }
}
*/
