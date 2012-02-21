package com.example.junkyard.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */
@Entity
@Table(name = "email_dest_view")
public class EmailDestination {

    @Id
    private EmailDestinationPk pk;

    @Column
    private String destAddr;

    public EmailDestinationPk getPk() {
        return pk;
    }

    public void setPk(EmailDestinationPk pk) {
        this.pk = pk;
    }

    public String getDestAddr() {
        return destAddr;
    }

    public void setDestAddr(String destAddr) {
        this.destAddr = destAddr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("pk", pk).
                append("destAddr", destAddr).
                toString();
    }
}
