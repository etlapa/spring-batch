package mx.edev.springbatch.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class PatientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "patient_id")
    private Long id;

    @NotNull
    @Column(name = "source_id", nullable = false)
    private String sourceId;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_initial", nullable = true)
    private String middleInitial;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = true)
    private String emailAddress;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull
    @Column(name = "street", nullable = false)
    private String street;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @NotNull
    @Column(name = "state", nullable = false)
    private String state;

    @NotNull
    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    @NotNull
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Column(name = "social_security_number", nullable = false)
    private String socialSecurityNumber;

    public PatientEntity() {

    }

    public PatientEntity(@NotNull String sourceId, @NotNull String firstName, String middleInitial,
            @NotNull String lastName, String emailAddress, @NotNull String phoneNumber, @NotNull String street,
            @NotNull String city, @NotNull String state, @NotNull String zipCode, @NotNull LocalDate birthDate,
            @NotNull String socialSecurityNumber) {
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
        this.zipCode = zipCode;
        this.birthDate = birthDate;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public PatientEntity(Long id, @NotNull String sourceId, @NotNull String firstName, String middleInitial,
            @NotNull String lastName, String emailAddress, @NotNull String phoneNumber, @NotNull String street,
            @NotNull String city, @NotNull String state, @NotNull String zipCode, @NotNull LocalDate birthDate,
            @NotNull String socialSecurityNumber) {
        super();
        this.id = id;
        this.sourceId = sourceId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.birthDate = birthDate;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}