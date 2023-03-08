package study.rpc.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author JiaXin
 * @description 远程调用其他服务，就得告诉远程服务要调用哪个接口的哪个方法以及参数，
 * 该对象会被传输到服务端，也需要序列化
 */
@Data
@Builder
public class RpcRequest implements Serializable {

    /**
     * @param interfaceName 接口名
     * @param methodName    方法名
     * @param parameters    参数
     * @param paramTypes    参数类型
     */
    private String interfaceName;

    private String methodName;

    private Object[] parameters;

    private Class<?>[] paramTypes;
}

