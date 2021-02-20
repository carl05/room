package com.smarthost.room;

import com.smarthost.room.domain.network.RoomManagerRequest;
import com.smarthost.room.domain.network.RoomManagerResponse;
import com.smarthost.room.domain.service.IRoomManagerUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RoomManagerUseCaseTest {

    @Autowired
    private IRoomManagerUseCase roomManagerUseCase;

    private final Double[] guestsMock = new Double[]{23D, 45D, 155D, 374D, 22D, 99D, 100D, 101D, 115D, 209D};

    @Test
    public void roomManagerShouldReturnTest1Case() throws Exception {
        //ARRANGE
        RoomManagerRequest requestMock = new RoomManagerRequest(3, 3, guestsMock);

        //ACT
        RoomManagerResponse response = roomManagerUseCase.execute(requestMock);

        //ASSERT
        assertThat(response.getOccupiedPremiumRooms()).isEqualTo(3);
        assertThat(response.getEarningsPremiumRooms()).isEqualTo(738);
        assertThat(response.getOccupiedEconomyRooms()).isEqualTo(3);
        assertThat(response.getEarningsEconomyRooms()).isEqualTo(167);
    }

    @Test
    public void roomManagerShouldReturnTest2Case() throws Exception {
        //ARRANGE
        RoomManagerRequest requestMock = new RoomManagerRequest(7, 5, guestsMock);

        //ACT
        RoomManagerResponse response = roomManagerUseCase.execute(requestMock);

        //ASSERT
        assertThat(response.getOccupiedPremiumRooms()).isEqualTo(6);
        assertThat(response.getEarningsPremiumRooms()).isEqualTo(1054);
        assertThat(response.getOccupiedEconomyRooms()).isEqualTo(4);
        assertThat(response.getEarningsEconomyRooms()).isEqualTo(189);
    }

    @Test
    public void roomManagerShouldReturnTest3Case() throws Exception {
        //ARRANGE
        RoomManagerRequest requestMock = new RoomManagerRequest(2, 7, guestsMock);

        //ACT
        RoomManagerResponse response = roomManagerUseCase.execute(requestMock);

        //ASSERT
        assertThat(response.getOccupiedPremiumRooms()).isEqualTo(2);
        assertThat(response.getEarningsPremiumRooms()).isEqualTo(583);
        assertThat(response.getOccupiedEconomyRooms()).isEqualTo(4);
        assertThat(response.getEarningsEconomyRooms()).isEqualTo(189);
    }

    @Test
    public void roomManagerShouldReturnTest4Case() throws Exception {
        //ARRANGE
        RoomManagerRequest requestMock = new RoomManagerRequest(7, 1, guestsMock);

        //ACT
        RoomManagerResponse response = roomManagerUseCase.execute(requestMock);

        //ASSERT
        assertThat(response.getOccupiedPremiumRooms()).isEqualTo(7);
        assertThat(response.getEarningsPremiumRooms()).isEqualTo(1153);
        assertThat(response.getOccupiedEconomyRooms()).isEqualTo(1);
        assertThat(response.getEarningsEconomyRooms()).isEqualTo(45);
    }

    @Test
    public void roomManagershouldReturnFilledResponse() throws Exception {
        //ARRANGE
        RoomManagerRequest requestMock = new RoomManagerRequest(5, 5, guestsMock);

        //ACT
        RoomManagerResponse response = roomManagerUseCase.execute(requestMock);

        //ASSERT
        assertThat(response).isNotNull();
        assertThat(response.getOccupiedPremiumRooms()).isNotNull();
        assertThat(response.getOccupiedPremiumRooms()).isNotNegative();
        assertThat(response.getEarningsPremiumRooms()).isNotNull();
        assertThat(response.getEarningsPremiumRooms()).isNotNegative();
        assertThat(response.getOccupiedEconomyRooms()).isNotNull();
        assertThat(response.getOccupiedEconomyRooms()).isNotNegative();
        assertThat(response.getEarningsEconomyRooms()).isNotNull();
        assertThat(response.getEarningsEconomyRooms()).isNotNegative();
    }

}
