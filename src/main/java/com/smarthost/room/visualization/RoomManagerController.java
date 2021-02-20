package com.smarthost.room.visualization;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import com.smarthost.room.domain.service.IRoomManagerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/room-manager/")
public class RoomManagerController {

    private final IRoomManagerUseCase roomManagerUseCase;

    public RoomManagerController(IRoomManagerUseCase roomManagerUseCase) {
        this.roomManagerUseCase = roomManagerUseCase;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "occupancy", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomManagerResponse occupancy(@Valid @RequestBody RoomManagerRequest roomManagerRequest){
        return roomManagerUseCase.execute(roomManagerRequest);
    }
}
