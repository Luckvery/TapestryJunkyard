package com.example.junkyard.annotations;

import java.lang.annotation.*;

/**
 * Security annotation for Tapestry Pages. Enables anonymous access to pages, so the user does not
 * have to be logged in.
 *
 * @author karesti
 * @version 1.0
 */
@Target(
{ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnonymousAccess {
}
