package com.ly.traffic.middleplatform.domain.order.repository.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * @author gaowei.liu
 */
@Getter
public class User {
    private long id;
    private String name;
    private String mobile;

    //在输出的Json数据中隐藏密码，只能输入不输出
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String role;

    public User(long id, String nickname, String mobile, String password, String role) {
        this.id = id;
        this.name = nickname;
        this.mobile = mobile;
        this.password = password;
        this.role = role;
    }

    public User() {
        super();
    }
}
