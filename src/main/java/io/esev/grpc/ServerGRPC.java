package io.esev.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 */
public class ServerGRPC {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("[SERVER] Starting ServerGRPC GRPC!");

        Server server = ServerBuilder
                            .forPort(9090)
                            .addService(new GreetingServiceImpl())
                            .build();

        server.start();
        System.out.println("[SERVER] ServerGRPC Started!");

        //Don't exit the main thread, wait until server is terminated
        server.awaitTermination();
    }
}
