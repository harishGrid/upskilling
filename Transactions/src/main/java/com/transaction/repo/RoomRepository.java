package com.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {}