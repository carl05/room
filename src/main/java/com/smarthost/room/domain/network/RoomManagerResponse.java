package com.smarthost.room.domain.network;

public class RoomManagerResponse {

    private Integer occupiedEconomyRooms;
    private Integer occupiedPremiumRooms;
    private Double totalEarnings;

    public Integer getOccupiedEconomyRooms() {
        return occupiedEconomyRooms;
    }

    public void setOccupiedEconomyRooms(Integer occupiedEconomyRooms) {
        this.occupiedEconomyRooms = occupiedEconomyRooms;
    }

    public Integer getOccupiedPremiumRooms() {
        return occupiedPremiumRooms;
    }

    public void setOccupiedPremiumRooms(Integer occupiedPremiumRooms) {
        this.occupiedPremiumRooms = occupiedPremiumRooms;
    }

    public Double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(Double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }
}
