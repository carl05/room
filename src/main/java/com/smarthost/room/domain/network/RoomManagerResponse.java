package com.smarthost.room.domain.network;

public class RoomManagerResponse {

    private Integer occupiedPremiumRooms;
    private Integer occupiedEconomyRooms;
    private Double earningsPremiumRooms;
    private Double earningsEconomyRooms;


    public RoomManagerResponse(Integer occupiedPremiumRooms, Integer occupiedEconomyRooms, Double earningsPremiumRooms, Double earningsEconomyRooms) {
        this.occupiedPremiumRooms = occupiedPremiumRooms;
        this.occupiedEconomyRooms = occupiedEconomyRooms;
        this.earningsEconomyRooms = earningsEconomyRooms;
        this.earningsPremiumRooms = earningsPremiumRooms;
    }

    public Integer getOccupiedPremiumRooms() {
        return occupiedPremiumRooms;
    }

    public void setOccupiedPremiumRooms(Integer occupiedPremiumRooms) {
        this.occupiedPremiumRooms = occupiedPremiumRooms;
    }

    public Integer getOccupiedEconomyRooms() {
        return occupiedEconomyRooms;
    }

    public void setOccupiedEconomyRooms(Integer occupiedEconomyRooms) {
        this.occupiedEconomyRooms = occupiedEconomyRooms;
    }

    public Double getEarningsPremiumRooms() {
        return earningsPremiumRooms;
    }

    public void setEarningsPremiumRooms(Double earningsPremiumRooms) {
        this.earningsPremiumRooms = earningsPremiumRooms;
    }

    public Double getEarningsEconomyRooms() {
        return earningsEconomyRooms;
    }

    public void setEarningsEconomyRooms(Double earningsEconomyRooms) {
        this.earningsEconomyRooms = earningsEconomyRooms;
    }
}
