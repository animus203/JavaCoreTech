package com.ludens.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        //模拟验证码发送
        //verifyCode("15216802105");
        //验证
        getRedisCode("15216802105", "122737");
    }

    //生成六位数字验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }

    //让每个手机每天只能发送三次，将验证码放入redis中，设置过期时间
    public static void verifyCode(String phone) {
        Jedis jedis = new Jedis("192.168.202.128", 6379);
        //拼接key
        //手机发送次数key
        String countKey = phone + ":count";
        //验证码的key
        String codeKey = phone + ":code";

        //每个手机只能发送三次
        String count = jedis.get(countKey);
        System.out.println(count);
        if (count == null){
            //如果没有发送次数，就设置发送次数为1，并设置过期时间
            jedis.setex(countKey, 24*60*60, "1");
        }else if (Integer.parseInt(count) <= 2){
            //发送次数+1
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) >2) {
            System.out.println("发送已超过三次");
            jedis.close();
            return;
        }
        //发送验证码放到redis里面
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }

    //验证码校验
    public static void getRedisCode(String phone, String code) {
        //从redis中获取验证码
        Jedis jedis = new Jedis("192.168.202.128", 6379);
        String codeKey = phone + ":code";
        String redisCode = jedis.get(codeKey);
        //判断
        if (redisCode.equals(code)){
            System.out.println("成功");
        } else {
            System.out.println("失败");
        }
        jedis.close();
    }
}
