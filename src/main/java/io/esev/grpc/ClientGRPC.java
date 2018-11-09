package io.esev.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGRPC {

    public static void main(String[] args) {

        System.out.println("[CLIENT] Starting ClientGRPC!");
        final ManagedChannel channel = ManagedChannelBuilder
                                            .forTarget("localhost:9090")
                                            .usePlaintext(true)
                                            .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Victor").build();

        System.out.println("[CLIENT] Invoke Remote Procedure");
//        GreetingServiceOuterClass.HelloResponse response = stub.greeting(request);

        System.out.println("[CLIENT] Response from Server");
//        System.out.println(response);

        channel.shutdownNow();
    }
}
