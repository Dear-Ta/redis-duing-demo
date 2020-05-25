package com.wang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

/**
 * 管道测试类
 */
public class JedisPipeTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.101",6379);

        String key = "pipe6";
        jedis.set(key,"10");
        //使用管道
        Pipeline pipeline = jedis.pipelined();
        for (int i = 0; i < 10 ;i++) {
            pipeline.incr(key);
        }
        //统一提交的命令
        pipeline.sync();
        System.out.println(jedis.get(key));

    }
}
