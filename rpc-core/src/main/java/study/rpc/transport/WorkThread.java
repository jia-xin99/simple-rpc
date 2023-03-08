package study.rpc.transport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import study.rpc.entity.RpcRequest;
import study.rpc.entity.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkThread extends Thread {
    private Object service;
    private Socket socket;
    private static final Logger logger = LoggerFactory.getLogger(WorkThread.class);

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            RpcRequest request = (RpcRequest) ois.readObject();
//            String interfaceName = request.getInterfaceName(); // 即service
            // 通过反射来获取调用服务的方法
            Method method = service.getClass().getMethod(request.getMethodName(), request.getParamTypes());
            Object returnObject = method.invoke(service, request.getParameters());
            RpcResponse<Object> response = RpcResponse.success(returnObject);
            oos.writeObject(response);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("服务方接收数据失败");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            logger.error("服务方接收数据失败");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            logger.error("调用方法失败");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logger.info("调用方法失败");
        }
    }
}

