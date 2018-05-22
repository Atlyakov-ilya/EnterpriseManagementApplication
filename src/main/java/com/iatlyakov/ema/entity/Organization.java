package com.iatlyakov.ema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "t_organization")
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "F_ORG_ID")
    private Long orgId;
    @Column(name = "F_ORG_NAME", nullable = false)
    @Size(min=3, max = 30)
    private String orgName;
    @Column(name = "F_ORG_Description")
    @Type(type = "text")
    private String orgDescription;
    @Column(name = "F_ORG_ADDRESS")
    private String address;
    @Column(name = "F_ORG_PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "F_ORG_NUMBER_OF_STAFF")
    private Integer numberOfStaff;
    @Column(name = "F_ORG_ADDITIONAL_INFORMATION")
    private String additionalInformation;
    @ManyToOne
    @JoinColumn(name = "F_ORG_TYPE_ID")
    private OrgType typeOfOrganization;
    @OneToOne
    @JoinColumn(name = "F_USER_ID")
    private User director;
    @Column(name = "F_DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(Integer numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public OrgType getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(OrgType typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public User getDirector() {
        return director;
    }

    public void setDirector(User director) {
        this.director = director;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Organization(@Size(min = 3, max = 30) String orgName, String orgDescription, String address, String phoneNumber, Integer numberOfStaff, String additionalInformation, OrgType typeOfOrganization, User director, Date date) {
        this.orgName = orgName;
        this.orgDescription = orgDescription;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfStaff = numberOfStaff;
        this.additionalInformation = additionalInformation;
        this.typeOfOrganization = typeOfOrganization;
        this.director = director;
        this.date = date;
    }

    public Organization(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (orgId != null ? !orgId.equals(that.orgId) : that.orgId != null) return false;
        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgDescription != null ? !orgDescription.equals(that.orgDescription) : that.orgDescription != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (numberOfStaff != null ? !numberOfStaff.equals(that.numberOfStaff) : that.numberOfStaff != null)
            return false;
        return additionalInformation != null ? additionalInformation.equals(that.additionalInformation) : that.additionalInformation == null;
    }

    @Override
    public int hashCode() {
        int result = orgId != null ? orgId.hashCode() : 0;
        result = 31 * result + (orgName != null ? orgName.hashCode() : 0);
        result = 31 * result + (orgDescription != null ? orgDescription.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (numberOfStaff != null ? numberOfStaff.hashCode() : 0);
        result = 31 * result + (additionalInformation != null ? additionalInformation.hashCode() : 0);
        return result;
    }
}
