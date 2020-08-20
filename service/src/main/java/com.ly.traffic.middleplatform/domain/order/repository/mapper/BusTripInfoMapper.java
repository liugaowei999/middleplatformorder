package com.ly.traffic.middleplatform.domain.createorder.repository.mapper;

import com.ly.traffic.middleplatform.domain.createorder.repository.po.BusTripInfoPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 汽车行程信息表(BusTripInfoPO)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 14:11:35
 */
public interface BusTripInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BusTripInfoPO queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BusTripInfoPO> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param busTripInfoPO 实例对象
     * @return 对象列表
     */
    List<BusTripInfoPO> queryAll(BusTripInfoPO busTripInfoPO);

    /**
     * 新增数据
     *
     * @param busTripInfoPO 实例对象
     * @return 影响行数
     */
    int insert(BusTripInfoPO busTripInfoPO);

    /**
     * 修改数据
     *
     * @param busTripInfoPO 实例对象
     * @return 影响行数
     */
    int update(BusTripInfoPO busTripInfoPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}
