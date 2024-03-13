package com.sky.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {
    @Autowired
    private AddressBookMapper addressBookMapper;


    /**
     * 条件查询
     *
     * @param addressBook
     * @return
     */

    //@SentinelResource("list")  定义一个资源，定义当资源内部发生异常时的处理逻辑
    //blockHandler 定义资源内部发生了BlockException应该进入的方法（捕获的是Sentinel定义的异常）
    //fallback 定义资源内部发生了Throwable应该进入的方法
    //    @SentinelResource(
    //            value = "save",
    //            blockHandler = "blockHandler",
    //            fallback = "fallback"
    //    )
    public List<AddressBook> list(AddressBook addressBook) {
        return addressBookMapper.list(addressBook);
    }

    //blockHandler
    //要求:
    //1.当前方法的返回值和参数要跟原方法一致
    //2.但是允许在参数列表的最后加入一个参数BlockException，用来接收原方法中发生的异常
    //    public String  blockHandler(String name, BlockException e){
    //        //自定义异常处理逻辑
    //        System.out.println("触发了blockException,内容为:"+e);
    //        return "BlockException";
    //    }

    //fallback
    //要求:
    //1.当前方法的返回值和参数要跟原方法一致
    //2.但是允许在参数列表的最后加入一个参数BlockException，用来接收原方法中发生的异常
    //    public String  fallback(String name, Throwable e){
    //        //自定义异常处理逻辑
    //        System.out.println("触发了Throwable,内容为:"+e);
    //        return "Throwable";
    //    }



    /**
     * 新增地址
     *
     * @param addressBook
     */
    public void save(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    public AddressBook getById(Long id) {
        AddressBook addressBook = addressBookMapper.getById(id);
        return addressBook;
    }

    /**
     * 根据id修改地址
     *
     * @param addressBook
     */
    public void update(AddressBook addressBook) {
        addressBookMapper.update(addressBook);
    }

    /**
     * 设置默认地址
     *
     * @param addressBook
     */
    @Transactional
    public void setDefault(AddressBook addressBook) {
        //1、将当前用户的所有地址修改为非默认地址 update address_book set is_default = ? where user_id = ?
        addressBook.setIsDefault(0);
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookMapper.updateIsDefaultByUserId(addressBook);

        //2、将当前地址改为默认地址 update address_book set is_default = ? where id = ?
        addressBook.setIsDefault(1);
        addressBookMapper.update(addressBook);
    }

    /**
     * 根据id删除地址
     *
     * @param id
     */
    public void deleteById(Long id) {
        addressBookMapper.deleteById(id);
    }

}
