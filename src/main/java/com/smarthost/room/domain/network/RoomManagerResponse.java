package com.smarthost.room.domain.network;

public final class RoomManagerResponse {

    private final Integer occupiedEconomyRooms;
    private final Integer occupiedPremiumRooms;
    private final Double totalEarnings;

    public RoomManagerResponse(Integer occupiedEconomyRooms, Integer occupiedPremiumRooms, Double totalEarnings) {
        this.occupiedEconomyRooms = occupiedEconomyRooms;
        this.occupiedPremiumRooms = occupiedPremiumRooms;
        this.totalEarnings = totalEarnings;
    }

    public Integer getOccupiedEconomyRooms() {
        return occupiedEconomyRooms;
    }

    public Integer getOccupiedPremiumRooms() {
        return occupiedPremiumRooms;
    }

    public Double getTotalEarnings() {
        return totalEarnings;
    }
}
