package org.rick.client;

import javax.annotation.PostConstruct;

import org.rick.grpc.proto.service.HelloRequest;
import org.rick.grpc.proto.service.HelloServiceGrpc.HelloServiceBlockingStub;
import org.springframework.stereotype.Service;

import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class HelloService {

	@GrpcClient(value = "GrpcServer")
	private HelloServiceBlockingStub helloServiceBlockingStub;

	public void sendHello(String name) {
		var request = HelloRequest.newBuilder().setName(name).build();
		var response = helloServiceBlockingStub.sayHello(request);

		System.out.println(response.getMessage());
	}

	@PostConstruct
	public void postConstruct() {
		this.sendHello("Ritik");
	}
}
