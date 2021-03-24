package com.darioxlz.bookings.application.dto.out;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.domain.entity.Booking;

import java.time.LocalDateTime;

public class BookingResponseDTO {
    private LocalDateTime starttime;

    private Integer slots;

    private Integer facid;

    private Integer memid;

    public static BookingResponseDTO toDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();

        dto.setMemid(booking.getMember().getMemberId());
        dto.setFacid(booking.getFacility().getFacilityId());
        dto.setSlots(booking.getSlots());
        dto.setStarttime(booking.getStartTime());

        return dto;
    }

//    public static Booking toBooking(BookingRequestDTO dto) {
//        Booking booking = new Booking();
//
//        return booking;
//    }

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
