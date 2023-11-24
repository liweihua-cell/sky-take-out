package com.sky.mapper;

import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liweihua
 * @classname SetMealDishMapper
 * @description TODO
 * @date 2023/11/23 11:16
 */
@Mapper
public interface SetMealDishMapper {


    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetMealIdsByDishId(List<Long> dishIds);
}
