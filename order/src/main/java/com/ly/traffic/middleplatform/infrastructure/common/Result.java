package com.ly.traffic.middleplatform.infrastructure.common;

import java.io.Serializable;

/**
 * @author boai
 * @className Result
 * @date: 2019/2/26
 */
public class Result implements Serializable {
    /**
     * 状态码
     */
    private String code;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回实体
     */
    private Object data;

    private boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setFail(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Result(String code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public Result(String code, String msg, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public Result() {
        this.msg = ResultCode.OK.msg();
        this.code = ResultCode.OK.val();
        this.success = true;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.val();
        this.msg = resultCode.msg();
        this.success = true;
    }

    public boolean isOk() {
        return ResultCode.OK.val().equals(code);
    }
}
