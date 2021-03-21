package com.darioxlz.bookings.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {
    public Booking() {
    }

    public Booking(BookingPK bookingId, LocalDateTime startTime, Integer slots, Facility facility, Member member) {
        this.bookingId = bookingId;
        this.startTime = startTime;
        this.slots = slots;
        this.facility = facility;
        this.member = member;
    }

    @EmbeddedId
    private BookingPK bookingId;

    @Column(name = "starttime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "slots", nullable = false)
    private Integer slots;

    @ManyToOne
    @MapsId("facilityId")
    @JoinColumn(name = "facid", insertable = false, updatable = false)
    private Facility facility;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "memid", insertable = false, updatable = false)
    private Member member;

    public BookingPK getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingPK bookingId) {
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
}
