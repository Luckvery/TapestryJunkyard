package com.example.junkyard.domain;

import com.example.junkyard.annotations.Type;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.tapestry5.annotations.Parameter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 */
@Embeddable
public class EmailDestinationPk implements Serializable {

    private Integer destId;

    @Type(type = "com.starpoint.helpdesk.hibernate.types.GenericEnumUserType", parameters = {
            @Parameter(name = "enumClass", value = "com.starpoint.helpdesk.domain.EmailDestinationSourceType" ),
            @Parameter(name = "identifierMethod", value = "getId") })
    private EmailDestinationSourceType destType;

    public Integer getDestId() {
        return destId;
    }

    public void setDestId(Integer destId) {
        this.destId = destId;
    }

    public EmailDestinationSourceType getDestType() {
        return destType;
    }

    public void setDestType(EmailDestinationSourceType destType) {
        this.destType = destType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("destId", destId).
                append("destType", destType).
                toString();
    }
}
