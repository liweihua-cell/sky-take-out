package com.sky.service;

import com.sky.dto.OrdersPaymentDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderSubmitVO;

/**
 * @author liweihua
 * @classname OderSevice
 * @description TODO
 * @date 2023/11/27 9:57
 */
public interface OrderService {

    /**
     * 用户下单
     * @param submitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO submitDTO);

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);
}
