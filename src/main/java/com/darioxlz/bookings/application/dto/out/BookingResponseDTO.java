package com.darioxlz.bookings.application.dto.out;

import com.darioxlz.bookings.domain.entity.Booking;

import java.time.LocalDateTime;

public class BookingResponseDTO {
    private Integer bookid;

    private LocalDateTime starttime;

    private Integer slots;

    private Integer facid;

    private Integer memid;

    public static BookingResponseDTO toDTO(Booking booking) {
        BookingResponseDTO dto = new BookingResponseDTO();

        dto.setBookid(booking.getBookingId());
        dto.setMemid(booking.getMemberId());
        dto.setFacid(booking.getFacilityId());
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

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}
