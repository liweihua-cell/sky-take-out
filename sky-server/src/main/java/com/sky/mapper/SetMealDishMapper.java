package com.sky.mapper;

import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
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
     *
     * @param dishIds
     * @return
     */
    List<Long> getSetMealIdsByDishId(List<Long> dishIds);


    /**
     * 批量保存套餐和菜品的关联关系
     *
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id删除套餐和菜品的关联关系
     *
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);


    /**
     * 根据id查询套餐和套餐菜品关系
     *
     * @param id
     * @return
     */

    List<SetmealDish> getBySetmealId(Long id);
}
