package io.esev.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase  {

    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request, StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {

        System.out.println("[SERVICE] Starting Greeting Service");
        System.out.println(request);

        //Create a new protoBuffer Object
        System.out.println("[SERVICE] New Object ProtoBuffer");
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder().setGreeting("Hello there, "+ request.getName()).build();

        //Send a single response back
        System.out.println("[SERVICE] Response Back");
        responseObserver.onNext(response);

        //Send a response back
        System.out.println("[SERVICE] Response Another");
        responseObserver.onNext(response);

        //Send a response back
        System.out.println("[SERVICE] Response Another");
        responseObserver.onNext(response);

        //completed process
        responseObserver.onCompleted();
    }
}
