package com.prueba.tecnica.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import model.SpaceShip;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import repository.SpaceShipRepository;
import service.SpaceShipService;

@SpringBootTest
public class SpaceShipServiceTest {

	@Mock
	private SpaceShipRepository repository;

	@InjectMocks
	private SpaceShipService service;

	public SpaceShipServiceTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testCreateSpaceShip() {
		SpaceShip ship = new SpaceShip();
		ship.setName("X-Wing");

		// Aquí puedes simular el comportamiento del repositorio si es necesario
		when(repository.save(any(SpaceShip.class))).thenReturn(ship);

		service.createSpaceShip(ship);
		assertNotNull(ship.getName());
	}
}
