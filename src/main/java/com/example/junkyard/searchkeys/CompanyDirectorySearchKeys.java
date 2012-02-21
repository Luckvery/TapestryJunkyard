package com.example.junkyard.searchkeys;



/**
 *
 */
public class CompanyDirectorySearchKeys
{
    private String searchTerm = null;
    private String searchLetter = null;
    private boolean exactMatch = false;

    public String getSearchTerm()
    {
        return searchTerm;
    }

    public void setSearchTerm(final String searchTerm)
    {
        this.searchTerm = searchTerm == null || searchTerm.trim().length() == 0 ?
                null : searchTerm;
    }

    public String getSearchLetter()
    {
        return searchLetter;
    }

    public void setSearchLetter(final String searchLetter)
    {
        this.searchLetter = searchLetter;
    }

    public boolean isExactMatch()
    {
        return exactMatch;
    }

    public void setExactMatch(final boolean exactMatch)
    {
        this.exactMatch = exactMatch;
    }
}
