package com.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transaction.entity.Room;
import com.transaction.repo.RoomRepository;
import com.transaction.service.BookingService;

@RestController
@RequestMapping("/hotel")
public class BookingController {

    @Autowired 
    private BookingService bookingService;
    @Autowired 
    private RoomRepository roomRepo;

    @PostMapping("/addRoom")
    public Room addRoom(@RequestParam String roomNumber, @RequestParam double price) {
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setPricePerNight(price);
        room.setAvailable(true);
        return roomRepo.save(room);
    }

    @PostMapping("/bookRoom")
    public String bookRoom(@RequestParam Long roomId, @RequestParam String guestName) {
        bookingService.bookRoom(roomId, guestName);
        return "Booking successful for guest: " + guestName;
    }
}
