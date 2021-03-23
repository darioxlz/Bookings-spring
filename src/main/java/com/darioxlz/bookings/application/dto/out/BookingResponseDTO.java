package com.darioxlz.bookings.application.dto.out;

import java.time.LocalDateTime;

public class BookingResponseDTO {
    private Integer bookid;

    private Integer facid;

    private Integer memid;

    private Integer slots;

    private LocalDateTime starttime;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
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

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }
}
