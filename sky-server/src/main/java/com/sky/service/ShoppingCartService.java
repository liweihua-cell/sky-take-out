package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liweihua
 * @classname ShoppingCartService
 * @description TODO
 * @date 2023/11/24 16:34
 */

public interface ShoppingCartService {

    /**
     * 添加购物车
     *
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);


    /**
     * 查看购物车
     *
     * @return
     */
    List<ShoppingCart> showShoppingCart();


    /**
     * 清空购物车
     */
    void cleanShoppingCart();
}
