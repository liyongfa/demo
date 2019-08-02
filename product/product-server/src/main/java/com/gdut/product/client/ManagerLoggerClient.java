package com.gdut.product.client;

import com.google.gson.Gson;
import com.gudt.product.req.BaseReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Auther: lyf
 * @Date: 2019-06-27 11:32
 * @Description:
 */
@Component
public class ManagerLoggerClient {

    private static final Logger logger = LoggerFactory.getLogger(ManagerLoggerClient.class);

    private static final Gson gson = new Gson();

    public static void insertLog(String routing, String type, Integer operationType, BaseReq req, Integer operationId) {
        logger.info("---routing={},type={},operationType={},requestParam={},operationId={}", routing, type, operationType, gson.toJson(req), gson.toJson(operationId));
    }
}
