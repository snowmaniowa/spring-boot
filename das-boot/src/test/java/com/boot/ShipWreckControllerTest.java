package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipWreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

public class ShipWreckControllerTest {

	// #creates an objects and injects
	@InjectMocks
	ShipWreckController sc;

	@Mock
	ShipWreckRepository shipWreckRepository;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipWreckGet(){
		Shipwreck mockedDO = new Shipwreck();
		mockedDO.setId(1L);
		
		when(shipWreckRepository.findOne(1L)).thenReturn(mockedDO);
		
		Shipwreck returnedShipWreck = sc.get(1L);
		assertEquals(1L, returnedShipWreck.getId().longValue());
	}
}
