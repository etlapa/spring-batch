package mx.edev.springbatch.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

/**
 * Patient record from the input file
 */
@Data
public class PatientRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sourceId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String birthDate;
    private String action;
    private String ssn;

    public PatientRecord() {
    }

    public PatientRecord(String sourceId, String firstName, String middleInitial, String lastName, String emailAddress,
            String phoneNumber, String street, String city, String state, String zip, String birthDate, String action,
            String ssn) {
        super();
        this.sourceId = sourceId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.birthDate = birthDate;
        this.action = action;
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}