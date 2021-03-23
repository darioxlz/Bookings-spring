package com.darioxlz.bookings.application.dto.out;

import com.darioxlz.bookings.domain.entity.Member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class MemberResponseDTO {
    private Integer memid;

    private String surname;

    private String firstname;

    private String address;

    private Integer zipcode;

    private String telephone;

    private Member recommendedby;

    private LocalDateTime joindate;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

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

    public Member getRecommendedby() {
        return recommendedby;
    }

    public void setRecommendedby(Member recommendedby) {
        this.recommendedby = recommendedby;
    }

    public LocalDateTime getJoindate() {
        return joindate;
    }

    public void setJoindate(LocalDateTime joindate) {
        this.joindate = joindate;
    }
}
