package io.esev.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ClientStreamGRPC {

    public static void main(String[] args) {

        System.out.println("[CLIENT STREAM] Starting ClientStreamGRPC!");
        final ManagedChannel channel = ManagedChannelBuilder
                                            .forTarget("localhost:9090")
                                            .usePlaintext(true)
                                            .build();

        GreetingServiceGrpc.GreetingServiceStub stub = GreetingServiceGrpc.newStub(channel);

        GreetingServiceOuterClass.HelloRequest request = GreetingServiceOuterClass.HelloRequest.newBuilder().setName("Emeric").build();

        System.out.println("[CLIENT STREAM] Invoke Remote Procedure");
        stub.greeting(request, new StreamObserver<GreetingServiceOuterClass.HelloResponse>() {
            public void onNext(GreetingServiceOuterClass.HelloResponse helloResponse) {
                System.out.println("[CLIENT STREAM] Response");
                System.out.println(helloResponse);
            }

            public void onError(Throwable throwable) {
                System.out.println("[CLIENT STREAM] Response ERROR");
                System.out.println(throwable.getMessage());
            }

            public void onCompleted() {
                System.out.println("[CLIENT STREAM] Complete procedure");
                channel.shutdownNow();
            }
        });
    }
}
