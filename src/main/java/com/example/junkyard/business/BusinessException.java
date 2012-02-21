package com.example.junkyard.business;

/**
 *
 */
public class BusinessException extends RuntimeException
{
    public BusinessException(String string)
    {
        super(string);
    }

    public BusinessException(final Exception e)
    {
        super(e);
    }

}
