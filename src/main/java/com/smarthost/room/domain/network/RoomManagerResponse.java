package com.smarthost.room.domain.network;

public class RoomManagerResponse {

    private final Integer occupiedPremiumRooms;
    private final Integer occupiedEconomyRooms;
    private final Double earningsPremiumRooms;
    private final Double earningsEconomyRooms;


    public RoomManagerResponse(Integer occupiedPremiumRooms, Integer occupiedEconomyRooms, Double earningsPremiumRooms, Double earningsEconomyRooms) {
        this.occupiedPremiumRooms = occupiedPremiumRooms;
        this.occupiedEconomyRooms = occupiedEconomyRooms;
        this.earningsEconomyRooms = earningsEconomyRooms;
        this.earningsPremiumRooms = earningsPremiumRooms;
    }

    public Integer getOccupiedPremiumRooms() {
        return occupiedPremiumRooms;
    }

    public Integer getOccupiedEconomyRooms() {
        return occupiedEconomyRooms;
    }

    public Double getEarningsEconomyRooms() {
        return earningsEconomyRooms;
    }

    public Double getEarningsPremiumRooms() {
        return earningsPremiumRooms;
    }
}
