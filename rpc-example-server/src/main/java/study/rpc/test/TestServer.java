package study.rpc.test;

import study.rpc.service.impl.HelloServiceImpl;
import study.rpc.transport.RpcServer;

public class TestServer {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        HelloServiceImpl helloService = new HelloServiceImpl();
        server.register(helloService, 9000);
    }
}

