package com.smarthost.room.domain.network;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RoomManagerRequest {
    @NotNull
    private Integer premiumRooms;
    @NotNull
    private Integer economyRooms;
    @NotNull @NotEmpty
    private Double[] guestsBudget;

    public RoomManagerRequest(Integer premiumRooms, Integer economyRooms, Double[] guestsBudget) {
        this.economyRooms = economyRooms;
        this.premiumRooms = premiumRooms;
        this.guestsBudget = guestsBudget;
    }

    public RoomManagerRequest() {
    }

    public Integer getPremiumRooms() {
        return premiumRooms;
    }

    public void setPremiumRooms(Integer premiumRooms) {
        this.premiumRooms = premiumRooms;
    }

    public Integer getEconomyRooms() {
        return economyRooms;
    }

    public void setEconomyRooms(Integer economyRooms) {
        this.economyRooms = economyRooms;
    }

    public Double[] getGuestsBudget() {
        return guestsBudget;
    }

    public void setGuestsBudget(Double[] guestsBudget) {
        this.guestsBudget = guestsBudget;
    }
}
