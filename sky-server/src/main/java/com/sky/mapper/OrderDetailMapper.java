package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liweihua
 * @classname OrderDetailMapper
 * @description TODO
 * @date 2023/11/27 10:03
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 批量插入订单数据
     * @param orderDetailList
     */
    void insertBatch(List<OrderDetail> orderDetailList);
}
