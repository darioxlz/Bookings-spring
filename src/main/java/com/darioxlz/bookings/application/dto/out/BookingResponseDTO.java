package com.darioxlz.bookings.application.dto.out;

import java.time.LocalDateTime;

public class BookingResponseDTO {
    private LocalDateTime starttime;

    private Integer slots;

    private Integer facid;

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
