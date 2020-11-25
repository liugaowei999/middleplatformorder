package com.ly.traffic.middleplatform.domain.refundticket.repository.mapper;

import com.ly.traffic.middleplatform.domain.refundticket.repository.po.RefundTicketOrderPO;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 退票订单表(RefundTicketOrderPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-24 16:21:50
 */
public interface RefundTicketOrderMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RefundTicketOrderPO queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RefundTicketOrderPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param refundTicketOrderPO 实例对象
     * @return 对象列表
     */
    List<RefundTicketOrderPO> queryAll(RefundTicketOrderPO refundTicketOrderPO);

    /**
     * 新增数据
     *
     * @param refundTicketOrderPO 实例对象
     * @return 影响行数
     */
    int insert(RefundTicketOrderPO refundTicketOrderPO);

    /**
     * 修改数据
     *
     * @param refundTicketOrderPO 实例对象
     * @return 影响行数
     */
    int update(RefundTicketOrderPO refundTicketOrderPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
