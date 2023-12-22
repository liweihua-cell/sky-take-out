package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @author liweihua
 * @classname UserMapper
 * @description TODO
 * @date 2023/11/24 13:45
 */
@Mapper
public interface UserMapper {

    /**
     * 根据openId来查询用户
     * @param openId
     * @return
     */
    @Select("select * from user where id = #{openId}")
    User getByOpenId(String openId);


    /**
     * 插入数据
     * @param user
     */
    void insert(User user);


    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    @Select("select * from user where id = #{id}")
    User getById(Long userId);


    /**
     * 根据动态条件统计用户数量
     * @param map
     * @return
     */
    Integer countByMap(Map map);

    User getByUserId(Long userId);
}
