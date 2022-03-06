# A simple grpc-server and grpc-client with Spring boot.

- **_grpc-protos-lib_**, a simple maven project only containing \*.proto files for protocol buffer to create code.

- **_grpc-server_**, a spring boot project which acts a grpc-server and uses 'grpc-protos-lib' as project dependency.

- **_grpc-client_**, a spring boot project for requesting 'grpc-server' and fetching response from it. It also uses 'grpc-protos-lib' as project dependency.
