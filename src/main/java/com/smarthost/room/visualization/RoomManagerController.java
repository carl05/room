package com.smarthost.room.visualization;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import com.smarthost.room.domain.service.RoomManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/room-manager/")
public class RoomManagerController {

    private final RoomManagerService roomManagerService;

    public RoomManagerController(RoomManagerService roomManagerService) {
        this.roomManagerService = roomManagerService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "occupancy", produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomManagerResponse occupancy(@RequestBody RoomManagerRequest roomManagerRequest){
        return roomManagerService.occupancy(roomManagerRequest);
    }
}
