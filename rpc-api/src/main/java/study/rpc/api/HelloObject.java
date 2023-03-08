package study.rpc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 序列化是因为该对象要从客服端发到服务端
public class HelloObject implements Serializable {
    private String id;
    private String message;
}

