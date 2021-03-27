package com.darioxlz.bookings.application.dto.in;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class MemberRequestDTO {
    @NotNull(message = "The member surname must not be null.")
    @Size(min = 3, max = 50, message = "The member surname must contain between 3 and 50 characters.")
    private String surname;

    @NotNull(message = "The member firstname must not be null.")
    @Size(min = 3, max = 50, message = "The member firstname must contain between 3 and 50 characters.")
    private String firstname;

    @NotNull(message = "The member address must not be null.")
    @Size(min = 3, max = 50, message = "The member address must contain between 3 and 50 characters.")
    private String address;

    @NotNull(message = "The member zipcode must not be null.")
    @Positive(message = "The member zipcode must be a positive integer")
    private Integer zipcode;

    @NotNull(message = "The member telephone number must not be null.")
    @Size(min = 3, max = 50, message = "The member telephone number must contain between 3 and 15 characters.")
    private String telephone;

    @Positive(message = "The recommendedby must be a positive integer.")
    private Integer recommendedby;

    private LocalDateTime joindate;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getRecommendedby() {
        return recommendedby;
    }

    public void setRecommendedby(Integer recommendedby) {
        this.recommendedby = recommendedby;
    }

    public LocalDateTime getJoindate() {
        return joindate;
    }

    public void setJoindate(LocalDateTime joindate) {
        this.joindate = joindate;
    }
}
