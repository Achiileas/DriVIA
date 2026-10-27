package sep3.drivia.tier3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sep3.drivia.tier3.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {}
