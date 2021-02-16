package com.smarthost.room.data.model;

public class Room {
    private RoomType room;

    public RoomType getRoom() {
        return room;
    }

    public void setRoom(RoomType room) {
        this.room = room;
    }
}

enum RoomType {
    ECONOMIC,
    PREMIUM
}
