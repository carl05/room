package com.smarthost.room.domain.network;

public final class RoomManagerRequest {
    private final Integer economyRooms;
    private final Integer premiumRooms;

    public RoomManagerRequest(Integer economyRooms, Integer premiumRooms) {
        this.economyRooms = economyRooms;
        this.premiumRooms = premiumRooms;
    }

    public Integer getEconomyRooms() {
        return economyRooms;
    }

    public Integer getPremiumRooms() {
        return premiumRooms;
    }
}
