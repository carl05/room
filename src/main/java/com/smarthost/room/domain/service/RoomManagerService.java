package com.smarthost.room.domain.service;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import org.springframework.stereotype.Service;

@Service
public class RoomManagerService {

    public RoomManagerResponse occupancy(RoomManagerRequest request) {
        RoomManagerResponse response = new RoomManagerResponse(request.getEconomyRooms(), request.getPremiumRooms(), 5.5);
        return response;
    }
}
