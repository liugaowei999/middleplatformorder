package com.ly.traffic.middleplatform.service;

import com.ly.traffic.middleplatform.domain.order.repository.mapper.MainOrderMapper;
import com.ly.traffic.middleplatform.domain.order.repository.po.UMainOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 主订单表(UMainOrder)表服务实现类
 *
 * @author makejava
 * @since 2020-08-07 17:29:26
 */
@Service
public class MainOrderService {
    @Resource
    private MainOrderMapper mainOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public UMainOrder queryById(Integer id) {
        return this.mainOrderDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<UMainOrder> queryAllByLimit(int offset, int limit) {
        return this.mainOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param UMainOrder 实例对象
     * @return 实例对象
     */
    public UMainOrder insert(UMainOrder UMainOrder) {
        this.mainOrderDao.insert(UMainOrder);
        return UMainOrder;
    }

    /**
     * 修改数据
     *
     * @param UMainOrder 实例对象
     * @return 实例对象
     */
    public UMainOrder update(UMainOrder UMainOrder) {
        this.mainOrderDao.update(UMainOrder);
        return this.queryById(UMainOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        return this.mainOrderDao.deleteById(id) > 0;
    }
}
