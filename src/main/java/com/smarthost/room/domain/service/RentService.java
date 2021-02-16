package com.smarthost.room.domain.service;

import com.smarthost.room.domain.network.RentResumeRequest;
import com.smarthost.room.domain.network.RentResumeResponse;
import org.springframework.stereotype.Service;

@Service
public class RentService {

    public RentResumeResponse getRentResumeByRooms(RentResumeRequest request) {
        RentResumeResponse response = new RentResumeResponse();
        response.setOccupiedPremiumRooms(request.getPremiumRooms());
        response.setOccupiedEconomyRooms(request.getEconomyRooms());
        response.setTotalEarnings(5.55);
        return response;
    }
}
