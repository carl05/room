package com.smarthost.room.data.model;

public final class Room {
    private final RoomType room;

    public Room(RoomType room) {
        this.room = room;
    }

    public RoomType getRoom() {
        return room;
    }
}

enum RoomType {
    ECONOMIC,
    PREMIUM
}
