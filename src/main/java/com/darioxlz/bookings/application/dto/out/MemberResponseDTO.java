package com.darioxlz.bookings.application.dto.out;

import com.darioxlz.bookings.application.dto.in.MemberRequestDTO;
import com.darioxlz.bookings.domain.entity.Member;

import java.time.LocalDateTime;

public class MemberResponseDTO {
    private Integer memid;

    private String surname;

    private String firstname;

    private String address;

    private Integer zipcode;

    private String telephone;

    private Integer recommendedby;

    private LocalDateTime joindate;

    public static Member toMember(MemberResponseDTO dto) {
        Member entity = new Member();

        entity.setMemberId(dto.getMemid());
        entity.setSurname(dto.getSurname());
        entity.setFirstname(dto.getFirstname());
        entity.setAddress(dto.getAddress());
        entity.setZipcode(dto.getZipcode());
        entity.setTelephone(dto.getTelephone());
        entity.setJoinDate(LocalDateTime.now());

        return entity;
    }

    public static Member toMember(MemberRequestDTO dto) {
        Member entity = new Member();

        entity.setSurname(dto.getSurname());
        entity.setFirstname(dto.getFirstname());
        entity.setAddress(dto.getAddress());
        entity.setZipcode(dto.getZipcode());
        entity.setTelephone(dto.getTelephone());
        entity.setJoinDate(LocalDateTime.now());

        return entity;
    }

    public static MemberResponseDTO toDto(Member entity) {
        MemberResponseDTO dto = new MemberResponseDTO();

        dto.setMemid(entity.getMemberId());
        dto.setSurname(entity.getSurname());
        dto.setFirstname(entity.getFirstname());
        dto.setAddress(entity.getAddress());
        dto.setZipcode(entity.getZipcode());
        dto.setTelephone(entity.getTelephone());
        dto.setJoindate(entity.getJoinDate());

        if (entity.getRecommendedBy() != null) {
            dto.setRecommendedby(entity.getRecommendedBy().getMemberId());
        }

        return dto;
    }

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
