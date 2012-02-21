package com.example.junkyard.querybuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PagedResult<T> {
    protected SearchParameters params = new SearchParameters();
    protected long totalRecords = 0;
    protected List<T> records = new ArrayList<T>();
    protected boolean tooManyClauses = false;

    /**
     * @return Returns the records.
     */
    public List<T> getRecords() {
        return records;
    }

    /**
     * @param records The records to set.
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }

    public void setTooManyClauses(boolean tooManyClauses) {
        this.tooManyClauses = tooManyClauses;
    }

    public boolean isTooManyClauses() {
        return tooManyClauses;
    }

    /**
     * @return Returns the params.
     */
    public SearchParameters getSearchParameters() {
        return params;
    }

    /**
     * @param params The params to set.
     */
    public void setSearchParameters(SearchParameters params) {
        this.params = params;
    }

    /**
     * This is the total number of results in all the pages.
     * Use the records collection to determine number of items on
     * this page
     *
     * @return Returns the totalRecords.
     */
    public long getTotalRecords() {
        return totalRecords;
    }

    /**
     * @param totalRecords The totalRecords to set.
     */
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    /**
     * return the number of pages in this result
     *
     * @return number of pages in the result set
     */
    public long getNumberPages() {
        if (params == null || params.getPageSize() == null)
            return 0;

        int pageSize = getSearchParameters().getPageSize();
        long pages = totalRecords / pageSize;

        if ((totalRecords % pageSize) != 0)
            pages++;

        return pages;
    }

    /**
     * return the previous page or null if there is no previous page
     *
     * @return previous page number, null if none
     */
    public Integer getPreviousPage() {
        if (params == null || params.getPage() == 1)
            return null;

        return params.getPage() - 1;
    }

    /**
     * return the next page or null if there is no next page
     *
     * @return next page number, null if none
     */
    public Integer getNextPage() {
        if (params == null || params.getPage() == getNumberPages())
            return null;

        return params.getPage() + 1;
    }

    public int getCurrentPage() {
        return params.getPage();
    }

    public int getPageSize() {
        return params.getPageSize();
    }

    public List<Integer> getPages() {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= getNumberPages(); i++) {
            list.add(i);
        }

        return list;
    }

    public String firstGrouping() {
        long pages = getNumberPages();
        if (pages == 0) {
            return null;
        }

        return "1";
    }

    public String lastGrouping() {
        long pages = getNumberPages();
        if (pages == 0) {
            return null;
        }

        return String.valueOf(pages);
    }

    public List getPagesInReverse() {
        List<Integer> list = getPages();
        Collections.reverse(list);
        return list;
    }
}
