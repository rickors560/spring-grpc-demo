package org.rick.grpc.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.rick.grpc.proto.service.HelloRequest;
import org.rick.grpc.proto.service.HelloResponse;
import org.rick.grpc.proto.service.HelloServiceGrpc;
import org.springframework.util.StringUtils;

@GrpcService
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

	@Override
	public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
		var name = request.getName();

		var responseMessage = "Hello World";
		if (StringUtils.hasLength(name)) {
			responseMessage = "Hello " + name;
		}

		var response = HelloResponse.newBuilder().setMessage(responseMessage).build();
		
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}

}
