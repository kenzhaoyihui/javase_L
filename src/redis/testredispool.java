package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class testredispool {

    public static void main(String[] args){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config,"127.0.0.1", 6379);

        Jedis jedis = null;

        try{
            jedis = jedisPool.getResource();
            jedis.auth("1234");
            jedis.set("cockpit", "yzhao");
            System.out.println("Value: " + jedis.get("cockpit"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null){
                jedis.close();
            }

            if (jedisPool != null){
                jedisPool.close();
            }
        }
    }
}
