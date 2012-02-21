package com.example.junkyard.domain;

import com.example.junkyard.annotations.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: rbaptiste
 * Date: 11/30/11
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="tbl_domain")
public class Domain {

    private Integer domainID;
    private String domainName;
    private String domainComment;
    private boolean allowInternalHosts;
    private boolean allowExternalHosts ;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer getDomainId() {
        return domainID;
    }

    public void setDomainId(Integer domainID) {
        this.domainID = domainID;
    }

    @Column
    @Length(max=255)
    @NotNull

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @Column
    @Length(max=255)

    public String getDomainComment() {
        return domainComment;
    }

    public void setDomainComment(String domainComment) {
        this.domainComment = domainComment;
    }

    @Column
    public boolean isAllowInternalHosts() {
        return allowInternalHosts;
    }

    public void setAllowInternalHosts(boolean allowInternalHosts) {
        this.allowInternalHosts = allowInternalHosts;
    }

    @Column
    public boolean isAllowExternalHosts() {
        return allowExternalHosts;
    }

    public void setAllowExternalHosts(boolean allowExternalHosts) {
        this.allowExternalHosts = allowExternalHosts;
    }
}

