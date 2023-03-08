package study.rpc.api;

// 客户端通过调用该接口相当于调用本地的方法
// 实际是远程调用服务端该接口的实现方法
public interface HelloService {
    String hello(HelloObject object);
}

