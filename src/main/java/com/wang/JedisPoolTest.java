package com.wang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 连接池测试类
 */
public class JedisPoolTest {

    public static void main(String[] args) {
        //连接池的配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);

        //连接池的创建
        JedisPool pool = new JedisPool(config,"192.168.56.101",6379);
        Jedis jedis = null;

        try{
            jedis = pool.getResource();
            jedis.set("pool6","hello");
            System.out.println(jedis.get("pool6"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null) {
                jedis.close();
            }
        }

    }
}
