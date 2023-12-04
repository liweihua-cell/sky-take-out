package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

/**
 * @author liweihua
 * @classname ReportService
 * @description TODO
 * @date 2023/11/28 14:25
 */
public interface ReportService {

    /**
     * 统计指定区间内的营业额数据
     * @param begin
     * @param end
     * @return
     */
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);



    /**
     * 统计指定区间内的用户数据
     * @return
     */
    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);


    /**
     *统计指定区间内的订单数据
     * @param begin
     * @param end
     * @return
     */
    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    /**
     *统计指定区间内的销量排名前十
     * @param begin
     * @param end
     * @return
     */
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);


    /**
     * 导出数据运营报表
     * @param response
     */
    void exportBusinessData(HttpServletResponse response);
}
