package com.smarthost.room.visualization;

import com.smarthost.room.domain.network.RentResumeRequest;
import com.smarthost.room.domain.network.RentResumeResponse;
import com.smarthost.room.domain.service.RentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RentResumeResponse getRentResumeByRooms(@RequestBody RentResumeRequest rentResumeRequest){
        return rentService.getRentResumeByRooms(rentResumeRequest);
    }
}
