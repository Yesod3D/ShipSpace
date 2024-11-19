package spaceShipController;

import model.SpaceShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SpaceShipService;

@RestController
@RequestMapping("/spaceships")
public class SpaceShipController {

    @Autowired
    private SpaceShipService service;

    // Obtener todas las naves con paginación
    @GetMapping
    public ResponseEntity<Page<SpaceShip>> getAllSpaceShips(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<SpaceShip> spaceships = service.getAllSpaceShips(page, size);
        return ResponseEntity.ok(spaceships);
    }

    // Obtener una nave por ID
    @GetMapping("/{id}")
    public ResponseEntity<SpaceShip> getSpaceShipById(@PathVariable Long id) {
        SpaceShip spaceShip = service.getSpaceShipById(id);
        return ResponseEntity.ok(spaceShip);
    }

    // Obtener todas las naves que contienen el valor en el nombre
    @GetMapping("/search")
    public ResponseEntity<Page<SpaceShip>> getSpaceShipsByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<SpaceShip> spaceships = service.getSpaceShipsByName(name, page, size);
        return ResponseEntity.ok(spaceships);
    }

    // Crear una nueva nave
    @PostMapping
    public ResponseEntity<SpaceShip> createSpaceShip(@RequestBody SpaceShip spaceShip) {
        SpaceShip createdSpaceShip = service.createSpaceShip(spaceShip);
        return ResponseEntity.ok(createdSpaceShip);
    }

    // Actualizar una nave
    public ResponseEntity<SpaceShip> updateSpaceShip(@RequestBody SpaceShip spaceShipDetails) {
        SpaceShip updatedSpaceShip = service.updateSpaceShip(spaceShipDetails.getId(),
                spaceShipDetails);
        return ResponseEntity.ok(updatedSpaceShip);
    }

    // Eliminar una nave
    @DeleteMapping public ResponseEntity<Void> deleteSpaceShip(@RequestBody SpaceShip spaceShip) {
        service.deleteSpaceShip(spaceShip.getId());
        return ResponseEntity.noContent().build();
    }

}
