package com.wang;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.List;
import java.util.Set;

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.101",6379);
        //具体逻辑
//        jedis.set("jedis","hello");
//        System.out.println(jedis.get("jedis"));

       //常用命令
//        String key = "jedis";
//        System.out.println(jedis.exists(key));
//        jedis.expire(key,100);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(jedis.ttl(key));


//        jedis.setnx("jedis","value1");
//        System.out.println(jedis.get("jedis"));


        //键值命令
//         Set set= jedis.keys("*");
//        System.out.println(set);

        //非字符串命令
//        jedis.lpush("list2","wang","li","xi");
//        List<String> list = jedis.lrange("list2", 0, -1);
//        System.out.println(list);
//        System.out.println("----------------------------------");

        //排序  sort +key  默认从小到大排序   alpha设置为按照字母排序
        SortingParams params = new SortingParams();
        System.out.println(jedis.sort("list2",params.alpha()));
        //创建时就要想着关闭
        jedis.close();
    }
}
