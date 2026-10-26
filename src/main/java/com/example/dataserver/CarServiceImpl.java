package com.example.dataserver;

import dk.via.drivia.grpc.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl extends CarServiceGrpc.CarServiceImplBase {
    private final VehicleRepository repository;

    public CarServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getAllCars(GetAllCarsRequest request, StreamObserver<CarList> responseObserver) {
        CarList.Builder list = CarList.newBuilder();
        for (Vehicle v : repository.findAll()) {
            list.addCars(Car.newBuilder()
                    .setId(v.getId())
                    .setModel(v.getModel())
                    .setCategory(v.getCategory())
                    .setLocation(v.getLocation()));
        }
        responseObserver.onNext(list.build());
        responseObserver.onCompleted();
    }
}
