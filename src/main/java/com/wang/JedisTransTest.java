package com.wang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * 事物测试
 */
public class JedisTransTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.101",6379);

        jedis.set("hong","5555");
        jedis.set("ming","3333");
        jedis.watch("hong","ming");



        //红给名转账2222元
        Transaction transaction = jedis.multi();

        if (Integer.parseInt(jedis.get("hong"))>=2222){

            transaction.decrBy("hong",2222);
            transaction.incrBy("ming",2222);
            transaction.exec();
        }


        //不想执行了
       // transaction.discard();




        //验证结果
        List<String> list = jedis.mget("hong", "ming");
        System.out.println(list);

    }

}
