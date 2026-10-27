package sep3.drivia.tier3.grpc;

import sep3.drivia.tier3.entity.Vehicle;
import sep3.drivia.tier3.service.VehicleService;
import dk.via.drivia.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

@Component
public class CarGrpcService extends CarServiceGrpc.CarServiceImplBase {
    private final VehicleService vehicleService;

    public CarGrpcService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void getAllCars(GetAllCarsRequest request, StreamObserver<CarList> responseObserver) {
        CarList.Builder list = CarList.newBuilder();
        for (Vehicle v : vehicleService.getAllVehicles()) {
            list.addCars(toProto(v));
        }
        responseObserver.onNext(list.build());
        responseObserver.onCompleted();
    }

    private Car toProto(Vehicle v) {
        return Car.newBuilder()
                .setId(v.getId())
                .setModel(v.getModel())
                .setCategory(v.getCategory())
                .setLocation(v.getLocation())
                .build();
    }
}