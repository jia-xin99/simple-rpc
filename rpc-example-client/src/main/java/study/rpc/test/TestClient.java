package study.rpc.test;

import study.rpc.api.HelloObject;
import study.rpc.api.HelloService;
import study.rpc.transport.RpcClient;
import study.rpc.transport.RpcClientProxy;

public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy proxy = new RpcClientProxy("127.0.0.1", 9000);
        HelloService helloService = proxy.getProxy(HelloService.class);
        HelloObject object = new HelloObject("123", "你好");
        // 会执行代理的方法
        String hello = helloService.hello(object);
        System.out.println(hello);
    }
}

