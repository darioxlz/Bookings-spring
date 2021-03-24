package com.darioxlz.bookings.application.dto.out;

import com.darioxlz.bookings.application.dto.in.FacilityRequestDTO;
import com.darioxlz.bookings.domain.entity.Facility;

public class FacilityResponseDTO {
    private Integer facid;

    private String name;

    private Double membercost;

    private Double guestcost;

    private Double initialoutlay;

    private Double monthlymaintenance;

    public static FacilityResponseDTO toDTO(Facility facility) {
        FacilityResponseDTO dto = new FacilityResponseDTO();

        dto.setFacid(facility.getFacilityId());
        dto.setName(facility.getName());
        dto.setGuestcost(facility.getGuestCost());
        dto.setMembercost(facility.getMemberCost());
        dto.setMonthlymaintenance(facility.getMonthlyMaintenance());
        dto.setInitialoutlay(facility.getInitialOutlay());

        return dto;
    }

    public static Facility toFacility(FacilityRequestDTO dto) {
        Facility facility = new Facility();

        facility.setName(dto.getName());
        facility.setGuestCost(dto.getGuestcost());
        facility.setMemberCost(dto.getMembercost());
        facility.setMonthlyMaintenance(dto.getMonthlymaintenance());
        facility.setInitialOutlay(dto.getInitialoutlay());

        return facility;
    }

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

    public Double getMembercost() {
        return membercost;
    }

    public void setMembercost(Double membercost) {
        this.membercost = membercost;
    }

    public Double getGuestcost() {
        return guestcost;
    }

    public void setGuestcost(Double guestcost) {
        this.guestcost = guestcost;
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
