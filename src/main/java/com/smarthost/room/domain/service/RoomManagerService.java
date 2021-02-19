package com.smarthost.room.domain.service;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomManagerService {
    private final Integer premiumValue = 100;
    public RoomManagerResponse occupancy(RoomManagerRequest request) {
        var premiumRooms = request.getPremiumRooms();
        var economicRooms = request.getEconomyRooms();
        var earningsPremium = 0.0;
        var earningsEconomic = 0.0;
        var guestsBudget = request.getGuestsBudget();
        Arrays.sort(guestsBudget);
        GuestsData guestsData = new GuestsData();

        guestsData.economicGuests.addAll(Arrays.stream(guestsBudget).filter(filter -> filter < 100).collect(Collectors.toList()));
        guestsData.premiumGuests.addAll(Arrays.stream(guestsBudget).filter(filter -> filter >= 100).collect(Collectors.toList()));

        while(hasVacancy(premiumRooms) && hasGuests(guestsData.premiumGuests)) {
            earningsPremium += guestsData.premiumGuests.pollLast();
            premiumRooms = fillRoom(premiumRooms);
        }

        while(guestsData.economicGuests.size() > economicRooms && hasVacancy(premiumRooms)) {
            earningsPremium += guestsData.economicGuests.pollLast();
            premiumRooms = fillRoom(premiumRooms);
        }

        while(hasVacancy(economicRooms) && hasGuests(guestsData.economicGuests)) {
            earningsEconomic += guestsData.economicGuests.pollLast();
            economicRooms = fillRoom(economicRooms);
        }



        RoomManagerResponse response = new RoomManagerResponse(request.getPremiumRooms() - premiumRooms,
                request.getEconomyRooms() - economicRooms,
                earningsPremium,
                earningsEconomic
        );
        return response;
    }

    private Integer fillRoom (Integer room) {
        return --room;
    }
    private boolean hasVacancy (Integer room) {
        return room > 0;
    }

    private boolean hasGuests (Queue guests) {
        return !guests.isEmpty();
    }


    private class GuestsData {
        Deque<Double> premiumGuests = new LinkedList<>();
        Deque<Double> economicGuests = new LinkedList();
    }
}
