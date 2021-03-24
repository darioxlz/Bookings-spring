package com.darioxlz.bookings.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "facilities")
public class Facility {
    public Facility() {
    }

    public Facility(String name, Double memberCost, Double guestCost, Double initialOutlay, Double monthlyMaintenance) {
        this.name = name;
        this.memberCost = memberCost;
        this.guestCost = guestCost;
        this.initialOutlay = initialOutlay;
        this.monthlyMaintenance = monthlyMaintenance;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facid")
    private Integer facilityId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "membercost", nullable = false)
    private Double memberCost;

    @Column(name = "guestcost", nullable = false)
    private Double guestCost;

    @Column(name = "initialoutlay", nullable = false)
    private Double initialOutlay;

    @Column(name = "monthlymaintenance", nullable = false)
    private Double monthlyMaintenance;

    @OneToMany(mappedBy = "facility")
    private List<Booking> bookings;

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMemberCost() {
        return memberCost;
    }

    public void setMemberCost(Double memberCost) {
        this.memberCost = memberCost;
    }

    public Double getGuestCost() {
        return guestCost;
    }

    public void setGuestCost(Double guestCost) {
        this.guestCost = guestCost;
    }

    public Double getInitialOutlay() {
        return initialOutlay;
    }

    public void setInitialOutlay(Double initiaOutlay) {
        this.initialOutlay = initiaOutlay;
    }

    public Double getMonthlyMaintenance() {
        return monthlyMaintenance;
    }

    public void setMonthlyMaintenance(Double monthlyMaintenance) {
        this.monthlyMaintenance = monthlyMaintenance;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "facilityId=" + facilityId +
                ", name='" + name + '\'' +
                ", memberCost=" + memberCost +
                ", guestCost=" + guestCost +
                ", initialOutlay=" + initialOutlay +
                ", monthlyMaintenance=" + monthlyMaintenance +
                ", bookings=" + bookings +
                '}';
    }
}
