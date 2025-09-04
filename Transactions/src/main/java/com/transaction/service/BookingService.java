package com.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.entity.Booking;
import com.transaction.entity.Room;
import com.transaction.repo.BookingRepository;
import com.transaction.repo.RoomRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;
    @Autowired
    private RoomRepository roomRepo;
    @Autowired 
    private PaymentService paymentService;
    @Autowired 
    private RoomService roomService;
    @Autowired 
    private NotificationService notificationService;
    @Autowired 
    private AuditService auditService;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
    public void bookRoom(Long roomId, String guestName) {
        Room room = roomRepo.findById(roomId).orElseThrow();
        if(!room.isAvailable()) throw new RuntimeException("Room not available");

        Booking booking = new Booking();
        booking.setRoomId(roomId);
        booking.setGuestName(guestName);
        booking.setStatus("CONFIRMED");
        bookingRepo.save(booking);

        paymentService.processPayment(booking.getId(), room.getPricePerNight());
        roomService.updateAvailability(roomId, false);
        notificationService.sendEmail("Booking confirmed for " + guestName);
        auditService.logBooking(booking.getId());
    }
}
