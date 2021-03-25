package com.darioxlz.bookings.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "members")
public class Member {
    public Member() {
    }

    public Member(String surname, String firstname, String address, Integer zipcode, String telephone, Member recommendedBy, LocalDateTime joinDate) {
        this.surname = surname;
        this.firstname = firstname;
        this.address = address;
        this.zipcode = zipcode;
        this.telephone = telephone;
        this.recommendedBy = recommendedBy;
        this.joinDate = joinDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memid")
    private Integer memberId;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "zipcode", nullable = false)
    private Integer zipcode;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @ManyToOne(optional=true)
    @JoinColumn(name="recommendedby")
    private Member recommendedBy;

    @Column(name = "joindate", updatable = false, nullable = false)
    private LocalDateTime joinDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Booking> bookings;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public Member getRecommendedBy() {
        return recommendedBy;
    }

    public void setRecommendedBy(Member recommendedBy) {
        this.recommendedBy = recommendedBy;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address='" + address + '\'' +
                ", zipcode=" + zipcode +
                ", telephone='" + telephone + '\'' +
                ", recommendedBy=" + recommendedBy +
                ", joinDate=" + joinDate +
                ", bookings=" + bookings +
                '}';
    }
}
