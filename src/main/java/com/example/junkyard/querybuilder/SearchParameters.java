package com.example.junkyard.querybuilder;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.mapping.Column;

import java.io.Serializable;

public class SearchParameters implements Serializable {
    private static final long serialVersionUID = -3398201103014015492L;
    private Object searchKeys = null;
    private Integer pageSize = 25;
    private int page = 1;
    private Column column = null;
    private SortDirection sortDirection = SortDirection.ASC;
    private PageLetter letter = PageLetter.ALL;

    public SearchParameters() {
    }

    /**
     * This method simply creates a new SearchParameters for the given set of searchKeys.
     * <p/>
     * Useful in testing scenarios.
     *
     * @param searchKeys The search keys to query the data source with
     */
    public SearchParameters(Object searchKeys) {
        this.setSearchKeys(searchKeys);
    }

    /**
     * @return Returns the pageSize.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize The pageSize to set.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        if (this.pageSize != null && this.pageSize <= 0) {
            this.pageSize = null;
        }
    }

    /**
     * Global index of first row to fetch
     */
    public int firstIndex() {
        if (pageSize == null) {
            return 0;
        }
        return (getPage() - 1) * pageSize;
    }

    public Object getSearchKeys() {
        return searchKeys;
    }

    public void setSearchKeys(Object searchKeys) {
        this.searchKeys = searchKeys;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Column getColumn() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public PageLetter getLetter() {
        return letter;
    }

    public void setLetter(PageLetter selectedLetter) {
        this.letter = selectedLetter;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this)
                .append("pageSize", this.pageSize)
                .append("sortDirection", this.sortDirection)
                .append("page", this.page)
                .append("letter", this.letter)
                .append("searchKeys", this.searchKeys)
                .append("column", this.column).toString();
    }


}
