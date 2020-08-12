package com.ly.traffic.middleplatform.domain.order.repository.mapper;

import com.ly.traffic.middleplatform.domain.order.repository.po.User;

/**
 * @author gaowei.liu
 */
public interface UserMapper {

    /**
     * 对应xml映射文件元素的ID
     */
    User selectByPrimaryKey(long id);

    void add(User user);
}
