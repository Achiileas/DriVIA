package sep3.drivia.tier3.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GrpcServerRunner implements CommandLineRunner {
    private final CarGrpcService carService;
    private final int port;

    public GrpcServerRunner(CarGrpcService carService, @Value("${grpc.port}") int port) {
        this.carService = carService;
        this.port = port;
    }

    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder.forPort(port).addService(carService).build().start();
        System.out.println("gRPC data server listening on port " + port);
        server.awaitTermination();
    }
}