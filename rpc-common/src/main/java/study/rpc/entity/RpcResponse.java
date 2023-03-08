package study.rpc.entity;


import lombok.Data;
import study.rpc.enumeration.ResponseCode;

import java.io.Serializable;

/**
 * @param <T> 返回的数据类型
 */
@Data
public class RpcResponse<T> implements Serializable {

    /**
     * @param code 响应状态码
     * @param message 响应状态补充信息
     * @param data 响应数据
     */
    private Integer code;

    private String message;

    private T data;

    public static <T> RpcResponse<T> success(T data) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setMessage(ResponseCode.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static <T> RpcResponse<T> fail(ResponseCode responseCode) {
        RpcResponse<T> response = new RpcResponse<>();
        response.setCode(responseCode.getCode());
        response.setMessage(response.getMessage());
        return response;
    }
}

