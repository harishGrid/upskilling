package com.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.entity.Room;
import com.transaction.repo.RoomRepository;


@Service
public class RoomService {

    @Autowired private RoomRepository roomRepo;

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateAvailability(Long roomId, boolean available) {
        Room room = roomRepo.findById(roomId).orElseThrow();
        room.setAvailable(available);
        roomRepo.save(room);
        System.out.println("Room availability updated: " + room.getRoomNumber());
    }
}
