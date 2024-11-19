package repository;

import model.SpaceShip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpaceShipRepository extends JpaRepository<SpaceShip, Long> {
    Page<SpaceShip> findByNameContaining(String name, Pageable pageable);
}
