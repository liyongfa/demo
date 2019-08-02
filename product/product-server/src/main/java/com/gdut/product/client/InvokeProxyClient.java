package com.gdut.product.client;

import com.gdut.product.service.BaseService;
import com.google.gson.Gson;
import com.gudt.product.req.BaseReq;
import com.gudt.product.resp.BaseResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 11:14
 * @Description:
 */
@Component
public class InvokeProxyClient {

    private static final Logger logger = LoggerFactory.getLogger(InvokeProxyClient.class);

    private static Gson gson = new Gson();

    public static BaseResp invoke(BaseService service, String methodName, BaseReq req) {
        BaseResp resp = new BaseResp();
        final Class<? extends BaseService> clazz = service.getClass();
        try {
            //进行日志的打印操作
            logger.info("----Class={},Method={},RequestParam={}", service.getClass(), methodName, gson.toJson(req));
            final Method method = clazz.getDeclaredMethod(methodName, req.getClass());
            resp = (BaseResp) method.invoke(service, req);
        } catch (NoSuchMethodException e) {
            //不存在该方法
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //参数存在错误时会抛出这个异常
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            //远程调用时失败
            logger.info("---Res----远程调用失败------RequestParam:" + gson.toJson(req));
        }
        return resp;
    }
}
