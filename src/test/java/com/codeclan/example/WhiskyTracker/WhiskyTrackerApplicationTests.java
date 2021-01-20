package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindByDistilleryAndAge(){
		List<Whisky> found = whiskyRepository.findByDistilleryNameAndAge( "Glendronach", 15);
		assertEquals(1, found.size());
		assertEquals("The Glendronach Revival", found.get(0).getName());

	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Highland");
		assertEquals(7, found.size());
	}


}
