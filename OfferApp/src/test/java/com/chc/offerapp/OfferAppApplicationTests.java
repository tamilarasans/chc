package com.chc.offerapp;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chc.offerapp.model.Offer;
import com.chc.offerapp.service.PointsCalculationService;

//@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class OfferAppApplicationTests {
@Autowired
	PointsCalculationService pointsCalculationService=new PointsCalculationService() ;
	@Test
	void contextLoads() {
	}

	
	@Test
	void calculatePoints() {
		Offer off= new Offer();
		int res=pointsCalculationService.calculatePoints(120,off);
		assertEquals(90,res);
	}
}
