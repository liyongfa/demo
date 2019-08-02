package com.gudt.common.resp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 17:44
 * @Description:
 */
public class BaseResp implements Serializable {

    private Integer code = 0;

    private String message = "SUCCESS";

    private Integer operationId;

    private Map<String, String> paramErrors = new HashMap<>();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getParamErrors() {
        return paramErrors;
    }

    public void setParamErrors(Map<String, String> paramErrors) {
        this.paramErrors = paramErrors;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }
}
