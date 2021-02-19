package com.smarthost.room.domain.network;

public final class RoomManagerResponse {

    private final Integer occupiedPremiumRooms;
    private final Integer occupiedEconomyRooms;
    private final Double earningsPremium;
    private final Double earningsEconomic;


    public RoomManagerResponse(Integer occupiedPremiumRooms, Integer occupiedEconomyRooms, Double earningsPremium, Double earningsEconomic) {
        this.occupiedPremiumRooms = occupiedPremiumRooms;
        this.occupiedEconomyRooms = occupiedEconomyRooms;
        this.earningsEconomic = earningsEconomic;
        this.earningsPremium = earningsPremium;
    }

    public Integer getOccupiedPremiumRooms() {
        return occupiedPremiumRooms;
    }

    public Integer getOccupiedEconomyRooms() {
        return occupiedEconomyRooms;
    }

    public Double getEarningsEconomic() {
        return earningsEconomic;
    }

    public Double getEarningsPremium() {
        return earningsPremium;
    }
}
