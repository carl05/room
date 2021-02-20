package com.smarthost.room.domain.network;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoomManagerRequest {
    @NotNull
    private final Integer premiumRooms;
    @NotNull
    private final Integer economyRooms;
    @NotNull @NotEmpty
    private final Double[] guestsBudget;

    public RoomManagerRequest(Integer premiumRooms, Integer economyRooms, Double[] guestsBudget) {
        this.economyRooms = economyRooms;
        this.premiumRooms = premiumRooms;
        this.guestsBudget = guestsBudget;
    }

    public Integer getEconomyRooms() {
        return economyRooms;
    }

    public Integer getPremiumRooms() {
        return premiumRooms;
    }

    public Double[] getGuestsBudget() {
        return guestsBudget;
    }
}
