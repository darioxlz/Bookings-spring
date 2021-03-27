package com.darioxlz.bookings.application;

import com.darioxlz.bookings.application.dto.in.BookingRequestDTO;
import com.darioxlz.bookings.application.dto.out.BookingResponseDTO;
import com.darioxlz.bookings.application.port.interactor.IBookingService;
import com.darioxlz.bookings.application.port.output.IBookingRepository;
import com.darioxlz.bookings.application.port.output.IFacilityRepository;
import com.darioxlz.bookings.application.port.output.IMemberRepository;
import com.darioxlz.bookings.domain.entity.Booking;
import com.darioxlz.bookings.domain.entity.Facility;
import com.darioxlz.bookings.domain.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements IBookingService {
    private final IBookingRepository repository;
    private final IMemberRepository memberRepository;
    private final IFacilityRepository facilityRepository;

    @Autowired
    public BookingServiceImpl(IBookingRepository repository, IMemberRepository memberRepository, IFacilityRepository facilityRepository) {
        this.repository = repository;
        this.memberRepository = memberRepository;
        this.facilityRepository = facilityRepository;
    }

    @Override
    public List<BookingResponseDTO> find() {
        return repository.find().stream().map(BookingResponseDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<BookingResponseDTO> findById(int id) {
        Optional<Booking> booking = repository.findById(id);

        if (booking.isPresent()) {
            BookingResponseDTO responseDTO = BookingResponseDTO.toDTO(booking.get());

            return Optional.of(responseDTO);
        } else {
            throw new ApplicationException("No member has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BookingResponseDTO save(BookingRequestDTO dto) {
        Booking booking = new Booking();
        Optional<Member> member = memberRepository.findByID(dto.getMemid());
        Optional<Facility> facility = facilityRepository.findById(dto.getFacid());

        if (member.isPresent() && facility.isPresent()) {
            booking.setFacilityId(facility.get().getFacilityId());
            booking.setMemberId(member.get().getMemberId());
            booking.setSlots(dto.getSlots());
            booking.setStartTime(dto.getStarttime());

            System.out.println(booking);

            booking = repository.save(booking);

            return BookingResponseDTO.toDTO(booking);
        } else {
            throw new ApplicationException("No member/facility has been found with the given ID's!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BookingResponseDTO update(int id, BookingRequestDTO dto) {
        Optional<Booking> booking = repository.findById(id);

        if (booking.isPresent()) {
            Booking entity = booking.get();

            if (dto.getSlots() != null) entity.setSlots(dto.getSlots());
            if (dto.getStarttime() != null) entity.setStartTime(dto.getStarttime());

            if (dto.getFacid() != null) {
                Optional<Facility> facility = facilityRepository.findById(dto.getFacid());

                if (facility.isPresent()) {
                    entity.setFacilityId(facility.get().getFacilityId());
                } else {
                    throw new ApplicationException("No facility has been found with this ID!", HttpStatus.NOT_FOUND);
                }
            }

            if (dto.getMemid() != null) {
                Optional<Member> member = memberRepository.findByID(dto.getMemid());

                if (member.isPresent()) {
                    entity.setMemberId(member.get().getMemberId());
                } else {
                    throw new ApplicationException("No member has been found with this ID!", HttpStatus.NOT_FOUND);
                }
            }

            entity = repository.save(entity);

            return BookingResponseDTO.toDTO(entity);
        } else {
            throw new ApplicationException("No booking has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public BookingResponseDTO delete(int id) {
        Optional<Booking> booking = repository.findById(id);

        if (booking.isPresent()) {
            repository.deleteByBookingId(id);

            return BookingResponseDTO.toDTO(booking.get());
        } else {
            throw new ApplicationException("No booking has been found with this ID!", HttpStatus.NOT_FOUND);
        }
    }
}
