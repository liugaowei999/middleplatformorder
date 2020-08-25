package com.ly.traffic.middleplatform.infrastructure.common;

/**
 * @author liugw
 * @Package com.ly.traffic.train.infrastructure.common
 * @Description: ${TODO}
 * @date 2020/8/11 15:42
 */
public enum ResultCode {
    /**
     * 成功
     */
    OK("200", "成功"),
    PARAM_INVALID("402", "非法参数"),

    ;

    ResultCode(String value, String msg) {
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

}
