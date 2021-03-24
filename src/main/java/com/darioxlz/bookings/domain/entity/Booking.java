package com.darioxlz.bookings.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    public Booking() {
    }

    public Booking(LocalDateTime startTime, Integer slots, Facility facility, Member member) {
        this.startTime = startTime;
        this.slots = slots;
        this.facility = facility;
        this.member = member;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private Integer bookingId;

    @Column(name = "starttime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "slots", nullable = false)
    private Integer slots;

    @Column(name = "memid")
    private Integer memberId;

    @Column(name = "facid")
    private Integer facilityId;

    @ManyToOne
    @JoinColumn(name = "facid", nullable = false, insertable = false, updatable = false)
    private Facility facility;

    @ManyToOne
    @JoinColumn(name = "memid", nullable = false, insertable = false, updatable = false)
    private Member member;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", startTime=" + startTime +
                ", slots=" + slots +
                ", facility=" + facility +
                ", member=" + member +
                '}';
    }
}
