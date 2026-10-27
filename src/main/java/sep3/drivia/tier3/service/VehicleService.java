package sep3.drivia.tier3.service;

import sep3.drivia.tier3.entity.Vehicle;
import sep3.drivia.tier3.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }
}
