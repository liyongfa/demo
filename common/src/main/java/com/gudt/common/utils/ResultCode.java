package com.gudt.common.utils;

/**
 * @Auther: lyf
 * @Date: 2019-06-21 19:18
 * @Description:
 */
public abstract class ResultCode {
    public static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;
    public static final Integer PARAM_ERROR = 2;
    public static final Integer RECORD_NOT_EXISTS = 3;
    public static final Integer INSERT_RECORD_FAIL = 4;
    public static final Integer UPDATE_RECORD_FAIL = 5;
    public static final Integer DELETE_RECORD_FAIL = 6;
    public static final Integer SELECT_RECORD_FAIL = 7;
    public static final Integer EXPORT_RECORD_FAIL = 8;

}