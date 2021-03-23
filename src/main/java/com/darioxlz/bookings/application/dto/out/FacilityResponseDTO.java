package com.darioxlz.bookings.application.dto.out;

public class FacilityResponseDTO {
    private Integer facid;

    private String name;

    private Double guestcost;

    private Double membercost;

    private Double initialoutlay;

    private Double monthlymaintenance;

    public Integer getFacid() {
        return facid;
    }

    public void setFacid(Integer facid) {
        this.facid = facid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGuestcost() {
        return guestcost;
    }

    public void setGuestcost(Double guestcost) {
        this.guestcost = guestcost;
    }

    public Double getMembercost() {
        return membercost;
    }

    public void setMembercost(Double membercost) {
        this.membercost = membercost;
    }

    public Double getInitialoutlay() {
        return initialoutlay;
    }

    public void setInitialoutlay(Double initialoutlay) {
        this.initialoutlay = initialoutlay;
    }

    public Double getMonthlymaintenance() {
        return monthlymaintenance;
    }

    public void setMonthlymaintenance(Double monthlymaintenance) {
        this.monthlymaintenance = monthlymaintenance;
    }
}
