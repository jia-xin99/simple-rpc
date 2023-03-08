package study.rpc.service.impl;

import study.rpc.api.HelloObject;
import study.rpc.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {

    private static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(HelloObject object) {
        logger.info("收到id" + object.getId() + "的消息：" + object.getMessage());
        return new String("服务端已收到消息");
    }
}

