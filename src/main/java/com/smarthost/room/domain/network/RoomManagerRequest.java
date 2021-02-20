package com.smarthost.room.domain.network;

public final class RoomManagerRequest {
    private final Integer economyRooms;
    private final Integer premiumRooms;
    private final Double[] guestsBudget;

    public RoomManagerRequest(Integer economyRooms, Integer premiumRooms, Double[] guestsBudget) {
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
