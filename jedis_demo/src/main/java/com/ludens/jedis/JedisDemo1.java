package com.ludens.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.202.128", 6379);
        //测试，ping一下
        String ping = jedis.ping();
        System.out.println(ping);
        //连接结束需要关闭jedis
        jedis.close();
    }

    //操作key
    @Test
    public void demo1(){
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.202.128", 6379);

        //添加
        jedis.set("name", "lucy");
        //获取
        String name = jedis.get("name");
        System.out.println(name);

        //设置多个key-value
        jedis.mset("k1", "v1", "k2", "v2");
        System.out.println(jedis.mget("k1", "k2"));

        //得到所有key
        Set<String> keys = jedis.keys("*");
        for (String key: keys){
            System.out.println(key);
        }
    }

    //操作list
    @Test
    public void demo2(){
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.202.128", 6379);

        jedis.lpush("key1", "lucy", "mary", "jack");
        System.out.println(jedis.lrange("key1", 0, -1));
    }

    //操作set
    @Test
    public void demo3(){
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.202.128", 6379);

        jedis.sadd("orders","01");
        jedis.sadd("orders","02");
        jedis.sadd("orders","03");
        Set<String> orders = jedis.smembers("orders");
        System.out.println(orders);
        jedis.close();
    }
}
