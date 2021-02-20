package com.smarthost.room.domain.service;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;

public interface IRoomManagerUseCase {
    RoomManagerResponse execute(RoomManagerRequest request);
}
