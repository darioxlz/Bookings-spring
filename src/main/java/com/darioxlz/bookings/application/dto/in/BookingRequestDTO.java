package com.darioxlz.bookings.application.dto.in;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

public class BookingRequestDTO {
    @FutureOrPresent(message = "The booking start time date is from the past")
    private LocalDateTime starttime;

    @NotNull(message = "The booking slots must not be null")
    @Positive(message = "The booking slots must be a positive integer")
    private Integer slots;

    @NotNull(message = "The booking facility id must not be null")
    @Positive(message = "The booking facility id must be a positive integer")
    private Integer facid;

    @NotNull(message = "The booking member id must not be null")
    @Positive(message = "The booking member id must be a positive integer")
    private Integer memid;

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public Integer getFacid() {
        return facid;
    }

    public void setFacid(Integer facid) {
        this.facid = facid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }
}
