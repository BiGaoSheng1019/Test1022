package com.example.demo.service;


import com.example.demo.mapper.UserMapaerXX;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Demo01ServiceImpl {

    @Autowired
    private UserMapaerXX maer;

    private static final Logger log= LoggerFactory.getLogger(Demo01ServiceImpl.class);

//  商品库存
    private static  Integer count  =5;

    /*c创建一个对象*/
    private static  Object  o = new Object();


    public String decStockNoLock() {

        /*同步代码块*/
        synchronized (o){
            if(count <= 0){

                log.info("下单失败，库存没有了");
                return "下单失败，库存没有了";
            }
            count--;
            log.info("下单成功，当前剩余产品库存：>>>"+count);
            return "下单成功，当前剩余产品库存："+count;
        }
    }

    public Map<String,String> decS123tockNoLock() {

        return  maer.niinif();
    }

    private class UserMapaer {
    }
}
