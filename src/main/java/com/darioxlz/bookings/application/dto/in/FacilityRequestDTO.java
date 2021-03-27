package com.darioxlz.bookings.application.dto.in;

import javax.validation.constraints.*;

public class FacilityRequestDTO {
    @NotNull(message = "The facility name cannot be null.")
    @Size(min = 3, max = 50, message = "The facility name must contain between 3 and 50 characters.")
    private String name;

    @NotNull(message = "The facility member cost must not be null")
    @PositiveOrZero(message = "The facility member cost must be positive number or zero.")
    private Double membercost;

    @NotNull(message = "The facility guest cost must not be null")
    @PositiveOrZero(message = "The facility guest cost must be positive number or zero.")
    private Double guestcost;

    @NotNull(message = "The facility initial outlay must not be null")
    @PositiveOrZero(message = "The facility initial outlay must be positive number or zero.")
    private Double initialoutlay;

    @NotNull(message = "The facility monthly maintenance must not be null")
    @PositiveOrZero(message = "The facility monthly maintenance must be positive number or zero.")
    private Double monthlymaintenance;

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
