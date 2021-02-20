package com.smarthost.room;

import com.smarthost.room.visualization.RoomManagerController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RoomManagerApplicationTests {

	@Autowired
	private RoomManagerController roomManagerController;
	@Test
	void contextLoads() throws Exception{
		assertThat(roomManagerController).isNotNull();
	}

}
