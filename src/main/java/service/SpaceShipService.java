package service;

import exceptions.ResourceNotFoundException;
import model.SpaceShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import repository.SpaceShipRepository;

@Service
public class SpaceShipService {

    @Autowired
    private SpaceShipRepository repository;

    // Crear una nueva nave
    public SpaceShip createSpaceShip(SpaceShip spaceShip) {
        return repository.save(spaceShip);
    }

    // Obtener todas las naves con paginación
    public Page<SpaceShip> getAllSpaceShips(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    // Obtener una nave por ID
    public SpaceShip getSpaceShipById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SpaceShip not found with id : " + id));
    }

    // Obtener todas las naves que contienen el valor en el nombre
    public Page<SpaceShip> getSpaceShipsByName(String name, int page, int size) {
        return repository.findByNameContaining(name, PageRequest.of(page, size));
    }

    // Actualizar una nave
    public SpaceShip updateSpaceShip(Long id, SpaceShip spaceShipDetails) {
        SpaceShip spaceShip = getSpaceShipById(id);

        spaceShip.setName(spaceShipDetails.getName());
        spaceShip.setSeries(spaceShipDetails.getSeries());
        spaceShip.setMovie(spaceShipDetails.getMovie());

        return repository.save(spaceShip);
    }

    // Eliminar una nave
    public void deleteSpaceShip(Long id) {
        SpaceShip spaceShip = getSpaceShipById(id);
        repository.delete(spaceShip);
    }
}
