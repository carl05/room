package com.smarthost.room.domain.service;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

@Service
public class RoomManagerUseCase {
    private final Integer premiumValue = 100;
    private ManagerData managerData;
    private GuestsData guestsData;

    public RoomManagerResponse execute(RoomManagerRequest request) {
        initData(request);
        fillPremiumRoomsWithPremiumGuests();
        fillPremiumRoomsWithUpgradedEconomyGuests();
        fillEconomyRoomsWithEconomyGuests();
        return getRoomManagerResponse(request.getPremiumRooms(), request.getEconomyRooms());
    }

    private void fillPremiumRoomsWithPremiumGuests() {
        while (canBookPremiumRoomWithPremiumGuest()) {
            managerData.earningsPremiumRooms += guestsData.premiumGuests.pollLast();
            managerData.premiumRooms = fillRoom(managerData.premiumRooms);
        }
    }

    private void fillPremiumRoomsWithUpgradedEconomyGuests() {
        while (canBookPremiumRoomWithUpgradedEconomyGuest()) {
            managerData.earningsPremiumRooms += guestsData.economyGuests.pollLast();
            managerData.premiumRooms = fillRoom(managerData.premiumRooms);
        }
    }

    private void fillEconomyRoomsWithEconomyGuests() {
        while (canBookEconomyRoomWithEconomyGuest()) {
            managerData.earningsEconomyRooms += guestsData.economyGuests.pollLast();
            managerData.economyRooms = fillRoom(managerData.economyRooms);
        }
    }

    private void initData(RoomManagerRequest request) {
        managerData = initManagerData(request);
        guestsData = initGuestsData();
        initGuestDataStructure();
    }

    private GuestsData initGuestsData() {
        return new GuestsData();
    }

    private ManagerData initManagerData(RoomManagerRequest request) {
        return new ManagerData(request.getPremiumRooms(), request.getEconomyRooms(), request.getGuestsBudget());
    }

    private void initGuestDataStructure() {
        guestsData.economyGuests.addAll(Arrays.stream(managerData.guestsBudget).filter(filter -> filter < premiumValue).collect(Collectors.toList()));
        guestsData.premiumGuests.addAll(Arrays.stream(managerData.guestsBudget).filter(filter -> filter >= premiumValue).collect(Collectors.toList()));
    }

    private RoomManagerResponse getRoomManagerResponse(Integer premiumRooms, Integer economyRooms) {
        return new RoomManagerResponse(premiumRooms - managerData.premiumRooms,
                economyRooms - managerData.economyRooms,
                managerData.earningsPremiumRooms,
                managerData.earningsEconomyRooms
        );
    }

    private boolean canBookPremiumRoomWithUpgradedEconomyGuest() {
        return hasPremiumVacancy() && hasMoreEconomyGuestsThenRooms();
    }

    private boolean canBookEconomyRoomWithEconomyGuest() {
        return hasEconomyVacancy() && hasEconomyGuests();
    }

    private boolean hasEconomyGuests() {
        return hasGuests(guestsData.economyGuests);
    }

    private boolean hasEconomyVacancy() {
        return hasVacancy(managerData.economyRooms);
    }

    private boolean canBookPremiumRoomWithPremiumGuest() {
        return hasPremiumVacancy() && hasPremiumGuests();
    }

    private boolean hasPremiumVacancy() {
        return hasVacancy(managerData.premiumRooms);
    }

    private boolean hasPremiumGuests() {
        return hasGuests(guestsData.premiumGuests);
    }

    private boolean hasMoreEconomyGuestsThenRooms() {
        return guestsData.economyGuests.size() > managerData.economyRooms;
    }

    private Integer fillRoom(Integer room) {
        return --room;
    }

    private boolean hasVacancy(Integer room) {
        return room > 0;
    }

    private boolean hasGuests(Queue guests) {
        return guests != null && !guests.isEmpty();
    }


}

class GuestsData {
    Deque<Double> premiumGuests = new LinkedList<>();
    Deque<Double> economyGuests = new LinkedList<>();
}

class ManagerData {
    Integer premiumRooms;
    Integer economyRooms;
    Double earningsPremiumRooms = 0.0;
    Double earningsEconomyRooms = 0.0;
    Double[] guestsBudget;

    public ManagerData(Integer premiumRooms, Integer economyRooms, Double[] guestsBudget) {
        this.premiumRooms = premiumRooms;
        this.economyRooms = economyRooms;
        this.guestsBudget = guestsBudget;
        Arrays.sort(this.guestsBudget);
    }
}
